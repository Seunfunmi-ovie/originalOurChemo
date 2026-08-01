
package ng.ourChemo.services;

import ng.ourChemo.data.models.Sale;
import ng.ourChemo.data.models.SaleItem;
import ng.ourChemo.data.repositories.SaleRepository;
import ng.ourChemo.data.repositories.SaleRepositoryImpl;
import ng.ourChemo.dtos.requests.SaleItemRequest;
import ng.ourChemo.dtos.requests.SaleRequest;
import ng.ourChemo.dtos.responses.SaleResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SaleServiceImplTest {

    private SaleRepository saleRepository;
    private SaleService saleService;

    @BeforeEach
    void setUp() {
        this.saleRepository = new SaleRepositoryImpl();
        this.saleService = new SaleServiceImpl(saleRepository);
        saleRepository.deleteAll();
    }

    @Test
    public void testThatSalesIsProcessedAndSaved() {
        SaleRequest saleRequest = new SaleRequest();

        SaleItemRequest item = new SaleItemRequest();
        item.setMedicineId("DRUG-123");
        item.setQuantity(5);

        if (saleRequest.getSaleItemRequestList() == null) {
            saleRequest.setSaleItemRequestList(new ArrayList<>());
        }
        saleRequest.getSaleItemRequestList().add(item);

        SaleResponse response = saleService.processSale(saleRequest);

        assertNotNull(response);
        assertEquals(1, saleRepository.findAll().size());
    }

    @Test
    public void testThat5QuantityOfDrugWasPurchasedAndSavedAs5Test() {
        SaleRequest saleRequest = new SaleRequest();

        SaleItemRequest item = new SaleItemRequest();
        item.setMedicineId("DRUG-123");
        item.setQuantity(5);

        if (saleRequest.getSaleItemRequestList() == null) {
            saleRequest.setSaleItemRequestList(new ArrayList<>());
        }
        saleRequest.getSaleItemRequestList().add(item);

        SaleResponse response = saleService.processSale(saleRequest);
        Sale savedSale = saleRepository.findAll().get(0);

        assertNotNull(response);
        assertEquals(1, savedSale.getItems().size());
        assertEquals(5, savedSale.getItems().get(0).getQuantity());
    }

    @Test
    public void testThatWeCanFindTransanctionById() {
        Sale sale = new Sale();
        String saleId = "Drug-1234e";

        sale.setSaleId(saleId);
        saleRepository.save(sale);

        Sale response = saleService.findSaleById(saleId);

        assertNotNull(response);
        assertEquals(saleId, response.getSaleId());
    }

    @Test
    public void testThatWeCanFindMedicineFromTransactionSlip() {
        Sale sale = new Sale();
        sale.setSaleId("PARA-100");

        if (sale.getItems() == null) {
            sale.setItems(new ArrayList<>());
        }

        SaleItem item = new SaleItem();
        item.setMedicineId("PARACETAMOL-123");
        item.setQuantity(2);
        sale.getItems().add(item);

        Sale response = saleRepository.save(sale);

//         saleService.findSaleById("PARA-100");

        assertNotNull(response);
        assertEquals("PARA-100", response.getSaleId());
        assertNotNull(response.getItems());
        assertEquals(1, response.getItems().size());
        assertEquals("PARACETAMOL-123", response.getItems().get(0).getMedicineId());
    }



}

