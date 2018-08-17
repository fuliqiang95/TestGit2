package com.fulq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.PrivateKey;

/**
 * 配置文件单独写配置信息的时候，controller类中使用 @Value 引用对象显示值
 * 当配置多的时候可以将多个配置进行分组，编写一个类引用get set方法，该类需要两个注解，
 * 分别为：@Component   @ConfigurationProperties(prefix = "girl")
 * 然后在controller类中使用注解 @Autowired 创建刚才那个类的对象，调用get方法获取值即可。
 */
@RestController
public class TestController {

    /*@Value("${cupSize}")
    private String cupSize;
    @Value("${content}")
    private String content;*/
    @Autowired
    private GirlProperties girlProperties;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        //return cupSize;
        //return content;
        //return "hello spring boot";
        return girlProperties.getCupSize()+girlProperties.getAge();
    }
}
