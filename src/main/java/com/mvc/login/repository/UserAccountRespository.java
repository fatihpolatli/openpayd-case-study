package com.mvc.login.repository;

import com.mvc.login.entity.UserAccount;
import com.mvc.login.enums.AccountTypeEnum;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRespository extends JpaRepository<UserAccount, Long> {

	UserAccount findByAccountType(AccountTypeEnum accountType);

	UserAccount findByAccountTypeAndUserId(AccountTypeEnum accountType, Long userId);

	void deleteByUserIdAndAccountType(Long userId, AccountTypeEnum accountType);

	UserAccount findOneByUserIdAndAccountType(Long userId, AccountTypeEnum accountType);

}
