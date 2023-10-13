package com.sun.accessibility.internal.resources;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private Date orderDate;
    private List<Product> products;
    private double totalAmount;

    public Order(int orderId, Date orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.products = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void addProduct(Product product) {
        products.add(product);
        updateTotalAmount();
    }

    public void removeProduct(Product product) {
        products.remove(product);
        updateTotalAmount();
    }

    private void updateTotalAmount() {
        totalAmount = calculateTotalAmount();
    }

    private double calculateTotalAmount() {
        double sum = 0.0;
        for (Product product : products) {
            sum += product.getPrice() * product.getQuantity();
        }
        return sum;
    }

}