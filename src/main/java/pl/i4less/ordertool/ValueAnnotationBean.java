package pl.i4less.ordertool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueAnnotationBean {

    public final String login;
    public final String pass;
    public final String number;

    @Autowired
    public ValueAnnotationBean(@Value("${systim.login}") String login, @Value("${systim.pass}") String pass, @Value("${systim.number}") String number) {
        this.login = login;
        this.pass = pass;
        this.number = number;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public String getNumber() {
        return number;
    }

}