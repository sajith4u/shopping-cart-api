package com.mock.api.service;

import com.mock.api.model.Customer;
import com.mock.api.network.AddCustomerRequest;

public interface CustomerService {
    /**
     * Add New Cuctomer
     *
     * @param addCustomerRequest
     * @return Customer Object
     */
    Customer addCustomer(AddCustomerRequest addCustomerRequest);

    /**
     * Find Customer By CustomerId
     *
     * @param customerId : Any String
     * @return
     */
    Customer findCustomer(String customerId);
}
