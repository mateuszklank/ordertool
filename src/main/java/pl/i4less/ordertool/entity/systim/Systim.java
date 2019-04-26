package pl.i4less.ordertool.entity.systim;

import org.springframework.beans.factory.annotation.Value;

public class Systim {

    @Value("${systim.login}")
    private String login;

    @Value("${systim.pass}")
    private String pass;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}