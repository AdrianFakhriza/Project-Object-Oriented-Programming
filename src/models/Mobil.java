package models;

public class Mobil extends Kendaraan{

    public Mobil(String jenisKendaraan,
                 String modelKendaran,
                 String warna,
                 int jumlahPenumpang,
                 int tahunProduksi,
                 double hargaSewa) {
        super(jenisKendaraan, modelKendaran, warna, tahunProduksi, hargaSewa);
        this.jumlahPenumpang = jumlahPenumpang;
    }

    @Override
    public double getHargaTotal() {
        return super.getHargaTotal();
    }
}
