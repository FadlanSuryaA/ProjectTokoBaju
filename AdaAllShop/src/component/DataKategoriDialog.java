
package component;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.table.DefaultTableModel;

public class DataKategoriDialog extends JDialog {
    private DefaultTableModel model;
    private JTable table;
    
    private String selectedKodeJenis;
    private String selectedNamaJenis;
    
    public String getSelectedKodeJenis() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            return model.getValueAt(selectedRow, 0).toString(); // Mengambil nilai dari kolom pertama (kode jenis)
        } else {
            return null; // Mengembalikan null jika tidak ada baris yang dipilih
        }
    }

    public String getSelectedNamaJenis() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            return model.getValueAt(selectedRow, 1).toString(); // Mengambil nilai dari kolom kedua (nama jenis)
        } else {
            return null; // Mengembalikan null jika tidak ada baris yang dipilih
        }
    }
    
    private void setSelection(String kodeJenis, String namaJenis) {
        selectedKodeJenis = kodeJenis;
        selectedNamaJenis = namaJenis;
    }

    public DataKategoriDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadData();
        
        // Atur ukuran dialog
        setSize(400, 300); // Sesuaikan dengan kebutuhan
        setLocationRelativeTo(null); // Posisikan di tengah layar
    }
    

    private void initComponents() {
        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void loadData() {
        model.setColumnIdentifiers(new String[]{"Kode Jenis", "Nama Jenis"});
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/toko", "root", "");
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery("SELECT id_kategori, nama_kategori FROM data_kategori");
            while (hasil.next()) {
                String kodeJenis = hasil.getString("id_kategori");
                String namaJenis = hasil.getString("nama_kategori");
                model.addRow(new Object[]{kodeJenis, namaJenis});
            }
            hasil.close();
            stat.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataKategoriDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
