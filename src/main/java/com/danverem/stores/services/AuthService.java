package com.danverem.stores.services;

import com.danverem.stores.dtos.UserLogin;
import com.danverem.stores.dtos.UserToken;
import com.danverem.stores.mappers.UserMapper;
import com.danverem.stores.models.User;
import com.danverem.stores.repositories.UserRepository;
import com.danverem.stores.utils.JWTTokenGenerator;
import com.danverem.stores.utils.PasswordHash;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
@LocalBean
public class AuthService {

    @Inject
    private UserRepository userRepository;

    @Inject
    private JWTTokenGenerator tokenGenerator;

    public boolean logIn(UserLogin userLogin) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", userLogin.getUsername());

        List<User> userList = userRepository.findWithNamedQuery(User.FIND_BY_USERNAME, params, 1);

        if (userList.isEmpty()) {
            return false;
        }

        User user = userList.get(0);

        return new PasswordHash().compare(userLogin.getPassword().toCharArray(), user.getPassword());
    }

    public UserToken generateToken(UserLogin userLogin) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", userLogin.getUsername());

        List<User> userList = userRepository.findWithNamedQuery(User.FIND_BY_USERNAME, params, 1);

        User user = userList.get(0);

        String token = tokenGenerator.generateToken(user);

        return new UserToken().setToken(token).setUser(UserMapper.mapTo(user));
    }
}
