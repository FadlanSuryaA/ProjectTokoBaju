
package component;

import Koneksi.koneksi;
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
import java.time.LocalDateTime;

public class DataPenjualanCoba2 extends javax.swing.JPanel {
    
 private DefaultTableModel csttable;
 private Connection conn;
 
public DataPenjualanCoba2(String name) {
        initComponents();
        conn = koneksi.getConnection();
        txt_kdpenjualan.setText(IDTransaksi());
        Tampilkan_data();
        jLabel1.setText(name);
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        
    }
    public int total;
    public void reset(){
        txt_kdpenjualan.setText("");
        txt_tanggal.setText("");
        txt_namabarang.setText("");
        txt_kdbarang.setText("");
        txt_harga.setText("");
        
        txt_jumlah.setText("");
        txt_total.setText("");
    }
    public void Tampilkan_data(){
        DefaultTableModel model =(DefaultTableModel) csttabel.getModel();
        model.setRowCount(0);
       
        try {
            String sql = "Select*from penjualan";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            
            while(hasil.next()){
               String id = hasil.getString("id_penjualan");
               String tanggal = hasil.getString("tanggal");
               String kode_barang = hasil.getString("kode_barang");
               String nama_barang = hasil.getString("nama_barang");              
               String harga = hasil.getString("harga");
           
               String jumlah = hasil.getString("jumlah_barang");
               String total = hasil.getString("total");
               
               Object[] rowData = {id,tanggal,kode_barang,nama_barang,harga,jumlah,total};
           model.addRow(rowData);
            }
        }catch (Exception e){
            Logger.getLogger(DataPenjualanCoba2.class.getName()).log(Level.SEVERE,null,e);
        }
        
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        panel1 = new Variasi.panel();
        txt_kdpenjualan = new TextCostum.TextField();
        txt_tanggal = new TextCostum.TextField();
        txt_namabarang = new TextCostum.TextField();
        txt_kdbarang = new TextCostum.TextField();
        txt_harga = new TextCostum.TextField();
        txt_jumlah = new TextCostum.TextField();
        tbn_hapus = new Variasi.fbutton();
        btn_tambah = new Variasi.fbutton();
        btn_jenis = new javax.swing.JButton();
        txt_total = new TextCostum.TextField();
        panel4 = new Variasi.panel();
        jLabel1 = new javax.swing.JLabel();
        panel5 = new Variasi.panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        csttabel = new javax.swing.JTable();
        t_cari = new Variasi.TextField();
        jLabel3 = new javax.swing.JLabel();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(txt_tanggal);

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(228, 228, 228));

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        txt_kdpenjualan.setLabelText("Kode Penjualan");
        txt_kdpenjualan.setLineColor(new java.awt.Color(0, 102, 51));
        txt_kdpenjualan.setSelectionColor(new java.awt.Color(0, 153, 51));
        txt_kdpenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kdpenjualanActionPerformed(evt);
            }
        });

        txt_tanggal.setLabelText("Tanggal ");
        txt_tanggal.setLineColor(new java.awt.Color(0, 102, 51));
        txt_tanggal.setSelectionColor(new java.awt.Color(0, 153, 51));

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

        tbn_hapus.setText("del");
        tbn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbn_hapusActionPerformed(evt);
            }
        });

        btn_tambah.setText("add");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_jenis.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btn_jenis.setForeground(new java.awt.Color(0, 102, 51));
        btn_jenis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/Add Database.png"))); // NOI18N
        btn_jenis.setText("        Pilih Barang");
        btn_jenis.setBorder(null);
        btn_jenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jenisActionPerformed(evt);
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

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_kdpenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txt_namabarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txt_harga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_jumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txt_kdbarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(23, 23, 23)
                            .addComponent(tbn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_jenis, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kdpenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_kdbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_jenis, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panel4.setBackground(new java.awt.Color(0, 102, 51));
        panel4.setRoundTopLeft(12);
        panel4.setRoundTopRight(12);

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Data Penjualan");

        panel5.setBackground(new java.awt.Color(0, 102, 51));
        panel5.setRoundTopLeft(12);
        panel5.setRoundTopRight(12);

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        csttabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Penjualan", "Tanggal", "Kode Barang", "Nama Barang", "Harga", "Jumlah", "Total"
            }
        ));
        csttabel.setGridColor(new java.awt.Color(36, 102, 69));
        csttabel.setInheritsPopupMenu(true);
        csttabel.setShowGrid(false);
        csttabel.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(csttabel);

        t_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_cariMouseClicked(evt);
            }
        });
        t_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_cariKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(80, 80, 80));
        jLabel3.setText("Cari :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(11, 11, 11)
                .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargaActionPerformed

    private void txt_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahActionPerformed
                                          
    }//GEN-LAST:event_txt_jumlahActionPerformed

    private void txt_kdpenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kdpenjualanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kdpenjualanActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed

        // Mendapatkan data dari inputan
    String id = txt_kdpenjualan.getText();
    String tanggal = txt_tanggal.getText();
    String kode_barang = txt_kdbarang.getText();
    String nama_barang = txt_namabarang.getText();
    String harga = txt_harga.getText();
    String jumlah = txt_jumlah.getText();
    String total = txt_total.getText();

    // Validasi inputan
    if (kode_barang.isBlank() || nama_barang.isEmpty() || id.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Isi terlebih dahulu semua kolom", "Validasi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Query untuk memasukkan data penjualan ke database
        String sql = "INSERT INTO Penjualan (id_penjualan, tanggal, kode_barang, nama_barang, harga, jumlah_barang, total) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = conn.prepareStatement(sql);
        // Pengaturan parameter
        st.setString(1, id);
        st.setString(2, tanggal);
        st.setString(3, kode_barang);
        st.setString(4, nama_barang);
        st.setString(5, harga);
        st.setString(6, jumlah);
        st.setString(7, total);

        // Eksekusi query INSERT
        int rowInserted = st.executeUpdate();
        if (rowInserted > 0) {
            JOptionPane.showMessageDialog(this, "Data penjualan berhasil ditambahkan");
            // Reset inputan
            reset();
            // Tampilkan data penjualan terbaru
            Tampilkan_data();
            // Kurangi stok barang setelah transaksi penjualan
            kurangiStokBarang(kode_barang, Integer.parseInt(jumlah));
        }
        st.close();
    } catch (Exception e) {
        Logger.getLogger(DataPenjualanCoba2.class.getName()).log(Level.SEVERE, null, e);
    }
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
        int selectRow = csttabel.getSelectedRow();
        if(selectRow == -1){
            JOptionPane.showMessageDialog(this, "Pilih terlebih dahulu baris yang akan dihapus");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin menghapus data ini", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            String kode_barang = csttabel.getValueAt(selectRow, 0).toString();

            try {
                String sql = "DELETE FROM Penjualan WHERE id_penjualan=?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, kode_barang);

                int rowDelete = st.executeUpdate();
                if(rowDelete > 0){

                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus");

                }
                st.close();
            } catch (Exception e) {
                Logger.getLogger(DataPenjualanCoba2.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        reset();
        Tampilkan_data();
        //onButton();
        //offButton();
 
    }//GEN-LAST:event_tbn_hapusActionPerformed

    private void t_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_cariKeyTyped
       DefaultTableModel model =(DefaultTableModel) csttabel.getModel();
        model.setRowCount(0);

        String cari = t_cari.getText();
        try{
            String sql = "Select * from Penjualan WHERE id_penjualan LIKE ? OR nama_barang LIKE ? OR kode_barang LIKE ? OR tanggal LIKE ?";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, "%" + cari + "%");
            st.setString(2, "%" + cari + "%");
            st.setString(3, "%" + cari + "%");
            st.setString(4, "%" + cari + "%");
            //st.setString(5, "%" + cari + "%");

            ResultSet rs = st.executeQuery();

            while(rs.next()){
               String id = rs.getString("id_penjualan");
               String tanggal = rs.getString("tanggal");
               String kode_barang = rs.getString("kode_barang");
               String nama_barang = rs.getString("nama_barang");              
               String harga = rs.getString("harga");
               
               String jumlah = rs.getString("jumlah_barang");
               String total = rs.getString("total");

                Object[] rowData = {id,tanggal ,kode_barang ,nama_barang,harga ,jumlah,total};
                model.addRow(rowData);
            }

            rs.close();
            st.close();

        }catch (Exception e){
            Logger.getLogger(DataPenjualanCoba2.class.getName()).log(Level.SEVERE,null,e);
        }
                      
    }//GEN-LAST:event_t_cariKeyTyped
