// Responsible for printing the report only
public class PrintProduct {

    private IProduct product;

    public PrintProduct(IProduct product) {
        this.product = product;
    }

    public void printTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void printAverageProductSales() {
        // Cast to int to match sample: 17 not 17.0
        System.out.println("AVERAGE PRODUCT SALES: " + (int) product.GetAverageProductSold());
    }

    public void printMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }

    public void printReport() {
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("******************************************");
        printTotalProductSales();
        printAverageProductSales();
        printMostPopularProduct();
    }
}