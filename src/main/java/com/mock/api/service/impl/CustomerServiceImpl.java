package com.mock.api.service.impl;

import com.mock.api.model.Customer;
import com.mock.api.dto.CustomerDto;
import com.mock.api.service.CustomerService;
import com.mock.api.util.ApiError;
import com.mock.api.util.CustomerException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {

    private List<Customer> customerPool = new ArrayList<>();


    @Override
    public Customer addCustomer(CustomerDto customerDto) {

        // To Generate Id using UUID class which is thread safe.
        Customer newCustomer = Customer.builder().name(customerDto.getName()).id(UUID.randomUUID().toString()).build();
        boolean isCustomerAlreadyRegistered = customerPool.contains(newCustomer);

        if (isCustomerAlreadyRegistered) {
            throw new CustomerException(ApiError.USER_ALREADY_REGISTERED);
        }

        addCustomer(newCustomer);
        return newCustomer;
    }


    /**
     * Add synchronized block to handle concurrency issue in List
     *
     * @param newCustomer
     */
    private synchronized void addCustomer(Customer newCustomer) {
        customerPool.add(newCustomer);
    }



    @Override
    public Customer findCustomer(String customerId) {
        Optional<Customer> cusomerInfo = customerPool.stream().filter(user -> user.getId().equals(customerId)).findAny();
        if (!cusomerInfo.isPresent()) {
            throw new CustomerException(ApiError.USER_NOT_AVAILABLE);
        }
        return cusomerInfo.get();
    }
}
