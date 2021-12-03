package com.springdemo.dao;

import com.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    //we have to inject the session factory which is used to connect to database
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<Customer> getCustomers() {

        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //create a query using hql
        Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);

        //execute query and get result set
        List<Customer> customers = theQuery.getResultList();

        //return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        //get cuurent hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //save the customer
      //  currentSession.save(theCustomer);
        currentSession.saveOrUpdate(theCustomer);

    }

    @Override
    public Customer getCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        //now retrive/read from database using the primary key
        Customer theCustomer = currentSession.get(Customer.class,theId);

        return theCustomer;
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        //delete object with primary key
        Query theQuery =currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId",theId);
        //below code works for both update and delete
        theQuery.executeUpdate();


    }
}
