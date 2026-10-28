import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Hitshop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhâp tên hàng: ");
        String nameProduct = sc.nextLine();

        System.out.print("Nhâp đơn giá: ");
        double price = sc.nextDouble();

        System.out.print("Nhâp số lượng: ");
        int sl = sc.nextInt();

        double total = price * sl;
        System.out.println("Thành tiền: " + total);

        final double VAT_RATE = 0.10;
        final int SHIPPING_FEE = 20000;

        double sumTotal = total + total*VAT_RATE + SHIPPING_FEE;

        System.out.println("Tổng tiền thanh toán: " + sumTotal);
    }
}