package life.male.community.dto;

/**
 * @Description: java类作用描述
 * @Author: zhangjiale
 * @CreateDate: 2019/8/31 15:42
 * @Version: 1.0
 */
public class GithubUserDTO {

    private String name;
    private Long id;
    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
