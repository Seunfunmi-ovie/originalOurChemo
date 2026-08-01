package ng.ourChemo.services;

import ng.ourChemo.data.models.Medicine;
import ng.ourChemo.data.repositories.MedicineRepository;
import ng.ourChemo.dtos.requests.AddMedicineRequest;
import ng.ourChemo.dtos.requests.DeleteMedicineRequest;
import ng.ourChemo.dtos.requests.UpdateMedicineRequest;
import ng.ourChemo.dtos.responses.AddMedicineResponse;
import ng.ourChemo.dtos.responses.DeleteMedicineResponse;
import ng.ourChemo.dtos.responses.UpdateMedicineResponse;

public class MedicineServiceImpl implements MedicineService {
    private final MedicineRepository medicineRepository;

    public MedicineServiceImpl(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public AddMedicineResponse addDrug(AddMedicineRequest request) {
        Medicine medicine = new Medicine();
        medicine.setName(request.getName());
        medicine.setUnitPrice(request.getPrice());
        medicine.setQuantityInStock(request.getInitialStock());

        Medicine savedMedicine = medicineRepository.save(medicine);

        AddMedicineResponse response = new AddMedicineResponse();
        response.setMessage("Medicine Successfully Added");

        return response;
    }

    @Override
    public UpdateMedicineResponse updateDrug(UpdateMedicineRequest request) {
        return null;
    }

    @Override
    public DeleteMedicineResponse deleteDrug(DeleteMedicineRequest REQUEST) {
        return null;
    }
}
