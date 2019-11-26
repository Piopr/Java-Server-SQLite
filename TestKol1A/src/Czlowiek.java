import java.io.Serializable;
import java.time.LocalDate;

public class Czlowiek implements Serializable {
	private static final long serialVersionUID = 1L;
	private String imie, nazwisko;
	private LocalDate data;
	public Czlowiek(String imie, String nazwisko, LocalDate data) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.data = data;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return imie+" "+nazwisko+" "+data.toString();
	}

}
