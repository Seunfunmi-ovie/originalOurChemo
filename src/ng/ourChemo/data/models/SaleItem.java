package ng.ourChemo.data.models;

public class SaleItem {

    private Medicine medicne;
    private int quantity;
    private double sellingPriceSale;
    private String medicineId;

    public Medicine getMedicne(){
        return medicne;
    }
    public void setMedicne(Medicine medicine){
        this.medicne = medicine;
    }

    public int getQuantity(){
        return quantity;

    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSellingPriceSale() {
        return sellingPriceSale;
    }

    public void setSellingPriceSale(double sellingPriceSale) {
        this.sellingPriceSale = sellingPriceSale;
    }

    public String getMedicineId(){
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }
}
