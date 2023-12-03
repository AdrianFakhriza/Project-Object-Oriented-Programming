package models;

public class Motor extends Kendaraan{
    public Motor(String jenisKendaraan,
                 String modelKendaran,
                 String warna,
                 int jumlahPenumpang,
                 int tahunProduksi,
                 double hargaSewa) {
        super(jenisKendaraan, modelKendaran, warna, tahunProduksi, hargaSewa);
        this.jumlahPenumpang = 2;
    }

    @Override
    public double getHargaTotal() {
            return super.getHargaTotal();
        }
}

