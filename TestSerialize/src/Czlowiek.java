import java.io.Serializable;

public class Czlowiek implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String imie, nazwisko;
	private int wiek;


	public Czlowiek(String imie, String nazwisko, int wiek) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.wiek = wiek;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return imie+" "+nazwisko+" lat: "+wiek;
	}
	
	

}
