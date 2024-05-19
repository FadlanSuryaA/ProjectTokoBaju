package component;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.table.DefaultTableModel;

public class DataBarangDialog extends JDialog {
    private DefaultTableModel model;
    private JTable table;
    
    private String selectedKodeBarang;
    private String selectedNamaBarang;
    private int selectedHargaJual;
    private int selectedStok;
    
    public String getSelectedKodeBarang() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            return model.getValueAt(selectedRow, 0).toString(); // Mengambil nilai dari kolom kode_barang
        } else {
            return null; // Mengembalikan null jika tidak ada baris yang dipilih
        }
    }

    public String getSelectedNamaBarang() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            return model.getValueAt(selectedRow, 1).toString(); // Mengambil nilai dari kolom nama_barang
        } else {
            return null; // Mengembalikan null jika tidak ada baris yang dipilih
        }
    }
    
    public int getSelectedHargaJual() {
    int selectedRow = table.getSelectedRow();
    if (selectedRow != -1) {
        try {
            return Integer.parseInt(model.getValueAt(selectedRow, 2).toString()); // Mengambil nilai dari kolom harga_beli
        } catch (NumberFormatException e) {
            // Tangani kesalahan konversi dengan mencetak pesan kesalahan dan mengembalikan nilai default
            System.err.println("Format harga beli tidak valid: " + e.getMessage());
            return -1; // Mengembalikan nilai default jika terjadi kesalahan
        }
    } else {
        return -1; // Mengembalikan -1 jika tidak ada baris yang dipilih
    }
}

    
    private void setSelection(String kodeBarang, String namaBarang, int hargaJual, int stok) {
        selectedKodeBarang = kodeBarang;
        selectedNamaBarang = namaBarang;
        selectedHargaJual= hargaJual;
        selectedStok = stok;
    }

    public DataBarangDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadData();
        
        // Atur ukuran dialog
        setSize(600, 300); // Sesuaikan dengan kebutuhan
        setLocationRelativeTo(null); // Posisikan di tengah layar
    }
    

    private void initComponents() {
        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
    

    private void loadData() {
        model.setColumnIdentifiers(new String[]{"Kode Barang", "Nama Barang", "Harga Jual", "Stok"});
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cihuuy", "root", "");
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery("SELECT kode_barang, nama_barang, harga_jual, stok FROM data_barang");
            while (hasil.next()) {
                String kodeBarang = hasil.getString("kode_barang");
                String namaBarang = hasil.getString("nama_barang");
                int hargaJual = hasil.getInt("harga_jual");
                int stok = hasil.getInt("stok");
                model.addRow(new Object[]{kodeBarang, namaBarang, hargaJual, stok});
            }
            hasil.close();
            stat.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBarangDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
