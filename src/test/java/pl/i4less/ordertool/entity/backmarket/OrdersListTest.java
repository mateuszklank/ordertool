package pl.i4less.ordertool.entity.backmarket;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.i4less.ordertool.entity.systim.Order;
import pl.i4less.ordertool.entity.systim.Product;
import pl.i4less.ordertool.service.ConvertOrdersService;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrdersListTest {

    @Autowired
    ConvertOrdersService convertOrdersService;

    @Test
    public void createTest() {
        OrdersList ordersList = new OrdersList();
        assertNotNull(ordersList);
    }

    @Test
    public void SetCountTest() throws NoSuchFieldException, IllegalAccessException {
        OrdersList ordersList = new OrdersList();
        ordersList.setCount(3);
        Field field = ordersList.getClass().getDeclaredField("count");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(ordersList), 3);
    }

    @Test
    public void GetCountTest() throws NoSuchFieldException, IllegalAccessException {
        OrdersList ordersList = new OrdersList();
        Field field = ordersList.getClass().getDeclaredField("count");
        field.setAccessible(true);
        field.set(ordersList, 4);
        int result = ordersList.getCount();
        assertEquals("Field wasn't retrieved properly", result, 4);
    }

    @Test
    public void ConvertOrdersTest() {

        //create backmarket objects
        OrdersList backmarketOrdersList = new OrdersList();
        List<pl.i4less.ordertool.entity.backmarket.Order> backmarketOrderList = new ArrayList<>();
        List<OrderLine> backmarketOrderLineList = new ArrayList<>();
        Address backmarketBillingAddress = new Address();
        Address backmarketShippingAddress = new Address();
        pl.i4less.ordertool.entity.backmarket.Order backmarketOrder = new pl.i4less.ordertool.entity.backmarket.Order();
        OrderLine backmarketOrderLine = new OrderLine();

        //create systim objects
        Order systimOrder = new Order();
        Product systimProduct = new Product();
        List<Order> systimOrdersList = new ArrayList<>();
        List<Product> systimProductsList = new ArrayList<>();

        //set objects
        backmarketOrderLineList.add(backmarketOrderLine);
        backmarketOrderList.add(backmarketOrder);
        backmarketOrdersList.setResults(backmarketOrderList);
        backmarketOrderList.get(0).setOrderlines(backmarketOrderLineList);
        backmarketOrderList.get(0).setBilling_address(backmarketBillingAddress);
        backmarketOrderList.get(0).setShipping_address(backmarketShippingAddress);

        //set objects
        systimOrdersList.add(systimOrder);
        systimProductsList.add(systimProduct);
        systimOrder.setProductList(systimProductsList);

        //set values for billing address
        backmarketBillingAddress.setFirst_name("Przemek");
        backmarketBillingAddress.setLast_name("Kowalski");
        backmarketBillingAddress.setPostal_code("123");
        backmarketBillingAddress.setCity("Warszawa");
        backmarketBillingAddress.setStreet("Normalna");
        backmarketBillingAddress.setStreet2("2/7");
        backmarketBillingAddress.setCountry("Polska");

        //set values for shipping address
        backmarketShippingAddress.setFirst_name("Przemek");
        backmarketShippingAddress.setLast_name("Kowalski");
        backmarketShippingAddress.setPostal_code("456");
        backmarketShippingAddress.setCity("Kraków");
        backmarketShippingAddress.setStreet("Ciekawa");
        backmarketShippingAddress.setStreet2("14/6");
        backmarketShippingAddress.setPhone("111222333");
        backmarketShippingAddress.setEmail("test@wp.pl");
        backmarketShippingAddress.setCountry("Poland");

        //set values for order
        backmarketOrderList.get(0).setShipper("DHL");
        backmarketOrderList.get(0).setOrder_id(93);
        backmarketOrderList.get(0).setState(3);
        backmarketOrderList.get(0).setDelivery_note("coś");
        backmarketOrderList.get(0).setCurrency("EUR");

        //set values for product
        backmarketOrderLineList.get(0).setProduct("Mate 10 Lite");
        backmarketOrderLineList.get(0).setPrice(123.45);
        backmarketOrderLineList.get(0).setBrand("Huawei");
        backmarketOrderLineList.get(0).setProduct_id(71);
        backmarketOrderLineList.get(0).setQuantity(3);

        //convert backmarket order to systim order
        systimOrdersList = convertOrdersService.convertOrders(backmarketOrdersList);

        //junit tests
        assertEquals(systimOrdersList.get(0).getNazwa(), backmarketOrdersList.getResults().get(1).getOrderlines().get(1).getProduct());

    }

}