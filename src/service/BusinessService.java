package service;

import domain.User;

public interface BusinessService {

    /**
     * 用户登录
     * @param name
     * @param password
     * @return  错误返回null
     */
    User login(String name, String password);
}
