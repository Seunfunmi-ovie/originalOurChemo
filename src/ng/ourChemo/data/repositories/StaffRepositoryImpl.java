package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.Staff;

import java.util.ArrayList;
import java.util.List;

public class StaffRepositoryImpl implements StaffRepository {

    private static int count;
    private static List<Staff> users = new ArrayList<>();


    @Override
    public Staff save(Staff user){
        users.add(user);
        count++;
        return user;

    }

    @Override
    public long count(){
        return count;
    }

    @Override
    public void delete(Staff user){
        users.remove(user);
        count--;

    }

    @Override
    public void deleteAll(){
        users.clear();
        count = 0;
    }

    @Override
    public Staff findById(String id) {
        for (Staff user : users) {
            if (id.equals(user.getId())) {
                return user;
            }
        }
        return null;
    }

}
