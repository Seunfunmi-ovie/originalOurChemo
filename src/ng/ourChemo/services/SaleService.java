package ng.ourChemo.services;

import ng.ourChemo.data.models.Sale;
import ng.ourChemo.dtos.requests.SaleRequest;
import ng.ourChemo.dtos.responses.SaleResponse;

public interface SaleService {

    SaleResponse processSale(SaleRequest request);
    SaleResponse cancelOrRefundSale(SaleRequest request);
    Sale findSaleById(String saleId);

}
