
package component;

import Koneksi.koneksi;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import table.TableCustom;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;

/*import java.time.LocalDateTime;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;*/

public class DataPenjualan extends javax.swing.JPanel {
    
    private DefaultTableModel keranajangModel;
    private Connection conn;
 
    public DataPenjualan(String name) {
        initComponents();
        conn = koneksi.getConnection();        
        tampilData();
        totalSemuaTransaksi();
        jLabel1.setText(name);
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
               
    }
    public int total;
    public void reset(){
        txt_kdpenjualan.setText("");
        txt_namabarang.setText("");
        txt_kdbarang.setText("");
        txt_harga.setText("");
        txt_jumlah.setText("");
        txt_total.setText("");
    }
    //public void tanggal(){
        //Date now = new Date();  
        //tgl_transaksi.setDate(now);    
    //}
    private DecimalFormat decimalFormat = new DecimalFormat("#,##0");
    private double totalHargaKeseluruhan = 0.0; // variabel untuk menyimpan total harga keseluruhan
    private void keranjang() {
    // Mendapatkan data dari inputan
    String tanggal = txt_tanggal.getText();
    String kode = txt_kdbarang.getText();
    String nama = txt_namabarang.getText();
    String harga = txt_harga.getText();
    String jumlah = txt_jumlah.getText();
    String total = txt_total.getText();
    
    // Mendapatkan tanggal transaksi dan mengubah formatnya menjadi "yyyy-MM-dd"
    //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //String tanggal = dateFormat.format(tgl_transaksi.getDate());
    
    // Validasi inputan
    if (kode.isBlank() || nama.isEmpty() || harga.isEmpty() || jumlah.isEmpty() || total.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Isi terlebih dahulu semua kolom", "Validasi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Query untuk memasukkan data transaksi ke database
        String queryTransaksi = "INSERT INTO transaksi (tgl_transaksi, kode_barang, nama_barang, harga, jumlah_barang, total_harga) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statementTransaksi = conn.prepareStatement(queryTransaksi);
        
        // Mengatur parameter untuk query transaksi
        statementTransaksi.setString(1, tanggal);
        statementTransaksi.setString(2, kode);
        statementTransaksi.setString(3, nama);
        statementTransaksi.setString(4, harga);
        statementTransaksi.setString(5, jumlah);
        statementTransaksi.setString(6, total);

        // Eksekusi query INSERT untuk transaksi
        int rowInsertedTransaksi = statementTransaksi.executeUpdate();
        statementTransaksi.close();
        
        // Query untuk memasukkan data ke dalam tabel keranjang (jika diperlukan)
        // Gantikan bagian ini dengan query INSERT INTO jika diperlukan

        if (rowInsertedTransaksi > 0) {
            JOptionPane.showMessageDialog(this, "Data Berhasil Dimasukkan Ke-Keranjang");
            // Reset inputan
            reset();
            // Tampilkan data penjualan terbaru
            tampilData();
            // Kurangi stok barang setelah transaksi penjualan (jika diperlukan)
            kurangiStokBarang(kode, Integer.parseInt(jumlah));
            // Gantikan bagian ini dengan panggilan metode yang sesuai jika diperlukan
            total();
            totalSemuaTransaksi();
        }
    }       catch (Exception e) {
                Logger.getLogger(DataPenjualanCoba2.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(this, "Data penjualan gagal ditambahkan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }

    private void tampilData() {
    // Mengambil model default dari tabel tempat menampilkan data transaksi
    DefaultTableModel model = (DefaultTableModel) keranjangModel.getModel();
    
    // Mengosongkan semua baris yang ada dalam tabel
    model.setRowCount(0);
    
    try {
        // Query SQL untuk mengambil semua data dari tabel penjualan
        String sql = "SELECT * FROM keranjang";
        
        // Membuat statement untuk menjalankan query
        Statement stat = conn.createStatement();
        
        // Eksekusi query SQL dan simpan hasilnya dalam ResultSet
        ResultSet hasil = stat.executeQuery(sql);
        
        // Mengambil dan menampilkan setiap baris hasil query
        while (hasil.next()) {
            // Mengambil nilai dari setiap kolom dalam baris hasil
            String kode_barang = hasil.getString("kode_barang");
            String nama_barang = hasil.getString("nama_barang");              
            String harga = hasil.getString("harga");
            String jumlah = hasil.getString("jumlah_barang");
            String total = hasil.getString("total_harga");          
            String tanggalDB = hasil.getString("tgl_transaksi"); // Ambil tanggal dari hasil ResultSet
            //SimpleDateFormat dateFormatDB = new SimpleDateFormat("yyyy-MM-dd"); // Tentukan pola format dari tanggal di basis data
            //SimpleDateFormat dateFormatGUI = new SimpleDateFormat("dd-MM-yyyy"); // Tentukan pola format yang diinginkan untuk ditampilkan di GUI
            //String tanggal = dateFormatGUI.format(dateFormatDB.parse(tanggalDB)); // Lakukan konversi tanggal

            
            // Membuat array yang berisi nilai-nilai dari setiap kolom
            Object[] rowData = {kode_barang, nama_barang, harga, jumlah, total, tanggalDB}; // Menggunakan variabel tanggal yang sudah dikonversi
            
            // Menambahkan baris baru ke dalam model tabel dengan nilai-nilai tersebut
            model.addRow(rowData);
        }
    } catch (Exception e) {
        // Menangkap dan mencatat kesalahan yang mungkin terjadi
        Logger.getLogger(DataPenjualan.class.getName()).log(Level.SEVERE, null, e);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        txt_kdpenjualan = new TextCostum.TextField();
        jPanel1 = new javax.swing.JPanel();
        panel1 = new Variasi.panel();
        txt_namabarang = new TextCostum.TextField();
        txt_kdbarang = new TextCostum.TextField();
        txt_harga = new TextCostum.TextField();
        txt_jumlah = new TextCostum.TextField();
        tbn_hapus = new Variasi.fbutton();
        btn_tambah = new Variasi.fbutton();
        txt_total = new TextCostum.TextField();
        fbutton1 = new Variasi.fbutton();
        reset = new Variasi.fbutton();
        txt_tanggal = new TextCostum.TextField();
        btn_jenis = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panel5 = new Variasi.panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        keranjangModel = new javax.swing.JTable();
        panel8 = new Variasi.panel();
        jPanel2 = new javax.swing.JPanel();
        btn_bayar = new Variasi.fbutton();
        btnCetak = new Variasi.fbutton();
        txt_totalHarga = new Variasi.TextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_bayar = new Variasi.TextField();
        txt_kembalian = new Variasi.TextField();
        panel6 = new Variasi.panel();
        txt_totalSemua = new Variasi.TextField();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(txt_tanggal);

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(228, 228, 228));

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        txt_namabarang.setLabelText("Nama Barang");
        txt_namabarang.setLineColor(new java.awt.Color(0, 102, 51));
        txt_namabarang.setSelectionColor(new java.awt.Color(0, 153, 51));
        txt_namabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarangActionPerformed(evt);
            }
        });

        txt_kdbarang.setLabelText("Kode Barang");
        txt_kdbarang.setLineColor(new java.awt.Color(0, 102, 51));
        txt_kdbarang.setSelectionColor(new java.awt.Color(0, 153, 51));
        txt_kdbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kdbarangActionPerformed(evt);
            }
        });

        txt_harga.setLabelText("Harga");
        txt_harga.setLineColor(new java.awt.Color(0, 102, 51));
        txt_harga.setSelectionColor(new java.awt.Color(0, 153, 51));
        txt_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargaActionPerformed(evt);
            }
        });

        txt_jumlah.setLabelText("Jumlah");
        txt_jumlah.setLineColor(new java.awt.Color(0, 102, 51));
        txt_jumlah.setSelectionColor(new java.awt.Color(0, 153, 51));
        txt_jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahActionPerformed(evt);
            }
        });
        txt_jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_jumlahKeyReleased(evt);
            }
        });

        tbn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/Trash.png"))); // NOI18N
        tbn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbn_hapusActionPerformed(evt);
            }
        });

        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/Add Shopping Cart.png"))); // NOI18N
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        txt_total.setLabelText("Total");
        txt_total.setLineColor(new java.awt.Color(0, 102, 51));
        txt_total.setSelectionColor(new java.awt.Color(0, 153, 51));
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });

        fbutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/Clear Shopping Cart.png"))); // NOI18N
        fbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fbutton1ActionPerformed(evt);
            }
        });

        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/Replace.png"))); // NOI18N
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        txt_tanggal.setLabelText("Tanggal");
        txt_tanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tanggalActionPerformed(evt);
            }
        });

        btn_jenis.setFont(new java.awt.Font("Century Gothic", 3, 10)); // NOI18N
        btn_jenis.setForeground(new java.awt.Color(255, 255, 255));
        btn_jenis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/Add Basket.png"))); // NOI18N
        btn_jenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jenisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_kdbarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_namabarang, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                            .addComponent(txt_jumlah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_jenis, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txt_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(fbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_jenis, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_kdbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tbn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Data Penjualan");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(80, 80, 80));
        jLabel3.setText("Total :");

        panel5.setBackground(new java.awt.Color(0, 102, 51));
        panel5.setRoundTopLeft(7);
        panel5.setRoundTopRight(7);

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        keranjangModel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Price", "Qty", "Total", "Date"
            }
        ));
        keranjangModel.setGridColor(new java.awt.Color(36, 102, 69));
        keranjangModel.setInheritsPopupMenu(true);
        keranjangModel.setShowGrid(false);
        keranjangModel.setShowHorizontalLines(true);
        keranjangModel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keranjangModelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(keranjangModel);

        panel8.setBackground(new java.awt.Color(0, 102, 51));
        panel8.setRoundTopLeft(7);
        panel8.setRoundTopRight(7);

        javax.swing.GroupLayout panel8Layout = new javax.swing.GroupLayout(panel8);
        panel8.setLayout(panel8Layout);
        panel8Layout.setHorizontalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel8Layout.setVerticalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btn_bayar.setText("payment");
        btn_bayar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btn_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bayarActionPerformed(evt);
            }
        });

        btnCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/Printer_1.png"))); // NOI18N
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        txt_totalHarga.setForeground(new java.awt.Color(102, 102, 102));
        txt_totalHarga.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txt_totalHarga.setShadowColor(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(80, 80, 80));
        jLabel4.setText("Total  Harga");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(80, 80, 80));
        jLabel5.setText("Kembalian");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(80, 80, 80));
        jLabel6.setText("Bayar");

        txt_bayar.setForeground(new java.awt.Color(102, 102, 102));
        txt_bayar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txt_bayar.setShadowColor(new java.awt.Color(51, 51, 51));
        txt_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bayarActionPerformed(evt);
            }
        });

        txt_kembalian.setForeground(new java.awt.Color(102, 102, 102));
        txt_kembalian.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txt_kembalian.setShadowColor(new java.awt.Color(51, 51, 51));
        txt_kembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kembalianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txt_totalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                        .addComponent(btn_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_totalHarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );

        panel6.setBackground(new java.awt.Color(0, 102, 51));
        panel6.setRoundTopLeft(7);
        panel6.setRoundTopRight(7);

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        txt_totalSemua.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_totalSemua.setToolTipText("");
        txt_totalSemua.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_totalSemua, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(panel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txt_totalSemua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargaActionPerformed
        
    }//GEN-LAST:event_txt_hargaActionPerformed

    private void txt_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahActionPerformed
                                      
    }//GEN-LAST:event_txt_jumlahActionPerformed
    // Deklarasikan objek DecimalFormat sebagai variabel instance

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
    keranjang();   
}
     private void kurangiStokBarang(String kode_barang, int jumlahDijual) {
    try {
        // Ambil data stok barang dari database
        String sql = "SELECT stok FROM Data_Barang WHERE kode_barang = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, kode_barang);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            // Ambil stok saat ini
            int stokSaatIni = rs.getInt("stok");
            // Hitung stok baru setelah transaksi penjualan
            int stokBaru = stokSaatIni - jumlahDijual;
            // Update stok barang di database
            sql = "UPDATE Data_Barang SET stok = ? WHERE kode_barang = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1, stokBaru);
            st.setString(2, kode_barang);
            // Eksekusi query UPDATE
            int rowUpdated = st.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("Stok barang berhasil diperbarui");
            }
        }
        rs.close();
        st.close();
    } catch (Exception e) {
        Logger.getLogger(DataPenjualanCoba2.class.getName()).log(Level.SEVERE, null, e);
    }                                 
    }//GEN-LAST:event_btn_tambahActionPerformed
    private void tbn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbn_hapusActionPerformed
        int selectRow = keranjangModel.getSelectedRow();
        if(selectRow == -1){
            JOptionPane.showMessageDialog(this, "Pilih terlebih dahulu baris yang akan dihapus");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin menghapus data ini", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            String kode_barang = keranjangModel.getValueAt(selectRow, 0).toString();
            try {
                String sql = "DELETE FROM keranjang WHERE id=?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, kode_barang);
                int rowDelete = st.executeUpdate();
                if(rowDelete > 0){
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
                }
                st.close();
            } catch (Exception e) {
                Logger.getLogger(DataPenjualan.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        reset();
        tampilData();
        //onButton();
        //offButton(); 
    }
        private void total() {
  try {
        // Query untuk mengambil total harga dari semua barang dalam keranjang
        String queryTotal = "SELECT SUM(total_harga) FROM keranjang";
        Statement statementTotal = conn.createStatement();
        ResultSet resultSet = statementTotal.executeQuery(queryTotal);

        // Mengambil nilai total harga dari hasil query
        if (resultSet.next()) {
            int totalHarga = resultSet.getInt(1);

            // Format angka dengan separator ribuan
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            String formattedTotalHarga = decimalFormat.format(totalHarga);

            // Mengatur nilai total pada teks area total
            txt_totalHarga.setText("Rp. "+formattedTotalHarga);
        }

        statementTotal.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
        } 
     private void totalSemuaTransaksi() {
    try {
        // Query untuk mengambil total harga dari semua barang dalam keranjang
        String queryTotal = "SELECT SUM(total_harga) FROM transaksi";
        Statement statementTotal = conn.createStatement();
        ResultSet resultSet = statementTotal.executeQuery(queryTotal);

        // Mengambil nilai total harga dari hasil query
        if (resultSet.next()) {
            int totalHarga = resultSet.getInt(1);

            // Format angka dengan separator ribuan
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            String formattedTotalHarga = decimalFormat.format(totalHarga);

            // Mengatur nilai total pada teks area total
            txt_totalSemua.setText("Rp. "+formattedTotalHarga);
        }

        statementTotal.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_tbn_hapusActionPerformed
    private void txt_kdbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kdbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kdbarangActionPerformed
    private void btn_jenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jenisActionPerformed
        // Panggil dan tampilkan dialog DataBarangDialog saat tombol jenis diklik
        DataBarangDialog dialog = new DataBarangDialog((JFrame) SwingUtilities.getWindowAncestor(this), true);
        dialog.setVisible(true);

        // Setelah dialog ditutup, dapatkan data yang dipilih (jika ada) dan tampilkan di teks field
        String kodeBarang = dialog.getSelectedKodeBarang();
        String namaBarang = dialog.getSelectedNamaBarang();
        int hargaBeli = dialog.getSelectedHargaJual();
        //int stok = dialog.getSelectedStok();

        if (kodeBarang != null && namaBarang != null) {
            txt_kdbarang.setText(kodeBarang);
            txt_namabarang.setText(namaBarang);
            txt_harga.setText(String.valueOf(hargaBeli));
            //txt_stok.setText(String.valueOf(stok));
            txt_namabarang.requestFocus();
            
        } else {
            System.out.println("No data selected from dialog");
        }    
        
    }//GEN-LAST:event_btn_jenisActionPerformed
    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed
    private void txt_jumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahKeyReleased
       if(txt_jumlah.getText().trim().equals("")) {
                System.out.println("Teks kosong, mengatur harga menjadi 0");
                //txt_harga.setText("0");
                txt_total.setText("0"); // Set txt_total menjadi 0 jika jumlah kosong
        } else {
            try {
                int harga = Integer.parseInt(txt_harga.getText().trim());
                int jumlah = Integer.parseInt(txt_jumlah.getText().trim());
                System.out.println("Harga: " + harga + ", Jumlah: " + jumlah);
                int total = harga * jumlah;
                System.out.println("Total: " + total);
                //txt_harga.setText(String.valueOf(total)); // Set txt_harga menjadi total
                txt_total.setText(String.valueOf(total)); // Set txt_total menjadi total
        } catch (NumberFormatException e) {
                System.out.println("Kesalahan parsing input: " + e.getMessage());   
        }
    }
    }//GEN-LAST:event_txt_jumlahKeyReleased
    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarangActionPerformed
    private void fbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fbutton1ActionPerformed
        reset();
    }//GEN-LAST:event_fbutton1ActionPerformed
    private void btn_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bayarActionPerformed
   // Mengambil nilai bayar dari teks dan menghilangkan karakter non-numerik
    String bayarStr = txt_bayar.getText().replaceAll("[^\\d]", "");
    int bayar = Integer.parseInt(bayarStr);

    // Mengambil nilai total harga dari teks dan menghilangkan karakter non-numerik
    String totalHargaStr = txt_totalHarga.getText().replaceAll("[^\\d]", ""); // Menghilangkan semua karakter non-numerik
    double totalHarga = Double.parseDouble(totalHargaStr);

    // Melakukan perhitungan kembalian
    double kembalian = bayar - totalHarga;

    // Format kembalian menggunakan DecimalFormat
    DecimalFormat decimalFormat = new DecimalFormat("#,##0");
    String formattedKembalian = decimalFormat.format(kembalian);

    // Menampilkan hasil kembalian di txt_kembalian
    txt_kembalian.setText("Rp. " + formattedKembalian);
    reset();
    }//GEN-LAST:event_btn_bayarActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
         try {
        String clear = "TRUNCATE keranjang";
        Connection connect = koneksi.getConnection();  
        PreparedStatement st = (PreparedStatement) connect.prepareStatement(clear);
        st.execute();
        
        DefaultTableModel model = (DefaultTableModel) keranjangModel.getModel();
        model.setRowCount(0);
        
        // Pembaruan tampilan tabel
        model.fireTableDataChanged();
        txt_totalHarga.setText("");
        
    } catch (Exception e) {
        System.out.println(e);
    } finally {
        // Mengatur ulang data dengan mengambil kolom yang diberikan
        if (txt_kdbarang != null) {
            txt_kdbarang.setText("");
        }
        if (txt_namabarang != null) {
            txt_namabarang.setText("");
        }
        if (txt_harga != null) {
            txt_harga.setText("");
        }
        if (txt_jumlah != null) {
            txt_jumlah.setText("");
        }
        if (txt_total != null) {
            txt_total.setText("");
        }
      }
    }//GEN-LAST:event_resetActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
    /*try {
    // Lokasi file laporan JasperReports
    String file = "/report/struk.jasper";
    
    // Memuat driver JDBC MySQL
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    // Membuat parameter untuk laporan
    HashMap<String, Object> param = new HashMap<>();
    param.put("total", txt_totalHarga.getText());
    param.put("bayar", txt_bayar.getText());
    param.put("kembalian", txt_kembalian.getText());
    
    // Mengisi laporan dengan data dan parameter
    JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream(file), param, koneksi.getConnection());
    
    // Menampilkan laporan menggunakan JasperViewer
    JasperViewer.viewReport(print, false);
} catch (ClassNotFoundException | JRException e) {
    // Menangani pengecualian jika terjadi kesalahan
    e.printStackTrace();
    System.out.println(e);
}      
    // Reset field setelah data disimpan

*/    //txt_id_penjualan.setText("");
   // txt_tanggal.setText("");
    txt_bayar.setText("");
    txt_totalHarga.setText("");
    txt_kembalian.setText("");
    }//GEN-LAST:event_btnCetakActionPerformed

    private void keranjangModelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keranjangModelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_keranjangModelMouseClicked

    private void txt_tanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tanggalActionPerformed

    private void txt_kembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kembalianActionPerformed

    private void txt_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bayarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Variasi.fbutton btnCetak;
    private Variasi.fbutton btn_bayar;
    private javax.swing.JButton btn_jenis;
    private Variasi.fbutton btn_tambah;
    private com.raven.datechooser.DateChooser dateChooser1;
    private Variasi.fbutton fbutton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable keranjangModel;
    private Variasi.panel panel1;
    private Variasi.panel panel5;
    private Variasi.panel panel6;
    private Variasi.panel panel8;
    private Variasi.fbutton reset;
    private Variasi.fbutton tbn_hapus;
    private Variasi.TextField txt_bayar;
    private TextCostum.TextField txt_harga;
    private TextCostum.TextField txt_jumlah;
    private TextCostum.TextField txt_kdbarang;
    private TextCostum.TextField txt_kdpenjualan;
    private Variasi.TextField txt_kembalian;
    private TextCostum.TextField txt_namabarang;
    private TextCostum.TextField txt_tanggal;
    private TextCostum.TextField txt_total;
    private Variasi.TextField txt_totalHarga;
    private Variasi.TextField txt_totalSemua;
    // End of variables declaration//GEN-END:variables

}
