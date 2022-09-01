package onepos.data;

import javax.persistence.*;

@Entity
@Table(name="store_menu") //메뉴
public class Menu {

    @Id @GeneratedValue
    int menuId;
    int storeId ;
    String menuNm;
    int amt ;
    int qty ;
    String servTm ; // 평균 조리시간
    // int prodId ; // 식자재 재고관리 추가시 구현
    // String prodNm ;

    public String getServTm() {
        return servTm;
    }
    public void setServTm(String servTm) {
        this.servTm = servTm;
    }
    public int getMenuId() {
        return menuId;
    }
    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    // public int getProdId() {
    //     return prodId;
    // }
    // public void setProdId(int prodId) {
    //     this.prodId = prodId;
    // }
    // public String getProdNm() {
    //     return prodNm;
    // }
    // public void setProdNm(String prodNm) {
    //     this.prodNm = prodNm;
    // }
    public int getStoreId() {
        return storeId;
    }
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }



    public String getMenuNm() {
        return menuNm;
    }
    public void setMenuNm(String menuNm) {
        this.menuNm = menuNm;
    }

    public int getAmt() {
        return amt;
    }
    public void setAmt(int amt) {
        this.amt = amt;
    }




}
