package pl.i4less.ordertool.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.i4less.ordertool.entity.backmarket.OrdersList;
import pl.i4less.ordertool.entity.systim.Response;
import pl.i4less.ordertool.logback.Logging;

import java.io.IOException;
import java.util.Collections;

@Component
public class RestExchangeService {

    @Autowired
    FileService fileService;

    @Value("${backmarket.token}")
    private String authToken;

    @Value("${backmarket.url}")
    private String backmarketUrl;

    @Value("${backmarket.url.all}")
    private String backmarketUrlAll;

    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    //receive response from systim
    public Response exchangeString(String addProductRequestUrl, String addProductParametersUrl) {
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
        return responseObject;
    }

    //get all orders from backmarket
    public OrdersList getAllOrders(HttpHeaders headers) {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<OrdersList> response = rest.exchange(
                backmarketUrlAll,
                HttpMethod.GET,
                new HttpEntity<>("parameters", headers),
                new ParameterizedTypeReference<OrdersList>(){});
        OrdersList orders = response.getBody();
        return orders;
    }

    //get orders from backmarket newer than taskDateString
    public OrdersList getOrders(HttpHeaders headers) {
        String taskDateString = fileService.getDateFromFile();
        RestTemplate rest = new RestTemplate();
        ResponseEntity<OrdersList> response = rest.exchange(
                backmarketUrl + taskDateString,
                HttpMethod.GET,
                new HttpEntity<>("parameters", headers),
                new ParameterizedTypeReference<OrdersList>(){});
        OrdersList orders = response.getBody();
        return orders;
    }

    //get orders from backmarket in json
    public ResponseEntity<String> getJsonOrders(HttpHeaders headers) {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> exchange = rest.exchange(
                "https://ppr.backmarket.fr/ws/orders/",
                HttpMethod.GET,
                new HttpEntity<>("parameters", headers),
                String.class);
        return exchange;
    }

    //get listings from backmarket in json
    public ResponseEntity<String> getJsonListings(HttpHeaders headers) {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> exchange = rest.exchange(
                "https://ppr.backmarket.fr/ws/listings/",
                HttpMethod.GET,
                new HttpEntity<>("parameters", headers),
                String.class);
        return exchange;
    }

    //set request header
    public HttpHeaders setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Content-type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Accept-Language", "fr-fr");
        headers.add("Authorization", "Basic " +authToken);
        return headers;
    }

}