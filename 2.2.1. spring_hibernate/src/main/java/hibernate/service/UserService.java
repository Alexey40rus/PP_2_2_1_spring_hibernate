package hibernate.service;

import hibernate.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    User getUserByCar(String model, int series);
}
