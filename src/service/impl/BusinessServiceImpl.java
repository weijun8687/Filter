package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.BusinessService;

public class BusinessServiceImpl implements BusinessService {

    private UserDao dao = new UserDaoImpl();
    public User login(String name, String password) {

        return dao.findeUser(name, password);
    }
}
