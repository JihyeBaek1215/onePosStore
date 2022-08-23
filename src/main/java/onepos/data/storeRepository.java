package onepos.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import onepos.data.Store;

public interface storeRepository extends JpaRepository<Store, Integer>{

  Store findByStoreIdAndPassWd(int storeId,String passWd);

}
