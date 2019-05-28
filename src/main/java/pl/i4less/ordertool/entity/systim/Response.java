package pl.i4less.ordertool.entity.systim;

public class Response {

    private ResponseError error;

    private String method;

    private int result;

    public ResponseError getError() {
        return error;
    }

    public void setError(ResponseError error) {
        this.error = error;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "error=" + error +
                ", method='" + method + '\'' +
                ", result=" + result +
                '}';
    }

}