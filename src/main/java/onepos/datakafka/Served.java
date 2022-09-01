package onepos.datakafka;

import onepos.AbstractEvent;

public class Served extends AbstractEvent {


    private int id; // 서빙Table ID
    private String holeflag; //홀.포장 구분
    private int tableNo;  //테이블 번호
    //private List<integer> //주문 메뉴 리스트
    private int orderId; //주문 테이블 Key
    private int storeId; //매장 ID
    private String status; //서빙 진행사항
    private String regDate ; //저장 시간


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getHoleflag() {
        return holeflag;
    }
    public void setHoleflag(String holeflag) {
        this.holeflag = holeflag;
    }
    public int getTableNo() {
        return tableNo;
    }
    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getStoreId() {
        return storeId;
    }
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getRegDate() {
        return regDate;
    }
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }


}
