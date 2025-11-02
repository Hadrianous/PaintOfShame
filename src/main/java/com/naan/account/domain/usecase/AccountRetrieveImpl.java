package com.naan.account.domain.usecase;

import com.naan.account.domain.User;
import com.naan.account.domain.UserRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountRetrieveImpl implements AccountRetrieve {

    private final UserRepository userRepository;

    public AccountRetrieveImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(OAuth2User oAuth2User) {
        String login = (String) oAuth2User.getAttributes().get("login");

        Optional<User> maybeUser = userRepository.findByUsername(login);
        User user = maybeUser.orElseGet(() -> new User(login));
        return userRepository.save(user);
    }
}
