package com.example.adminStudy.repository;


import com.example.adminStudy.AdminStudyApplicationTests;
import com.example.adminStudy.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;

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
       user.setAccount("TestUser01");
       user.setEmail("TestUser01@gmail.com");
       user.setPhoneNumber("010-1111-1111");
       user.setCreatedAt(LocalDateTime.now());
       user.setCreatedBy("admin");

       User newUser = userRepository.save(user);
        System.out.println("newUser: " + newUser);
    }

    public void read(){

    }

    public void update(){

    }

    public void delete(){

    }


}
