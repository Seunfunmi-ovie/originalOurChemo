package ng.ourChemo.services;

import ng.ourChemo.data.repositories.MedicineRepository;
import ng.ourChemo.dtos.requests.AddMedicineRequest;
import ng.ourChemo.dtos.responses.AddMedicineResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MedicineServiceImplTest {

    private MedicineRepository medicineRepository;
    private MedicineService medicineService;

    @BeforeEach
    void setUp(){
        medicineRepository.deleteAll();
    }


    @Test
    public void testThatWeCanAddDrugToInventory(){
        AddMedicineRequest request = new AddMedicineRequest();
        request.setName("PARACETAMOL");
        request.setPrice(400.00);
        request.setInitialStock(50);

        AddMedicineResponse response = medicineService.addDrug(request);
        assertEquals("Medicine Successfully Added", response.getMessage());
        assertEquals(1,medicineRepository.save(medicine));


    }
}