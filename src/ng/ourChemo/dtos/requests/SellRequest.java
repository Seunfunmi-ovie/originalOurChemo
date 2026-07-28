package ng.ourChemo.dtos.requests;

import java.util.ArrayList;
import java.util.List;

public class SellRequest {

        private  List<SaleItemRequest> saleItemRequestList =new ArrayList<>();

        public List<SaleItemRequest> saleItemRequestList(){
            return saleItemRequestList;
    }

    public void SaleItemRequestList(List<SaleItemRequest> saleItemRequestList){
            this.saleItemRequestList = saleItemRequestList;
    }

}
