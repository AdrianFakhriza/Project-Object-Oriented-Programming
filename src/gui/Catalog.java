package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import service.Controller;
import models.Kendaraan;
import service.WindowLayout;

public class Catalog {

    private JTable catalogTable;
    private JPanel CatalogPanel;
    private JLabel CatalogLabel;
    private JButton sewaButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton refreshButton;
    Controller controllerKendaraan = new Controller();

    WindowLayout layout = new WindowLayout();

    public void initData(){
        // initialize table
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Jenis Kendaraan");
        columnNames.add("Model Kendaraan");
        columnNames.add("Warna");
        columnNames.add("Jumlah Penumpang");
        columnNames.add("Tahun Produksi");
        columnNames.add("Harga Sewa");

        Vector<Vector<Object>> data = new Vector<>();
        for (Kendaraan k : controllerKendaraan.getKendaraan()) {
            Vector<Object> row = new Vector<>();
            row.add(k.getJenisKendaraan());
            row.add(k.getModelKendaraan());
            row.add(k.getWarna());
            row.add(k.getJumlahPenumpang());
            row.add(k.getTahunProduksi());
            row.add(k.getHargaSewa());
            data.add(row);
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        catalogTable.setModel(model);
        catalogTable.setDefaultEditor(Object.class, null);
    }

    public JPanel getCatalogPanel() {
        return CatalogPanel;
    }

    public Catalog() {
        initData();
        sewaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowSelected = catalogTable.getSelectedRow();
                JFrame frame = new JFrame("Rent Confirmation");
                frame.setLocation(layout.getWidth(), layout.getHeight());
                frame.setContentPane(new RentConfirmation(rowSelected).getRentConfirmPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowSelected = catalogTable.getSelectedRow();
                JFrame frame = new JFrame("Edit Data");
                frame.setLocation(layout.getWidth(), layout.getHeight());
                frame.setContentPane(new EditData(rowSelected).getEditDataPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowSelected = catalogTable.getSelectedRow();
                controllerKendaraan.removeKendaraan(rowSelected);
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initData();
            }
        });
    }
}
