package pl.i4less.ordertool.entity.systim;

import org.springframework.lang.Nullable;

import java.util.List;

public class ResponseError {

    private int code;

    private String message;

    @Nullable
    private List fields;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Nullable
    public List getFields() {
        return fields;
    }

    public void setFields(@Nullable List fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "ResponseError{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", fields='" + fields + '\'' +
                '}';
    }

}