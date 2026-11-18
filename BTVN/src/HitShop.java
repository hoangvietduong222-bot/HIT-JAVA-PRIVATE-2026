import model.Book;
import model.CartItem;
import model.Customer;
import model.Order;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HitShop {
    private static final Customer currentCustomer =
            new Customer("C01", "Linh Nguyễn", "0900000001");
    private static final List<CartItem> cart = new ArrayList<>();

    // Danh sách sản phẩm chứa P01, P02 và Book P03
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product("P01", "Áo thun", 150000.0, 20));
        products.add(new Product("P02", "Bình nước", 50000.0, 10));
        products.add(new Book("P03", "Java cơ bản", 120000.0, 5, "An Nguyen"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("========== Menu ==========");
            System.out.println("1. Thêm mặt hàng");
            System.out.println("2. Xóa mặt hàng");
            System.out.println("3. Xem giỏ hàng");
            System.out.println("4. Xem tổng tiền");
            System.out.println("0. Thoát");
            System.out.println("==========================");
            System.out.print("Chọn: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ.");
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1:
                    handleAddFlow(sc);
                    break;
                case 2:
                    handleRemoveFlow(sc);
                    break;
                case 3:
                    printItems();
                    break;
                case 4:
                    System.out.println("Tổng tiền: " + calculateTotal());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (choice != 0);

        sc.close();
    }

    private static void handleAddFlow(Scanner sc) {
        System.out.println("Danh sách sản phẩm:");
        // Một vòng lặp gọi getDescription() đa hình cho mọi phần tử
        for (Product p : products) {
            System.out.println(p.getId() + " | " + p.getDescription() + " | Giá: " + p.getPrice());
        }

        System.out.print("Nhập mã sản phẩm: ");
        String code = sc.nextLine().trim();

        Product selectedProduct = null;
        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(code)) {
                selectedProduct = p;
                break;
            }
        }

        if (selectedProduct == null) {
            System.out.println("Không tìm thấy sản phẩm.");
            return;
        }

        System.out.print("Nhập số lượng: ");
        int quantity;
        try {
            quantity = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Số lượng phải lớn hơn 0.");
            return;
        }

        if (quantity <= 0) {
            System.out.println("Số lượng phải lớn hơn 0.");
            return;
        }

        addItem(selectedProduct, quantity);
    }

    private static void handleRemoveFlow(Scanner sc) {
        System.out.print("Bạn muốn xóa mặt hàng thứ mấy?: ");
        int displayNumber;
        try {
            displayNumber = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Không tìm thấy mặt hàng.");
            return;
        }

        if (displayNumber <= 0 || displayNumber > cart.size()) {
            System.out.println("Không tìm thấy mặt hàng.");
            return;
        }

        removeItem(displayNumber - 1);
    }

    static void addItem(Product product, int quantity) {
        cart.add(new CartItem(product, quantity));
    }

    static void removeItem(int index) {
        if (index >= 0 && index < cart.size()) {
            cart.remove(index);
        }
    }

    static void printItems() {
        System.out.println("Khách hàng: " + currentCustomer.toString());
        if (cart.isEmpty()) {
            System.out.println("Giỏ hàng đang trống.");
            return;
        }

        for (int i = 0; i < cart.size(); i++) {
            CartItem item = cart.get(i);
            Product p = item.getProduct();
            System.out.printf("%d. %s | %s | %.1f | SL: %d | Thành tiền: %.1f\n",
                    (i + 1),
                    p.getId(),
                    p.getDescription(),
                    p.getPrice(),
                    item.getQuantity(),
                    item.getTotal());
        }
    }

    static double calculateTotal() {
        double total = 0.0;
        for (CartItem item : cart) {
            total += item.getTotal();
        }
        return total;
    }
}