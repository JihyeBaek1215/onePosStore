package onepos.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface menuRepository extends JpaRepository<Menu, Integer>{
	// 2. nativeQuery
	@Query(value =

	"select " +
	" a.menu_id , a.amt , a.menu_nm , a.qty , a.store_id , b.serv_tm " +
	"from store_menu a " +
	"	left join(select  " +
	"					  sale_menu_id " +
	"					 ,concat ( truncate (avg(time_to_sec(timediff(finished_dtm ,sale_dtm )) ) /60 , 0) , '분'  " +
	"					 ,truncate (mod (avg(time_to_sec(timediff(finished_dtm ,sale_dtm )) ) , 60)  , 0),'초') as serv_tm " +
	"				from store_sale " +
	"				group by sale_menu_id) b on( a.menu_id = b.sale_menu_id) " +
	"where a.store_id=?1 and a.qty > 0 "

	,nativeQuery = true)


	List<Menu> searchStore(Integer storeId);

}
