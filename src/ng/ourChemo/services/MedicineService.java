package ng.ourChemo.services;

import ng.ourChemo.dtos.requests.AddMedicineRequest;
import ng.ourChemo.dtos.requests.DeleteMedicineRequest;
import ng.ourChemo.dtos.requests.UpdateMedicineRequest;
import ng.ourChemo.dtos.responses.AddMedicineResponse;
import ng.ourChemo.dtos.responses.DeleteMedicineResponse;
import ng.ourChemo.dtos.responses.UpdateMedicineResponse;

public interface MedicineService {

    AddMedicineResponse addDrug(AddMedicineRequest request);
    UpdateMedicineResponse updateDrug(UpdateMedicineRequest request);
    DeleteMedicineResponse deleteDrug(DeleteMedicineRequest REQUEST);
}
