package com.baizhi.service;

import com.baizhi.entity.User;
import com.baizhi.entity.UserDTO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/10/28.
 */
public interface UserService {

    public List<User> queryAllUser();

    public Map selectUserByTime();

    public void add(User user);

    public void exportAll(HttpServletResponse response);

    public List<Map> selectAllUserDTO();

}
