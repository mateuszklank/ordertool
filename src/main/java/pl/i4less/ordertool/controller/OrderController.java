package pl.i4less.ordertool.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import pl.i4less.ordertool.entity.systim.Response;
import pl.i4less.ordertool.logback.Logging;
import pl.i4less.ordertool.service.ConvertOrdersService;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@Controller
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    @Autowired
    ConvertOrdersService convertOrdersService;

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

        //orders.convertOrders(orders);
        convertOrdersService.convertOrders(orders);
        //convertOrdersService.generateSystimAddOrderUrl(convertOrdersService.convertOrders(orders));

        return orders.toString();
    }

    @RequestMapping("/test5")
    public String addSystimOrders() {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> response = rest.exchange(
                "https://41216.systim.pl/jsonAPI.php?act=addProduct&login=matiic@interia.pl&pass=ByS|H5c{ucBkV$R5mxnMRGp-,us|ij9&nazwa=iPhone+7+32+-+Or+Rose+-+D%C3%A9bloqu%C3%A9&cena_brutto=300.0&cena_netto=243.90243900000002&id_kategorii=1&stawka_vat=1&rodzaj=1&opis=Apple&kod_kreskowy=13445&kod_produktu=13445",
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
        return responseObject.toString();
    }

    @RequestMapping("/to-be-redirected")
    public RedirectView localRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://www.yahoo.com");
        return redirectView;
    }

}