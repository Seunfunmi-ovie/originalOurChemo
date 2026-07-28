package ng.ourChemo.dtos.responses;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaleResponse {
    private String saleId;
    private LocalDateTime dateTime;
    private String processedBy;
    private List<String> items = new ArrayList<>();
    private double amount;




    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }
}
