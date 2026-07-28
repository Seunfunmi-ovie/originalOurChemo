package ng.ourChemo.dtos.requests;

public class SaleItemRequest {
    private String medicineId;
    private int quantity;


    public String getMedicineId(){
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
