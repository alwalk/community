package life.male.community.controller;

import org.slf4j.Logger;
import life.male.community.dto.AccessTokenDTO;
import life.male.community.dto.GithubUserDTO;
import life.male.community.provider.GithubProvider;
import life.male.community.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


/**
 * @Description: java类作用描述
 * @Author: zhangjiale
 * @CreateDate: 2019/8/31 13:58
 * @Version: 1.0
 */
@Controller
public class AuthorizeController {


    Logger logger =  LoggerFactory.getLogger(getClass());
    @Autowired
    private GithubProvider githubProvider;
    @Value("${github.clientId}")
    private String clientId;
    @Value("${github.clientSecret}")
    private String clientSecret;
    @Value("${github.redirectUri}")
    private String redirectUri;
    @Autowired
    private UserService userService;


    @RequestMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state,
                           HttpServletResponse response){
        logger.info("这是AuthorizeController的---------info日志");
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(redirectUri);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUserDTO githubUser = githubProvider.getUser(accessToken);
        if(null!=githubUser){
            String token = UUID.randomUUID().toString();
            userService.insertUser(githubUser,token);
            response.addCookie(new Cookie("token",token));
            return "redirect:/";
        }else {
            return "redirect:/";
        }

    }

}
