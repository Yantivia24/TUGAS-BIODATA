import java.util.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel.*;
import javax.swing.*; 
import javax.swing.table.*;

public class Biodata extends JFrame{
    private boolean checkBoxSelected; 

    public Biodata(){
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        JLabel labelInput = new JLabel("Input Nama :");
        labelInput.setBounds(15, 20, 100,10);

        JTextField textField = new JTextField();
        textField.setBounds(15,40,350,30);

        JLabel labelInputno = new JLabel("Input Nomor HP:");
        labelInputno.setBounds(15, 80, 100,10);

        JTextField textFieldno = new JTextField();
        textFieldno.setBounds(15,100,350,30);

        JLabel labelAlamat = new JLabel("Alamat :");
        labelAlamat.setBounds(15, 135, 100,10);

        JTextArea txtAlamat = new JTextArea();
        txtAlamat.setBounds(15,150,350,30);

        JLabel labelRadio = new JLabel("Jenis Kelamin");
        labelRadio.setBounds(15, 200, 350, 10);

        JRadioButton radioButton1 = new JRadioButton("Perempuan", true);
        radioButton1.setBounds(15,215,350,30);

        JRadioButton radioButton2 = new JRadioButton("Laki-Laki");
        radioButton2.setBounds(15,250,350,30);

        JCheckBox checkBox = new JCheckBox("Warga Negara Asing ");
        checkBox.setBounds(15,  280,350, 30);

        JCheckBox checkBox1 = new JCheckBox("Bukan ");
        checkBox1.setBounds(15, 290, 350, 30);

       
        checkBox.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange()==1;
            }
        });


        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
       

        JButton button = new JButton("Simpan");
        button.setBounds(15,315,100,40);

        JButton buttonEdit = new JButton("Edit");
        buttonEdit.setBounds(115,315,100,40);

        JButton buttonHapus = new JButton("Hapus");
        buttonHapus.setBounds(215,315,100,40);

        JButton buttonExit = new JButton("Exit ");
        buttonExit.setBounds(300,315,100,40);

        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15 ,400 ,500,500);

        BiodataTable tableModel = new BiodataTable();
        table.setModel(tableModel);

    
        button.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                String jenisKelamin ="";
              
                if(textField.getText().trim().equals("")||
                  textFieldno.getText().trim().equals("")||
                  checkBox1.getText().trim().equals("") ||
                  txtAlamat.getText().trim().equals("") ||
                  labelRadio.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(Biodata.this, "Lengkapi data anda dengan benar");
                  }else {
                    JOptionPane.showMessageDialog(Biodata.this, "Data berhasil di simpan");
                  }

                if(radioButton1.isSelected()){
                    jenisKelamin = radioButton1.getText();
                }
                if(radioButton2.isSelected()){
                    jenisKelamin = radioButton2.getText();
                }
                if (checkBoxSelected){
                    checkBox1.setText("Ya");
                }

                    String nama = textField.getText();
                    String noHP = textFieldno.getText();
                    String WNA = checkBox1.getText();
                    String alamat = txtAlamat.getText();

                tableModel.add(new ArrayList<>(Arrays.asList(nama, noHP, alamat, jenisKelamin, WNA )));
               
            }
        });

        
        buttonHapus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                if (table.getSelectedRow()==0){
                    if (table.getRowCount()==1){
                        JOptionPane.showMessageDialog(Biodata.this, "tidak ada data dalam table");
                    }else {
                        JOptionPane.showMessageDialog(Biodata.this, "Pilih data yang akan di hapus");

                    }
                }else {
                    tableModel.removeRow(table.getSelectedRow());
                }
                String nama = textField.getText();
                String noHP = textFieldno.getText();
                String WNA = checkBox1.getText();
                String alamat = txtAlamat.getText();

            tableModel.add(new ArrayList<>(Arrays.asList(nama, noHP, alamat,  WNA )));
           
                
              }
        });

       
        buttonEdit.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent e) {
                
                if (table.getSelectedRow()==1){
                    if (table.getRowCount()==0){
                        JOptionPane.showMessageDialog(Biodata.this, "tidak ada data dalam table");
                    }else {
                        JOptionPane.showMessageDialog(Biodata.this, "Pilih data yang akan di hapus");

                    }
                } else 
                {
                   

                    tableModel.setValueAt(textField.getText(), table.getSelectedRow(), 0);
                    tableModel.setValueAt(textFieldno.getText(), table.getSelectedRow(), 1);
                    tableModel.setValueAt(checkBox1.getText(), table.getSelectedRow(), 2);
                    tableModel.setValueAt(txtAlamat.getText(), table.getSelectedRow(), 3);
                    tableModel.setValueAt(labelRadio.getText(), table.getSelectedRow(), 4);
                    
                    JOptionPane.showConfirmDialog(Biodata.this, "Data telah di edit");         
             }
            
            
        }
     });

          buttonExit.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               int confirmation = JOptionPane.showConfirmDialog(Biodata.this,
                "Apakah anda yakin ingin keluar dari Apliasi?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
               
                if(confirmation == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                } else
                {
                    JOptionPane.showConfirmDialog(Biodata.this, "anda menekan tombol No");
                }

            }
        });

        
        this.add(labelInput);
        this.add(textField);
        this.add(labelInputno);
        this.add(textFieldno);
        this.add(labelAlamat);
        this.add(txtAlamat);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
        this.add(button);
        this.add(buttonEdit);
        this.add(buttonHapus);
        this.add(buttonExit);
        this.add(scrollableTable);
        
        this.setSize(400,500);
        this.setLayout(null);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Biodata h = new Biodata();
                h.setVisible(true);
            }
        });
    }
}


