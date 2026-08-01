package ng.ourChemo.dtos.responses;

public class AddMedicineResponse {

        private String name;
        private double price;
        private String message;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}




