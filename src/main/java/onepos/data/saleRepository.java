package onepos.data;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface saleRepository extends JpaRepository<Sale, Integer>{
	// 2. nativeQuery
	@Query(value =

	//"select * from store_sale where store_id=?1"

	"select a.order_number ,a.finished_dtm  , a.sale_amt  , a.sale_dtm  , a.sale_menu_id , a.sale_menu_nm " +
	", a.sale_qty , a.store_id , a.store_name ,concat ( truncate (time_to_sec(timediff(finished_dtm ,sale_dtm ))  /60 , 0) , '분',truncate (mod (time_to_sec(timediff(finished_dtm ,sale_dtm ))  , 60)  , 0),'초') as serv_tm " +
	"from store_sale a " +
	"where store_id =?1 "

	,nativeQuery = true)


	List<Sale> searchSale(Integer storeId);
}
