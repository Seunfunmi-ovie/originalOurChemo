package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.Staff;

public interface StaffRepository {
    Staff save(Staff user);
    long count();
    void delete(Staff user);
    void deleteAll();
    Staff findById(String id);

}

