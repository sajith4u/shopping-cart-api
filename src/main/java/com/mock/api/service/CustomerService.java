package com.mock.api.service;

import com.mock.api.model.Customer;
import com.mock.api.dto.CustomerDto;

public interface CustomerService {
    /**
     * Add New Cuctomer
     *
     * @param customerDto
     * @return Customer Object
     */
    Customer addCustomer(CustomerDto customerDto);

    /**
     * Find Customer By CustomerId
     *
     * @param customerId : Any String
     * @return
     */
    Customer findCustomer(String customerId);
}
