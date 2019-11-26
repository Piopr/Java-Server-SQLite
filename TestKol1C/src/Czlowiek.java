import java.io.Serializable;
import java.time.LocalDate;

public class Czlowiek implements Serializable{

	private String imie, nazwisko;
	private LocalDate data;
	public Czlowiek(String imie, String nazwisko, LocalDate d) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.data = data;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return imie+' '+nazwisko+" "+data.toString();
	}
}
