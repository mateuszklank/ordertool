package pl.i4less.ordertool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ValueAnnotationBean {

    private static String login;
    private static String pass;
    private static String number;
    private static String filePath;

    public ValueAnnotationBean(@Value("${systim.login}") String login, @Value("${systim.pass}") String pass, @Value("${systim.number}") String number, @Value("${path.nextId}") String filePath) {
        this.login = login;
        this.pass = pass;
        this.number = number;
        this.filePath = filePath;
    }

    public static String getLogin() {
        return login;
    }

    public static String getPass() {
        return pass;
    }

    public static String getNumber() {
        return number;
    }

    public static String getFilePath() {
        return filePath;
    }

}