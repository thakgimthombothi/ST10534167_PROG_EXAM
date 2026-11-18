 import java.util.Scanner;

public class ProductApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Single-dimensional array for product names
        String[] productNames = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        // Two-dimensional array [3 products][3 months]
        int[][] sales = new int[3][3];

        // Capture sales for each product for each month
        for (int i = 0; i < productNames.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1)
                        + " for " + productNames[i] + " mattress: ");
                sales[i][j] = input.nextInt();
            }
            System.out.println();
        }

        Product product = new Product(productNames, sales);
        PrintProduct printer = new PrintProduct(product);
        printer.printReport();

        input.close();
    }
}