package models;

public  class Transaksi {
    private String modelKendaraan;
    private double lamaSewa, hargaTotal;

    public Transaksi(String modelKendaraan, double lamaSewa, double hargaTotal) {
        this.modelKendaraan = modelKendaraan;
        this.lamaSewa = lamaSewa;
        this.hargaTotal = hargaTotal;
    }

    public String getModelKendaraan() {
        return modelKendaraan;
    }
    public double getLamaSewa() {
        return lamaSewa;
    }
    public double getHargaTotal() {
        return hargaTotal;
    }
}