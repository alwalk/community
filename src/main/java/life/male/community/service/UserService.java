package life.male.community.service;

import life.male.community.dto.GithubUserDTO;
import life.male.community.pojo.User;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


public interface UserService {

    void insertUser(GithubUserDTO user,String token);

    User findByToken(String token);
}
