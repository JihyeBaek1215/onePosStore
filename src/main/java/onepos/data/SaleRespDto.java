package onepos.data;


import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class SaleRespDto {

  int orderNumber ;
  int storeId ;
  String storeName;
  LocalDateTime saleDtm ;
  LocalDateTime finishedDtm ;
  int saleMenuId;
  String saleMenuNm;
  int saleAmt ;
  int saleQty ;
  String servTm ;

  private LocalDateTime createTime;


    public SaleRespDto(Sale sale) {
    	this.orderNumber = sale.getOrderNumber();
    	this.storeId =sale.getStoreId();
      this.storeName =sale.getStoreName();
      this.saleDtm =sale.getSaleDtm();
      this.finishedDtm =sale.getFinishedDtm();
      this.saleMenuId = sale.getSaleMenuId();
      this.saleMenuNm =sale.getSaleMenuNm();
      this.saleAmt = sale.getSaleAmt();
      this.saleQty =sale.getSaleQty();
      this.servTm=sale.getServTm();
    }




}
