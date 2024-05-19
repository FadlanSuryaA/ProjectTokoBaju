
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

public class Pembelian extends javax.swing.JPanel {

private DefaultTableModel csttable;
private DefaultTableModel csttable1;
private DefaultTableModel csttable3;
private DefaultTableModel csttable4;
 private Connection conn;
 
    public Pembelian() {
        initComponents();
        conn = koneksi.getConnection();
        
        Tampilkan_data();
        Tampildata();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.MULTI_LINE);
        TableCustom.apply(jScrollPane3, TableCustom.TableType.MULTI_LINE);
        TableCustom.apply(jScrollPane4, TableCustom.TableType.MULTI_LINE);
    }

    public void Tampilkan_data(){
        DefaultTableModel model =(DefaultTableModel) csttabel.getModel();
        model.setRowCount(0);
       
        try {
            String sql = "Select*from sementara_pembelian";
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

        mainPanel = new javax.swing.JPanel();
        DataPembelian = new javax.swing.JPanel();
        panel1 = new Variasi.panel();
        txt_kdPembelian = new TextCostum.TextField();
        txt_kdsupp = new TextCostum.TextField();
        txt_namapengirim = new TextCostum.TextField();
        txt_jumlahbeli = new TextCostum.TextField();
        txt_harga = new TextCostum.TextField();
        txt_total = new TextCostum.TextField();
        btn_tambah = new Variasi.fbutton();
        txt_namabarang = new TextCostum.TextField();
        tbn_hapus1 = new Variasi.fbutton();
        textField2 = new TextCostum.TextField();
        btn_tambah1 = new Variasi.fbutton();
        tbn_hapus2 = new Variasi.fbutton();
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
        DetailRestock = new javax.swing.JPanel();
        DataRestock = new javax.swing.JPanel();
        panel8 = new Variasi.panel();
        jLabel2 = new javax.swing.JLabel();
        panel10 = new Variasi.panel();
        jScrollPane3 = new javax.swing.JScrollPane();
        csttabel3 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        csttabel4 = new javax.swing.JTable();
        btn_tambah2 = new Variasi.fbutton();

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

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

        txt_namabarang.setLabelText("Nama Barang");
        txt_namabarang.setLineColor(new java.awt.Color(0, 102, 51));
        txt_namabarang.setSelectionColor(new java.awt.Color(0, 153, 51));

        tbn_hapus1.setText("Masukkan");
        tbn_hapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbn_hapus1ActionPerformed(evt);
            }
        });

        textField2.setLabelText("Tanggal Pengiriman");

        btn_tambah1.setText("add");
        btn_tambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah1ActionPerformed(evt);
            }
        });

        tbn_hapus2.setText("Detail");
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_tambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_namabarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_jumlahbeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_harga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_kdPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_kdsupp, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbn_hapus2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_namapengirim, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                .addComponent(textField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tbn_hapus1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_kdPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_namapengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_kdsupp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_tambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_jumlahbeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbn_hapus2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbn_hapus1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                "Kode Pembelian", "Kode Supplier", "Tanggal Pembelian", "Nama Pengirim"
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
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
                    .addGroup(DataPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DataPembelianLayout.setVerticalGroup(
            DataPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataPembelianLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(DataPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(DataPembelianLayout.createSequentialGroup()
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DataPembelianLayout.createSequentialGroup()
                        .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        mainPanel.add(DataPembelian, "card2");

        DataRestock.setBackground(new java.awt.Color(228, 228, 228));

        panel8.setBackground(new java.awt.Color(0, 102, 51));
        panel8.setRoundTopLeft(12);
        panel8.setRoundTopRight(12);

        javax.swing.GroupLayout panel8Layout = new javax.swing.GroupLayout(panel8);
        panel8.setLayout(panel8Layout);
        panel8Layout.setHorizontalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel8Layout.setVerticalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Data Pembelian");

        panel10.setBackground(new java.awt.Color(0, 102, 51));
        panel10.setRoundTopLeft(12);
        panel10.setRoundTopRight(12);

        javax.swing.GroupLayout panel10Layout = new javax.swing.GroupLayout(panel10);
        panel10.setLayout(panel10Layout);
        panel10Layout.setHorizontalGroup(
            panel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel10Layout.setVerticalGroup(
            panel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        csttabel3.setModel(new javax.swing.table.DefaultTableModel(
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
                "Kode Pembelian", "Kode Supplier", "Tanggal Pembelian", "Nama Pengirim"
            }
        ));
        csttabel3.setGridColor(new java.awt.Color(36, 102, 69));
        csttabel3.setInheritsPopupMenu(true);
        csttabel3.setShowGrid(false);
        csttabel3.setShowHorizontalLines(true);
        csttabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                csttabel3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(csttabel3);

        csttabel4.setModel(new javax.swing.table.DefaultTableModel(
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
        csttabel4.setGridColor(new java.awt.Color(36, 102, 69));
        csttabel4.setInheritsPopupMenu(true);
        csttabel4.setShowGrid(false);
        csttabel4.setShowHorizontalLines(true);
        jScrollPane4.setViewportView(csttabel4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btn_tambah2.setText("Kembali");
        btn_tambah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DataRestockLayout = new javax.swing.GroupLayout(DataRestock);
        DataRestock.setLayout(DataRestockLayout);
        DataRestockLayout.setHorizontalGroup(
            DataRestockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataRestockLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(DataRestockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(btn_tambah2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        DataRestockLayout.setVerticalGroup(
            DataRestockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataRestockLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(btn_tambah2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DetailRestockLayout = new javax.swing.GroupLayout(DetailRestock);
        DetailRestock.setLayout(DetailRestockLayout);
        DetailRestockLayout.setHorizontalGroup(
            DetailRestockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1263, Short.MAX_VALUE)
            .addGroup(DetailRestockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DataRestock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DetailRestockLayout.setVerticalGroup(
            DetailRestockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 705, Short.MAX_VALUE)
            .addGroup(DetailRestockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DataRestock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(DetailRestock, "card3");

        add(mainPanel, "card3");
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

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
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
             //   reset();
              //  Tampilkan_data();
            }
            st.close();
        } catch (Exception e) {
            Logger.getLogger(DataPembelian.class.getName()).log(Level.SEVERE,null,e);
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void tbn_hapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbn_hapus1ActionPerformed
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
            String sql = "INSERT INTO sementara_pembelian (id,id_supplier,tanggal,nama_pengirim)values(?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, id_supplier);
            st.setString(3, nama_barang);
            st.setString(4, nama_pengirim);

            int rowInserted = st.executeUpdate();
            if(rowInserted>0){
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
              //  reset();
               // Tampilkan_data();
            }
            st.close();
        } catch (Exception e) {
            Logger.getLogger(DataPembelian.class.getName()).log(Level.SEVERE,null,e);
        }
    }//GEN-LAST:event_btn_tambah1ActionPerformed

    private void tbn_hapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbn_hapus2ActionPerformed
    mainPanel.removeAll();
    mainPanel.repaint();
    mainPanel.revalidate();
    
    mainPanel.add(DetailRestock);
    mainPanel.repaint();
    mainPanel.revalidate();
    }//GEN-LAST:event_tbn_hapus2ActionPerformed

    private void btn_tambah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah2ActionPerformed
    mainPanel.removeAll();
    mainPanel.repaint();
    mainPanel.revalidate();
    
    mainPanel.add(DataPembelian);
    mainPanel.repaint();
    mainPanel.revalidate();
    }//GEN-LAST:event_btn_tambah2ActionPerformed

    private void csttabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_csttabel3MouseClicked
        int row = csttabel3.getSelectedRow();
        
    }//GEN-LAST:event_csttabel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DataPembelian;
    private javax.swing.JPanel DataRestock;
    private javax.swing.JPanel DetailRestock;
    private Variasi.fbutton btn_tambah;
    private Variasi.fbutton btn_tambah1;
    private Variasi.fbutton btn_tambah2;
    private javax.swing.JTable csttabel;
    private javax.swing.JTable csttabel1;
    private javax.swing.JTable csttabel3;
    private javax.swing.JTable csttabel4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel mainPanel;
    private Variasi.panel panel1;
    private Variasi.panel panel10;
    private Variasi.panel panel2;
    private Variasi.panel panel3;
    private Variasi.panel panel4;
    private Variasi.panel panel5;
    private Variasi.panel panel8;
    private Variasi.fbutton tbn_hapus1;
    private Variasi.fbutton tbn_hapus2;
    private TextCostum.TextField textField2;
    private TextCostum.TextField txt_harga;
    private TextCostum.TextField txt_jumlahbeli;
    private TextCostum.TextField txt_kdPembelian;
    private TextCostum.TextField txt_kdsupp;
    private TextCostum.TextField txt_namabarang;
    private TextCostum.TextField txt_namapengirim;
    private TextCostum.TextField txt_total;
    // End of variables declaration//GEN-END:variables

    private void Tampildata(){
        DefaultTableModel model =(DefaultTableModel) csttabel3.getModel();
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
}
