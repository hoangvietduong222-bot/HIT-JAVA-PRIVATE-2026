import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HitShop {
    static final List<String> names = new ArrayList<>();
    static final List<Double> prices = new ArrayList<>();
    static final List<Integer> quantities = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("========== Menu ==========");
            printMenu();
            System.out.println("==========================");
            System.out.print("Chọn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addItem(sc);
                    break;
                case 2:
                    removeItem(sc);
                    break;
                case 3:
                    printItems();
                    break;
                case 4:
                    printDetails();
                    break;
                case 5:
                    searchItemByName(sc);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (choice != 0);

        sc.close();
    }

    static void printMenu() {
        System.out.println("1. Thêm mặt hàng");
        System.out.println("2. Xóa mặt hàng");
        System.out.println("3. Xem giỏ");
        System.out.println("4. Xem tổng tiền");
        System.out.println("5. Tìm kiếm theo tên");
        System.out.println("0. Thoát");
    }

    static void addItem(Scanner sc) {
        System.out.print("Nhập tên hàng: ");
        String name = sc.nextLine();

        System.out.print("Nhập giá hàng: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(sc.nextLine());

        addItem(name, price, quantity);
        printItems();
    }

    public static void addItem(String name, double price, int quantity) {
        names.add(name);
        prices.add(price);
        quantities.add(quantity);
    }

    static void removeItem(Scanner sc) {
        System.out.print("Bạn muốn xóa mặt hàng thứ mấy?: ");
        int index = Integer.parseInt(sc.nextLine());

        if (index <= 0 || index > names.size()) {
            System.out.println("Không tìm thấy mặt hàng.");
            return;
        }

        removeItem(index - 1);
        printItems();
    }

    public static void removeItem(int index) {
        if (index >= 0 && index < names.size()) {
            names.remove(index);
            prices.remove(index);
            quantities.remove(index);
        }
    }

    public static void printItems() {
        if (names.isEmpty()) {
            System.out.println("Giỏ hàng không có gì!");
            return;
        }
        for (int i = 0; i < names.size(); i++) {
            System.out.println((i + 1) + ". Tên: " + names.get(i)
                    + " | Giá: " + prices.get(i)
                    + " | Số lượng: " + quantities.get(i));
        }
    }

    public static double calculateTotal() {
        double total = 0;
        for (int i = 0; i < names.size(); i++) {
            total += prices.get(i) * quantities.get(i);
        }
        return total;
    }

    static void searchItemByName(Scanner sc) {
        System.out.print("Nhập tên mặt hàng cần tìm: ");
        String keyword = sc.nextLine();
        searchItemByName(keyword);
    }

    public static void searchItemByName(String keyword) {
        boolean found = false;
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(keyword.trim())) {
                System.out.println((i + 1) + ". Tên: " + names.get(i)  + " | Giá: " + prices.get(i) + " | Số lượng: " + quantities.get(i));
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy mặt hàng.");
        }
    }

    static void printDetails() {
        double subTotal = calculateTotal();

        if (names.isEmpty()) {
            System.out.println("Tiền hàng: 0");
            System.out.println("Thuế VAT (10%): 0");
            System.out.println("Phí vận chuyển: 0");
            System.out.println("Tổng thanh toán: 0");
            return;
        }

        final double VAT_RATE = 0.10;
        double vat = subTotal * VAT_RATE;
        final double shippingFee = 20000;
        double grandTotal = subTotal + vat + shippingFee;

        System.out.printf("Tiền hàng: %.0f\n", subTotal);
        System.out.printf("Thuế VAT: %.0f\n", vat);
        System.out.printf("Phí vận chuyển: %.0f\n", shippingFee);
        System.out.printf("Tổng thanh toán: %.0f\n", grandTotal);
    }
}