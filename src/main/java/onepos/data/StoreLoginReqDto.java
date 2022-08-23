package onepos.data;

import onepos.data.Store;
import lombok.Data;

@Data
public class StoreLoginReqDto {


	private int storeId;
	private String passWd ;

	public Store toEntity() {
		return Store.builder()
				.storeId(storeId)
				.passWd(passWd)
				.build();
	}

}
