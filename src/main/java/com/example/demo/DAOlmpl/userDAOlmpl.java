package com.example.demo.DAOlmpl;
//对数据库进行操作的实现
import com.example.demo.DAO.userDAO;
import com.example.demo.po.user;
import org.springframework.stereotype.Component;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component//用于AutoWrited
public class userDAOlmpl implements userDAO {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(user user) {
        mongoTemplate.save(user);
    }

    @Override
    public void removeUser(Long id) {
        Query query = new Query(Criteria.where("id").is(id));//查找其id字段的值与传入参数id相等的数据
        mongoTemplate.remove(query,user.class);
    }

    @Override
    public user findUserByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        user user = mongoTemplate.findOne(query,user.class);
        return user;
    }

    @Override
    public int updateUser(user user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("name",user.getName()).set("password",user.getPassword());
        //更新查询返回的结果集的第一条数据
        UpdateResult result = mongoTemplate.updateFirst(query,update,user.class);
        //更新查询到的所有结果集
        //UpdateResult all_result = mongoTemplate.updateMulti(query,update,User.class);
        if(result!= null)
            return (int) result.getModifiedCount();
        else
            return 0;
    }


}
