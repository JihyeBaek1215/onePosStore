package onepos.datakafka;
import onepos.AbstractEvent;
import java.util.Date;

public class Paid  extends AbstractEvent {


    int orderId; //주문번호
    int tableNum; //테이블 번호
    int price; //가격
    int storeId; //매장ID
    String payTool; //계산수단
    String payStatus; // 계산결과
    Date payDate; //계산 시간


    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getTableNum() {
        return tableNum;
    }
    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getStoreId() {
        return storeId;
    }
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    public String getPayTool() {
        return payTool;
    }
    public void setPayTool(String payTool) {
        this.payTool = payTool;
    }
    public String getPayStatus() {
        return payStatus;
    }
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }
    public Date getPayDate() {
        return payDate;
    }
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

}
