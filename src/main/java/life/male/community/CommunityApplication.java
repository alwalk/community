package life.male.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//这个是把src/main/java下面的mapper接口放入到ioc容器中，也可以在每一个接口中写@mapper
@MapperScan("life.male.community.mapper")
public class CommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
    }

}
