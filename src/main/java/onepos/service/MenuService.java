package onepos.service;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import onepos.data.Menu;
import onepos.data.menuRepository;
import onepos.data.MenuRespDto;


@RequiredArgsConstructor
@Service
public class MenuService {


	private final menuRepository menuRepository;

	@Transactional(readOnly = true) // 변경감지 자체를 수행안한다. select하는곳에는 다 붙혀줘야함
	public List<MenuRespDto> 메뉴조회 (int id) {


		List<Menu> menuEntity = menuRepository.searchStore(id);


		List<MenuRespDto> MenuRespDtos = new ArrayList<>();
	    for (Menu menu : menuEntity) {
	    	MenuRespDtos.add(new MenuRespDto(menu));
		}


		return MenuRespDtos;
	}

}
