package pl.i4less.ordertool.controller;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@Controller
public class OrderController {

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
        String authToken = "";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Content-type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Accept-Language", "fr-fr");
        headers.add("Authorization", "Basic "+authToken);

        RestTemplate rest = new RestTemplate();

        ResponseEntity<String> exchange = rest.exchange(
            "http://bykowski.pl/materials/HttpExample.php?name=Przemek",
            HttpMethod.GET,
            new HttpEntity<>("parameters", headers),
            String.class);
        return exchange.getBody();
    }

}