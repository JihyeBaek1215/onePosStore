package onepos.service;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import onepos.data.CommonRespDto;
import onepos.data.Store;
import onepos.data.StoreRespDto;
import onepos.data.storeRepository;
import onepos.data.StoreLoginReqDto;

import onepos.data.Sale;
import onepos.data.SaleRespDto;
import onepos.data.saleRepository;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class StoreService {


	private final storeRepository storeRepository;

	@Transactional(readOnly = true) // 변경감지 자체를 수행안한다. select하는곳에는 다 붙혀줘야함
	public StoreRespDto 한건찾기(int id) {

		Store storeEntity =storeRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("id를 찾을수 없습니다.");
		});

		StoreRespDto userRespDto = new StoreRespDto(storeEntity);
		return userRespDto;
	}

	@Transactional(readOnly = true) // 변경감지 자체를 수행안한다. select하는곳에는 다 붙혀줘야함
	public Store 로그인(StoreLoginReqDto StoreLoginReqDto) {
		Store storeEntity = storeRepository.findByStoreIdAndPassWd(StoreLoginReqDto.getStoreId(), StoreLoginReqDto.getPassWd());
		return storeEntity;
	}


	private final saleRepository saleRepository;

	@Transactional(readOnly = true) //메뉴조회 변경감지 자체를 수행안한다. select하는곳에는 다 붙혀줘야함
	public List<SaleRespDto> 매출조회 (int id) {

		List<Sale> saleEntity = saleRepository.searchSale(id);

		List<SaleRespDto> SaleRespDto = new ArrayList<>();
	    for (Sale sale : saleEntity) {
	    	SaleRespDto.add(new SaleRespDto(sale));
		}
		return SaleRespDto;
	}


}
