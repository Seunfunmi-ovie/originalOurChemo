package ng.ourChemo.services;

import ng.ourChemo.data.models.Medicine;
import ng.ourChemo.data.repositories.MedicineRepository;
import ng.ourChemo.data.repositories.MedicineRepositoryImpl;
import ng.ourChemo.dtos.requests.AddMedicineRequest;
import ng.ourChemo.dtos.responses.AddMedicineResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MedicineServiceImplTest {

    private MedicineRepository medicineRepository;
    private MedicineService medicineService;

    @BeforeEach
    void setUp() {
        medicineRepository = new MedicineRepositoryImpl();
        medicineService = new MedicineServiceImpl(medicineRepository);
    }

    @AfterEach
    void tearDown() {
        medicineRepository.deleteAll();
    }

    @Test
    public void testThatWeCanAddDrugToInventory() {
        AddMedicineRequest request = new AddMedicineRequest();
        request.setName("PARACETAMOL");
        request.setPrice(400.00);
        request.setInitialStock(50);

        AddMedicineResponse response = medicineService.addDrug(request);

        assertEquals("Medicine Successfully Added", response.getMessage());

        Medicine savedMedicine = medicineRepository.findById("1");
        assertNotNull(savedMedicine);
        assertEquals("PARACETAMOL", savedMedicine.getName());
        assertEquals(400.00, savedMedicine.getUnitPrice());
        assertEquals(50, savedMedicine.getQuantityInStock());
    }
}
