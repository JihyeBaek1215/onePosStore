package onepos.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface menuRepository extends JpaRepository<Menu, Integer>{
	// 2. nativeQuery
	@Query(value = "SELECT * FROM store_menu WHERE store_id=?1 and qty > 0 ",nativeQuery = true)
	List<Menu> searchStore(Integer storeId);

}
