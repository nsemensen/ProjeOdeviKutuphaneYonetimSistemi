
public class UyeKitap {
	private String uyeId;
	private String kitapId;

	public UyeKitap(String uyeId, String kitapId) {
		this.uyeId = uyeId;
		this.kitapId = kitapId;
	}

	public String getUyeId() {
		return uyeId;
	}

	public void setUyeId(String uyeId) {
		this.uyeId = uyeId;
	}

	public String getKitapId() {
		return kitapId;
	}

	public void setKitapId(String kitapId) {
		this.kitapId = kitapId;
	}

	@Override
	public String toString() {
		
		String returned = "Kitap ID=" + this.kitapId + "Uye ID=" + this.uyeId;
		return returned;
	}
}
