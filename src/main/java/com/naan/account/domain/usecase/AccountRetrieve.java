package com.naan.account.domain.usecase;

import com.naan.account.domain.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface AccountRetrieve {
    User save(OAuth2User oAuth2User);
}
