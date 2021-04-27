package com.itheima;

import com.itheima.domain.Person;
import com.itheima.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter02ApplicationTests {
    @Autowired //将Person作为Bean注入Spring容器，然后的contextLoads()方法中输出Person
    private Person person;
    @Autowired
    private Student student;

    @Test
    public void contextLoads() {
        System.out.println(person);
        System.out.println(student);
    }

}
