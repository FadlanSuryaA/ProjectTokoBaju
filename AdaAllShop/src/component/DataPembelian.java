
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

public class DataPembelian extends javax.swing.JPanel {
    
 private DefaultTableModel csttable;
  private DefaultTableModel csttable1;
 private Connection conn;
 
public DataPembelian(String name) {
        initComponents();
        conn = koneksi.getConnection();
        
        Tampilkan_data();
        jLabel1.setText(name);
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.MULTI_LINE);
    }

    public void reset(){
        txt_namabarang.setText("");
        txt_kdsupp.setText("");
        txt_namapengirim.setText("");
        txt_jumlahbeli.setText("");
        txt_harga.setText("");
        txt_total.setText("");
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
               String nama_pengirim = hasil.getString("nama_pengirim");
               
               Object[] rowData = {id, id_supplier, tanggal, nama_pengirim,  };
           model.addRow(rowData);
            }
        }catch (Exception e){
            Logger.getLogger(DataPembelian.class.getName()).log(Level.SEVERE,null,e);
        }
        
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DataPembelian = new javax.swing.JPanel();
        panel1 = new Variasi.panel();
        txt_kdPembelian = new TextCostum.TextField();
        txt_kdsupp = new TextCostum.TextField();
        txt_namapengirim = new TextCostum.TextField();
        txt_jumlahbeli = new TextCostum.TextField();
        txt_harga = new TextCostum.TextField();
        txt_total = new TextCostum.TextField();
        btn_tambah = new Variasi.fbutton();
        tbn_hapus = new Variasi.fbutton();
        txt_namabarang = new TextCostum.TextField();
        tbn_hapus1 = new Variasi.fbutton();
        txt_tanggal = new TextCostum.TextField();
        btn_tambah1 = new Variasi.fbutton();
        tbn_hapus2 = new Variasi.fbutton();
        myButton1 = new Variasi.MyButton();
        panel2 = new Variasi.panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        csttabel = new javax.swing.JTable();
        panel3 = new Variasi.panel();
        panel4 = new Variasi.panel();
        jLabel1 = new javax.swing.JLabel();
        panel5 = new Variasi.panel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        csttabel1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());

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

        txt_namapengirim.setLabelText("Nama Pengirim");
        txt_namapengirim.setLineColor(new java.awt.Color(0, 102, 51));
        txt_namapengirim.setSelectionColor(new java.awt.Color(0, 153, 51));

        txt_jumlahbeli.setLabelText("Jumlah Beli");
        txt_jumlahbeli.setLineColor(new java.awt.Color(0, 102, 51));
        txt_jumlahbeli.setSelectionColor(new java.awt.Color(0, 153, 51));

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

        btn_tambah.setText("add");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        tbn_hapus.setText("del");
        tbn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbn_hapusActionPerformed(evt);
            }
        });

        txt_namabarang.setLabelText("Nama Barang");
        txt_namabarang.setLineColor(new java.awt.Color(0, 102, 51));
        txt_namabarang.setSelectionColor(new java.awt.Color(0, 153, 51));

        tbn_hapus1.setText("del");
        tbn_hapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbn_hapus1ActionPerformed(evt);
            }
        });

        txt_tanggal.setLabelText("Tanggal Pengiriman");

        btn_tambah1.setText("add");
        btn_tambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah1ActionPerformed(evt);
            }
        });

        tbn_hapus2.setText("del");
        tbn_hapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbn_hapus2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(tbn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_tambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_namabarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_jumlahbeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_harga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_kdPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(txt_kdsupp, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tbn_hapus2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_namapengirim, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tbn_hapus1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(22, 22, 22))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kdPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kdsupp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_namapengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(txt_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_jumlahbeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbn_hapus1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbn_hapus2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        panel2.setBackground(new java.awt.Color(255, 255, 255));

        csttabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tanggal Pembelian", "Kode Pembelian", "Kode Supliers", "Nama Pengirim"
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jLabel1.setText("Data Pembelian");

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

        csttabel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama Barang", "Jumlah Beli", "Harga Beli", "Total "
            }
        ));
        csttabel1.setGridColor(new java.awt.Color(36, 102, 69));
        csttabel1.setInheritsPopupMenu(true);
        csttabel1.setShowGrid(false);
        csttabel1.setShowHorizontalLines(true);
        jScrollPane2.setViewportView(csttabel1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DataPembelianLayout = new javax.swing.GroupLayout(DataPembelian);
        DataPembelian.setLayout(DataPembelianLayout);
        DataPembelianLayout.setHorizontalGroup(
            DataPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPembelianLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(DataPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(DataPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DataPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(131, 131, 131))
        );
        DataPembelianLayout.setVerticalGroup(
            DataPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataPembelianLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(DataPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DataPembelianLayout.createSequentialGroup()
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DataPembelianLayout.createSequentialGroup()
                        .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(DataPembelian, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void txt_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargaActionPerformed

    private void txt_kdPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kdPembelianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kdPembelianActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_kdsuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kdsuppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kdsuppActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        String id   = txt_kdPembelian.getText();
        String id_supplier   = txt_kdsupp.getText();
        String tanggal = txt_tanggal.getText();
        String nama_pengirim = txt_namapengirim.getText();
        
     //   String stok = txt_stok.getText();

        if(id.isBlank() || nama_pengirim.isEmpty()){
            JOptionPane.showMessageDialog(this, "Isi terlebih dahulu semua kolom", "validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String sql = "INSERT INTO Pembelian (kode_barang,kode_jenis,nama_barang,nama_jenis,harga_beli,harga_jual,stok)values(?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, id_supplier);
            st.setString(3, tanggal);
            st.setString(4, nama_pengirim);
           

            int rowInserted = st.executeUpdate();
            if(rowInserted>0){
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                reset();
                Tampilkan_data();
            }
            st.close();
        } catch (Exception e) {
            Logger.getLogger(DataPembelian.class.getName()).log(Level.SEVERE,null,e);
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
                Logger.getLogger(DataPembelian.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        reset();
        Tampilkan_data();
        //onButton();
        //offButton();

    }//GEN-LAST:event_tbn_hapusActionPerformed
                           
       

    private void tbn_hapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbn_hapus1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbn_hapus1ActionPerformed

    private void btn_tambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah1ActionPerformed
        String id   = txt_kdPembelian.getText();
        String id_supplier   = txt_kdsupp.getText();
        String nama_barang = txt_namapengirim.getText();
        String nama_pengirim = txt_namapengirim.getText();
        
     //   String stok = txt_stok.getText();

        if(id.isBlank() || nama_pengirim.isEmpty()){
            JOptionPane.showMessageDialog(this, "Isi terlebih dahulu semua kolom", "validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String sql = "INSERT INTO Pembelian (kode_barang,kode_jenis,nama_barang,nama_jenis,harga_beli,harga_jual,stok)values(?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, id_supplier);
            st.setString(3, nama_barang);
            st.setString(4, nama_pengirim);
           

            int rowInserted = st.executeUpdate();
            if(rowInserted>0){
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                reset();
                Tampilkan_data();
            }
            st.close();
        } catch (Exception e) {
            Logger.getLogger(DataPembelian.class.getName()).log(Level.SEVERE,null,e);
        }
    }//GEN-LAST:event_btn_tambah1ActionPerformed

    private void tbn_hapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbn_hapus2ActionPerformed
        
    }//GEN-LAST:event_tbn_hapus2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DataPembelian;
    private Variasi.fbutton btn_tambah;
    private Variasi.fbutton btn_tambah1;
    private javax.swing.JTable csttabel;
    private javax.swing.JTable csttabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private Variasi.MyButton myButton1;
    private Variasi.panel panel1;
    private Variasi.panel panel2;
    private Variasi.panel panel3;
    private Variasi.panel panel4;
    private Variasi.panel panel5;
    private Variasi.fbutton tbn_hapus;
    private Variasi.fbutton tbn_hapus1;
    private Variasi.fbutton tbn_hapus2;
    private TextCostum.TextField txt_harga;
    private TextCostum.TextField txt_jumlahbeli;
    private TextCostum.TextField txt_kdPembelian;
    private TextCostum.TextField txt_kdsupp;
    private TextCostum.TextField txt_namabarang;
    private TextCostum.TextField txt_namapengirim;
    private TextCostum.TextField txt_tanggal;
    private TextCostum.TextField txt_total;
    // End of variables declaration//GEN-END:variables
}
