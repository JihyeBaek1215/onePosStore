package onepos.data;


import java.time.LocalDateTime;


import lombok.Data;

@Data
public class StoreRespDto {

	int storeId; //매장ID(사업자번호)
	String storeName; //매장명
	String repName; //대표자명
	String repPhonNum; //대표자연락처
	String passWd ; //패스워드
	int tableCnt ; // 매장 테이블 수
  private LocalDateTime createTime;


    public StoreRespDto(Store store) {
    	this.storeId = store.getStoreId();
    	this.storeName =store.getStoreName();
    	this.tableCnt =store.getTableCnt();
    }
}
