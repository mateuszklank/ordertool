package pl.i4less.ordertool.entity.backmarket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdersListBackmarket {

    private int count;

    private String next;

    private String previous;

    private OrderBackmarket results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public OrderBackmarket getResults() {
        return results;
    }

    public void setResults(OrderBackmarket results) {
        this.results = results;
    }

}