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

    // [14]
    @OneToMany(fetch =FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}
