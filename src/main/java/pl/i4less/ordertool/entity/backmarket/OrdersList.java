package pl.i4less.ordertool.entity.backmarket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.i4less.ordertool.ValueAnnotationBean;
import pl.i4less.ordertool.entity.systim.Product;
import pl.i4less.ordertool.logback.Logging;
import pl.i4less.ordertool.service.ExecutePostService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdersList {

    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    private int count;

    private String next;

    private String previous;

    private List<Order> results;

    private int id;

    private Date taskDate;

    private String taskDateString;

    @Nullable
    private String addOrderRequestUrl;

    @Nullable
    private String addOrderParametersUrl;

    @Nullable
    private String addProductRequestUrl;

    @Nullable
    private String addProductParametersUrl;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    private static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public int getSystimNextId() {
        try {
            try {
                //read data from file
                id = Integer.parseInt(readFile(ValueAnnotationBean.getFilePath(), Charset.forName("ASCII")));
                logger.info("Identification after reading from file using getSystimNextId(): {}", id);
            } catch (NumberFormatException e) {
                logger.info("Error: {}", e);
            }
        } catch (IOException e) {
            logger.info("Error: {}", e);
        }
        return id;
    }

    public void setSystimNextId() {
        try {
            //create and save date to file
            logger.info("Identification before save using setSystimNextId(): {}", id);
            File file = new File("src/main/resources/next.log");
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(Integer.toString(id));
            fileWriter.close();
            logger.info("Identification after save using setSystimNextId(): {}", id);
        } catch (IOException e) {
            logger.info("Error: {}", e);
        }
    }

//    //converting orders from backmarket to systim
//    public void convertOrders(OrdersList ordersList) {
//        //for every order in orders list
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
//                id = ordersList.getSystimNextId();
//                id++;
//                ordersList.setSystimNextId();
//                logger.info("Identification at end of loop: {}", id);
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
//            produkty.clear();
//        }
//    }

//    @Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
//    public void pushOrdersfromBackmarketToSystimTask() {
//        try {
//
//            //read date from file
//            taskDateString = readFile(ValueAnnotationBean.getDatePath(), Charset.forName("ASCII"));
//            logger.info("Date String after read: {}", taskDateString);
//
//            //parse date readed from file
//            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            try {
//                logger.info("Date before parse: {}", taskDate);
//                taskDate = format.parse(taskDateString);
//            } catch (ParseException e) {
//                logger.info("Error: {}", e);
//            }
//            logger.info("Date after parse: {}", taskDate);
//
//            //get current date
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = new Date();
//
//            //compare current date with readed date
//            int compare = taskDate.compareTo(date);
//            logger.info("Date before(-1), equal(0) or after(1) the argument Date: {}", compare);
//
//            //convert current date to String
//            String newDateString = dateFormat.format(date);
//            logger.info("New actual date: {}", newDateString);
//
//            //create and save date to file
//            File file = new File("src/main/resources/date.log");
//            FileWriter fileWriter = new FileWriter(file, false);
//            fileWriter.write(newDateString);
//            fileWriter.close();
//        } catch (IOException e) {
//            logger.info("Error: {}", e);
//        }
//    }

}