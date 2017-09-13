package dao;

import domain.User;

public interface UserDao {

     User findeUser(String name, String password);

}
