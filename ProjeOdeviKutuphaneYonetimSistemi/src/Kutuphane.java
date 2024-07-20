import java.io.*;
import java.util.*;

public class Kutuphane {
	private Map<String, Kitap> kitaplar;
	private Map<String, Uye> uyeler;
	private Map<String, UyeKitap> oduncKitaplar;

	public Kutuphane() {
		kitaplar = new HashMap<>();
		uyeler = new HashMap<>();
		oduncKitaplar = new HashMap<>();
	}

	public void kitapEkle(Kitap kitap) {
		kitaplar.put(kitap.getId(), kitap);
	}

	public void kitapSil(String id) throws Exception {
		if (kitaplar.containsKey(id)) {
			kitaplar.remove(id);

			System.out.println("Kitap silindi.");

		} else {
			System.out.println("Kitap bulunamadı.");
		}
	}

	public void uyeEkle(Uye uye) {
		uyeler.put(uye.getId(), uye);
	}

	public void uyeSil(String id) throws Exception {
		if (uyeler.containsKey(id)) {
			uyeler.remove(id);
			System.out.println("Üye silindi.");
		} else {
			System.out.println("Üye bulunamadı.");
		}
	}

	public void uyeKitapSil(String id) throws Exception {
		if (oduncKitaplar.containsKey(id)) {
			oduncKitaplar.remove(id);
		}
	}

	public void kitapOduncVer(UyeKitap uyeKitap) throws Exception {
		String kitapID = uyeKitap.getKitapId();
		String uyeID = uyeKitap.getUyeId();
		if (kitaplar.containsKey(kitapID) && uyeler.containsKey(uyeID)) {
			Kitap kitap = kitaplar.get(kitapID);
			if (oduncKitaplar.containsKey(kitapID)) {
				System.out.println("Kitap zaten ödünç verilmiş.");
			} else {
				kitap.setOdunc(true);
				oduncKitaplar.put(kitapID, uyeKitap);
				System.out.println("Kitap ödünç verildi.");
			}
		} else {
			System.out.println("Kitap veya üye bulunamadı.");
		}
	}

	public void kitapGeriAl(String kitapId) throws Exception {
		Kitap kitap = kitaplar.get(kitapId);
		if (oduncKitaplar.containsKey(kitapId)) {
			kitap.setOdunc(false);
			uyeKitapSil(kitapId);
			System.out.println("Kitap geri alındı.");
		} else {
			System.out.println("Kitap geri alınacak durumda değil.");
		}
	}

	public void kitaplariListele() {
		for (Kitap kitap : kitaplar.values()) {
			boolean odunc = kitap.isOdunc();
			String isOdunc = odunc ? "true" : "false";
			if (isOdunc == "false") {
				System.out.println(kitap);
			}
		}
	}

	public void uyeleriListele() {
		for (Uye uye : uyeler.values()) {
			System.out.println(uye);
		}
	}

	public void oduncListele() {
		if (oduncKitaplar.isEmpty() != true) {
			for (UyeKitap uyeKitap : oduncKitaplar.values()) {

				String kitapID = uyeKitap.getKitapId();
				String uyeID = uyeKitap.getUyeId();
				if (kitaplar.containsKey(kitapID) && uyeler.containsKey(uyeID)) {
					Kitap kitap = kitaplar.get(kitapID);
					Uye uye = uyeler.get(uyeID);
					System.out.println("Kitap Bilgileri:" + kitap + ", Uye Bilgileri " + uye);
				}
			}
		} else {
			System.out.println("Odünç kitap bulunamamıştır");
		}
	}

	public Map<String, Kitap> getKitaplar() {
		return kitaplar;
	}

	public Map<String, Uye> getUyeler() {
		return uyeler;
	}

	public Map<String, UyeKitap> getOduncKitaplar() {
		return oduncKitaplar;
	}
}
