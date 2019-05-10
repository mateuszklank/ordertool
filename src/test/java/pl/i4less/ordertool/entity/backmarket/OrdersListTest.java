package pl.i4less.ordertool.entity.backmarket;

import org.junit.Test;
import pl.i4less.ordertool.entity.systim.Order;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.Assert.*;

public class OrdersListTest {

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
        OrdersList ordersList = new OrdersList();
        Order orderSystim = new Order();
        //orderSystim.setKod(ordersList.getResults().get(0).getBilling_address().getPostal_code());
        assertNull(orderSystim.getKod());
    }

}