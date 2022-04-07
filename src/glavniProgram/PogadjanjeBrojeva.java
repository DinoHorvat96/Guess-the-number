package glavniProgram;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import broj.Broj;

public class PogadjanjeBrojeva {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Broj broj = new Broj();
		
		Timer igrac = new Timer();
		TimerTask unesiBroj = new TimerTask() {
			Random slucajniBroj = new Random();
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (!broj.isProvjeri()){
					if (broj.getRezultatProvjere() == 0) {
						igrac.cancel();
					}
				else {
					broj.setrBrPokusaja();
					if (broj.getRezultatProvjere() == -1) {
						
						
						broj.setUneseniBroj(slucajniBroj.nextInt(broj.getTrazeniBroj() - broj.getUneseniBroj() + 1) + broj.getUneseniBroj());
					} else if (broj.getRezultatProvjere() == 1) {
						broj.setUneseniBroj(slucajniBroj.nextInt(broj.getUneseniBroj() - broj.getTrazeniBroj() + 1) + broj.getTrazeniBroj());

					} else{
						broj.setUneseniBroj(slucajniBroj.nextInt(Broj.MAX_BROJ - Broj.MIN_BROJ + 1) + Broj.MIN_BROJ);
					}
	
					System.out.println("IGRAC: " + broj.getUneseniBroj());
					broj.setProvjeri(true);
					}
				}
			}
		};
		
		Timer sudac = new Timer();
		TimerTask provjeraBroja = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (broj.isProvjeri()){
					if (broj.getUneseniBroj() < broj.getTrazeniBroj()) {
						broj.setRezultatProvjere(-1);
						System.out.println("UNESENI BROJ JE MANJI OD TRAŽENOG!");
					} else if (broj.getUneseniBroj() > broj.getTrazeniBroj()) {
						broj.setRezultatProvjere(1);
						System.out.println("UNESENI BROJ JE VECI OD TRAŽENOG!");
					} else {
						broj.setRezultatProvjere(0);
						System.out.println("POGODAK U " + broj.getrBrPokusaja() + " POKUŠAJA");
						sudac.cancel();
						
					}
					
					broj.setProvjeri(false);
				}
			}
		};
		
		sudac.schedule(provjeraBroja, 0, 1000);
		igrac.schedule(unesiBroj, 0, 1000);
	}

}
