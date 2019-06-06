package pl.i4less.ordertool.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.i4less.ordertool.entity.systim.Order;
import pl.i4less.ordertool.entity.systim.Product;
import pl.i4less.ordertool.entity.systim.Response;
import pl.i4less.ordertool.logback.Logging;

import java.util.*;

@Component
public class SystimService {

    @Autowired
    RestExchangeService restExchangeService;

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

    public void sendToSystim(List<Order> systimOrdersList) {

        //for every order in list
        for (int i = 0; i < systimOrdersList.size(); i++) {

            //get order from list
            Order orderSystim = systimOrdersList.get(i);

            //create map of ordered products
            HashMap<Integer, Integer> produkty = new HashMap<>();

            for (int j = 0; j < orderSystim.getProductList().size(); j++) {

                //get product from list
                Product productSystim = orderSystim.getProductList().get(j);

                //convert object of systim product to request url
                setAddProductRequestUrl(productSystim.toRequestString());
                setAddProductParametersUrl(productSystim.toParametersString());

                //add product to systim and receive response
                Response responseObject = restExchangeService.exchangeString(addProductRequestUrl, addProductParametersUrl);
                logger.info("Request URL: {}", addProductRequestUrl + addProductParametersUrl);
                logger.info("Response: {}", responseObject.toString());

                //add product to map
                produkty.put(responseObject.getResult(), productSystim.getIlosc());
            }

            //set map of ordered products
            orderSystim.setProdukty(produkty);

            //convert object of systim order to request url
            setAddOrderRequestUrl(orderSystim.toRequestString());
            setAddOrderParametersUrl(orderSystim.toParametersString());

            //add order to systim and receive response
            Response responseObject = restExchangeService.exchangeString(addOrderRequestUrl, addOrderParametersUrl);
            logger.info("Request URL: {}", addOrderRequestUrl + addOrderParametersUrl);
            logger.info("Response: {}", responseObject.toString());

            //clear map of products
            produkty.clear();
        }
    }

}