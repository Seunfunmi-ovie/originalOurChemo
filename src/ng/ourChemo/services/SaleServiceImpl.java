package ng.ourChemo.services;

import ng.ourChemo.data.models.Sale;
import ng.ourChemo.data.models.SaleItem;
import ng.ourChemo.data.repositories.SaleRepository;
import ng.ourChemo.data.repositories.SaleRepositoryImpl;
import ng.ourChemo.data.repositories.StaffRepositoryImpl;
import ng.ourChemo.dtos.requests.SaleItemRequest;
import ng.ourChemo.dtos.requests.SaleRequest;
import ng.ourChemo.dtos.responses.SaleItemResponse;
import ng.ourChemo.dtos.responses.SaleResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public SaleResponse processSale(SaleRequest request) {
        Sale sale = new Sale();
        sale.setSaleId(UUID.randomUUID().toString());
        sale.setDateTime(LocalDateTime.now());

        List<SaleItem> saleItemList = new ArrayList<>();
        List<SaleItemResponse> itemResponseList = new ArrayList<>();

        for (SaleItemRequest item : request.getSaleItemRequestList()) {
            SaleItem saleItem = new SaleItem();
            saleItem.setMedicineId(item.getMedicineId());
            saleItem.setQuantity(item.getQuantity());
            saleItemList.add(saleItem);

            SaleItemResponse itemResponse = new SaleItemResponse();
            itemResponse.setMedicineId(item.getMedicineId());
            itemResponse.setQuantity(item.getQuantity());
            itemResponseList.add(itemResponse);
        }

        sale.setItems(saleItemList);
        saleRepository.save(sale);

        SaleResponse response = new SaleResponse();
        response.setSaleId(sale.getSaleId());
        response.setDateTime(sale.getDateTime());
        response.setItems(itemResponseList);

        return response;
    }

    @Override
    public SaleResponse cancelOrRefundSale(SaleRequest request) {
        Sale sale = new Sale();
        return null;




    }

    @Override
    public Sale findSaleById(String saleId) {
        return saleRepository.findById(saleId);
    }

    public boolean medicineOnReceipt(String salesId, String targetMedicineId) {
        Sale sale = saleRepository.findById(salesId);
        if (sale == null) {
            return false;
        }
        for (SaleItem item : sale.getItems()) {
            if (item.getMedicineId().equals(targetMedicineId)) {
                return true;
            }
        }
        return false;
    }

}
