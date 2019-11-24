package life.male.community.service.impl;

import life.male.community.dto.GithubUserDTO;
import life.male.community.mapper.UserMapper;
import life.male.community.pojo.User;
import life.male.community.pojo.UserExample;
import life.male.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @Description: java类作用描述
 * @Author: zhangjiale
 * @CreateDate: 2019/9/1 2:46
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(GithubUserDTO githubUser,String token) {
        User user = new User();
        user.setAccountId(String.valueOf(githubUser.getId()));
        user.setName(githubUser.getName());
        user.setToken(token);
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModitify(user.getGmtCreate());
        userMapper.insert(user);
    }

    @Override
    public User findByToken(String token) {
        UserExample example = new UserExample();
        example.createCriteria().andTokenEqualTo(token);
        User byToken = userMapper.selectByExample(example).get(0);
        if(null!=byToken){
            return byToken;
        }
        return null;
    }
}
