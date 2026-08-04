package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.Medicine;


import java.util.List;

public interface MedicineRepository {
    List<Medicine> findAll();
    Medicine findById(String id);
    void updateStock(String id,int newStock);
    Medicine save(Medicine medicine);
    void deleteAll();


}
