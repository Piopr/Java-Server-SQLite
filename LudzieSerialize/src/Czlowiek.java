import java.io.Serializable;
import java.time.LocalDate;

public class Czlowiek implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String imie, nazwisko;
	private LocalDate dataUr;
	public Czlowiek(String imie, String nazwisko, LocalDate dataUr) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.dataUr = dataUr;
	}

   @Override
   public String toString() {
	
	return imie+" "+nazwisko+" "+dataUr.toString();
}
}
