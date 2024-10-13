package com.yunmo.template.domain.repository;

import com.yunmo.domain.common.EntityRepository;
import com.yunmo.template.domain.UserAccount;

import java.util.Optional;

/** @author lh */
public interface UserAccountRepository extends EntityRepository<UserAccount, Long> {
  Optional<UserAccount> findByAccountName(String phone);

  Optional<UserAccount> findByPhone(String phone);

  Optional<UserAccount> findByPassword(String password);
}
