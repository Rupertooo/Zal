package zaliczenie;

import java.util.ArrayList;

/**
 *
 * @author mcogiel
 */
public class Lista {

    private ArrayList<Pracownik> listaPracownikow = new ArrayList();

    public void dodajPracownika(String imie, String nazwisko, char plec, int nrDzialu, float placa, int wiek, int dzieci, boolean stanCywilny) {
        Pracownik pracownik = new Pracownik(imie, nazwisko, plec, nrDzialu, placa, wiek, dzieci, stanCywilny);
        listaPracownikow.add(pracownik);
    }

    public void dodajPracownika(Pracownik pracownik) {
        listaPracownikow.add(pracownik);
    }

    public void wyswietlPracownikow() {
        System.out.println("Imie\tNazwisko\tPłaca");
        for (Pracownik p : listaPracownikow) {
            p.wyswietlanieOkrojone();
        }
    }

    /*    private void sprawdzanieStatusu(char plec, boolean StanCywilny) {
     if (StanCywilny) {
     if (plec == 'M') {
     System.out.println("Żonaty");
     } else {
     System.out.println("Mężatka");
     }
     } else {
     if (plec == 'M') {
     System.out.println("Kawaler");
     } else {
     System.out.println("Panna");
     }
     }
     }*/
}
