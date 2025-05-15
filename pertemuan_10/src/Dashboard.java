import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Dashboard extends JFrame {
    public Dashboard(){
        setTitle("Dashboard");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //CRUD panel, wait aku notice sesuatu, ini crud cuma buat label kah? ga bisa buat button?
        JPanel crudPanel = new JPanel(new GridLayout(4,2));

        crudPanel.add(new JLabel("Nama")); //asdos namain text field ya? atau aku salah paham? OHH atau tempat buat isi itu namanya Field, lupa
        JTextField namaField = new JTextField();
        crudPanel.add(namaField);

        crudPanel.add(new JLabel("NIM"));
        JTextField nimField = new JTextField();
        crudPanel.add(nimField);

        crudPanel.add(new JLabel("Jurusan"));
        JTextField jurusanField = new JTextField();
        crudPanel.add(jurusanField);

        JButton addButton = new JButton("Tambah Data");
        crudPanel.add(addButton);

        JButton deleteButton = new JButton("Hapus Data");
        crudPanel.add(deleteButton);

        //Tabel
        String[] namaKolom = {"Nama", "NIM", "Jurusan"};
        DefaultTableModel tableModel = new DefaultTableModel(namaKolom, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        add(crudPanel, BorderLayout.NORTH); //lah ini pake crud? aslinya crud itu apa dan buat apa sih

        //mengaktifkan buttons
        addButton.addActionListener(e->{
            String nama = namaField.getText();
            String nim = nimField.getText();
            String jurusan = jurusanField.getText();
            tableModel.addRow(new Object[]{nama, nim, jurusan});
        });

        deleteButton.addActionListener(e->{
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1){
                tableModel.removeRow(selectedRow);
            }
        });
    }
}