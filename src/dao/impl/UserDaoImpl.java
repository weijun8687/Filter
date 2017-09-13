package dao.impl;

import dao.UserDao;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private QueryRunner runner = new QueryRunner();
    public User findeUser(String name, String password) {
        try {
            return runner.query("select * from user where name=? and password=?", new BeanHandler<User>(User.class), name, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
