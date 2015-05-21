package zaliczenie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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

    public void usunPracownika() {
        System.out.println("LP.\tImie\tNazwisko\tPłeć\tNrDziału\tPłaca\tIlość dzieci\tStan Cywilny");
        int licznik = 1;
        for (Pracownik p : listaPracownikow) {
            System.out.print(licznik++ + ". \t");
            p.wyswietlanie();
            sprawdzanieStatusu(p.getPlec(), p.isStanCywilny());
        }

        System.out.println("Którego pracownika usunąć?");
        Scanner in = new Scanner(System.in);
        int kogo = in.nextInt();
        Iterator it = listaPracownikow.iterator();
        licznik = 1;
        while (it.hasNext()) {
            it.next();
            if (licznik == kogo) {
                it.remove();
            }
            licznik++;
        }

    }

    public void edycjaPracownika() {
        System.out.println("LP.\tImie\tNazwisko\tPłeć\tNrDziału\tPłaca\tIlość dzieci\tStan Cywilny");
        int licznik = 1;
        for (Pracownik p : listaPracownikow) {
            System.out.print(licznik++ + ". \t");
            p.wyswietlanie();
            sprawdzanieStatusu(p.getPlec(), p.isStanCywilny());
        }
        System.out.println("Którego pracownika chcesz edytować?");
        Scanner in = new Scanner(System.in);
        int kogo = in.nextInt();
        licznik = 1;
        for (Pracownik p : listaPracownikow) {
            if (licznik == kogo) {
                System.out.println("IMIĘ\tNAZWISKO");
                p.wyswietlanieSpecjalne();
                if (p.getPlec() == 'K') {
                    int co = Menu.menuEdycjaKobieta();
                    switch (co) {
                        case 1:
                            System.out.print("Podaj nowe nazwisko.");
                            String tmp = in.nextLine(); //coś tutaj się krzaczy
                            p.setNazwisko(tmp);
                            break;
                        case 2:
                            System.out.println("Podaj nowy numer działu.");
                            p.setNrDzialu(in.nextInt());
                            break;
                        case 3:
                            System.out.println("Podaj nową płace.");
                            p.setPlaca(in.nextFloat());
                            break;
                        case 4:
                            System.out.println("Podaj nowy wiek.");
                            p.setWiek(in.nextInt());
                            break;
                        case 5:
                            System.out.println("Podaj nową liczbe dzieci.");
                            p.setDzieci(in.nextInt());
                            break;
                        case 6:
                            System.out.println("Podaj nowy stan cywilny (false/true).");
                            p.setStanCywilny(in.nextBoolean());
                            break;
                        default:
                            System.out.println("Wybrano złą opcje");
                    }
                } else {
                    int co = Menu.menuEdycjaMezczyna();
                    switch (co) {
                        case 1:
                            System.out.println("Podaj nowy numer działu.");
                            p.setNrDzialu(in.nextInt());
                            break;
                        case 2:
                            System.out.println("Podaj nową płace.");
                            p.setPlaca(in.nextFloat());
                            break;
                        case 3:
                            System.out.println("Podaj nowy wiek.");
                            p.setWiek(in.nextInt());
                            break;
                        case 4:
                            System.out.println("Podaj nową liczbe dzieci.");
                            p.setDzieci(in.nextInt());
                            break;
                        case 5:
                            System.out.println("Podaj nowy stan cywilny (false/true).");
                            p.setStanCywilny(in.nextBoolean());
                    }
                }
            }
            licznik++;
        }

    }

    private void sprawdzanieStatusu(char plec, boolean StanCywilny) {
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
    }

    public int obliczniePracownikow(float pensja) {
        int licznik = 0;
        for (Pracownik a : listaPracownikow) {
            if(a.getPlaca()>pensja) {
                licznik++;
            }
        }
        return licznik;
    }
}
