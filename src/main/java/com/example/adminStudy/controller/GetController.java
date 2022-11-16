package com.example.adminStudy.controller;

import com.example.adminStudy.model.SearchParam;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class GetController {

    @RequestMapping(method= RequestMethod.GET, path="/getMethod")  // http://localhost:8080/api/getMethod
    public String getRequest(){
        return "This is getMethod";
    }

    @GetMapping("/getParameter")  // http://localhost:8080/api/getParameter?id=abcd&password=1234
    public String getParameter(@RequestParam String id, @RequestParam(name="password") String pw ){
        String password = "1234";
        System.out.println("id: "+id);
        System.out.println("pw: "+pw);

        return id+pw;
    }

//    public String getMultiParameter(@RequestParam String account,
//                                    @RequestParam String email,
//                                    @RequestParam int page){
//                                    }

    @GetMapping("/getMultiParameter")  // http://localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    public String getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return "OK";
    }

}


