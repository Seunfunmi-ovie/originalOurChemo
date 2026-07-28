package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.Medicine;

import java.util.ArrayList;
import java.util.List;

public class MedicineRepositoryImpl  implements MedicineRepository{

    private final List<Medicine> medicineList = new ArrayList<>();

    @Override
    public List<Medicine> findAll() {
        return medicineList;
    }


    @Override
    public Medicine findById(String id){
        for(Medicine medicine: medicineList){
            if(medicine.getId().equalsIgnoreCase(id)){
                return medicine;

            }
        }
        return null;
    }

    @Override
    public void updateStock(String id, int newStock){
        Medicine medicine = findById(id);
        if(medicine != null){
            medicine.setQuantityInStock(newStock);
        }

    }

}
