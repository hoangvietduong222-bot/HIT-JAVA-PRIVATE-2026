package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private Customer customer;
    private List<CartItem> items;
    private String status;

    public Order(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.status = "PENDING";
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public void addItem(CartItem item) {
        if (item != null && item.getProduct() != null && item.getQuantity() > 0) {
            this.items.add(item);
        }
    }

    public double getTotal() {
        double total = 0.0;
        for (CartItem item : items) {
            total += item.getTotal();
        }
        return total;
    }
    public void confirm() {
        if ("PENDING".equals(this.status)) {
            this.status = "CONFIRMED";
        }
    }
    public void cancel() {
        if ("PENDING".equals(this.status)) {
            this.status = "CANCELLED";
        }
    }
}