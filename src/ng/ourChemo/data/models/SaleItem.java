package ng.ourChemo.data.models;

public class SaleItem {

    private Medicine medicne;
    private int quantity;
    private double sellingPriceSale;

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
}
