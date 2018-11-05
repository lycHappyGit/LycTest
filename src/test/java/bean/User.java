package bean;

import lombok.Data;

@Data
public class User {

    private String name;

    private String likes;

    public User(String name, String likes) {
        this.name = name;
        this.likes = likes;
    }
}
