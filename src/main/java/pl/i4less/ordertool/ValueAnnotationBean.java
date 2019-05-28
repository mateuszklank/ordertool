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
    private static String datePath;

    public ValueAnnotationBean(@Value("${systim.login}") String login, @Value("${systim.pass}") String pass, @Value("${systim.number}") String number, @Value("${path.nextId}") String filePath, @Value("${path.date}") String datePath) {
        this.login = login;
        this.pass = pass;
        this.number = number;
        this.filePath = filePath;
        this.datePath = datePath;
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

    public static String getDatePath() {
        return datePath;
    }

}