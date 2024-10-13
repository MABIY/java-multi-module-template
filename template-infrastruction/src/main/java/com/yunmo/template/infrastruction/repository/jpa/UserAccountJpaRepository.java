package com.yunmo.template.infrastruction.repository.jpa;


import com.yunmo.template.domain.UserAccount;
import com.yunmo.template.domain.repository.UserAccountRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/** @author lh */
public interface UserAccountJpaRepository
    extends JpaRepository<UserAccount, Long>, UserAccountRepository {}
