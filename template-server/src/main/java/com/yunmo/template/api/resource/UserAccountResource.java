package com.yunmo.template.api.resource;

import com.yunmo.domain.common.Principal;
import com.yunmo.domain.common.Tenant;
import com.yunmo.template.domain.UserAccount;
import com.yunmo.template.domain.repository.UserAccountRepository;
import com.yunmo.template.domain.value.UserAccountValue;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import java.util.List;

/**
 * @author lh
 */
@RestController
@Transactional
@RequestMapping("/api/accounts")
@Tag(name = "账户资源")
public class UserAccountResource {
    @Autowired
    UserAccountRepository userAccountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Operation(description = "已登录用户信息")
    @GetMapping("/me")
    public UserAccount get(@Principal Tenant tenant) {
        return userAccountRepository
                .findById(tenant.getId())
                .orElseThrow(
                        () -> {
                            throw Problem.valueOf(Status.NOT_FOUND, "账户信息不存在");
                        });
    }

    @PatchMapping("/{id}")
    @Operation(description = "修改用户信息用户信息")
    public void update(
            @PathVariable(value = "id") UserAccount userAccount,
            @RequestBody UserAccountValue userAccountValue) {
        userAccountRepository.save(userAccountValue.patchTo(userAccount));
    }


    @GetMapping("/all")
    @Operation(description = "全部用户")
    public List<UserAccount> getAllUserAccountList() {
        return userAccountRepository.findAll();
    }

    @PostMapping
    public UserAccount create(UserAccountValue userAccountValue) {
        return userAccountRepository.save(userAccountValue.create());
    }

    @PutMapping("/{id}")
    public UserAccount update(UserAccountValue userAccountValue, @PathVariable UserAccount userAccount) {
        return userAccountRepository.save(userAccountValue.patchTo(userAccount));
    }

}
