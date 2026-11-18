 package test;

import org.junit.Test;

public class ProductTest {

    // Same data as sample screenshot
    String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    int[][] sales = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};
    Product product = new Product(names, sales);

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        int expected = 153;
        int actual = product.GetTotalProductsSold();
        assertEquals(expected, actual);
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        double expected = 17.0;
        double actual = product.GetAverageProductSold();
        assertEquals(expected, actual, 0.01);
    }

    private void assertEquals(int expected, int actual) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(double expected, double actual, double d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}