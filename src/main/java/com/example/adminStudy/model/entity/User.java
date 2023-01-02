package com.example.adminStudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data // 기본생성자와 변수에 대해 get set 메소드 자동완성
@AllArgsConstructor // 모든매개변수가 들어가는 생성자 자동완성
@NoArgsConstructor
@Entity // 하단의 User라는 객체(camel_case)에 맞는 table명(snake_case)에 연결
public class User {
//@Table(name="user")  데이터베이스의 테이블명이랑 아래의 클래스명이 같으면 생략가능

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) // 관리 전략인데 Mysql 사용중이라  GenerationType.IDENTITY
    private Long id;
//@Column (name = "account") 데이터베이스의 컬럼명이랑 아래의 변수명이 같으면 생략가능
    private String account;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    // [14]
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")  //
    private List<OrderDetail> orderDetailList;  // <OrderDetail> 에서 OrderDetail라는 클래스를 의미
}
