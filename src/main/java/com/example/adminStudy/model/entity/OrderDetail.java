package com.example.adminStudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data // 기본생성자와 변수에 대해 get set 메소드 자동완성
@AllArgsConstructor // 모든매개변수가 들어가는 생성자 자동완성
@NoArgsConstructor
@Entity // 하단의 OrderDetail라는 객체(camel_case)에 맞는 table명(snake_case)에 연결, 즉 order_detail
@ToString(exclude = {"user","item"}) // [14] @ManyToOne User user, Item item 상호참조 overflow오류해결
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderAt;
    // [13]
    // private Long userId;
    // [14] private Long userId 를 아래 User user로 바꿈 (hibernate가 알아서 userId를 찾아감 )
    @ManyToOne
    private User user;
    // hibernate 를 통한 연관관계 설정은 반드시 객체이름(User user)을 적어줘야한다.

    // [13]
    //private Long itemId;
    // [14] 더 상단 Long userId를 --> User user로 바꾼 이유와 동일
    @ManyToOne
    private Item item;  // Long 타입 column과 매칭되는 itemId

}

