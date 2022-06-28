package models;

import datatest.GenToken.getDataToken;
import lombok.Data;

@Data
public class GenToken {

    private String username;
    private String password;

    private GenToken() {
        getDataToken getData = getDataToken.getDataJson();
        //assert getData != null;
        this.username = getData.getUsername();
        this.password = getData.getPassword();
    }

    public static GenToken getInstanceGenToken() {
        return new GenToken();
    }
}
