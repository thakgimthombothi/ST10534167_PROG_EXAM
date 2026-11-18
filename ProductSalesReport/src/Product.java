// Product class implements IProduct - holds the sales data and calculations
public class Product implements IProduct {

    private String[] productNames; // single-dimensional array
    private int[][] sales; // two-dimensional array [product][month]

    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
    }

    // Total of all products sold
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }
        }
        return total;
    }

    // Average = total / total number of entries (3 products x 3 months = 9)
    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int count = sales.length * sales[0].length;
        return (double) total / count;
    }

    // Most popular = product with the highest single monthly sale
    // This matches the sample: Cozy Nights Monarch(25)
    @Override
    public String GetMostPopularProduct() {
        int maxSale = sales[0][0];
        String popularProduct = productNames[0];

        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                if (sales[i][j] > maxSale) {
                    maxSale = sales[i][j];
                    popularProduct = productNames[i];
                }
            }
        }
        return popularProduct + "(" + maxSale + ")";
    }
}