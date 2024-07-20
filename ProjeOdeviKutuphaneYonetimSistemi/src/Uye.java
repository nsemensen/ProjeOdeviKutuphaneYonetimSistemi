
public class Uye {
	private String id;
    private String isim;
    private String email;
    private String telefon;
    
	public Uye(String id, String isim, String email, String telefon) {
		this.id = id;
		this.isim = isim;
		this.email = email;
		this.telefon = telefon;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	@Override
	public String toString() {
		return "Uye Id= " + this.id + ", Üye Adı= " + this.isim + ", Email= " + this.email + ", Telefon= " + this.telefon;
	}
}
