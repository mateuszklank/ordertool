package pl.i4less.ordertool.entity.backmarket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBackmarket {

    private int order_id;

    private AddressBackmarket shipping_address;

    private AddressBackmarket billing_address;

    private String delivery_note;

    private String tracking_number;

    private String tracking_url;

    private String shipper;

    private Date date_creation;

    private Date date_modification;

    private Date date_shipping;

    private Date date_payment;

    private int state;

    private OrderLineBackmarket orderlines;

    private Double price;

    private Double shipping_price;

    private String currency;

    private String country_code;

    private String paypal_reference;

    private Boolean installment_payment;

    private String payment_method;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public AddressBackmarket getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(AddressBackmarket shipping_address) {
        this.shipping_address = shipping_address;
    }

    public AddressBackmarket getBilling_address() {
        return billing_address;
    }

    public void setBilling_address(AddressBackmarket billing_address) {
        this.billing_address = billing_address;
    }

    public String getDelivery_note() {
        return delivery_note;
    }

    public void setDelivery_note(String delivery_note) {
        this.delivery_note = delivery_note;
    }

    public String getTracking_number() {
        return tracking_number;
    }

    public void setTracking_number(String tracking_number) {
        this.tracking_number = tracking_number;
    }

    public String getTracking_url() {
        return tracking_url;
    }

    public void setTracking_url(String tracking_url) {
        this.tracking_url = tracking_url;
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDate_modification() {
        return date_modification;
    }

    public void setDate_modification(Date date_modification) {
        this.date_modification = date_modification;
    }

    public Date getDate_shipping() {
        return date_shipping;
    }

    public void setDate_shipping(Date date_shipping) {
        this.date_shipping = date_shipping;
    }

    public Date getDate_payment() {
        return date_payment;
    }

    public void setDate_payment(Date date_payment) {
        this.date_payment = date_payment;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public OrderLineBackmarket getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(OrderLineBackmarket orderlines) {
        this.orderlines = orderlines;
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

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getPaypal_reference() {
        return paypal_reference;
    }

    public void setPaypal_reference(String paypal_reference) {
        this.paypal_reference = paypal_reference;
    }

    public Boolean getInstallment_payment() {
        return installment_payment;
    }

    public void setInstallment_payment(Boolean installment_payment) {
        this.installment_payment = installment_payment;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

}