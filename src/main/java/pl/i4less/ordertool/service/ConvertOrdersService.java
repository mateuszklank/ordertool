package pl.i4less.ordertool.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.i4less.ordertool.entity.backmarket.OrdersList;
import pl.i4less.ordertool.entity.systim.Order;
import pl.i4less.ordertool.entity.systim.Product;
import pl.i4less.ordertool.entity.systim.Response;
import pl.i4less.ordertool.logback.Logging;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ConvertOrdersService {

    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    @Nullable
    private String addOrderRequestUrl;

    @Nullable
    private String addOrderParametersUrl;

    @Nullable
    private String addProductRequestUrl;

    @Nullable
    private String addProductParametersUrl;

    private int id;

    @Nullable
    public String getAddOrderRequestUrl() {
        return addOrderRequestUrl;
    }

    public void setAddOrderRequestUrl(@Nullable String addOrderRequestUrl) {
        this.addOrderRequestUrl = addOrderRequestUrl;
    }

    @Nullable
    public String getAddOrderParametersUrl() {
        return addOrderParametersUrl;
    }

    public void setAddOrderParametersUrl(@Nullable String addOrderParametersUrl) {
        this.addOrderParametersUrl = addOrderParametersUrl;
    }

    @Nullable
    public String getAddProductRequestUrl() {
        return addProductRequestUrl;
    }

    public void setAddProductRequestUrl(@Nullable String addProductRequestUrl) {
        this.addProductRequestUrl = addProductRequestUrl;
    }

    @Nullable
    public String getAddProductParametersUrl() {
        return addProductParametersUrl;
    }

    public void setAddProductParametersUrl(@Nullable String addProductParametersUrl) {
        this.addProductParametersUrl = addProductParametersUrl;
    }

    //converting orders from backmarket to systim
    public void convertOrders(OrdersList ordersList) {
        //for every order in orders list
        for(int i = 0; i < ordersList.getResults().size(); i++) {
            //create new systim order
            pl.i4less.ordertool.entity.systim.Order orderSystim = new pl.i4less.ordertool.entity.systim.Order();
            //set values for systim order
            orderSystim.setNazwa(ordersList.getResults().get(i).getShipping_address().getFirst_name() + " " + ordersList.getResults().get(i).getShipping_address().getLast_name());
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
            //check and set currency
            if(ordersList.getResults().get(i).getCurrency().equals("EUR")) {
                orderSystim.setId_waluty(1);
            } else if(ordersList.getResults().get(i).getCurrency().equals("USD")) {
                orderSystim.setId_waluty(2);
            } else if(ordersList.getResults().get(i).getCurrency().equals("PLN")) {
                orderSystim.setId_waluty(0);
            }
            //create new systim product
            Product productSystim = new Product();
            //create map of ordered products
            HashMap<Integer, Integer> produkty = new HashMap<>();
            //for every product in this order
            for(int j = 0; j < ordersList.getResults().get(i).getOrderlines().size(); j++) {
                //produkty.put(id, ordersList.getResults().get(i).getOrderlines().get(j).getQuantity());
                //produkty.put(ordersList.getResults().get(i).getOrderlines().get(j).getProduct_id(), ordersList.getResults().get(i).getOrderlines().get(j).getQuantity());
                //set values for systim product
                productSystim.setNazwa(ordersList.getResults().get(i).getOrderlines().get(j).getProduct());
                productSystim.setCena_brutto(ordersList.getResults().get(i).getOrderlines().get(j).getPrice());
                productSystim.setCena_netto(ordersList.getResults().get(i).getOrderlines().get(j).getPrice() * 0.81300813);
                productSystim.setId_kategorii(1);
                productSystim.setStawka_vat(1);
                productSystim.setRodzaj(1);
                productSystim.setJednostka("szt.");
                productSystim.setOpis(ordersList.getResults().get(i).getOrderlines().get(j).getBrand());
                productSystim.setKod_kreskowy(ordersList.getResults().get(i).getOrderlines().get(j).getProduct_id());
                productSystim.setKod_produktu(ordersList.getResults().get(i).getOrderlines().get(j).getProduct_id());
                //convert object of systim product to request url
                addProductRequestUrl = productSystim.toRequestString();
                addProductParametersUrl = productSystim.toParametersString();

                RestTemplate rest = new RestTemplate();
                ResponseEntity<String> response = rest.exchange(
                        addProductRequestUrl + addProductParametersUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<String>(){});
                String resp = response.getBody();
                Response responseObject = new Response();
                try {
                    responseObject = new ObjectMapper().readValue(resp, Response.class);
                } catch(IOException e) {
                    logger.info("Error: {}", e);
                }

                //add product to map
                produkty.put(responseObject.getResult(), ordersList.getResults().get(i).getOrderlines().get(j).getQuantity());

                //encode url
//                logger.info("Product: {}{}", addProductRequestUrl, addProductParametersUrl);
//                ExecutePostService executePostService = new ExecutePostService();
//                String response = executePostService.executePost(addProductRequestUrl, addProductParametersUrl);
//                logger.info("Response: {}", response);
//                ordersList.setId(ordersList.getSystimNextId() + 1);
//                ordersList.setSystimNextId();
//                logger.info("Identification at end of loop: {}", ordersList.getId());
            }
            //set map of ordered products
            orderSystim.setProdukty(produkty);
            //convert object of systim order to request url
            addOrderRequestUrl = orderSystim.toRequestString();
            addOrderParametersUrl = orderSystim.toParametersString();
            //encode url
            logger.info("Order: {}{}", addOrderRequestUrl, addOrderParametersUrl);
            ExecutePostService executePostService = new ExecutePostService();
            String response = executePostService.executePost(addOrderRequestUrl, addOrderParametersUrl);
            logger.info("Response: {}", response);
            produkty.clear();
        }
    }

    //converting orders from backmarket to systim
//    public List<Order> convertOrders(OrdersList ordersList) {
//        //create list of systim orders
//        List<Order> systimOrdersList = new ArrayList<Order>();
//        //for every order in ordersList from backmarket
//        for(int i = 0; i < ordersList.getResults().size(); i++) {
//            //create new systim order
//            pl.i4less.ordertool.entity.systim.Order orderSystim = new pl.i4less.ordertool.entity.systim.Order();
//            //set values for systim order
//            orderSystim.setNazwa(ordersList.getResults().get(i).getShipping_address().getFirst_name() + " " + ordersList.getResults().get(i).getShipping_address().getLast_name());
//            orderSystim.setKod(ordersList.getResults().get(i).getBilling_address().getPostal_code());
//            orderSystim.setMiejscowosc(ordersList.getResults().get(i).getBilling_address().getCity());
//            orderSystim.setUlica(ordersList.getResults().get(i).getBilling_address().getStreet() + " " + ordersList.getResults().get(i).getBilling_address().getStreet2());
//            orderSystim.setNazwa_dostawy(ordersList.getResults().get(i).getShipper());
//            orderSystim.setKod_dostawy(ordersList.getResults().get(i).getShipping_address().getPostal_code());
//            orderSystim.setMiejscowosc_dostawy(ordersList.getResults().get(i).getShipping_address().getCity());
//            orderSystim.setUlica_dostawy(ordersList.getResults().get(i).getShipping_address().getStreet() + " " + ordersList.getResults().get(i).getShipping_address().getStreet2());
//            orderSystim.setId_dostawy(ordersList.getResults().get(i).getOrder_id());
//            orderSystim.setId_zamawiajacego(ordersList.getResults().get(i).getOrder_id());
//            orderSystim.setImie(ordersList.getResults().get(i).getShipping_address().getFirst_name());
//            orderSystim.setNazwisko(ordersList.getResults().get(i).getShipping_address().getLast_name());
//            orderSystim.setTelefon(ordersList.getResults().get(i).getShipping_address().getPhone());
//            orderSystim.setId_statusu(ordersList.getResults().get(i).getState());
//            orderSystim.setEmail(ordersList.getResults().get(i).getShipping_address().getEmail());
//            orderSystim.setUwagi(ordersList.getResults().get(i).getDelivery_note());
//            orderSystim.setPanstwo(ordersList.getResults().get(i).getBilling_address().getCountry());
//            orderSystim.setPanstwo_dostawy(ordersList.getResults().get(i).getShipping_address().getCountry());
//            //check and set currency
//            if(ordersList.getResults().get(i).getCurrency().equals("EUR")) {
//                orderSystim.setId_waluty(1);
//            } else if(ordersList.getResults().get(i).getCurrency().equals("USD")) {
//                orderSystim.setId_waluty(2);
//            } else if(ordersList.getResults().get(i).getCurrency().equals("PLN")) {
//                orderSystim.setId_waluty(0);
//            }
//            //create new systim product
//            Product productSystim = new Product();
//            //create map of ordered products
//            HashMap<Integer, Integer> produkty = new HashMap<>();
//            //for every product in this order
//            for(int j = 0; j < ordersList.getResults().get(i).getOrderlines().size(); j++) {
//                //add product to map
//                produkty.put(ordersList.getSystimNextId(), ordersList.getResults().get(i).getOrderlines().get(j).getQuantity());
//                //produkty.put(id, ordersList.getResults().get(i).getOrderlines().get(j).getQuantity());
//                //produkty.put(ordersList.getResults().get(i).getOrderlines().get(j).getProduct_id(), ordersList.getResults().get(i).getOrderlines().get(j).getQuantity());
//                //set values for systim product
//                productSystim.setNazwa(ordersList.getResults().get(i).getOrderlines().get(j).getProduct());
//                productSystim.setCena_brutto(ordersList.getResults().get(i).getOrderlines().get(j).getPrice());
//                productSystim.setCena_netto(ordersList.getResults().get(i).getOrderlines().get(j).getPrice() * 0.81300813);
//                productSystim.setId_kategorii(1);
//                productSystim.setStawka_vat(1);
//                productSystim.setRodzaj(1);
//                productSystim.setJednostka("szt.");
//                productSystim.setOpis(ordersList.getResults().get(i).getOrderlines().get(j).getBrand());
//                productSystim.setKod_kreskowy(ordersList.getResults().get(i).getOrderlines().get(j).getProduct_id());
//                productSystim.setKod_produktu(ordersList.getResults().get(i).getOrderlines().get(j).getProduct_id());
//                //convert object of systim product to request url
//                addProductRequestUrl = productSystim.toRequestString();
//                addProductParametersUrl = productSystim.toParametersString();
//                //encode url
//                logger.info("Product: {}{}", addProductRequestUrl, addProductParametersUrl);
//                ExecutePostService executePostService = new ExecutePostService();
//                String response = executePostService.executePost(addProductRequestUrl, addProductParametersUrl);
//                logger.info("Response: {}", response);
//                ordersList.setId(ordersList.getSystimNextId() + 1);
//                ordersList.setSystimNextId();
//                logger.info("Identification at end of loop: {}", ordersList.getId());
//            }
//            //set map of ordered products
//            orderSystim.setProdukty(produkty);
//            //convert object of systim order to request url
//            addOrderRequestUrl = orderSystim.toRequestString();
//            addOrderParametersUrl = orderSystim.toParametersString();
//            //encode url
//            logger.info("Order: {}{}", addOrderRequestUrl, addOrderParametersUrl);
//            ExecutePostService executePostService = new ExecutePostService();
//            String response = executePostService.executePost(addOrderRequestUrl, addOrderParametersUrl);
//            logger.info("Response: {}", response);
//            systimOrdersList.add(orderSystim);
//            produkty.clear();
//        }
//        return systimOrdersList;
//    }

    public void generateSystimAddOrderUrl(List<Order> systimOrderList) {
        for(int i = 0; i < systimOrderList.size(); i++) {
            //convert object of systim order to request url
            System.out.println(systimOrderList.get(i));
//            addOrderRequestUrl = orderSystim.toRequestString();
//            addOrderParametersUrl = orderSystim.toParametersString();
//            //encode url
//            logger.info("Order: {}{}", addOrderRequestUrl, addOrderParametersUrl);
//            ExecutePostService executePostService = new ExecutePostService();
//            String response = executePostService.executePost(addOrderRequestUrl, addOrderParametersUrl);
//            logger.info("Response: {}", response);
        }
    }

}