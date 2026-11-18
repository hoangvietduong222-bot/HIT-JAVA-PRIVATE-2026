package model;

public class Product {
    private String id;
    private String name;
    private double price;
    private int stock;

    public Product(String id, String name, double price, int stock) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID sản phẩm không được rỗng.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên sản phẩm không được rỗng.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Đơn giá phải lớn hơn 0.");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("Tồn kho không được âm.");
        }
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public void decreaseStock(int quantity) {
        if (quantity > 0 && quantity <= stock) {
            this.stock -= quantity;
        }
    }

    public String getDescription() {
        return name;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + price + " | tồn: " + stock;
    }
}