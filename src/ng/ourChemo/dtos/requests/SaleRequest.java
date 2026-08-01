package ng.ourChemo.dtos.requests;

import java.util.ArrayList;
import java.util.List;

public class SaleRequest {

    private List<SaleItemRequest> saleItemRequestList = new ArrayList<>();

    public List<SaleItemRequest> getSaleItemRequestList() {
        return saleItemRequestList;
    }

    public void setSaleItemRequestList(List<SaleItemRequest> saleItemRequestList) {
        this.saleItemRequestList = saleItemRequestList;
    }


}
