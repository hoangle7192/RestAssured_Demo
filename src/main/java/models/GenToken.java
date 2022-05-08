package models;

import lombok.Data;

@Data
public class GenToken {

    private String username;
    private String password;

    private GenToken() {
        this.username = "reblitz";
        this.password = "reblitz";
    }

    public static GenToken getInstanceGenToken() {
        return new GenToken();
    }
}
