import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Kutuphane kutuphane = new Kutuphane();
		Scanner scanner = new Scanner(System.in);

		try {
			DosyaIslemleri.veriYukle(kutuphane);

			boolean isValid = false;
			int secim;
			while (true) {
				while (!isValid) {
					System.out.println("Kütüphane Yönetim Sistemi");
					System.out.println("1. Kitap Ekle");
					System.out.println("2. Kitap Sil");
					System.out.println("3. Kitap Ödünç Ver");
					System.out.println("4. Kitap Geri Al");
					System.out.println("5. Üye Ekle");
					System.out.println("6. Üye Sil");
					System.out.println("7. Kitapları Listele");
					System.out.println("8. Üyeleri Listele");
					System.out.println("9. Odünç Kitapları Listele");
					System.out.println("10. Çıkış");
					System.out.print("Seçiminizi yapın: ");

					if (scanner.hasNextInt()) {
						secim = scanner.nextInt();
						scanner.nextLine();
						isValid = true;

						switch (secim) {
						case 1:
							System.out.print("Kitap ID: ");
							String kitapId = scanner.nextLine().toUpperCase();

							System.out.print("Kitap Başlık: ");
							String baslik = scanner.nextLine().toUpperCase();

							System.out.print("Kitap Yazar: ");
							String yazar = scanner.nextLine().toUpperCase();

							System.out.print("Yayın Yılı: ");
							String yayinYili = scanner.nextLine().toUpperCase();

							System.out.print("Kategori: ");
							String kategori = scanner.nextLine().toUpperCase();

							Kitap yeniKitap = new Kitap(kitapId, baslik, yazar, yayinYili, kategori, false);
							kutuphane.kitapEkle(yeniKitap);
							break;

						case 2:
							try {
								kutuphane.kitaplariListele();
								System.out.print("Silinecek Kitap ID: ");
								String silinecekKitapId = scanner.nextLine().toUpperCase();
								kutuphane.kitapSil(silinecekKitapId);

							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;

						case 3:
							kutuphane.kitaplariListele();
							kutuphane.uyeleriListele();
							System.out.print("Ödünç Verilecek Kitap ID: ");
							String oduncKitapId = scanner.nextLine().toUpperCase();
							System.out.print("Ödünç Verilecek Üye ID: ");
							String oduncUyeId = scanner.nextLine().toUpperCase();
							try {
								UyeKitap yeniUyeKitap = new UyeKitap(oduncUyeId, oduncKitapId);
								kutuphane.kitapOduncVer(yeniUyeKitap);

							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;

						case 4:
							kutuphane.oduncListele();
							System.out.print("Geri Alınacak Kitap ID: ");
							String geriAlinacakKitapId = scanner.nextLine().toUpperCase();
							try {
								kutuphane.kitapGeriAl(geriAlinacakKitapId);

							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;

						case 5:
							System.out.print("Üye ID: ");
							String uyeIdYeni = scanner.nextLine().toUpperCase();

							System.out.print("Üye İsim: ");
							String isim = scanner.nextLine().toUpperCase();

							System.out.print("Üye Email: ");
							String email = scanner.nextLine().toUpperCase();

							System.out.print("Üye Telefon: ");
							String telefon = scanner.nextLine().toUpperCase();

							Uye yeniUye = new Uye(uyeIdYeni, isim, email, telefon);
							kutuphane.uyeEkle(yeniUye);
							break;

						case 6:
							try {
								kutuphane.uyeleriListele();
								System.out.print("Silinecek Üye ID: ");
								String silinecekUyeId = scanner.nextLine().toUpperCase();

								kutuphane.uyeSil(silinecekUyeId);

							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							break;

						case 7:
							kutuphane.kitaplariListele();
							break;

						case 8:
							kutuphane.uyeleriListele();
							break;

						case 9:
							kutuphane.oduncListele();
							break;
						case 10:
							try {
								DosyaIslemleri.veriKaydet(kutuphane);
								System.out.println("Veriler kaydedildi.");
							} catch (IOException e) {
								System.out.println("Veriler kaydedilirken hata oluştu.");
							}
							System.out.println("Çıkılıyor...");
							return;

						default:
							System.out.println("Geçersiz seçenek, tekrar deneyin.");
							continue;

						}
						isValid = false;
						DosyaIslemleri.veriKaydet(kutuphane);
					} else {
						System.out.println("Lütfen Sayı giriniz.");
						scanner.next();
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Veriler yüklenirken hata oluştu.");
		}
	}
}
