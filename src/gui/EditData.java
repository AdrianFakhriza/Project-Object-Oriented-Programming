package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import models.*;
import service.Controller;
public class EditData {
    private JTextField tfJenisKendaraan;
    private JLabel labelEditData;
    private JTextField tfModelKendaraan;
    private JTextField tfWarna;
    private JTextField tfJumlahPenumpang;
    private JTextField tfTahunProduksi;
    private JTextField tfHargaSewa;
    private JButton saveButton;
    private JButton cancelButton;
    private JLabel labelJenis;
    private JLabel labelModel;
    private JLabel labelWarna;
    private JLabel labelJumlahPenumpang;
    private JLabel labelTahunProduksi;
    private JLabel labelHargaSewa;
    private JPanel panelEditData;

    Controller controllerKendaraan = new Controller();
    public JPanel getEditDataPanel() {
        return panelEditData;
    }
    public EditData(int rowSelected) {
        Vector<Kendaraan> listKendaraan = controllerKendaraan.getKendaraan();

        String jenisKendaraan, modelKendaraan, warna;
        int jumlahPenumpang, tahunProduksi;
        double hargaSewa;

        jenisKendaraan = listKendaraan.get(rowSelected).getJenisKendaraan();
        modelKendaraan = listKendaraan.get(rowSelected).getModelKendaraan();
        warna = listKendaraan.get(rowSelected).getWarna();
        jumlahPenumpang = listKendaraan.get(rowSelected).getJumlahPenumpang();
        tahunProduksi = listKendaraan.get(rowSelected).getTahunProduksi();
        hargaSewa = listKendaraan.get(rowSelected).getHargaSewa();

        tfJenisKendaraan.setText(jenisKendaraan);
        tfModelKendaraan.setText(modelKendaraan);
        tfWarna.setText(warna);
        tfJumlahPenumpang.setText(String.valueOf(jumlahPenumpang));
        tfTahunProduksi.setText(String.valueOf(tahunProduksi));
        tfHargaSewa.setText(String.valueOf(hargaSewa));

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jenisKendaraan, modelKendaraan, warna;
                int jumlahPenumpang, tahunProduksi;
                double hargaSewa;

                jenisKendaraan = tfJenisKendaraan.getText();
                modelKendaraan = tfModelKendaraan.getText();
                warna = tfWarna.getText();
                jumlahPenumpang = Integer.parseInt(tfJumlahPenumpang.getText());
                tahunProduksi = Integer.parseInt(tfTahunProduksi.getText());
                hargaSewa = Double.parseDouble(tfHargaSewa.getText());

                if (jenisKendaraan.equals("Mobil")){
                    Mobil newMobil = new Mobil(jenisKendaraan, modelKendaraan, warna, jumlahPenumpang, tahunProduksi, hargaSewa);
                    controllerKendaraan.updateKendaraan(rowSelected, newMobil);
                } else if (jenisKendaraan.equals("Motor")){
                    Motor newMotor = new Motor(jenisKendaraan, modelKendaraan, warna, jumlahPenumpang, tahunProduksi, hargaSewa);
                    controllerKendaraan.updateKendaraan(rowSelected, newMotor);
                } else {
                    JOptionPane.showMessageDialog(null, "Jenis kendaraan tidak valid!");
                }

                JOptionPane.showMessageDialog(null, "Data berhasil diubah!");

                // close window
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelEditData);
                frame.dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelEditData);
                frame.dispose();
            }
        });
    }
}
