import java.io.*;
import java.util.*;

public class DosyaIslemleri {

	private static final String KITAPLAR = "kitaplar.txt";
	private static final String UYELER = "uyeler.txt";
	private static final String UYE_KITAP = "kitap_uye.txt";

	public static void veriYukle(Kutuphane kutuphane) throws Exception {
		try (BufferedReader kitapReader = new BufferedReader(new FileReader(KITAPLAR));
				BufferedReader uyeReader = new BufferedReader(new FileReader(UYELER));
				BufferedReader uyeKitapReader = new BufferedReader(new FileReader(UYE_KITAP))) {

			String line;
			while ((line = kitapReader.readLine()) != null) {
				String[] kitapData = line.split(",");
				Kitap kitap = new Kitap(kitapData[0], kitapData[1], kitapData[2], kitapData[3], kitapData[4],
						Boolean.parseBoolean(kitapData[5]));
				kutuphane.kitapEkle(kitap);
			}

			while ((line = uyeReader.readLine()) != null) {
				String[] uyeData = line.split(",");
				Uye uye = new Uye(uyeData[0], uyeData[1], uyeData[2], uyeData[3]);
				kutuphane.uyeEkle(uye);
			}

			while ((line = uyeKitapReader.readLine()) != null) {
				String[] uyeKitapData = line.split(",");
				UyeKitap uyeKitap = new UyeKitap(uyeKitapData[1], uyeKitapData[0]);
				kutuphane.kitapOduncVer(uyeKitap);
			}
		} catch (Exception e) {
			System.out.println("Beklenmeyen bir hata oluştu !");
		}
	}

	public static void veriKaydet(Kutuphane kutuphane) throws IOException {
		try (BufferedWriter kitapWriter = new BufferedWriter(new FileWriter(KITAPLAR));
				BufferedWriter uyeWriter = new BufferedWriter(new FileWriter(UYELER));
				BufferedWriter uyeKitapWriter = new BufferedWriter(new FileWriter(UYE_KITAP))) {

			for (Kitap kitap : kutuphane.getKitaplar().values()) {
				kitapWriter.write(kitap.getId() + "," + kitap.getBaslik() + "," + kitap.getYazar() + ","
						+ kitap.getYayinYili() + "," + kitap.getKategori() + "," + kitap.isOdunc() + "\n");
			}

			for (Uye uye : kutuphane.getUyeler().values()) {
				uyeWriter.write(
						uye.getId() + "," + uye.getIsim() + "," + uye.getEmail() + "," + uye.getTelefon() + "\n");
			}
			for (UyeKitap uyeKitap : kutuphane.getOduncKitaplar().values()) {
				uyeKitapWriter.write(uyeKitap.getKitapId() + "," + uyeKitap.getUyeId() + "\n");
			}
		} catch (Exception e) {
			System.out.println("Beklenmeyen bir hata oluştu !");
		}
	}

}
