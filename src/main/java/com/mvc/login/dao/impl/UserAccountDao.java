package com.mvc.login.dao.impl;

import javax.transaction.Transactional;

import com.mvc.login.dao.IUserAccountDao;
import com.mvc.login.entity.UserAccount;
import com.mvc.login.enums.AccountTypeEnum;
import com.mvc.login.exception.NoUserAccountException;
import com.mvc.login.repository.UserAccountRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class UserAccountDao implements IUserAccountDao {

	@Autowired
	UserAccountRespository repository;

	@Override
	public UserAccount save(UserAccount userAccount) {
		// TODO Auto-generated method stub
		return repository.save(userAccount);
	}

	@Override
	public UserAccount findByAccountType(AccountTypeEnum accountType) {
		// TODO Auto-generated method stub
		return repository.findByAccountType(accountType);
	}

	@Override
	public UserAccount findByAccountTypeAndUserId(AccountTypeEnum accountType, Long userId)
			throws NoUserAccountException {
		// TODO Auto-generated method stub

		UserAccount account = repository.findByAccountTypeAndUserId(accountType, userId);

		if (account == null) {

			throw new NoUserAccountException();
		}

		return account;
	}

	@Override
	public Boolean delete(Long userId, AccountTypeEnum accountType) {
		// TODO Auto-generated method stub
		UserAccount persistentData = repository.findOneByUserIdAndAccountType(userId, accountType);

		persistentData.setIsDeleted(1);

		repository.save(persistentData);

		return true;
	}

}
