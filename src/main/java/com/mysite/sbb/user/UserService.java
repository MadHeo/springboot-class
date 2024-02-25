package com.mysite.sbb.user;

import com.mysite.sbb.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String password, String email) {
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        this.userRepository.save(user);
        return user;
    }

    public SiteUser getUser(String username) {
        Optional<SiteUser> optionalSiteUser = this.userRepository.findByusername(username);

        if (optionalSiteUser.isPresent()) {
            return optionalSiteUser.get();
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }

    public boolean isLogin(String username, String password) {

        SiteUser siteUser = getUser(username);
        System.out.println(siteUser + "들어옴");
        if (siteUser != null) {
            String siteUserPassword = siteUser.getPassword();
            if (siteUserPassword.equals(password)) {
                System.out.println(siteUser + "맞음");
                return true;
            } else {
                System.out.println(siteUser + "틀림");
                return false;

            }
        } else {
            return false;
        }
    }
}