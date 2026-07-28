package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.Sale;

import java.util.ArrayList;
import java.util.List;

public class SaleRepositoryImpl implements SaleRepository{
    private int count;
    private final List<Sale> saleList = new ArrayList<>();

    @Override
   public List<Sale> findAll(){
        return saleList;
    }

    @Override
    public Sale save(Sale sale){
        saleList.add(sale);
        count++;
        return sale;

    }

    @Override
    public Sale findById(String saleId){
        for(Sale sale: saleList){
            if(saleId.equals(sale.getSaleId())){
                return sale;
            }

        }
            return null;
    }

}
