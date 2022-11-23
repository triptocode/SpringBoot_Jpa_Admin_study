package com.example.adminStudy.model;
import lombok.AllArgsConstructor;
import lombok.Data;

// 16번줄이하 주석처리한 get, set 메소드 외에 생성자까지 자동생성해주는 lombok 의 @Data 와 @AllArgConstructor
@Data
@AllArgsConstructor
public class SearchParam {

    private String account;
    private String email;
    private int page;



//    public String getAccount() { return account; }
//    public void setAccount(String account) { this.account = account;}

//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }

//    public int getPage() { return page; }
//    public void setPage(int page) { this.page = page; }

}
