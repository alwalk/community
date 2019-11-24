package life.male.community.provider;


import com.alibaba.fastjson.JSON;
import life.male.community.dto.AccessTokenDTO;
import life.male.community.dto.GithubUserDTO;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;


import java.io.IOException;


/**
 * @Description: java类作用描述
 * @Author: zhangjiale
 * @CreateDate: 2019/8/31 14:03
 * @Version: 1.0
 */
@Component
public class GithubProvider {

    /**
     * 通过向github发起一个post请求，来接收一个AccessToken
     * @param accessTokenDTO
     * @return
     */

    public String getAccessToken(AccessTokenDTO accessTokenDTO) {

        MediaType mediaType = MediaType.get("application/json;charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        okhttp3.RequestBody body = okhttp3.RequestBody.create(mediaType,com.alibaba.fastjson.JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String[] split = response.body().string().split("&");
            String token = split[0].split("=")[1];
            return token;
         /*   String string = response.body().string();
            System.out.println(string);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过AccessToken去github上获取用户的信息
     * @return
     */
    public GithubUserDTO getUser(String accessToken){


        OkHttpClient client = new OkHttpClient();


            Request request = new Request.Builder()
                    .url("https://api.github.com/user").addHeader("Authorization","token "+accessToken)
                    .build();

          try {
              Response response = client.newCall(request).execute();
              String string = response.body().string();
              GithubUserDTO githubUserDTO = JSON.parseObject(string, GithubUserDTO.class);
              return githubUserDTO;
          } catch (IOException e) {
              e.printStackTrace();
          }

        return null;
    }
}
