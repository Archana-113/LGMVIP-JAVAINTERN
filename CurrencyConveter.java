import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class CurrencyConveter extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private JLabel amountLabel;
    private JTextField amountTextField;
    private JLabel fromLabel;
    private JComboBox<String> fromComboBox;
    private JLabel toLabel;
    private JComboBox<String> toComboBox;
    private JButton convertButton;
    private JLabel resultLabel;
    String[] currencies = {"USD", "EUR", "JPY", "GBP","INR" };
    
    public CurrencyConveter() {
        super("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 3));
        amountLabel = new JLabel(" Enter Amount:");
        panel.add(amountLabel);
        amountTextField = new JTextField();
        panel.add(amountTextField);
        
        fromLabel = new JLabel("From Currency:");
        panel.add(fromLabel);
        
        fromComboBox = new JComboBox<>(currencies);
        panel.add(fromComboBox);

        toLabel = new JLabel("TO Currency:");
        panel.add(toLabel);
        toComboBox = new JComboBox<>(currencies);
        panel.add(toComboBox);

        

        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);

        panel.add(convertButton);
        resultLabel = new JLabel("");
        panel.add(resultLabel);
        add(panel);
        setVisible(true);
    }
    @Override
     public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountTextField.getText());
                String fromCurrency = (String) fromComboBox.getSelectedItem();
                String toCurrency = (String) toComboBox.getSelectedItem();
                double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);
                resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, convertedAmount, toCurrency));
            }

    private double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        double usdToEur = 0.85;
        double usdToGbp = 0.72;
        double usdToJpy = 109.67;
        double usdToInr = 82.748;
        double rateFrom;
        double rateTo;
        switch (fromCurrency) {
            case "USD":
                rateFrom = 1.0;
                break;
            case "EUR":
                rateFrom = usdToEur;
                break;
            case "GBP":
                rateFrom = usdToGbp;
                break;
            case "JPY":
                rateFrom = usdToJpy;
                break;
             case "INR":
                rateFrom = usdToInr;
                break;
            default:
                rateFrom = 1.0;
        }
        switch (toCurrency) {
            case "USD":
                rateTo = 1.0;
                break;
            case "EUR":
                rateTo = usdToEur;
                break;
            case "GBP":
                rateTo = usdToGbp;
                break;
            case "JPY":
                rateTo = usdToJpy;
                break;
            case "INR":
                rateTo = usdToInr;
                break;
            default:
                rateTo = 1.0;
        }
        return (amount / rateFrom) * rateTo;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CurrencyConveter().setVisible(true);
            }
        });
    }
}
