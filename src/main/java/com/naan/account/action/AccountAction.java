package com.naan.account.action;

import com.naan.account.domain.User;
import com.naan.account.domain.usecase.AccountRetrieve;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountAction {

    private final AccountRetrieve accountRetrieve;

    public AccountAction(AccountRetrieve accountRetrieve) {
        this.accountRetrieve = accountRetrieve;
    }

    @GetMapping("/user")
    public ResponseEntity<User> login(@AuthenticationPrincipal OAuth2User userDetails) {
        User user = accountRetrieve.save(userDetails);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
