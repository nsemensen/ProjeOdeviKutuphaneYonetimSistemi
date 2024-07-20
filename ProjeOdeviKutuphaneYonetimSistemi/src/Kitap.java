
public class Kitap {
	private String id;
	private String baslik;
	private String yazar;
	private String yayinYili;
	private String kategori;
	private boolean odunc=false;

	public Kitap(String id, String baslik, String yazar, String yayinYili, String kategori,boolean odunc) {
		this.id = id;
		this.baslik = baslik;
		this.yazar = yazar;
		this.yayinYili = yayinYili;
		this.kategori = kategori;
		this.odunc = odunc;
	}
	public Kitap(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getBaslik() {
		return baslik;
	}

	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}

	public String getYazar() {
		return yazar;
	}

	public void setYazar(String yazar) {
		this.yazar = yazar;
	}

	public String getYayinYili() {
		return yayinYili;
	}

	public void setYayinYili(String yayinYili) {
		this.yayinYili = yayinYili;
	}

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	@Override
	public String toString() {
		return "Kitap Id=" + this.id + ", Başlık=" + this.baslik + ", Yazar=" + this.yazar + ", Yayın Yılı=" + this.yayinYili
				+ ", Kategori=" + this.kategori;
	}

	
	public boolean isOdunc() {
		return odunc;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setOdunc(boolean odunc) {
		this.odunc = odunc;
	}
}
