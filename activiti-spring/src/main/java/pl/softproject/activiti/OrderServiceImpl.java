/**
 * Copyright 2016-03-30 the original author or authors.
 */
package pl.softproject.activiti;

import pl.softproject.activiti.model.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class OrderServiceImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public Order create() {

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        Order order = new Order();

        order.setName("ala ma kota");

        entityManager.persist(order);

        return order;
    }

}
