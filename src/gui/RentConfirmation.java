package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import service.Controller;
import models.Kendaraan;
import models.Transaksi;
import service.HistoryController;


public class RentConfirmation {

    private JLabel formTitle;
    private JPanel rentConfirmPanel;
    private JTextField tfJenisKendaraan;
    private JTextField tfModelKendaraan;
    private JTextField tfJumlahPenumpang;
    private JTextField tfHargaSewa;
    private JLabel labelJenisKendaraan;
    private JLabel labelModelKendaraan;
    private JLabel labelJumlahPenumpang;
    private JLabel labelHargaSewa;
    private JTextField tfLamaSewa;
    private JLabel labelLamaSewa;
    private JButton rentButton;
    private JLabel labelTotalSewa;

    Controller controllerKendaraan = new Controller();
    HistoryController historyController = new HistoryController();

    Vector<Kendaraan> listKendaraan = controllerKendaraan.getKendaraan();
    int rowSelected;


    public JPanel getRentConfirmPanel() {
        return rentConfirmPanel;
    }
    public void reset() {
        tfJenisKendaraan.setText("");
        tfModelKendaraan.setText("");
        tfJumlahPenumpang.setText("");
        tfHargaSewa.setText("");
        tfLamaSewa.setText("");
        labelTotalSewa.setText("");
    }
    public RentConfirmation(int row) {
        this.rowSelected = row;
        String jenisKendaraan, modelKendaraan;
        int jumlahPenumpang;
        double hargaSewa;

        jenisKendaraan = listKendaraan.get(this.rowSelected).getJenisKendaraan();
        modelKendaraan = listKendaraan.get(this.rowSelected).getModelKendaraan();
        jumlahPenumpang = listKendaraan.get(this.rowSelected).getJumlahPenumpang();
        hargaSewa = listKendaraan.get(this.rowSelected).getHargaSewa();

        tfJenisKendaraan.setText(jenisKendaraan);
        tfModelKendaraan.setText(modelKendaraan);
        tfJumlahPenumpang.setText(String.valueOf(jumlahPenumpang));
        tfHargaSewa.setText(String.valueOf(hargaSewa));

        rentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double lamaSewa, totalSewa;
                lamaSewa = Double.parseDouble(tfLamaSewa.getText());

                totalSewa = hargaSewa * lamaSewa;

                labelTotalSewa.setText(String.valueOf(totalSewa));

                JOptionPane.showMessageDialog(null, "Sewa Berhasil!");

                Transaksi transaksi = new Transaksi(modelKendaraan, lamaSewa, totalSewa);
                historyController.addTransaksi(transaksi);

                reset();
            }
        });
    }
}
