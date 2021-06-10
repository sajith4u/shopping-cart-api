package com.mock.api.service.impl;

import com.mock.api.model.Customer;
import com.mock.api.dto.CustomerDto;
import com.mock.api.service.CustomerService;
import com.mock.api.util.CustomerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerServiceImplTest {

    @Test
    @DisplayName("Test Customer Creation")
    void testAddCustomer() {
        CustomerService customerService = new CustomerServiceImpl();
        Customer customerDetails = customerService.addCustomer(new CustomerDto("Sajith"));

        Customer customer = customerService.findCustomer(customerDetails.getId());
        assertNotNull(customer);
    }


    @Test
    @DisplayName("Test Duplicate Customer Name")
    void testDuplicateCustomer() {
        CustomerService customerService = new CustomerServiceImpl();
        CustomerDto customer = new CustomerDto("Sajith");
        customerService.addCustomer(customer);

        assertThrows(CustomerException.class, () -> {
            customerService.addCustomer(customer);
        });
    }
}