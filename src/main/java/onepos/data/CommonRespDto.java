package onepos.data;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonRespDto <T>{ //공통 리턴 용 DTO. 아래 3개 값으로 json 리턴

	private int satuteCode; // 상태코드 1은 정상 -1은 실패
	private String msg; // 오류내용
	private T respdata;

}
