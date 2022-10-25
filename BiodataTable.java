import javax.swing.JScrollPane;
import javax.swing.table.*;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

public class BiodataTable extends AbstractTableModel {
    private String[] columnNames =  {"Nama", "No HP", "Alamat","Jenis Kelamin", "Warga Negara "};
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    protected Object table;

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        List<String> rowItem = data.get(row);
        return rowItem.get(col);
    }    
   
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(ArrayList<String> value)
    {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public static JScrollPane getText() {
        return null;
    }

    public Component getSelectedRow() {
        return null;
    }

    public void removeRow(int selectedRow) {
    }
      
}
