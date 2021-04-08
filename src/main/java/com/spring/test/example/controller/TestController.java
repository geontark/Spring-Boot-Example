package com.spring.test.example.controller;

import com.spring.test.example.dto.Info;
import com.spring.test.example.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// @ResponseBody를 지원하는 컨트롤러라는 의미로, return 시킨 ResponseEntity를 ResponseBody에 담아 반환
@RestController
@RequestMapping("/test")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    // RequestParam: query string 을 mapping함, require 옵션으로 필수값 체크 할 수 있음
    // ex) http://localhost:8888/test/get/name=kim
    @GetMapping("/get")
    ResponseEntity<?> getHelloWorld(@RequestParam(required = false) String name){
        return new ResponseEntity<>(testService.myName(name), HttpStatus.OK);
    }

    // PathVariable: path 값을 mapping함
    // ex) http://localhost:o8888/test/post/50
    @PostMapping("/post/{age}")
    ResponseEntity<?> postHelloWorld(@PathVariable("age") Integer age){
        return new ResponseEntity<>(testService.myAge(age), HttpStatus.OK);
    }

    // RequestBody: body의 담긴 객체를 매핑
    @PutMapping("/put")
    ResponseEntity<?> putHelloWorld(@RequestBody Info info){
        return new ResponseEntity<>(testService.myInfo(info), HttpStatus.OK);
    }

    // RequestHeader: 헤더중 파라미터 명과 이름이 같은 header값을 가져옴
    @DeleteMapping("/delete")
    ResponseEntity<?> deleteHelloWorld(@RequestHeader String role, @RequestBody Info info){
        return new ResponseEntity<>(testService.myInfoWithRole(role, info), HttpStatus.OK);
    }
}