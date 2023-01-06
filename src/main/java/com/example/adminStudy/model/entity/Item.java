package com.example.adminStudy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor // 모든매개변수가 들어가는 생성자 자동완성
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private String content;

    // [15]
    // LAZY 지연로딩 vs EAGER 즉시로딩 차이
    // => itemRepositoryTest.java 에서 read() 조회값에 테이블을 모두 join하는지 유무차이

    // 1) LAZY 로딩  : orderDetailList변수를 get으로 호출하지 않는 이상 연관관계설정(ex @OneToMany)한 테이블들을  조회 x
    // Hibernate: select item0_.id as id1_0_0_, item0_.content as content2_0_0_, item0_.name as name3_0_0_, item0_.price as price4_0_0_ from item item0_ where item0_.id=?
    //@OneToMany(fetch =FetchType.LAZY, mappedBy = "item")
    //private List<OrderDetail> orderDetailList;
    // 2) EAGER 로딩: @OneToMany등 연관관계 설정을 한 모든 테이블에 대해 아래처럼 join이 일어난다.
    // EAGER 문제점과 추천사항 : EAGER는 모든연관관계테이블을 JOIN해서 성능저하나, 모든 값을 제대로 가져오지 못랄수 있기에, 1:1 , @ManyToOne등 한건만 존재할때 EAGER추천
    // Hibernate: select item0_.id as id1_0_0_, item0_.content as content2_0_0_, item0_.name as name3_0_0_, item0_.price as price4_0_0_, orderdetai1_.item_id as item_id3_1_1_, orderdetai1_.id as id1_1_1_, orderdetai1_.id as id1_1_2_, orderdetai1_.item_id as item_id3_1_2_, orderdetai1_.order_at as order_at2_1_2_, orderdetai1_.user_id as user_id4_1_2_, user2_.id as id1_2_3_, user2_.account as account2_2_3_, user2_.created_at as created_3_2_3_, user2_.created_by as created_4_2_3_, user2_.email as email5_2_3_, user2_.phone_number as phone_nu6_2_3_, user2_.updated_at as updated_7_2_3_, user2_.updated_by as updated_8_2_3_
    // from item item0_ left outer join order_detail orderdetai1_ on item0_.id=orderdetai1_.item_id left outer join user user2_ on orderdetai1_.user_id=user2_.id
    // where item0_.id=?
    // 즉,
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?

    @OneToMany(fetch =FetchType.EAGER, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}
