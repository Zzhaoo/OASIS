package com.example.demo.DAO;
import com.example.demo.po.user;

//对数据库进行操作的接口
public interface userDAO {
    public void saveUser(user user);    //新增数据
    public void removeUser(Long id);    //删除数据
    public user findUserByName(String name);    //通过名字查找数据
    public int updateUser(user user);           //修改数据
}
