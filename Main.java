package com.sun.accessibility.internal.resources;

public class Main {
    public static void main(String[] args) {
        
        Store groceryStore = new Store();

    
        Product apple = new Product(1, "Apple", 1.0, 5);
        Product banana = new Product(2, "Banana", 0.5, 3);
        Product milk = new Product(3, "Milk", 2.0, 2);


        groceryStore.getInventory().addProductToInventory(apple);
        groceryStore.getInventory().addProductToInventory(banana);
        groceryStore.getInventory().addProductToInventory(milk);


        Customer customer = new Customer(1, "John Doe");


        Cart cart = new Cart();
        cart.addProduct(apple);
        cart.addProduct(banana);
        cart.addProduct(milk);


        Order order = new Order(101, new Date());
        order.setPayment(new Payment(201, cart.getTotalAmount(), "Credit Card"));
        order.getProducts().addAll(cart.getProducts());
        customer.placeOrder(order);


        System.out.println("Order Details:");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Order Date: " + order.getOrderDate());
        System.out.println("Products:");
        for (Product product : order.getProducts()) {
            System.out.println("- " + product.getName() + " (Quantity: " + product.getQuantity() + ")");
        }
        System.out.println("Total Amount: $" + order.getTotalAmount());
        System.out.println("Payment Method: " + order.getPayment().getPaymentMethod());
    }
}
