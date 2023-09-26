package com.example.ioc;

import com.example.config.MyConfig;
import com.example.config.MyConfigProto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PrintBeans {
    private final ApplicationContext applicationContext;
    private final MyConfig myConfig;
    private final MyConfigProto myConfigProto;

    @Bean
    public void printBeansMethod() {
//        MyConfig myConfig1 = applicationContext.getBean(MyConfig.class);
//        MyConfig myConfig2 = applicationContext.getBean(MyConfig.class);
//        MyConfig myConfig3 = applicationContext.getBean(MyConfig.class);

//        System.out.println(myConfig);
//        System.out.println(myConfig);
//        System.out.println(myConfig);
//
//        System.out.println(myConfigProto);
//        System.out.println(myConfigProto);
//        System.out.println(myConfigProto);
//
//        List<String> beans = Arrays.stream(applicationContext.getBeanDefinitionNames()).toList();
//        for (String bean : beans) {
//            System.out.println(bean);
//        }
    }
}
