import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class MenuItem {
    String name;
    double price;

    MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    HashMap<MenuItem, Integer> items = new HashMap<>();

    void addItem(MenuItem item, int quantity) {
        items.put(item, quantity);
    }

    double calculateTotal() {
        double total = 0;
        for (MenuItem item : items.keySet()) {
            total += item.price * items.get(item);
        }
        return total;
    }


    void printReceipt() {
        System.out.println("=== Struk Pemesanan ===");
        for (MenuItem item : items.keySet()) {
            System.out.println(item.name + " x " + items.get(item) + " = " + (item.price * items.get(item)));
        }
        System.out.println("Total: " + calculateTotal());
    }


}

public class RestaurantOrderApp {
    public static void main(String[] args) {
        ArrayList<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Nasi Goreng", 20000));
        menu.add(new MenuItem("Mie Goreng", 15000));
        menu.add(new MenuItem("Ayam Penyet", 25000));
        menu.add(new MenuItem("ayam madu", 25000) );



        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        System.out.println("=== Menu Makanan ===");
        for (MenuItem item : menu) {
            System.out.println(item.name + " - " + item.price);
        }

        while (true) {
            System.out.print("Masukkan nama makanan (atau 'selesai' untuk menyelesaikan): ");
            String foodName = scanner.nextLine();
            if (foodName.equalsIgnoreCase("selesai")) {
                break;
            }

            MenuItem selectedItem = null;
            for (MenuItem item : menu) {
                if (item.name.equalsIgnoreCase(foodName)) {
                    selectedItem = item;
                    break;
                }
            }

            if (selectedItem != null) {
                System.out.print("Masukkan jumlah: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                order.addItem(selectedItem, quantity);


            } else {
                System.out.println("Makanan tidak ditemukan.");
            }
        }

        order.printReceipt();
        scanner.close();
    }
}