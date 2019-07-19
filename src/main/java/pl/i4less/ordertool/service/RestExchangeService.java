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

    @Value("${backmarket.url1}")
    private String backmarketUrl1;

    @Value("${backmarket.url2}")
    private String backmarketUrl2;

    @Value("${backmarket.url.all}")
    private String backmarketUrlAll;

    private static final Logger logger = LoggerFactory.getLogger(RestExchangeService.class);

    //receive response from systim
    public Response exchangeString(String addProductRequestUrl, String addProductParametersUrl) {
        RestTemplate rest = new RestTemplate();
        String backmarketUrl = addProductRequestUrl + addProductParametersUrl;
        logger.info("Sending GET to:{}", backmarketUrl);
        ResponseEntity<String> response = rest.exchange(backmarketUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<String>() {
                });
        String resp = response.getBody();
        Response responseObject = new Response();
        try {
            responseObject = new ObjectMapper().readValue(resp, Response.class);
        } catch (IOException e) {
            logger.error("Error: {}", e);
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
                new ParameterizedTypeReference<OrdersList>() {
                });
        OrdersList orders = response.getBody();
        return orders;
    }

    //get orders from backmarket newer than taskDateString
    public OrdersList getOrders(HttpHeaders headers) {
        try {
            String taskDateString = fileService.getDateFromFile();
            RestTemplate rest = new RestTemplate();
            String requestUrl = backmarketUrl1 + taskDateString + backmarketUrl2;
            logger.info("Sending GET to: {}", requestUrl);
            ResponseEntity<OrdersList> response = rest.exchange(
                    requestUrl,
                    HttpMethod.GET,
                    new HttpEntity<>("parameters", headers),
                    new ParameterizedTypeReference<OrdersList>() {
                    });
            OrdersList orders = response.getBody();
            return orders;
        } catch (Exception ex){
            logger.error("getOrders error: " + ex.getMessage(), ex);
        }
        return null;
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
        headers.add("Authorization", "Basic " + authToken);
        return headers;
    }

}