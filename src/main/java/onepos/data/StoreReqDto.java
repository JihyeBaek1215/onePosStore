package onepos.data;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Data
public class StoreReqDto {


    int storeId; //매장ID(사업자번호)
    String passWd ; //패스워드


    public StoreReqDto(Store store) {
    	this.storeId = store.getStoreId();
    	this.passWd = store.getPassWd() ;
    }



}
