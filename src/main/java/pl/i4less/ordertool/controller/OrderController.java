package pl.i4less.ordertool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.i4less.ordertool.entity.backmarket.OrdersList;
import pl.i4less.ordertool.service.ConvertOrdersService;
import pl.i4less.ordertool.service.RestExchangeService;
import pl.i4less.ordertool.service.SystimService;

@RestController
@Controller
public class OrderController {

    @Autowired
    ConvertOrdersService convertOrdersService;

    @Autowired
    RestExchangeService restExchangeService;

    @Autowired
    SystimService systimService;

    //get listings (products) in json from backmarket
    @RequestMapping("/listings")
    public String getListings() {
        HttpHeaders headers = restExchangeService.setHeaders();
        ResponseEntity<String> listings = restExchangeService.getJsonListings(headers);
        return listings.getBody();
    }

    //get orders in json from backmarket
    @RequestMapping("/orders")
    public String getOrders() {
        HttpHeaders headers = restExchangeService.setHeaders();
        ResponseEntity<String> orders = restExchangeService.getJsonOrders(headers);
        return orders.getBody();
    }

    //convert backmarket orders newer than last task date and send to systim
    @RequestMapping("/convertOrders")
    public String getOrdersObjects() {
        HttpHeaders headers = restExchangeService.setHeaders();
        OrdersList orders = restExchangeService.getOrders(headers);
        systimService.sendToSystim(convertOrdersService.convertOrders(orders));
        return orders.toString();
    }

    //convert all backmarket orders and send to systim
    @RequestMapping("/convertAllOrders")
    public String getAllOrdersObjects() {
        HttpHeaders headers = restExchangeService.setHeaders();
        OrdersList orders = restExchangeService.getAllOrders(headers);
        systimService.sendToSystim(convertOrdersService.convertOrders(orders));
        return orders.toString();
    }

}