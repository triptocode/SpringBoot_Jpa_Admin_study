package com.example.adminStudy.repository;

import com.example.adminStudy.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 제네릭 <User, Long>  설명 : User 라는 entity(=DB테이블),  Long은  그 엔터티의 기본키 인덱스 ID의 타입
    // 1. @Entity 생성:  (User.java파일에) DB테이블과 매칭되는 @Entity 테이블 생성후,
    // 2. @Repository 생성: (interface UserRepositor파일에) 따로 쿼리문 없이도 CRUD를 할수있는 레파지토리 생성
    // 1+2 단계인 @Entity와 @Repository 과정을 거쳐 디비매칭과 crud 작업을 할 수 있게 됨
}
