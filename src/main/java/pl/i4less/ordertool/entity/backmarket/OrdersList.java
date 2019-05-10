package pl.i4less.ordertool.entity.backmarket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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

    //converting orders from backmarket to systim
    public void convertOrders(OrdersList ordersList) {
        //for every order in orders list
        for(int i = 0; i < ordersList.getResults().size(); i++) {
            //create new systim order
            pl.i4less.ordertool.entity.systim.Order orderSystim = new pl.i4less.ordertool.entity.systim.Order();
            //set values for systim order
            orderSystim.setNazwa(ordersList.getResults().get(i).getStringOrder_id() + "_" + ordersList.getResults().get(i).getShipping_address().getLast_name());
            orderSystim.setKod(ordersList.getResults().get(i).getBilling_address().getPostal_code());
            orderSystim.setMiejscowosc(ordersList.getResults().get(i).getBilling_address().getCity());
            orderSystim.setUlica(ordersList.getResults().get(i).getBilling_address().getStreet() + " " + ordersList.getResults().get(i).getBilling_address().getStreet2());
            orderSystim.setNazwa_dostawy(ordersList.getResults().get(i).getShipper());
            orderSystim.setKod_dostawy(ordersList.getResults().get(i).getShipping_address().getPostal_code());
            orderSystim.setMiejscowosc_dostawy(ordersList.getResults().get(i).getShipping_address().getCity());
            orderSystim.setUlica_dostawy(ordersList.getResults().get(i).getShipping_address().getStreet() + " " + ordersList.getResults().get(i).getShipping_address().getStreet2());
            orderSystim.setId_dostawy(ordersList.getResults().get(i).getOrder_id());
            orderSystim.setId_zamawiajacego(ordersList.getResults().get(i).getOrder_id());
            orderSystim.setImie(ordersList.getResults().get(i).getShipping_address().getFirst_name());
            orderSystim.setNazwisko(ordersList.getResults().get(i).getShipping_address().getLast_name());
            orderSystim.setTelefon(ordersList.getResults().get(i).getShipping_address().getPhone());
            orderSystim.setId_statusu(ordersList.getResults().get(i).getState());
            orderSystim.setEmail(ordersList.getResults().get(i).getShipping_address().getEmail());
            orderSystim.setUwagi(ordersList.getResults().get(i).getDelivery_note());
            orderSystim.setPanstwo(ordersList.getResults().get(i).getBilling_address().getCountry());
            orderSystim.setPanstwo_dostawy(ordersList.getResults().get(i).getShipping_address().getCountry());
            //create map of ordered products
            HashMap<Integer, Integer> produkty = new HashMap<>();
            //for every product in this order
            for(int j = 0; j < ordersList.getResults().get(i).getOrderlines().size(); j++) {
                //add product to map
                produkty.put(ordersList.getResults().get(i).getOrderlines().get(j).getProduct_id(), ordersList.getResults().get(i).getOrderlines().get(j).getQuantity());
            }
            //set map of ordered products
            orderSystim.setProdukty(produkty);
            //map to string
            orderSystim.printMap(produkty);
            //convert object of systim order to request url
            String urlPath = orderSystim.toRequestString();
            System.out.println(orderSystim.encodeValue(urlPath));
        }
    }

}