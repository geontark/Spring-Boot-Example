package com.spring.test.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// @PropertySource를 추가하여 필요한 yml파일을 지정해주고,
// 만들어둔 YamlPropertySourceFactory을 factory에 등록
// 만약 yml 파일이 아닌 properties 파일을 추가할 경우에는 factory를 등록하지 않고 사용하면 됨
// ignoreResourceNotFound는 지정한 resource 파일을 찾을 수 없을 경우 에러를 발생여부를 지정함
@Configuration
@PropertySource(value = "classpath:constants.yml", // class path 설정
        factory = YamlPropertySourceFactory.class, ignoreResourceNotFound = true)
public class CustomConfig {
    public CustomConfig(@Value("${info.name}") String name) {
        // use Your constants
    }
}
