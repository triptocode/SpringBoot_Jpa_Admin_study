package com.example.adminStudy.repository;


import com.example.adminStudy.AdminStudyApplicationTests;
import com.example.adminStudy.model.entity.Item;
import com.example.adminStudy.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends AdminStudyApplicationTests {

    //  @Autowired  를 안붙이면
    // private UserRepository userRepository = new UserRepository; 를 통해서 객체를 생성하고
    //  public void create(){
    //          userRepository.save()
    //          userRepository.count()
    //    }
    // 이런식으로 메소드를 활욯하는 형태로 길어진다.
    @Autowired  // DI = Dependency Injection ( 위와같은 객체를 직접만들지않고 스프링에서 주입하도록 하는 디자인패턴)
    private UserRepository userRepository;

    @Test
    public void create(){
        //String sql = insert into user(%s, %s, %d) value (account, email, age);
       User user = new User();
       user.setAccount("TestUser05");
       user.setEmail("TestUser05@gmail.com");
       user.setPhoneNumber("010-5555-5555");
       user.setCreatedAt(LocalDateTime.now());
       user.setCreatedBy("TestUser5");

       User newUser = userRepository.save(user);
        System.out.println("newUser: " + newUser);
    }
    @Test
    @Transactional // [14.jpa] 2. 수정
    public void read(){
        Optional<User> user = userRepository.findById(2L);
        user.ifPresent(selectUser ->  // 위 findById가 1인 user가 존재할때만 {}를 실행
                        {
                            // [13.jpa] 1.
                            // System.out.println("user : " + selectUser);
                            // System.out.println("email : " + selectUser.getEmail());
                            // [14.jpa] 2.수정:	 위 두줄 주석처리, 아래 두줄을 추가
                             selectUser.getOrderDetailList().stream().forEach(
                                     //detail->{System.out.println(detail.getItemId()); }
                            // [14.jpa] 3.수정: ItemId를 Item item 으로 변경했으니 getItem으로 수정
                                     detail->{System.out.println(detail.getItem()); }
                             // [14.jpa] 4.수정: 위 코드와 동일하지만 변수 item 을 활용하여 작성도 가능
                             // detail->{
                             //Item item = detail.getItem();
                             // System.out.println(item);}
                             );
                        });
    }
    @Test
    public void update() {
        Optional<User> user = userRepository.findById(3L);
        user.ifPresent(selectUser -> {
            selectUser.setPhoneNumber("010-3333-3333");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }
    @Test
    public void delete(){
        Optional<User> user = userRepository.findById(2L);  // 조회  , L은 Id 타입 Long
        Assert.assertTrue(user.isPresent());  // 현재 반드시 값이 있는지여부가  true 여야 통과되게 함
        user.ifPresent(selectUser-> {userRepository.delete(selectUser);} );// 존재한다면, delete메소드로 삭제
        Optional<User> deleteUser = userRepository.findById(2L);  // 다시 해당 아이디로 조회해서 deleteUser에 넣고 , 아래 if else 문으로 삭제유무 체크
        Assert.assertFalse(deleteUser.isPresent());
//        if(deleteUser.isPresent()){
//            System.out.println("데이터 존재 : " + deleteUser.get());
//        }else{
//            System.out.println( "데이터 삭제로 데이터 없음");
//        }
    }
}