package com.mock.api.model;

public interface CartItem {

    /**
     * calculate Shopping cart Summary
     *
     * @return
     */
    void calculateCost();


    /**
     * Show the Summary of Shopping Cart
     *
     * @return
     */

    String viewSummary();
}
