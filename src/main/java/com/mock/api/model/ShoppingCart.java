package com.mock.api.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppingCart implements CartItem {

    private String cartId;
    private Customer customer;
    private Map<Product, Integer> products;

    private BigDecimal productCost;
    private BigDecimal totalVat;
    private BigDecimal shippingCost;
    private BigDecimal totalDiscount;
    private BigDecimal totalTax;
    private BigDecimal finalCost;

    @Override
    public void calculateCost() {

        BigDecimal productPrice = BigDecimal.ZERO;
        BigDecimal taxPrice = BigDecimal.ZERO;
        BigDecimal discountPrice = BigDecimal.ZERO;
        for (Map.Entry<Product, Integer> prodEntry : products.entrySet()) {
            productPrice = productPrice.add(prodEntry.getKey().getPrice().multiply(BigDecimal.valueOf(prodEntry.getValue())));
            taxPrice = taxPrice.add(prodEntry.getKey().getPrice().multiply(BigDecimal.valueOf(prodEntry.getKey()
                    .getTaxPercentage())).divide(BigDecimal.valueOf(100)));
            discountPrice = discountPrice.add(prodEntry.getKey().getPrice().multiply(BigDecimal.valueOf(prodEntry.getKey().getDiscountPercentage()))
                    .divide(BigDecimal.valueOf(100)));
        }
        productCost = productPrice;
        totalDiscount = discountPrice;
        totalTax = taxPrice;
        finalCost = productPrice.add(shippingCost).add(taxPrice).add(totalVat).subtract(discountPrice);
    }


    @Override
    public String viewSummary() {
        return "Cart ID : " + cartId + " \n"
                + "Product Cost : " + productCost + "\n"
                + "Total Discount : " + totalDiscount + "\n"
                + "Total Vat : " + totalVat + "\n"
                + "Total Shipping Cost : " + shippingCost + "\n"
                + "Total Tax : " + totalTax + "\n"
                + "Final Price : " + finalCost + "\n";
    }
}
