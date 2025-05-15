import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Dashboard_11 extends JFrame {
    public Dashboard_11() {
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel untuk form input
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        JTextField nameField = new JTextField();
        JTextField nimField = new JTextField();
        JTextField prodiField = new JTextField();

        panel.add(new JLabel("Name"));
        panel.add(nameField);

        panel.add(new JLabel("NIM"));
        panel.add(nimField);

        panel.add(new JLabel("Prodi"));
        panel.add(prodiField);

        JButton addButton = new JButton("Add Student");
        JButton deleteButton = new JButton("Delete Student");

        panel.add(addButton);
        panel.add(deleteButton);

        // Tabel data
        String[] column = {"Nama", "NIM", "Prodi"};
        DefaultTableModel tabelModel = new DefaultTableModel(column, 0);
        JTable table = new JTable(tabelModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Mengatur layout frame
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // ActionListener untuk tombol Add
        addButton.addActionListener(e -> {
            String nameValue = nameField.getText();
            String nimValue = nimField.getText();
            String prodiValue = prodiField.getText();

            if (!nameValue.isEmpty() && !nimValue.isEmpty() && !prodiValue.isEmpty()) {
                tabelModel.addRow(new Object[]{nameValue, nimValue, prodiValue});
                nameField.setText("");
                nimField.setText("");
                prodiField.setText("");
            }
        });

        // ActionListener untuk tombol Delete
        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tabelModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Pilih baris yang akan dihapus!", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard_11();
    }
}