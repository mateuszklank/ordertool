package pl.i4less.ordertool.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import pl.i4less.ordertool.entity.backmarket.OrderLine;
import pl.i4less.ordertool.entity.backmarket.OrdersList;
import pl.i4less.ordertool.entity.systim.Order;
import pl.i4less.ordertool.entity.systim.Product;
import pl.i4less.ordertool.entity.systim.Response;
import pl.i4less.ordertool.logback.Logging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ConvertOrdersService {

    @Autowired
    RestExchangeService restExchangeService;

    @Autowired
    ScheduledTaskService scheduledTaskService;

    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    @Nullable
    private String addOrderRequestUrl;

    @Nullable
    private String addOrderParametersUrl;

    @Nullable
    private String addProductRequestUrl;

    @Nullable
    private String addProductParametersUrl;

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

//    //converting orders from backmarket to systim
//    public void convertOrders(OrdersList ordersList) {
//
//        //for every order in orders list
//        for(int i = 0; i < ordersList.getResults().size(); i++) {
//
//            //create new systim order
//            pl.i4less.ordertool.entity.systim.Order orderSystim = new pl.i4less.ordertool.entity.systim.Order();
//
//            //set values for systim order
//            pl.i4less.ordertool.entity.backmarket.Order order = ordersList.getResults().get(i);
//            orderSystim.setNazwa(order.getShipping_address().getFirst_name() + " " + order.getShipping_address().getLast_name());
//            orderSystim.setKod(order.getBilling_address().getPostal_code());
//            orderSystim.setMiejscowosc(order.getBilling_address().getCity());
//            orderSystim.setUlica(order.getBilling_address().getStreet() + " " + order.getBilling_address().getStreet2());
//            orderSystim.setNazwa_dostawy(order.getShipper());
//            orderSystim.setKod_dostawy(order.getShipping_address().getPostal_code());
//            orderSystim.setMiejscowosc_dostawy(order.getShipping_address().getCity());
//            orderSystim.setUlica_dostawy(order.getShipping_address().getStreet() + " " + order.getShipping_address().getStreet2());
//            orderSystim.setId_dostawy(order.getOrder_id());
//            orderSystim.setId_zamawiajacego(order.getOrder_id());
//            orderSystim.setImie(order.getShipping_address().getFirst_name());
//            orderSystim.setNazwisko(order.getShipping_address().getLast_name());
//            orderSystim.setTelefon(order.getShipping_address().getPhone());
//            orderSystim.setId_statusu(order.getState());
//            orderSystim.setEmail(order.getShipping_address().getEmail());
//            orderSystim.setUwagi(order.getDelivery_note());
//            orderSystim.setPanstwo(order.getBilling_address().getCountry());
//            orderSystim.setPanstwo_dostawy(order.getShipping_address().getCountry());
//
//            //check and set currency
//            if(order.getCurrency().equals("EUR")) {
//                orderSystim.setId_waluty(1);
//            } else if(order.getCurrency().equals("USD")) {
//                orderSystim.setId_waluty(2);
//            } else if(order.getCurrency().equals("PLN")) {
//                orderSystim.setId_waluty(0);
//            }
//
//            //create new systim product
//            Product productSystim = new Product();
//
//            //create map of ordered products
//            HashMap<Integer, Integer> produkty = new HashMap<>();
//
//            //for every product in this order
//            for(int j = 0; j < order.getOrderlines().size(); j++) {
//
//                //set values for systim product
//                OrderLine orderLine = order.getOrderlines().get(j);
//                productSystim.setNazwa(orderLine.getProduct());
//                productSystim.setCena_brutto(orderLine.getPrice());
//                productSystim.setCena_netto(orderLine.getPrice() * 0.81300813);
//                productSystim.setId_kategorii(1);
//                productSystim.setStawka_vat(1);
//                productSystim.setRodzaj(1);
//                productSystim.setJednostka("szt.");
//                productSystim.setOpis(orderLine.getBrand());
//                productSystim.setKod_kreskowy(orderLine.getProduct_id());
//                productSystim.setKod_produktu(orderLine.getProduct_id());
//
//                //convert object of systim product to request url
//                setAddProductRequestUrl(productSystim.toRequestString());
//                setAddProductParametersUrl(productSystim.toParametersString());
//
//                //add product to systim and receive response
//                Response responseObject = restExchangeService.exchangeString(addProductRequestUrl, addProductParametersUrl);
//                logger.info("Response: {}", responseObject.toString());
//
//                //add product to map
//                produkty.put(responseObject.getResult(), orderLine.getQuantity());
//            }
//
//            //set map of ordered products
//            orderSystim.setProdukty(produkty);
//
//            //convert object of systim order to request url
//            setAddOrderRequestUrl(orderSystim.toRequestString());
//            setAddOrderParametersUrl(orderSystim.toParametersString());
//
//            //add order to systim and receive response
//            Response responseObject = restExchangeService.exchangeString(addOrderRequestUrl, addOrderParametersUrl);
//            logger.info("Response: {}", responseObject.toString());
//
//            //clear map of products
//            produkty.clear();
//        }
//    }

//    //converting orders from backmarket to systim
//    public List<Order> convertOrders(OrdersList ordersList) {
//
//        //create list of systim orders
//        List<Order> systimOrdersList = new ArrayList<>();
//
//        //for every order in orders list
//        for(int i = 0; i < ordersList.getResults().size(); i++) {
//
//            //create new systim order
//            pl.i4less.ordertool.entity.systim.Order orderSystim = new pl.i4less.ordertool.entity.systim.Order();
//
//            //set values for systim order
//            pl.i4less.ordertool.entity.backmarket.Order order = ordersList.getResults().get(i);
//            orderSystim.setNazwa(order.getShipping_address().getFirst_name() + " " + order.getShipping_address().getLast_name());
//            orderSystim.setKod(order.getBilling_address().getPostal_code());
//            orderSystim.setMiejscowosc(order.getBilling_address().getCity());
//            orderSystim.setUlica(order.getBilling_address().getStreet() + " " + order.getBilling_address().getStreet2());
//            orderSystim.setNazwa_dostawy(order.getShipper());
//            orderSystim.setKod_dostawy(order.getShipping_address().getPostal_code());
//            orderSystim.setMiejscowosc_dostawy(order.getShipping_address().getCity());
//            orderSystim.setUlica_dostawy(order.getShipping_address().getStreet() + " " + order.getShipping_address().getStreet2());
//            orderSystim.setId_dostawy(order.getOrder_id());
//            orderSystim.setId_zamawiajacego(order.getOrder_id());
//            orderSystim.setImie(order.getShipping_address().getFirst_name());
//            orderSystim.setNazwisko(order.getShipping_address().getLast_name());
//            orderSystim.setTelefon(order.getShipping_address().getPhone());
//            orderSystim.setId_statusu(order.getState());
//            orderSystim.setEmail(order.getShipping_address().getEmail());
//            orderSystim.setUwagi(order.getDelivery_note());
//            orderSystim.setPanstwo(order.getBilling_address().getCountry());
//            orderSystim.setPanstwo_dostawy(order.getShipping_address().getCountry());
//
//            //check and set currency
//            if(order.getCurrency().equals("EUR")) {
//                orderSystim.setId_waluty(1);
//            } else if(order.getCurrency().equals("USD")) {
//                orderSystim.setId_waluty(2);
//            } else if(order.getCurrency().equals("PLN")) {
//                orderSystim.setId_waluty(0);
//            }
//
//            //create list of systim products
//            List<Product> productList = new ArrayList<>();
//
//            //for every product in this order
//            for(int j = 0; j < order.getOrderlines().size(); j++) {
//
//                //create new systim product
//                Product productSystim = new Product();
//
//                //set values for systim product
//                OrderLine orderLine = order.getOrderlines().get(j);
//                productSystim.setNazwa(orderLine.getProduct());
//                productSystim.setCena_brutto(orderLine.getPrice());
//                productSystim.setCena_netto(orderLine.getPrice() * 0.81300813);
//                productSystim.setId_kategorii(1);
//                productSystim.setStawka_vat(1);
//                productSystim.setRodzaj(1);
//                productSystim.setJednostka("szt.");
//                productSystim.setOpis(orderLine.getBrand());
//                productSystim.setKod_kreskowy(orderLine.getProduct_id());
//                productSystim.setKod_produktu(orderLine.getProduct_id());
//                productSystim.setIlosc(orderLine.getQuantity());
//
//                //add product to list
//                productList.add(productSystim);
//            }
//
//            //set product list for systim order
//            orderSystim.setProductList(productList);
//
//            //add systim order to list
//            systimOrdersList.add(orderSystim);
//        }
//        return systimOrdersList;
//    }

    //converting one order from backmarket to systim
    public List<Order> convertOrders(OrdersList ordersList) {

        //create list of systim orders
        List<Order> systimOrdersList = new ArrayList<>();

        //check orders list size
        if(ordersList.getResults().size() != 0){

            //for every order in orders list
            for(int i = 0; i < 1; i++) {

                //create new systim order
                pl.i4less.ordertool.entity.systim.Order orderSystim = new pl.i4less.ordertool.entity.systim.Order();

                //create backmarket order
                pl.i4less.ordertool.entity.backmarket.Order order = ordersList.getResults().get(i);

                //compare dates
                if(scheduledTaskService.getDate().before(order.getDate_creation())) {

                    //set values for systim order
                    orderSystim.setNazwa(order.getBilling_address().getFirst_name() + " " + order.getBilling_address().getLast_name());
                    //orderSystim.setNazwa(order.getShipping_address().getFirst_name() + " " + order.getShipping_address().getLast_name());
                    orderSystim.setKod(order.getBilling_address().getPostal_code());
                    orderSystim.setMiejscowosc(order.getBilling_address().getCity());
                    orderSystim.setUlica(order.getBilling_address().getStreet() + " " + order.getBilling_address().getStreet2());
                    orderSystim.setNazwa_dostawy(order.getShipping_address().getFirst_name() + " " + order.getShipping_address().getLast_name());
//                    orderSystim.setNazwa_dostawy(order.getShipper());
//                    orderSystim.setKod_dostawy(order.getBilling_address().getPostal_code());
                    orderSystim.setKod_dostawy(order.getShipping_address().getPostal_code());
//                    orderSystim.setMiejscowosc_dostawy(order.getBilling_address().getCity());
                    orderSystim.setMiejscowosc_dostawy(order.getShipping_address().getCity());
//                    orderSystim.setUlica_dostawy(order.getBilling_address().getStreet() + " " + order.getBilling_address().getStreet2());
                    orderSystim.setUlica_dostawy(order.getShipping_address().getStreet() + " " + order.getShipping_address().getStreet2());
                    orderSystim.setId_dostawy(order.getOrder_id());
                    orderSystim.setId_zamawiajacego(order.getOrder_id());
                    orderSystim.setImie(order.getBilling_address().getFirst_name());
                    //orderSystim.setImie(order.getShipping_address().getFirst_name());
                    orderSystim.setNazwisko(order.getBilling_address().getLast_name());
                    //orderSystim.setNazwisko(order.getShipping_address().getLast_name());
                    orderSystim.setTelefon(order.getBilling_address().getPhone());
                    //orderSystim.setTelefon(order.getShipping_address().getPhone());
                    orderSystim.setId_statusu(order.getState());
                    orderSystim.setEmail(order.getBilling_address().getEmail());
                    //orderSystim.setEmail(order.getShipping_address().getEmail());
                    orderSystim.setUwagi("");
                    orderSystim.setPanstwo(order.getBilling_address().getCountry());
//                    orderSystim.setPanstwo_dostawy(order.getBilling_address().getCountry());
                    orderSystim.setPanstwo_dostawy(order.getShipping_address().getCountry());

                    //check and set currency
                    if(order.getCurrency().equals("EUR")) {
                        orderSystim.setId_waluty(1);
                    } else if(order.getCurrency().equals("USD")) {
                        orderSystim.setId_waluty(2);
                    } else if(order.getCurrency().equals("PLN")) {
                        orderSystim.setId_waluty(0);
                    }

                    //create list of systim products
                    List<Product> productList = new ArrayList<>();

                    //for every product in this order
                    for(int j = 0; j < order.getOrderlines().size(); j++) {

                        //create new systim product
                        Product productSystim = new Product();

                        //set values for systim product
                        OrderLine orderLine = order.getOrderlines().get(j);
                        productSystim.setNazwa(orderLine.getProduct());
                        productSystim.setCena_brutto(orderLine.getPrice());
                        productSystim.setCena_netto(orderLine.getPrice() * 0.81300813);
                        productSystim.setId_kategorii(1);
                        productSystim.setStawka_vat(14);
                        productSystim.setRodzaj(1);
                        productSystim.setJednostka("szt.");
                        productSystim.setOpis(orderLine.getBrand());
                        productSystim.setKod_kreskowy(orderLine.getProduct_id());
                        productSystim.setKod_produktu(orderLine.getProduct_id());
                        productSystim.setIlosc(orderLine.getQuantity());

                        //add product to list
                        productList.add(productSystim);
                    }

                    //set product list for systim order
                    orderSystim.setProductList(productList);

                    //add systim order to list
                    systimOrdersList.add(orderSystim);

                    //save order creation date to file
                    scheduledTaskService.SaveCreationDate(order.getDate_payment());
                    //scheduledTaskService.SaveCreationDate(order.getDate_creation());
                }
            }
        }
        return systimOrdersList;
    }

}