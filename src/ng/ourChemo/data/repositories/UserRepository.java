package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.User;

public interface UserRepository {
    User save(User user);
    long count();
    void delete(User user);
    void deleteAll();
    User findById(String id);

}

