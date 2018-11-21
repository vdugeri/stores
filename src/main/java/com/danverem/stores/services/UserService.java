package com.danverem.stores.services;

import com.danverem.stores.models.User;
import com.danverem.stores.repositories.UserRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Stateless
@LocalBean
public class UserService {
    @Inject
    private UserRepository userRepository;

    /**
     * @author Verem Dugeri <verem.dugeri@gmail.com>
     *
     * @return List of users
     */
    public List<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * @author Verem Dugeri <verem.dugeri@gmail.com>
     *
     * @param user User
     *
     * @return created user
     */
    public User create(User user) {
        return userRepository.create(user);
    }

    /**
     * @author Verem Dugeri <verem.dugeri@gmail.com>
     *
     * @param ID user id
     * @return found user or null if the user does not exist
     */
    public Optional<User> find(Long ID) {
        return Optional.ofNullable(userRepository.find(ID));
    }

    /**
     * @author Verem Dugeri <verem.dugeri@gmail.com>
     *
     * @param user User to edit
     *
     * @return edited user
     */
    public User edit(User user) {
        return userRepository.edit(user);
    }

    /**
     * @author Verem Dugeri <verem.dugeri@gmail.com>
     *
     * @param ID user id
     */
    public void delete(Long ID) {
        userRepository.delete(ID);
    }
}
