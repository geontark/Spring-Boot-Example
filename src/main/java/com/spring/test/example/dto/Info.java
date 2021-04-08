package com.spring.test.example.dto;

import lombok.Data;

// Request Body의 model을 만들기 위한 Date to object
// Lombok 에서 제공해주는 annotation으로 getter, sestter를 생성해줌
@Data
public class Info {
    String name;
    Integer age;
}
