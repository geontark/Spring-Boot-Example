package com.spring.test.example.service;

import com.spring.test.example.dto.Info;
import org.springframework.stereotype.Service;

// requestBody에 실질적으로 들어가게 되는 결과를 만드는곳
@Service // 컨트롤러에 반환되는 비즈니스 로직임을 명시!
public class TestService {
    public String myName(String name) {
        if(name != null) {
            return "my name is " + name;
        }else {
            return "no name param";
        }
    }

    public String myAge(Integer age) {
        if(age != null) {
            return "my age is " + age;
        }else {
            return "no age param";
        }
    }

    public String myInfo(Info info) {
        // return myName(info.getName()) + " / " + myAge(info.getAget());
        return myName(info.getName()) + " / " + myAge(info.getAge());
    }

    public String myInfoWithRole(String role, Info info) {
        return role + " / " + myInfo(info);
    }

}
