package com.itheima;

import com.itheima.domain.Address;
import com.itheima.domain.Family;
import com.itheima.domain.Person;
import com.itheima.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname RedisTests
 * @Description TODO
 * @Date 2019-3-1 16:06
 * @Created by CrazyStone
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {
    @Autowired
    private PersonRepository repository;
    @Test
    public void savePerson() {
        Person person =new Person("张","有才");
        Person person2 =new Person("James","Harden");
        // 创建并添加住址信息
        Address address=new Address("北京","China");
        person.setAddress(address);
        // 创建并添加家庭成员
        List<Family> list =new ArrayList<>();
        Family dad =new Family("父亲","张良");
        Family mom =new Family("母亲","李香君");
        list.add(dad);
        list.add(mom);
        person.setFamilyList(list);
        // 向Redis数据库添加数据
        Person save = repository.save(person);
        Person save2 = repository.save(person2);
        System.out.println(save);
        System.out.println(save2);
    }
    @Test
    public void selectPerson() {
        List<Person> list = repository.findByAddress_City("北京");
        System.out.println(list);
    }
    @Test
    public void updatePerson() {
        Person person = repository.findByFirstnameAndLastname("张","有才").get(0);
        person.setLastname("小明");
        Person update = repository.save(person);
        System.out.println(update);
    }
    @Test
    public void deletePerson() {
        Person person = repository.findByFirstnameAndLastname("张","小明").get(0);
        repository.delete(person);
    }

}
