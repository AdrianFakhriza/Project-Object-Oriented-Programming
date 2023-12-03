package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import models.*;
import service.Controller;
import gui.Catalog;

public class InsertData {

    private JTextField VehicleType;
    private JTextField VehicleModel;
    private JTextField VehicleYear;
    private JLabel Year;
    private JLabel Model;
    private JLabel Type;
    private JLabel Color;
    private JTextField VehicleColor;
    private JTextField VehicleRentPrice;
    private JButton Add;
    private JLabel Data;
    private JLabel RentPrice;
    private JLabel Status;
    private JPanel insertdataPanel;
    private JLabel labelJumlahPenumpang;
    private JTextField passengerCount;

    public JPanel getInsertdataPanel() {
        return insertdataPanel;
    }


    public InsertData() {
        Controller controllerKendaraan = new Controller();
        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jenisKendaraan, modelKendaraan, warna;
                int tahunProduksi, jumlahPenumpang, hargaSewa;

                jenisKendaraan = VehicleType.getText();
                modelKendaraan = VehicleModel.getText();
                warna = VehicleColor.getText();
                tahunProduksi = Integer.parseInt(VehicleYear.getText());
                jumlahPenumpang = Integer.parseInt(passengerCount.getText());
                hargaSewa = Integer.parseInt(VehicleRentPrice.getText());

                if (jenisKendaraan.equals("Mobil")) {
                    Mobil mobil = new Mobil(jenisKendaraan, modelKendaraan, warna, jumlahPenumpang, tahunProduksi, hargaSewa);
                    controllerKendaraan.addKendaraan(mobil);
                    Status.setText("Mobil berhasil ditambahkan!");

                } else if (jenisKendaraan.equals("Motor")) {
                    Motor motor = new Motor(jenisKendaraan, modelKendaraan, warna, jumlahPenumpang, tahunProduksi, hargaSewa);
                    controllerKendaraan.addKendaraan(motor);
                    Status.setText("Motor berhasil ditambahkan!");
                } else {
                    JOptionPane.showMessageDialog(null, "Jenis kendaraan tidak valid!");
                }

                VehicleType.setText("");
                VehicleModel.setText("");
                VehicleColor.setText("");
                VehicleYear.setText("");
                passengerCount.setText("");
                VehicleRentPrice.setText("");
            }
        });
    }
}
