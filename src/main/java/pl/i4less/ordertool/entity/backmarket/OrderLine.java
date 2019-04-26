package pl.i4less.ordertool.entity.backmarket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderLine {

    private int id;

    private Date date_creation;

    private int state;

    private Double price;

    private Double shipping_price;

    private String currency;

    private int return_reason;

    private String return_message;

    private String listing;

    private String product;

    private int quantity;

    private List<String> imei_numbers;

    private String brand;

    private int product_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getShipping_price() {
        return shipping_price;
    }

    public void setShipping_price(Double shipping_price) {
        this.shipping_price = shipping_price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getReturn_reason() {
        return return_reason;
    }

    public void setReturn_reason(int return_reason) {
        this.return_reason = return_reason;
    }

    public String getReturn_message() {
        return return_message;
    }

    public void setReturn_message(String return_message) {
        this.return_message = return_message;
    }

    public String getListing() {
        return listing;
    }

    public void setListing(String listing) {
        this.listing = listing;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String> getImei_numbers() {
        return imei_numbers;
    }

    public void setImei_numbers(List<String> imei_numbers) {
        this.imei_numbers = imei_numbers;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", date_creation=" + date_creation +
                ", state=" + state +
                ", price=" + price +
                ", shipping_price=" + shipping_price +
                ", currency='" + currency + '\'' +
                ", return_reason=" + return_reason +
                ", return_message='" + return_message + '\'' +
                ", listing='" + listing + '\'' +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", imei_numbers=" + imei_numbers +
                ", brand='" + brand + '\'' +
                ", product_id=" + product_id +
                '}';
    }
}