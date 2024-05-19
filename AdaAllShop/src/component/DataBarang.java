
package component;

import Koneksi.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import table.TableCustom;
import javax.swing.table.DefaultTableModel;

public class DataBarang extends javax.swing.JPanel {
    
 private DefaultTableModel csttable;
 private Connection conn;
 
public DataBarang(String name) {
        initComponents();
        conn = koneksi.getConnection();
        
        Tampilkan_data();
        jLabel1.setText(name);
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
    }

    public void reset(){
        txt_kdbarang.setText("");
        txt_kdjenis.setText("");
        txt_namabarang.setText("");
        txt_namajenis.setText("");
        txt_harga.setText("");
        txt_harga1.setText("");
        txt_stok.setText("");
    }
    public void Tampilkan_data(){
        DefaultTableModel model =(DefaultTableModel) csttabel.getModel();
        model.setRowCount(0);
       
        try {
            String sql = "Select*from data_barang";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            
            while(hasil.next()){
               String kode_barang = hasil.getString("kode_barang");
               String kode_jenis = hasil.getString("kode_jenis");
               String nama_barang = hasil.getString("nama_barang");
               String nama_jenis = hasil.getString("nama_jenis");
               String harga_beli = hasil.getString("harga_beli");
               String harga_jual = hasil.getString("harga_jual");
               String stok = hasil.getString("stok");
               
               Object[] rowData = {kode_barang, kode_jenis, nama_barang, nama_jenis, harga_beli,harga_jual, stok};
           model.addRow(rowData);
            }
        }catch (Exception e){
            Logger.getLogger(DataBarang.class.getName()).log(Level.SEVERE,null,e);
        }
        
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel1 = new Variasi.panel();
        txt_kdbarang = new TextCostum.TextField();
        txt_kdjenis = new TextCostum.TextField();
        txt_namabarang = new TextCostum.TextField();
        txt_namajenis = new TextCostum.TextField();
        txt_harga = new TextCostum.TextField();
        txt_stok = new TextCostum.TextField();
        tbn_hapus = new Variasi.fbutton();
        btn_tambah = new Variasi.fbutton();
        txt_harga1 = new TextCostum.TextField();
        panel2 = new Variasi.panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        csttabel = new javax.swing.JTable();
        t_cari = new Variasi.TextField();
        jLabel2 = new javax.swing.JLabel();
        panel3 = new Variasi.panel();
        panel4 = new Variasi.panel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(228, 228, 228));

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        txt_kdbarang.setLabelText("Kode Barang");
        txt_kdbarang.setLineColor(new java.awt.Color(0, 102, 51));
        txt_kdbarang.setSelectionColor(new java.awt.Color(0, 153, 51));
        txt_kdbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kdbarangActionPerformed(evt);
            }
        });

        txt_kdjenis.setLabelText("Kode Jenis");
        txt_kdjenis.setLineColor(new java.awt.Color(0, 102, 51));
        txt_kdjenis.setSelectionColor(new java.awt.Color(0, 153, 51));

        txt_namabarang.setLabelText("Nama Barang");
        txt_namabarang.setLineColor(new java.awt.Color(0, 102, 51));
        txt_namabarang.setSelectionColor(new java.awt.Color(0, 153, 51));

        txt_namajenis.setLabelText("Nama Jenis");
        txt_namajenis.setLineColor(new java.awt.Color(0, 102, 51));
        txt_namajenis.setSelectionColor(new java.awt.Color(0, 153, 51));

        txt_harga.setLabelText("Harga Beli");
        txt_harga.setLineColor(new java.awt.Color(0, 102, 51));
        txt_harga.setSelectionColor(new java.awt.Color(0, 153, 51));
        txt_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargaActionPerformed(evt);
            }
        });

        txt_stok.setLabelText("Stok");
        txt_stok.setLineColor(new java.awt.Color(0, 102, 51));
        txt_stok.setSelectionColor(new java.awt.Color(0, 153, 51));
        txt_stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stokActionPerformed(evt);
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

        txt_harga1.setLabelText("Harga Jual");
        txt_harga1.setLineColor(new java.awt.Color(0, 102, 51));
        txt_harga1.setSelectionColor(new java.awt.Color(0, 153, 51));
        txt_harga1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_harga1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(tbn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_kdjenis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_namabarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_namajenis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_harga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_stok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_harga1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(txt_kdbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_kdbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_kdjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_namajenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_harga1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_stok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                "Kode Barang", "Kode Jenis", "Nama Barang", "Nama Jenis", "Harga Beli", "Harga Jual", "Stok"
            }
        ));
        csttabel.setGridColor(new java.awt.Color(36, 102, 69));
        csttabel.setInheritsPopupMenu(true);
        csttabel.setShowGrid(false);
        csttabel.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(csttabel);

        t_cari.setText("cari");
        t_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_cariMouseClicked(evt);
            }
        });
        t_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cariActionPerformed(evt);
            }
        });
        t_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_cariKeyTyped(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/Google Web Search.png"))); // NOI18N

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panel3.setBackground(new java.awt.Color(0, 102, 51));
        panel3.setRoundTopLeft(12);
        panel3.setRoundTopRight(12);

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        panel4.setBackground(new java.awt.Color(0, 102, 51));
        panel4.setRoundTopLeft(12);
        panel4.setRoundTopRight(12);

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Data Barang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 51, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargaActionPerformed

    private void txt_stokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stokActionPerformed

    private void txt_kdbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kdbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kdbarangActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        String kode_barang   = txt_kdbarang.getText();
        String kode_jenis   = txt_kdjenis.getText();
        String nama_barang = txt_namabarang.getText();
        String nama_jenis = txt_namajenis.getText();
        String harga_beli = txt_harga.getText();
        String harga_jual = txt_harga1.getText();
        String stok = txt_stok.getText();
        

        if(kode_barang.isBlank() || nama_barang.isEmpty() || harga_beli.isEmpty()){
            JOptionPane.showMessageDialog(this, "Isi terlebih dahulu semua kolom", "validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String sql = "INSERT INTO Data_Barang (kode_barang,kode_jenis,nama_barang,nama_jenis,harga_beli,harga_jual,stok)values(?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, kode_barang);
            st.setString(2, kode_jenis);
            st.setString(3, nama_barang);
            st.setString(4, nama_jenis);
            st.setString(5, harga_beli);
            st.setString(6, harga_jual);
            st.setString(7, stok);
            

            int rowInserted = st.executeUpdate();
            if(rowInserted>0){
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                reset();
                Tampilkan_data();
            }
            st.close();
        } catch (Exception e) {
            Logger.getLogger(DataBarang.class.getName()).log(Level.SEVERE,null,e);
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
                String sql = "DELETE FROM Data_BARANG WHERE kode_barang=?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, kode_barang);

                int rowDelete = st.executeUpdate();
                if(rowDelete > 0){

                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus");

                }
                st.close();
            } catch (Exception e) {
                Logger.getLogger(DataBarang.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        reset();
        Tampilkan_data();
        //onButton();
        //offButton();
 
    }//GEN-LAST:event_tbn_hapusActionPerformed

    private void txt_harga1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_harga1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_harga1ActionPerformed

    private void t_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_cariKeyTyped
       DefaultTableModel model =(DefaultTableModel) csttabel.getModel();
        model.setRowCount(0);

        String cari = t_cari.getText();
        try{
            String sql = "Select * from data_barang WHERE nama_barang LIKE ? OR nama_jenis LIKE ? OR kode_barang LIKE ? OR kode_jenis LIKE ?";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, "%" + cari + "%");
            st.setString(2, "%" + cari + "%");
            st.setString(3, "%" + cari + "%");
            st.setString(4, "%" + cari + "%");
            //st.setString(5, "%" + cari + "%");

            ResultSet rs = st.executeQuery();

            while(rs.next()){
                String kode_barang   = rs.getString("kode_barang");
                String kode_jenis    = rs.getString("kode_jenis");
                String nama_barang   = rs.getString("nama_barang");
                String nama_jenis    = rs.getString("nama_jenis");
                String harga_beli    = rs.getString("harga_beli");
                String harga_jual    = rs.getString("harga_jual");
                String stok          = rs.getString("stok");

                Object[] rowData = {kode_barang,kode_jenis ,nama_barang ,nama_jenis,harga_beli ,harga_jual,stok};
                model.addRow(rowData);
            }

            rs.close();
            st.close();

        }catch (Exception e){
            Logger.getLogger(DataBarang.class.getName()).log(Level.SEVERE,null,e);
        }
                      
    }//GEN-LAST:event_t_cariKeyTyped

    private void t_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_cariMouseClicked
        t_cari.setText("");
    }//GEN-LAST:event_t_cariMouseClicked

    private void t_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_cariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Variasi.fbutton btn_tambah;
    private javax.swing.JTable csttabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Variasi.panel panel1;
    private Variasi.panel panel2;
    private Variasi.panel panel3;
    private Variasi.panel panel4;
    private Variasi.TextField t_cari;
    private Variasi.fbutton tbn_hapus;
    private TextCostum.TextField txt_harga;
    private TextCostum.TextField txt_harga1;
    private TextCostum.TextField txt_kdbarang;
    private TextCostum.TextField txt_kdjenis;
    private TextCostum.TextField txt_namabarang;
    private TextCostum.TextField txt_namajenis;
    private TextCostum.TextField txt_stok;
    // End of variables declaration//GEN-END:variables
}
