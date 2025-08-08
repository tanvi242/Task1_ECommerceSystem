import java.util.Scanner;

// Interface with abstract method
interface Product {
    void displayDetails();
}

// Superclass
class Item {
    protected String name;
    protected double price;
    protected int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return price * quantity;
    }
}

// Subclass: Electronics
class Electronics extends Item implements Product {
    private String brand;

    public Electronics(String name, double price, int quantity, String brand) {
        super(name, price, quantity);
        this.brand = brand;
    }

    
public void displayDetails() {
    System.out.println("[Category: Electronics]");
    System.out.println("Name: " + name);
    System.out.println("Brand: " + brand);
    System.out.println("Price: Rs. " + price);
    System.out.println("Quantity: " + quantity);
    System.out.println("Total: Rs. " + getTotalCost());
    System.out.println("------------------------");
}

}

// Subclass: Clothing
class Clothing extends Item implements Product {
    private String size;

    public Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }


public void displayDetails() {
    System.out.println("[Category: Clothing]");
    System.out.println("Name: " + name);
    System.out.println("Size: " + size);
    System.out.println("Price: Rs. " + price);
    System.out.println("Quantity: " + quantity);
    System.out.println("Total: Rs. " + getTotalCost());
    System.out.println("------------------------");
}

    }


// Main class
public class ECommerceSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product[] cart = new Product[2];

        System.out.println("=== Welcome to Tanvi's E-Commerce System ===");

        // Get Electronics data
        System.out.println("\nEnter Electronics Product Details:");
        System.out.print("Name: ");
        String eName = scanner.nextLine();
        System.out.print("Brand: ");
        String eBrand = scanner.nextLine();
        System.out.print("Price: ");
        double ePrice = scanner.nextDouble();
        System.out.print("Quantity: ");
        int eQty = scanner.nextInt();
        scanner.nextLine(); // consume newline
        cart[0] = new Electronics(eName, ePrice, eQty, eBrand);

        // Get Clothing data
        System.out.println("\nEnter Clothing Product Details:");
        System.out.print("Name: ");
        String cName = scanner.nextLine();
        System.out.print("Size (e.g. M, L): ");
        String cSize = scanner.nextLine();
        System.out.print("Price: ");
        double cPrice = scanner.nextDouble();
        System.out.print("Quantity: ");
        int cQty = scanner.nextInt();
        cart[1] = new Clothing(cName, cPrice, cQty, cSize);

        // Display all product details
        System.out.println("\n=== Order Summary ===");
        for (Product p : cart) {
            p.displayDetails();
        }

        scanner.close();
    }
}
