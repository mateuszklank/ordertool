package pl.i4less.ordertool.entity.backmarket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdersList {

    private int count;

    private String next;

    private String previous;

    private List<Order> results;

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

    public List<Order> getResults() {
        return results;
    }

    public void setResults(List<Order> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "OrdersList{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", results=" + results +
                '}';
    }

    public void convertOrders(OrdersList ordersList) {
        for(int i = 0; i < ordersList.getResults().size(); i++) {
            pl.i4less.ordertool.entity.systim.Order orderSystim = new pl.i4less.ordertool.entity.systim.Order();
            orderSystim.setNazwa(ordersList.getResults().get(i).getShipper());
            orderSystim.setKod(ordersList.getResults().get(i).getShipping_address().getPostal_code());
            orderSystim.setMiejscowosc(ordersList.getResults().get(i).getShipping_address().getCity());
            orderSystim.setUlica(ordersList.getResults().get(i).getShipping_address().getStreet() + ordersList.getResults().get(i).getShipping_address().getStreet2());
            orderSystim.setNazwa_dostawy(ordersList.getResults().get(i).getShipping_address().getLast_name());
            orderSystim.setKod_dostawy(ordersList.getResults().get(i).getShipping_address().getPostal_code());
            orderSystim.setMiejscowosc_dostawy(ordersList.getResults().get(i).getShipping_address().getCity());
            orderSystim.setUlica_dostawy(ordersList.getResults().get(i).getShipping_address().getStreet() + ordersList.getResults().get(i).getShipping_address().getStreet2());
            orderSystim.setId_dostawy(ordersList.getResults().get(i).getOrder_id());
            orderSystim.setId_zamawiajacego(ordersList.getResults().get(i).getOrder_id());
            orderSystim.setImie(ordersList.getResults().get(i).getShipping_address().getFirst_name());
            orderSystim.setNazwisko(ordersList.getResults().get(i).getShipping_address().getLast_name());
            System.out.println(orderSystim.toString());
        }
    }

}