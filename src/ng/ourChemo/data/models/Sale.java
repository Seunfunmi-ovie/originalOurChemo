package ng.ourChemo.data.models;

import java.time.LocalDateTime;
import java.util.List;


public class Sale {
    private String saleId;

    private LocalDateTime dateTime;

    private Staff user;

    private List<SaleItem> items;

    private double totalAmount;

    public String getSaleId(){
        return saleId;
    }
    public void setSaleId(String saleId){
        this.saleId = saleId;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
