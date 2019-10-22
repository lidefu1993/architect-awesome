package com.ldf.architect.base.proxy;

/**
 * @author lidefu
 * @date 2019/9/25 7:40
 */
public class UserServiceImpl implements UserService {

    @Override
    public String getName() {
        return "ldf";
    }

    @Override
    public String getAge() {
        return "26";
    }

}
