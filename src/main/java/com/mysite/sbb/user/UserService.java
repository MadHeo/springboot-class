package com.mysite.sbb.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String password, String email) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        SiteUser siteUser = new SiteUser();
        siteUser.setUsername(username);
        siteUser.setPassword(password);
        siteUser.setEmail(email);
//        siteUser.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(siteUser);

        return siteUser;
    }
}
