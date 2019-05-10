package pl.i4less.ordertool.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;
import pl.i4less.ordertool.entity.backmarket.OrdersList;
import pl.i4less.ordertool.entity.systim.Order;

import java.util.Collections;

@RestController
@Controller
public class OrderController {

    @Value("${backmarket.token}")
    private String authToken;

    @RequestMapping("/")
    public String index() {
        return "Greetings!";
    }

    @RequestMapping("/getOrder")
    @ResponseBody
    public String getOrder(
            @RequestParam String login,
            @RequestParam String pass,
            @RequestParam(required = false) String id) {

        return String.format("Values: login=%s, pass=%s, id=%s", login, pass, id);
    }

    @RequestMapping("/test")
    public String callGet() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Content-type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Accept-Language", "fr-fr");
        headers.add("Authorization", "Basic " +authToken);

        RestTemplate rest = new RestTemplate();


        ResponseEntity<String> exchange = rest.exchange(
            "http://bykowski.pl/materials/HttpExample.php?name=Przemek",
            HttpMethod.GET,
            new HttpEntity<>("parameters", headers),
            String.class);
        return exchange.getBody();
    }

    @RequestMapping("/test2")
    public String getListings() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Content-type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Accept-Language", "fr-fr");
        headers.add("Authorization", "Basic " +authToken);

        RestTemplate rest = new RestTemplate();

        ResponseEntity<String> exchange = rest.exchange(
                "https://ppr.backmarket.fr/ws/listings/",
                HttpMethod.GET,
                new HttpEntity<>("parameters", headers),
                String.class);
        return exchange.getBody();
    }

    @RequestMapping("/test3")
    public String getOrders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Content-type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Accept-Language", "fr-fr");
        headers.add("Authorization", "Basic " +authToken);

        RestTemplate rest = new RestTemplate();

        ResponseEntity<String> exchange = rest.exchange(
                "https://ppr.backmarket.fr/ws/orders/",
                HttpMethod.GET,
                new HttpEntity<>("parameters", headers),
                String.class);
        return exchange.getBody();
    }

    @RequestMapping("/test4")
    public String getOrdersObjects() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Content-type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Accept-Language", "fr-fr");
        headers.add("Authorization", "Basic " +authToken);

        RestTemplate rest = new RestTemplate();

        ResponseEntity<OrdersList> response = rest.exchange(
                "https://ppr.backmarket.fr/ws/orders/",
                HttpMethod.GET,
                new HttpEntity<>("parameters", headers),
                new ParameterizedTypeReference<OrdersList>(){});
        OrdersList orders = response.getBody();

        orders.convertOrders(orders);

        return orders.toString();
    }

    @RequestMapping("/to-be-redirected")
    public RedirectView localRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://www.yahoo.com");
        return redirectView;
    }

}