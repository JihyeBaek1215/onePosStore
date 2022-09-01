package onepos;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import onepos.config.kafka.KafkaProcessor;
import onepos.data.Sale;
import onepos.data.saleRepository;
import onepos.data.menuRepository;
import onepos.datakafka.Paid;
import onepos.datakafka.Served;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Optional;

@Service
public class PolicyHandler{


    /*이벤트 발생시간을 String 변환 저장시 사용*/
    final LocalDateTime localDateTimeNow = LocalDateTime.now();
    String parsedLocalDateTimeNow = localDateTimeNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));



    @Autowired
    saleRepository SaleRepository ;
    @Autowired
    menuRepository MenuRepository ;


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCreated(@Payload Paid paid){


                System.out.println("##### listener UpdateStatus: " + paid.toJson());


                int tempMenuId = 3 ; //계산에서 넘겨줄 경우 해당 값으로 변경
                int tempMenuQty = 1 ; //계산에서 넘겨줄 경우 해당 값으로 변경
                /*계산완료시*/
            if(paid.getPayStatus().equals("PaySucess")){

                /*1.매출등록 */
                Sale sale = new Sale();
                sale.setOrderNumber(paid.getOrderId()); // MSA 간 전달 파리미터/유형 협의 필요!!!!!!!!!!. Test 를 위해 임의값 대신 저장/
                sale.setSaleAmt(paid.getPrice());
                sale.setStoreId(paid.getStoreId());
                sale.setSaleDtm(LocalDateTime.now());
              //  sale.setSaleMenuId(paid.getMenuId()); //계산에서 넘겨줄 경우 해당 값으로 세팅
              //  sale.setSaleMenuNm(paid.getMenuNm()) //계산에서 넘겨줄 경우 해당 값으로 세팅
              //  sale.setSaleQty(paid.getQty()); //계산에서 넘겨줄 경우 해당 값으로 세팅
                SaleRepository.save(sale);


                /*2.메뉴수량 차감 */
                MenuRepository.findById(tempMenuId).ifPresent(menu->{
                    menu.setQty(menu.getQty() - tempMenuQty);
                    MenuRepository.save(menu) ;
                });

            }

    }

            /*서빙완료시 완료시간 갱신 . 테스트 안해봄*/
     public void whenServed(@Payload Served served){
        System.out.println("##### listener UpdateStatus: " + served.toJson());
        SaleRepository.findById(served.getOrderId()).ifPresent(sale->{
            sale.setFinishedDtm(LocalDateTime.now());
            SaleRepository.save(sale) ;
        });
     }


}
