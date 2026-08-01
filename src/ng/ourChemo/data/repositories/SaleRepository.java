package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.Sale;

import java.util.List;

public interface SaleRepository {
    Sale save(Sale sale);
    List<Sale> findAll();
    Sale findById(String saleId);
    void deleteAll();
}
