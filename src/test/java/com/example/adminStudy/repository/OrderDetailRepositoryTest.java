package com.example.adminStudy.repository;

import com.example.adminStudy.AdminStudyApplicationTests;
import com.example.adminStudy.model.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends AdminStudyApplicationTests {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderAt(LocalDateTime.now());

        //어떤 User - [14]  orderDetail.setUserId(2L);를 주석처리! 이유: OrderDetail.java파일에 private Long userId;를(주석처리)  --> User user로 변경해서
        //orderDetail.setUserId(2L);
        // 어떤 Item? - [14] orderDetail.setItemId(3L);를 주석처리! 위와 동일이유 - OrderDetail.java파일에 private Long itemId;를 --> Item item으로 변경해서
        //orderDetail.setItemId(3L);

         OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
         Assert.assertNotNull(newOrderDetail);
    }
}
