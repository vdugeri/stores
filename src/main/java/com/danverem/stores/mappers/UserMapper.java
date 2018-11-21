package com.danverem.stores.mappers;

import com.danverem.stores.dtos.UserDTO;
import com.danverem.stores.models.User;

public class UserMapper {

    public static UserDTO mapTo(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setEmailAddress(user.getEmailAddress());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setIntials(user.getInitials());
        userDTO.setLastName(user.getLastName());
        userDTO.setPassword(user.getPassword());
        userDTO.setUsername(user.getUsername());

        return userDTO;
    }
}
