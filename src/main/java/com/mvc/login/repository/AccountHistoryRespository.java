package com.mvc.login.repository;

import java.util.Set;

import com.mvc.login.entity.AccountHistory;
import com.mvc.login.entity.UserAccount;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountHistoryRespository extends JpaRepository<AccountHistory, Long> {

	Set<AccountHistory> findByAccount(UserAccount account);

	Set<AccountHistory> findByAccountOrderByActionDateDesc(UserAccount account);

}
