package zaliczenie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.PrintWriter;
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
        System.out.println("LP.\tImie\tNazwisko Płeć NrDziału\tPłaca\tIlość dzieci\tStan Cywilny");
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
        System.out.println("LP.\tImie\tNazwisko Płeć NrDziału\tPłaca\tIlość dzieci\tStan Cywilny");
        int licznik = 1;
        for (Pracownik p : listaPracownikow) {
            System.out.print(licznik++ + ". \t");
            p.wyswietlanie();
            sprawdzanieStatusu(p.getPlec(), p.isStanCywilny());
        }
        System.out.println("Którego pracownika chcesz edytować?");
        Scanner in = new Scanner(System.in);
        int kogo = Integer.parseInt(in.nextLine());
        licznik = 1;
        for (Pracownik p : listaPracownikow) {
            if (licznik == kogo) {
                System.out.println("IMIĘ\tNAZWISKO");
                p.wyswietlanieSpecjalne();
                if (p.getPlec() == 'K') {
                    int co = Menu.menuEdycjaKobieta();
                    switch (co) {
                        case 1:
                            System.out.println("Podaj nowe nazwisko.");
                            String tmp = in.nextLine();
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

    public int obliczniePracownikow(String inputFile, float pensja) {
        ArrayList<Pracownik> listaPracownikow = odczytZPliku(inputFile);
        int licznik = 0;
        for (Pracownik a : listaPracownikow) {
            if (a.getPlaca() > pensja) {
                licznik++;
            }
        }
        return licznik;
    }

    private ArrayList odczytZPliku(String inputFile) {
        try {
            File iF = new File(inputFile);
            FileReader fR = new FileReader(iF);
            BufferedReader bR = new BufferedReader(fR);
            String odczyt;
            String[] wynik;
            ArrayList<Pracownik> listaPracownikow = new ArrayList();
            while ((odczyt = bR.readLine()) != null) {
                wynik = odczyt.split(",");
                listaPracownikow.add(new Pracownik(wynik[0], wynik[1], wynik[2].charAt(0), Integer.parseInt(wynik[3]), Float.parseFloat(wynik[4]), Integer.parseInt(wynik[6]), Integer.parseInt(wynik[5]), Boolean.parseBoolean(wynik[7])));
            }
            return listaPracownikow;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void eksport(String nazwaPliku) {
        try {
            File oF = new File(nazwaPliku);
            FileWriter fW = new FileWriter(oF);
            PrintWriter pW = new PrintWriter(fW);
            for (Pracownik p : listaPracownikow) {
                pW.println(p.getImie() + "," + p.getNazwisko() + "," + p.getPlec() + "," + p.getNrDzialu() + "," + p.getPlaca() + "," + p.getWiek() + "," + p.getDzieci() + "," + p.isStanCywilny());
            }
            pW.flush();
            pW.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public float sredniaDzialu(String inputFile, int nrDzialu) { //Zwraca średnia podanego działu 0 jeśli ilość osób w dziale jest równa 0
        ArrayList<Pracownik> listaPracownikow = odczytZPliku(inputFile);
        int licznik = 0;
        float suma = 0;
        for (Pracownik p : listaPracownikow) {
            if (p.getNrDzialu() == nrDzialu) {
                licznik++;
                suma = suma + p.getPlaca();
            }
        }
        if (licznik == 0) {
            return 0;
        } else {
            return suma / licznik;
        }
    }

    public void najwiekszePlace(String inputFile) { //Wyświetlanie najwyższej pensji kobiety i meżczyzny
        ArrayList<Pracownik> listaPracownikow = odczytZPliku(inputFile);
        float najwiekszaKobieta = Float.MIN_VALUE;
        float najwiekszaMez = Float.MIN_VALUE;
        for (Pracownik p : listaPracownikow) {
            if (p.getPlec() == 'K') {
                najwiekszaKobieta = Float.max(najwiekszaKobieta, p.getPlaca());
            } else {
                najwiekszaMez = Float.max(najwiekszaMez, p.getPlaca());
            }
        }
        System.out.println("Najwyższa płaca Kobiety : " + najwiekszaKobieta + " Mężczyzny : " + najwiekszaMez);
    }

    public void stosunekPensji(String inputFile) {
        ArrayList<Pracownik> listaPracownikow = odczytZPliku(inputFile);
        float sredniaKobiet = 0;
        int licznikKobiet = 0;
        float sredniaMez = 0;
        int licznikMez = 0;
        for (Pracownik p : listaPracownikow) {
            if (p.getPlec() == 'K') {
                sredniaKobiet += p.getPlaca();
                licznikKobiet++;
            } else {
                sredniaMez += p.getPlaca();
                licznikMez++;
            }
        }
        System.out.println("Stosunek sredniej pensji kobiet do mężczyzn " + ((sredniaKobiet/licznikKobiet) / (sredniaMez/licznikMez)));
    }

    public void zwiekszPensje(String inputFile) {
        ArrayList<Pracownik> listaPracownikow = odczytZPliku(inputFile);
        for (Pracownik p : listaPracownikow) {
            p.setPlaca(p.getPlaca() + p.podwyzka(10));
        }
    }
}
