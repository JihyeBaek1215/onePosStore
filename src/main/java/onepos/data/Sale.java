package onepos.data;

import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="store_sale") //매출등록. "정산 MSA" 에 설계 되었으나 일단 매장에 넣음
public class Sale {

    @Id
    int orderNumber ;
    int storeId ;
    String storeName;
    String saleDtm ;

/* 주문과 메뉴를 같이 처리할 경우 */
    int saleMenuId;
    public int getSaleMenuId() {
        return saleMenuId;
    }
    public void setSaleMenuId(int saleMenuId) {
        this.saleMenuId = saleMenuId;
    }

    String saleMenuNm;
    public String getSaleMenuNm() {
        return saleMenuNm;
    }
    public void setSaleMenuNm(String saleMenuNm) {
        this.saleMenuNm = saleMenuNm;
    }

    int saleAmt ;
    public int getSaleAmt() {
      return saleAmt;
    }
    public void setSaleAmt(int saleAmt) {
      this.saleAmt = saleAmt;
    }

    int saleQty ;
    public int getSaleQty() {
        return saleQty;
    }
    public void setSaleQty(int saleQty) {
        this.saleQty = saleQty;
    }
/* 주문과 메뉴를 같이 처리할 경우 */




/* 주문의 메뉴를 별도로 뺄 경우 아래로 처리 한다
    @Embedded  // 1:1
    SalemenuId oneMenu;

        public SalemenuId getOneMenu() {
            return oneMenu;
        }

        public void setOneMenu(SalemenuId oneMenu) {
            this.oneMenu = oneMenu;
        }

    @ElementCollection // 1:n
    List<SalemenuId> menuIds;


        public List<SalemenuId> getMenuIds() {
                return menuIds;
        }

        public void setMenuIds(List<SalemenuId> menuIds) {
                this.menuIds = menuIds;
        }
*/









    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getStoreId() {
        return storeId;
    }
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getSaleDtm() {
        return saleDtm;
    }
    public void setSaleDtm(String saleDtm) {
        this.saleDtm = saleDtm;
    }






}
