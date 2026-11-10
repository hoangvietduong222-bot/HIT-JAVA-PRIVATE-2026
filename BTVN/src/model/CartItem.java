package model;

public class CartItem {
    private Product product;
    private int quantity;

    // Constructor nhận đủ 2 thuộc tính
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Thành tiền = đơn giá * số lượng mua
    public double getTotal() {
        return product.getPrice() * quantity;
    }
}