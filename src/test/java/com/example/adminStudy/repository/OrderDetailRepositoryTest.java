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

        //어떤 고객?
        orderDetail.setUserId(1L);
        // 어떤 상품?
        orderDetail.setItemId(1L);
        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(newOrderDetail);
    }
}
