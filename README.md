# Shopping Cart API GUIDE

### Class Diagram

![alt text](https://github.com/sajith4u/shopping-cart-api/blob/master/diagrams/class_diagram.jpg)

### How to Test API

Go to ShoppingCartApiApplication.class & execute the main method.

### Areas Available to Test

#### Case 1

Add Single Customer & add Single Product & View Shopping Cart  Summary

**OutPut**

Cart ID : 8f2c77b8-b08c-46ed-be2d-9de1850b05c2 

Product Cost : 300000

Total Discount : 8250.0

Total Vat : 1500

Total Shipping Cost : 2500

Total Tax : 15000.0

Final Price : 310750.0

{Product{name='Samsung Odyssey CRG9', price=150000}=2}



#### Case 2

Add Another Customer & add multiple Products with different quantity & View Shopping Cart  Summary

**OutPut**

Cart ID : 54e0d660-4ab9-4a18-852b-4bffe9d1508b 

Products Cost : 900000

Total Discount : 22250.0

Total Vat : 1500

Total Shipping Cost : 2500

Total Tax : 45000.0

Final Price : 926750.0

_Products_ :

{Product{name='Samsung Odyssey CRG9', price=150000}=2, Product{name='ASUS ROG Strix', price=200000}=3}



### Assumptions

1. Vat & Shipping Cost will be applicable to Shopping Cart. So those values available as hard code values.

Shipping Cost : 2500

Vat : 1500 

### Used Libraries 

1. Used Lombok library to generate getters, setters & constructors 



