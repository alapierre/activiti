/**
 * Copyright 2016-03-30 the original author or authors.
 */
package pl.softproject.activiti;

import org.springframework.beans.factory.annotation.Autowired;
import pl.softproject.activiti.dao.OrderDAO;
import pl.softproject.activiti.model.Order;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class OrderServiceImpl {

    @Autowired
    private OrderDAO orderDAO;

    public Order create() {

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        Order order = new Order();

        order.setName("ala ma kota");

        orderDAO.save(order);

        return order;
    }

}
