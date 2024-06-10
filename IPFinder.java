import javax.swing.*;
import java.awt.event.*;
import java.net.*;

public class IPFinder extends JFrame implements ActionListener {

    private JLabel label;
    private JTextField textField;
    private JButton findButton;

    public IPFinder() {
        super("IP Finder Tool - Javatpoint");

        label = new JLabel("Enter URL:");
        label.setBounds(50, 70, 150, 20);

        textField = new JTextField();
        textField.setBounds(50, 100, 200, 20);

        findButton = new JButton("Find IP");
        findButton.setBounds(50, 150, 80, 30);
        findButton.addActionListener(this);

        add(label);
        add(textField);
        add(findButton);

        setSize(300, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use SwingUtilities.invokeLater to ensure GUI updates on the EDT
        SwingUtilities.invokeLater(() -> setVisible(true));
    }

    public void actionPerformed(ActionEvent e) {
        String url = textField.getText();
        try {
            InetAddress ia = InetAddress.getByName(url);
            String ip = ia.getHostAddress();
            JOptionPane.showMessageDialog(this, "IP Address: " + ip);
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new IPFinder();
    }
}
