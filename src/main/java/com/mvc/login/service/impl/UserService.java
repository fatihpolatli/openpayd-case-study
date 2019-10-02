package com.mvc.login.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.mvc.login.dao.IAccountHistoryDao;
import com.mvc.login.dao.IUserAccountDao;
import com.mvc.login.dao.IUserDao;
import com.mvc.login.dto.BalanceDto;
import com.mvc.login.dto.TransferDto;
import com.mvc.login.dto.UserDto;
import com.mvc.login.entity.AccountHistory;
import com.mvc.login.entity.User;
import com.mvc.login.entity.UserAccount;
import com.mvc.login.enums.AccountTransactionType;
import com.mvc.login.enums.AccountTypeEnum;
import com.mvc.login.exception.AccountAlreadyExistException;
import com.mvc.login.exception.DuplicateEmailException;
import com.mvc.login.exception.NoUserException;
import com.mvc.login.exception.NotEnoughBalanceException;
import com.mvc.login.mapper.UserMapper;
import com.mvc.login.mock.BalanceLoader;
import com.mvc.login.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class UserService implements IUserService {
	@Autowired
	private IUserDao userDao;

	@Autowired
	private IUserAccountDao userAccountDao;

	@Autowired
	private IAccountHistoryDao accountHistoryDao;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JdbcUserDetailsManager jdbcUserDetailsManager;

	@Transactional
	@Override
	public User registerNewUserAccount(UserDto userDto) throws Exception {

		if (emailExist(userDto.getEmail())) {
			throw new DuplicateEmailException();
		}

		User user = UserMapper.INSTANCE.toEntity(userDto);
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));

		// authorities to be granted
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

		org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), authorities);

		jdbcUserDetailsManager.createUser(userDetails);
		jdbcUserDetailsManager.loadUserByUsername(user.getUsername());
		return userDao.save(user);
	}

	private boolean emailExist(String email) throws DuplicateEmailException {
		User user = userDao.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}

	@Override
	public User findByUserName(String username) throws NoUserException {

		return userDao.findByUsername(username);

	}

	@Override
	public User findById(Long userId) throws NoUserException {

		return userDao.findById(userId);

	}

	@Override
	public User createUserAccount(UserDto accountDto) throws Exception {

		return registerNewUserAccount(accountDto);

	}

	@Override
	public Boolean deleteAccount(AccountTypeEnum accountType) throws Exception {
		// TODO Auto-generated method stub

		User user = getUserInfo();
		return userAccountDao.delete(user.getId(), accountType);
	}

	@Override
	@Transactional
	public User addAcount(AccountTypeEnum accountType) throws Exception {

		User user = getUserInfo();

		Set<UserAccount> accounts = user.getAccounts();

		UserAccount existingAccount = null;
		try {

			existingAccount = getAccountInfo(accountType, user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (existingAccount != null) {

			throw new AccountAlreadyExistException();
		}

		if (accounts == null) {

			accounts = new HashSet<UserAccount>();

			user.setAccounts(accounts);
		}

		UserAccount userAccount = new UserAccount();

		userAccount.setAccountType(accountType);

		UserAccount persistentAccount = userAccountDao.save(userAccount);

		user.getAccounts().add(persistentAccount);

		return userDao.save(user);

	}

	private User getUserInfo() throws Exception {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		return findByUserName(username);
	}

	private UserAccount getAccountInfo(AccountTypeEnum accountType, Long userId) throws Exception {

		return userAccountDao.findByAccountTypeAndUserId(accountType, userId);

	}

	@Override
	public Set<UserAccount> getAccounts() throws NoUserException {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User user = findByUserName(username);

		return user.getAccounts();

	}

	@Override
	@Transactional
	public Boolean addSubtractBalance(BalanceDto balance) throws Exception {

		User user = getUserInfo();

		return addSubtractBalanceByUser(user, balance);

	}

	public Boolean addSubtractBalanceByUser(User user, BalanceDto balance) throws Exception {

		UserAccount userAccount = getAccountInfo(balance.getAccount().getAccountType(), user.getId());

		Long currentBalance = userAccount.getBalance();

		Long balanceAmount = balance.getAmount();

		if (balance.getType() == AccountTransactionType.ADD) {

			currentBalance = currentBalance + balanceAmount;

			accountHistoryDao.additionLog(balanceAmount, userAccount);

		} else if (balance.getType() == AccountTransactionType.SUBTRACT) {

			if (currentBalance >= balanceAmount) {

				currentBalance = currentBalance - balanceAmount;

				accountHistoryDao.subtractLog(balanceAmount, userAccount);
			} else {

				throw new NotEnoughBalanceException();
			}
		}

		userAccount.setBalance(currentBalance);

		userAccountDao.save(userAccount);

		return true;

	}

	@Override
	public Long getCurrentBalance(AccountTypeEnum accountType) throws Exception {

		User user = getUserInfo();

		UserAccount userAccount = getAccountInfo(accountType, user.getId());

		return userAccount.getBalance();
	}

	@Override
	public Set<AccountHistory> getAccountHistory(AccountTypeEnum accountType) throws Exception {

		User user = getUserInfo();

		UserAccount userAccount = getAccountInfo(accountType, user.getId());

		return accountHistoryDao.findByAccount(userAccount);
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	@Transactional
	public Boolean transferMoney(TransferDto transferData) throws Exception {
		// TODO Auto-generated method stub

		User targetUser = userDao.findByUsername(transferData.getTargetUser().getUsername());

		BalanceDto balanceData = transferData.getBalance();

		balanceData.setType(AccountTransactionType.SUBTRACT);

		addSubtractBalance(balanceData);

		balanceData.setType(AccountTransactionType.ADD);

		balanceData.setAccount(transferData.getTargetAccount());

		addSubtractBalanceByUser(targetUser, balanceData);

		return true;
	}

	@Override
	public Boolean loadBalance(BalanceDto balance) throws Exception {
		// TODO Auto-generated method stub
		Boolean result = BalanceLoader.loadBalance();

		if (result) {

			balance.setType(AccountTransactionType.ADD);

			return addSubtractBalance(balance);
		}

		return false;
	}

}