/**
 * Copyright 2016-03-30 the original author or authors.
 */
package pl.softproject.activiti.dao;

import org.springframework.data.repository.CrudRepository;
import pl.softproject.activiti.model.Order;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public interface OrderDAO extends CrudRepository<Order, Long> {
}
