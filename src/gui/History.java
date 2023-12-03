package gui;
import models.*;
import service.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.util.Vector;

public class History {
    private JLabel History;
    private JTable historyTable;
    private JPanel historyPanel;

    HistoryController historyController = new HistoryController();
    public JPanel getHistoryPanel() {
        return historyPanel;
    }

    public History() {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Model Kendaraan");
        columnNames.add("Lama Sewa");
        columnNames.add("Harga Total");

        Vector<Vector<Object>> data = new Vector<>();
        for (Transaksi t : historyController.getListTransaksi()) {
            Vector<Object> row = new Vector<>();
            row.add(t.getModelKendaraan());
            row.add(t.getLamaSewa());
            row.add(t.getHargaTotal());
            data.add(row);
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        historyTable.setModel(model);
        historyTable.setDefaultEditor(Object.class, null);
    }
}
