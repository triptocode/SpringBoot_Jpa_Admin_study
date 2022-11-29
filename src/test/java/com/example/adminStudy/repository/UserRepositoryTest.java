package com.example.adminStudy.repository;


import com.example.adminStudy.AdminStudyApplicationTests;
import com.example.adminStudy.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
       user.setAccount("TestUser02");
       user.setEmail("TestUser02@gmail.com");
       user.setPhoneNumber("010-1111-2222");
       user.setCreatedAt(LocalDateTime.now());
       user.setCreatedBy("TestUser2");

       User newUser = userRepository.save(user);
        System.out.println("newUser: " + newUser);
    }
    @Test
    public void read(){
        Optional<User> user = userRepository.findById(1L);
        user.ifPresent(selectUser ->{
            System.out.println("user : " + selectUser);
            System.out.println("email : " + selectUser.getEmail());
        });
    }
    @Test
    public void update() {
        Optional<User> user = userRepository.findById(2L);
        user.ifPresent(selectUser -> {
            selectUser.setPhoneNumber("010-2222-2222");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }
    public void delete(){

    }
}