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




        if(paid.isMe()){
            System.out.println("##### listener1 UpdateStatus: " + paid.toJson());
                /*계산완료시*/
            if(paid.getPayStatus().equals("PaySucess")){
                int tempMenuId = Integer.parseInt(paid.getMenuId()) ;
                /*1.매출등록 */
                Sale sale = new Sale();
                sale.setOrderNumber(paid.getOrderId());
                sale.setSaleAmt(paid.getPrice());
                sale.setStoreId(paid.getStoreId());
                sale.setSaleDtm(LocalDateTime.now());
                sale.setSaleMenuId(tempMenuId);
                sale.setSaleMenuNm(paid.getMenuNm()) ;
                sale.setSaleQty(paid.getQty());
                SaleRepository.save(sale);


                /*2.메뉴수량 차감 */
                MenuRepository.findById(tempMenuId).ifPresent(menu->{
                    menu.setQty(menu.getQty() - paid.getQty());
                    MenuRepository.save(menu) ;
                });

            }
        }


    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCreated(@Payload Served served){


        if(served.isMe()){
            System.out.println("##### listener2 UpdateStatus: " + served.toJson());
              /*서빙완료시 완료시간 갱신 . */
            SaleRepository.findById(served.getOrderId()).ifPresent(sale->{
            sale.setFinishedDtm(LocalDateTime.now());
            SaleRepository.save(sale) ;
        });
        }


    }




}
