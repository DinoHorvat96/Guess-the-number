package broj;

import java.util.Random;

public class Broj  {
	final public static int MIN_BROJ = 0;
	final public static int MAX_BROJ = 100;
	private int trazeniBroj;
	private int rBrPokusaja;
	private int uneseniBroj;
	private int rezultatProvjere; // -1 - uneseni broj manji; 1 - uneseni broj veci; 0 - uneseni broj jednak
	private boolean provjeri;
	
	public Broj() {
		Random slucajniBroj = new Random();
		trazeniBroj = slucajniBroj.nextInt(MAX_BROJ-MIN_BROJ + 1) + MIN_BROJ;
		rBrPokusaja = 0;
		provjeri = false;
		rezultatProvjere = 2;
	}

	public boolean isProvjeri() {
		return provjeri;
	}

	public void setProvjeri(boolean provjeri) {
		this.provjeri = provjeri;
	}

	public int getRezultatProvjere() {
		return rezultatProvjere;
	}

	public void setRezultatProvjere(int rezultatProvjere) {
		this.rezultatProvjere = rezultatProvjere;
	}
	
	public int getUneseniBroj() {
		return uneseniBroj;
	}

	public void setUneseniBroj(int uneseniBroj) {
		this.uneseniBroj = uneseniBroj;
	}

	public int getTrazeniBroj() {
		return trazeniBroj;
	}

	public void setTrazeniBroj(int trazeniBroj) {
		this.trazeniBroj = trazeniBroj;
	}
	
	public int getrBrPokusaja() {
		return rBrPokusaja;
	}

	public void setrBrPokusaja() {
		this.rBrPokusaja ++;
	}
}
