package pl.i4less.ordertool.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.i4less.ordertool.entity.backmarket.OrdersList;
import pl.i4less.ordertool.entity.systim.Order;

public class OrderService {

    @Autowired
    private Order orderSystim;

    @Autowired
    private OrdersList ordersListBackmarket;

}