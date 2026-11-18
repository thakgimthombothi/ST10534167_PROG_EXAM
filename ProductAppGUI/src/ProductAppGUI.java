import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class ProductAppGUI extends JFrame {
    private JTextField txtCustomerName, txtPrice;
    private JComboBox<String> cmbProduct;
    private JButton btnProcess;

    public ProductAppGUI() {
        setTitle("Product Sales Application");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu Bar - this is your File / Tools menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem mnuExit = new JMenuItem("Exit");
        fileMenu.add(mnuExit);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem mnuProcess = new JMenuItem("Process");
        JMenuItem mnuClear = new JMenuItem("Clear");
        toolsMenu.add(mnuProcess);
        toolsMenu.add(mnuClear);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // Form
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        panel.add(txtCustomerName);

        panel.add(new JLabel("Select Product:"));
        cmbProduct = new JComboBox<>(new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});
        panel.add(cmbProduct);

        panel.add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        panel.add(txtPrice);

        panel.add(new JLabel(""));
        btnProcess = new JButton("PROCESS");
        panel.add(btnProcess);

        add(panel);

        // Actions - same code for button and menu
        ActionListener processAction = e -> processData();
        btnProcess.addActionListener(processAction);
        mnuProcess.addActionListener(processAction);

        mnuClear.addActionListener(e -> {
            txtCustomerName.setText("");
            txtPrice.setText("");
            cmbProduct.setSelectedIndex(0);
        });

        mnuExit.addActionListener(e -> System.exit(0));
    }

    private void processData() {
        try {
            String customerName = txtCustomerName.getText();
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            String message = "Customer Name: " + customerName
                    + "\nProduct: " + productName
                    + "\nVAT: R " + vat
                    + "\nCOMMISSION: R " + commission
                    + "\nTOTAL: R " + total;
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            try (FileWriter writer = new FileWriter("data.txt", true)) {
                writer.write("DATA LOG\n");
                writer.write("******************************************\n");
                writer.write("Customer Name: " + customerName + "\n");
                writer.write("Product: " + productName + "\n");
                writer.write("VAT: R " + vat + "\n");
                writer.write("COMMISSION: R " + commission + "\n");
                writer.write("TOTAL: R " + total + "\n");
                writer.write("******************************************\n");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving to file: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductAppGUI().setVisible(true));
    }
}