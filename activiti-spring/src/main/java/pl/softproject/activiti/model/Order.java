/**
 * Copyright 2016-03-30 the original author or authors.
 */
package pl.softproject.activiti.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
