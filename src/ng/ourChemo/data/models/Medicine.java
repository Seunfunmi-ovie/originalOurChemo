package ng.ourChemo.data.models;

import java.time.LocalDate;

public class Medicine {

    private String name;

    private String id;

    private String brandName;

    private String genericName;

    private String strength;

    private String dosageForm;

    private Manufacturer manufacturer;

    private String batchNumber;

    private LocalDate manufactureDate;

    private double unitPrice;

    private int quantityInStock;


    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getBrandName(){
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getStrength(){
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getDosageForm(){
        return dosageForm;
    }

    public void setDosageForm(String dosageForm){
        this.dosageForm = dosageForm;
    }

    public Manufacturer getManufacturer(){
        return manufacturer;
    }
    public void setManufacturer(Manufacturer manufacturer){
        this.manufacturer = manufacturer;
    }

    public String getBatchNumber(){
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber){
        this.batchNumber = batchNumber;
    }

    public LocalDate getManufactureDate(){
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public double getUnitPrice(){
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
    }

    public int getQuantityInStock(){

        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock){
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
