package model;

public class Book extends Product {
    private String author;

    public Book(String id, String name, double price, int stock, String author) {
        super(id, name, price, stock);
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên tác giả không được rỗng.");
        }
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    // Ghi đè đa hình theo đúng mẫu: Tên sách — tác giả: Tác giả
    @Override
    public String getDescription() {
        return getName() + " — tác giả: " + author;
    }
}