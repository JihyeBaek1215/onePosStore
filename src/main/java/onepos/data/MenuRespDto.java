package onepos.data;


import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class MenuRespDto {


  int menuId;
  int storeId ;
  String menuNm;
  int amt ;
  int qty ;
  String servTm ;

  private LocalDateTime createTime;


    public MenuRespDto(Menu menu) {
    	this.menuId = menu.getMenuId();
    	this.menuNm =menu.getMenuNm();
      this.amt =menu.getAmt();
      this.qty =menu.getQty();
      this.storeId =menu.getStoreId();
      this.servTm =menu.getServTm();
    }




}
