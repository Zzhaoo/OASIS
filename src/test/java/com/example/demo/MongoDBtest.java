package com.example.demo;

import com.example.demo.DAOlmpl.userDAOlmpl;
import com.example.demo.po.user;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDBtest {
    @Autowired
    private userDAOlmpl userImp;

    @org.junit.Test
    public void saveUser() {
        user u = new user();
        u.setId(2L);
        u.setPassword("123456asfa");
        u.setName("xiaoming");
        u.setAge(24);
        userImp.saveUser(u);
    }

    @org.junit.Test
    public void removeUser() {
        userImp.removeUser(1L);
    }

    @org.junit.Test
    public void findUserByName() {
        user u = userImp.findUserByName("xiaoming");
        System.out.println(u);
    }

    @org.junit.Test
    public void updateUser() {
        user u = new user();
        u.setId(1L);
        u.setName("abcedf");
        u.setPassword("qwerttyui");
        int update_num = userImp.updateUser(u);
        System.out.println("update num:" + update_num);
    }
}


