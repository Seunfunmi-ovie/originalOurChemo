package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl  implements  UserRepository{

    private int count;
    private List<User> users = new ArrayList<>();


    @Override
    public User save(User user){
        users.add(user);
        count++;
        return user;

    }

    @Override
    public long count(){
        return count;
    }

    @Override
    public void delete(User user){
        users.remove(user);
        count--;

    }

    @Override
    public void deleteAll(){
        users.clear();
        count = 0;
    }

    @Override
    public User findById(String id) {
        for (User user : users) {
            if (id.equals(user.getId())) {
                return user;
            }
        }
        return null;
    }

}
