package onepos.controller;


import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;
import onepos.data.CommonRespDto;
import onepos.data.storeRepository;
import onepos.service.StoreService;
import onepos.data.StoreLoginReqDto;
import onepos.data.Store;

@RequiredArgsConstructor
@RestController
public class StoreController {

	private final storeRepository storeRepository;
	private final HttpSession session;

	private final StoreService storeService;

	@GetMapping("/stores/{id}") // 한건 찾기
	public CommonRespDto<?> findById(@PathVariable int id){

		return new CommonRespDto<>(1,"성공",storeService.한건찾기(id));
	}


	@PostMapping("/login") // 로그인처리
	public CommonRespDto<?> login(@RequestBody StoreLoginReqDto StoreLoginReqDto){
		Store storeEntity = storeService.로그인(StoreLoginReqDto);
		if(storeEntity ==null) {
			return new CommonRespDto<>(-1,"실패",null);
		}else {
			//storeEntity.setPassWd(passWd:null);
			session.setAttribute("principal", storeEntity);
			return new CommonRespDto<>(1,"성공",storeEntity);
		}
	}

	@GetMapping("/sales/{id}") //
	public CommonRespDto<?> findByIdSale(@PathVariable int id){

		return new CommonRespDto<>(1,"성공",storeService.매출조회(id));
	}



}
