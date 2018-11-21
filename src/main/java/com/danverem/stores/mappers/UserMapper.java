package com.danverem.stores.mappers;

import com.danverem.stores.dtos.UserDTO;
import com.danverem.stores.models.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO mapTo(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setEmailAddress(user.getEmailAddress());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setInitials(user.getInitials());
        userDTO.setLastName(user.getLastName());
        userDTO.setPassword(user.getPassword());
        userDTO.setUsername(user.getUsername());

        return userDTO;
    }

    public static User mapTo(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setPassword(userDTO.getPassword());
        user.setEmailAddress(userDTO.getEmailAddress());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setID(userDTO.getID());
        user.setInitials(userDTO.getInitials());
        user.setUsername(userDTO.getUsername());

        return user;
    }

    public static List<UserDTO> mapTo(List<User> users) {
        if (users.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return users
            .stream()
            .map(user -> mapTo(user))
            .collect(Collectors.toList());
    }
}
