/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;
import Koneksi.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import table.TableCustom;
import javax.swing.table.DefaultTableModel;

public class Restock extends javax.swing.JPanel {
    private DefaultTableModel csttable;
    private Connection conn;
    
    public Restock() {
        initComponents();
        conn = koneksi.getConnection();
        Tampilkan_data();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
    }
     
     
        public void Tampilkan_data(){
        DefaultTableModel model =(DefaultTableModel) csttabel.getModel();
        model.setRowCount(0);
       
        try {
            String sql = "Select*from pembelian";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            
            while(hasil.next()){
               String tanggal = hasil.getString("tanggal");
               String id = hasil.getString("id");
               String id_supplier = hasil.getString("id_supplier");
               String nama_barang = hasil.getString("nama_barang");
               String jumlah = hasil.getString("jumlah");
               String harga_beli = hasil.getString("harga_beli");
               String total = hasil.getString("total");
               
               Object[] rowData = {id, id_supplier, tanggal, nama_barang, jumlah,harga_beli, total  };
           model.addRow(rowData);
            }
        }catch (Exception e){
            Logger.getLogger(DataPembelian.class.getName()).log(Level.SEVERE,null,e);
        }
        }
        public void reset(){
        txt_kdPembelian.setText("");
        txt_kdsupp.setText("");
        txt_namabarang.setText("");
        txt_jumlahbeli.setText("");
        txt_harga.setText("");
        txt_total.setText("");
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DataPembelian = new javax.swing.JPanel();
        panel1 = new Variasi.panel();
        txt_kdPembelian = new TextCostum.TextField();
        txt_kdsupp = new TextCostum.TextField();
        txt_jumlahbeli = new TextCostum.TextField();
        txt_harga = new TextCostum.TextField();
        txt_total = new TextCostum.TextField();
        txt_namabarang = new TextCostum.TextField();
        tbn_masukkan = new Variasi.fbutton();
        txt_tanggal = new TextCostum.TextField();
        jButton1 = new javax.swing.JButton();
        tbn_hapus = new Variasi.fbutton();
        tbn_edit = new Variasi.fbutton();
        btn_reset = new javax.swing.JButton();
        panel2 = new Variasi.panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        csttabel = new javax.swing.JTable();
        panel4 = new Variasi.panel();
        jLabel1 = new javax.swing.JLabel();
        panel6 = new Variasi.panel();
        txt_cari = new Variasi.TextField();

        DataPembelian.setBackground(new java.awt.Color(228, 228, 228));

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        txt_kdPembelian.setLabelText("Kode Pembelian");
        txt_kdPembelian.setLineColor(new java.awt.Color(0, 102, 51));
        txt_kdPembelian.setSelectionColor(new java.awt.Color(0, 153, 51));
        txt_kdPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kdPembelianActionPerformed(evt);
            }
        });

        txt_kdsupp.setLabelText("Kode Suppliers");
        txt_kdsupp.setLineColor(new java.awt.Color(0, 102, 51));
        txt_kdsupp.setSelectionColor(new java.awt.Color(0, 153, 51));
        txt_kdsupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kdsuppActionPerformed(evt);
            }
        });

        txt_jumlahbeli.setLabelText("Jumlah Beli");
        txt_jumlahbeli.setLineColor(new java.awt.Color(0, 102, 51));
        txt_jumlahbeli.setSelectionColor(new java.awt.Color(0, 153, 51));
        txt_jumlahbeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahbeliActionPerformed(evt);
            }
        });

        txt_harga.setLabelText("Harga Beli");
        txt_harga.setLineColor(new java.awt.Color(0, 102, 51));
        txt_harga.setSelectionColor(new java.awt.Color(0, 153, 51));
        txt_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargaActionPerformed(evt);
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

        txt_namabarang.setLabelText("Nama Barang");
        txt_namabarang.setLineColor(new java.awt.Color(0, 102, 51));
        txt_namabarang.setSelectionColor(new java.awt.Color(0, 153, 51));

        tbn_masukkan.setText("Masukkan");
        tbn_masukkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbn_masukkanActionPerformed(evt);
            }
        });

        txt_tanggal.setLabelText("Tanggal Pengiriman");

        jButton1.setText("jButton1");

        tbn_hapus.setText("Delete");
        tbn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbn_hapusActionPerformed(evt);
            }
        });

        tbn_edit.setText("Edit");
        tbn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbn_editActionPerformed(evt);
            }
        });

        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tbn_masukkan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tbn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_kdPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(txt_kdsupp, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_jumlahbeli, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kdPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kdsupp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_jumlahbeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbn_masukkan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        panel2.setBackground(new java.awt.Color(255, 255, 255));

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
                "Kode Pembelian", "Kode Supplier", "Tanggal Pembelian", "Nama Barang", "Jumlah Beli", "Harga Beli", "Total"
            }
        ));
        csttabel.setGridColor(new java.awt.Color(36, 102, 69));
        csttabel.setInheritsPopupMenu(true);
        csttabel.setShowGrid(false);
        csttabel.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(csttabel);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1112, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );

        panel4.setBackground(new java.awt.Color(0, 102, 51));
        panel4.setRoundTopLeft(12);
        panel4.setRoundTopRight(12);

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1112, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Data Restock");

        panel6.setBackground(new java.awt.Color(0, 102, 51));
        panel6.setRoundTopLeft(12);
        panel6.setRoundTopRight(12);

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1112, Short.MAX_VALUE)
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DataPembelianLayout = new javax.swing.GroupLayout(DataPembelian);
        DataPembelian.setLayout(DataPembelianLayout);
        DataPembelianLayout.setHorizontalGroup(
            DataPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPembelianLayout.createSequentialGroup()
                .addGroup(DataPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DataPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DataPembelianLayout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jLabel1))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataPembelianLayout.createSequentialGroup()
                            .addGap(86, 86, 86)
                            .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        DataPembelianLayout.setVerticalGroup(
            DataPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataPembelianLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(panel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1252, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DataPembelian, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DataPembelian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_kdPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kdPembelianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kdPembelianActionPerformed

    private void txt_kdsuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kdsuppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kdsuppActionPerformed

    private void txt_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargaActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void tbn_masukkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbn_masukkanActionPerformed
        String id   = txt_kdPembelian.getText();
        String id_supplier   = txt_kdsupp.getText();
        String tanggal = txt_tanggal.getText();
        String nama_barang = txt_namabarang.getText();
        String  jumlah = txt_jumlahbeli.getText();
        String harga_beli = txt_harga.getText();
        String total = txt_total.getText();

        //   String stok = txt_stok.getText();

        if(id.isBlank() || nama_barang.isBlank() || harga_beli.isBlank() ||jumlah.isEmpty()){
            JOptionPane.showMessageDialog(this, "Isi terlebih dahulu semua kolom", "validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String sql = "INSERT INTO Pembelian (id,id_supplier,tanggal,nama_barang,jumlah,harga_beli,total)values(?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, id_supplier);
            st.setString(3, tanggal);
            st.setString(4, nama_barang);
            st.setString(5, jumlah);
            st.setString(6, harga_beli);
            st.setString(7,total);

            int rowInserted = st.executeUpdate();
            if(rowInserted>0){
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
             //   reset();
                Tampilkan_data();
            }
            st.close();
        } catch (Exception e) {
            Logger.getLogger(DataPembelian.class.getName()).log(Level.SEVERE,null,e);
        }
    }//GEN-LAST:event_tbn_masukkanActionPerformed

    private void txt_jumlahbeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahbeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlahbeliActionPerformed

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
                String sql = "DELETE FROM Data_BARANG WHERE kode_barang=?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, kode_barang);

                int rowDelete = st.executeUpdate();
                if(rowDelete > 0){

                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus");

                }
                st.close();
            } catch (Exception e) {
                Logger.getLogger(DataPembelian.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        Tampilkan_data();
        //onButton();
        //offButton();
    }//GEN-LAST:event_tbn_hapusActionPerformed

    private void tbn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbn_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbn_editActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
     reset();
    }//GEN-LAST:event_btn_resetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DataPembelian;
    private javax.swing.JButton btn_reset;
    private javax.swing.JTable csttabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Variasi.panel panel1;
    private Variasi.panel panel2;
    private Variasi.panel panel4;
    private Variasi.panel panel6;
    private Variasi.fbutton tbn_edit;
    private Variasi.fbutton tbn_hapus;
    private Variasi.fbutton tbn_masukkan;
    private Variasi.TextField txt_cari;
    private TextCostum.TextField txt_harga;
    private TextCostum.TextField txt_jumlahbeli;
    private TextCostum.TextField txt_kdPembelian;
    private TextCostum.TextField txt_kdsupp;
    private TextCostum.TextField txt_namabarang;
    private TextCostum.TextField txt_tanggal;
    private TextCostum.TextField txt_total;
    // End of variables declaration//GEN-END:variables
}
