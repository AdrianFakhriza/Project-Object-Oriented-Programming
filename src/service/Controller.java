package service;
import java.util.ArrayList;
import java.util.Vector;

import models.*;

public class Controller {

    public static Vector<Kendaraan> kendaraan = new Vector<>();

    public void addKendaraan(Kendaraan k) {
        kendaraan.add(k);
    }
    public void removeKendaraan(int index) {
        kendaraan.remove(index);
    }

    public void updateKendaraan(int index, Kendaraan k) {
        kendaraan.set(index, k);
    }

    public Vector<Kendaraan> getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Vector<Kendaraan> kendaraan) {
        Controller.kendaraan = kendaraan;
    }

    public void clearKendaraan() {
        kendaraan.clear();
    }

    public void getInfoKendaraan() {
        for (Kendaraan k : kendaraan) {
            System.out.println(k.getJenisKendaraan());
            System.out.println(k.getModelKendaraan());
            System.out.println(k.getWarna());
            System.out.println(k.getJumlahPenumpang());
            System.out.println(k.getTahunProduksi());
            System.out.println(k.getHargaSewa());
            System.out.println(k.getHargaTotal());
        }
    }
}

// Reference:
// https://stackoverflow.com/questions/20526917/load-arraylist-data-into-jtable
// https://docs.oracle.com/javase/tutorial/uiswing/events/listselectionlistener.html
// https://www.geeksforgeeks.org/java-swing-jtable/