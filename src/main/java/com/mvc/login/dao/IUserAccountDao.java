package com.mvc.login.dao;

import com.mvc.login.entity.UserAccount;
import com.mvc.login.enums.AccountTypeEnum;
import com.mvc.login.exception.NoUserAccountException;

public interface IUserAccountDao {

	UserAccount save(UserAccount userAccount);

	UserAccount findByAccountType(AccountTypeEnum accountType);

	UserAccount findByAccountTypeAndUserId(AccountTypeEnum accountType, Long userId) throws NoUserAccountException;

	Boolean delete(Long userId, AccountTypeEnum accountType);

}