private String IDTransaksi() {
    String urutan = null;

    String sql = "SELECT id FROM detail_penjualan ORDER BY id DESC LIMIT 1";
    try (PreparedStatement st = conn.prepareStatement(sql)) {
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            String lastId = rs.getString("id");
            String numericPart = lastId.replaceAll("[^0-9]", "");
            String alphabeticPart = lastId.replaceAll("[^A-Za-z]", "");
            int idNumeric = Integer.parseInt(numericPart) + 1;
            String formattedNumeric = String.format("%03d", idNumeric);
            urutan = alphabeticPart + formattedNumeric;
        } else {
            urutan = "PJ001";
        }
    } catch (Exception e) {
        Logger.getLogger(DataPenjualanCoba2.class.getName()).log(Level.SEVERE, null, e);
    }
    return urutan;
}

    private void t_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_cariMouseClicked
        t_cari.setText("");
    }//GEN-LAST:event_t_cariMouseClicked

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
        // ...

    }//GEN-LAST:event_btn_jenisActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_jumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahKeyReleased
       if(txt_jumlah.getText().trim().equals("")) {
    System.out.println("Teks kosong, mengatur harga menjadi 0");
    txt_harga.setText("0");
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_jenis;
    private Variasi.fbutton btn_tambah;
    private javax.swing.JTable csttabel;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Variasi.panel panel1;
    private Variasi.panel panel4;
    private Variasi.panel panel5;
    private Variasi.TextField t_cari;
    private Variasi.fbutton tbn_hapus;
    private TextCostum.TextField txt_harga;
    private TextCostum.TextField txt_jumlah;
    private TextCostum.TextField txt_kdbarang;
    private TextCostum.TextField txt_kdpenjualan;
    private TextCostum.TextField txt_namabarang;
    private TextCostum.TextField txt_tanggal;
    private TextCostum.TextField txt_total;
    // End of variables declaration//GEN-END:variables

}
