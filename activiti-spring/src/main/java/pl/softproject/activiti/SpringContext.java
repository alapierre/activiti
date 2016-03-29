/**
 * Copyright 2016-03-29 the original author or authors.
 */
package pl.softproject.activiti;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class SpringContext {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("activiti-spring.xml");

    }
}
