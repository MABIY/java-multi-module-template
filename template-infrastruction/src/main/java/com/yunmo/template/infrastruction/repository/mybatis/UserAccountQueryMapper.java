package com.yunmo.template.infrastruction.repository.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunmo.template.domain.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserAccountQueryMapper extends BaseMapper<UserAccount> {
    public UserAccount selectByUserAccountId(@Param("id") Long id);
}
