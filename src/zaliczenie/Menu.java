package zaliczenie;

import java.util.Scanner;

/**
 *
 * @author mcogiel
 */
public class Menu {

    public static int menu() {
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Wypisywanie Pracowników");
        System.out.println("     2. Dodaj pracownika");
        System.out.println("     3. Eksport");
        System.out.println("     4. Usuń pracownika");
        System.out.println("     5. Edycja danych");
        System.out.println("     6. Dodatkowe Funkcje");
        System.out.println("     0. Koniec");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();

        return w;
    }

    public static int menuDodatkowe() {
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Oblicznie pracowników z pensją wyższą");
        System.out.println("     2. Oblicznie sredniej płacy w dziale");
        System.out.println("     3. Wyświetlanie największych pensji kobiet i mężczyzn");
        System.out.println("     4. Średnia płaca kobier do średniej płacy mężczyzn");
        System.out.println("     5. Podwyższka o 10%");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();

        return w;
    }

    public static int menuEdycjaKobieta() {
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Nazwisko");
        System.out.println("     2. Numer działu");
        System.out.println("     3. Płaca");
        System.out.println("     4. Wiek");
        System.out.println("     5. Liczba dzieci");
        System.out.println("     6. Stan Cywilny");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();

        return w;
    }

    public static int menuEdycjaMezczyna() {
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Numer działu");
        System.out.println("     2. Płaca");
        System.out.println("     3. Wiek");
        System.out.println("     4. Liczba dzieci");
        System.out.println("     5. Stan Cywilny");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();

        return w;
    }

    public Pracownik dodawniePrac() {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj Imię");
        String imie = in.nextLine();
        System.out.println("Podaj Nazwisko");
        String nazwisko = in.nextLine();
        System.out.println("Podaj płeć");
        char plec = in.nextLine().charAt(0);
        System.out.println("Podaj numer działu");
        int nrDzialu = in.nextInt();
        System.out.println("Podaj płace");
        float placa = in.nextFloat();
        System.out.println("Podaj wiek");
        int wiek = in.nextInt();
        System.out.println("Podaj ilość dzieci");
        int dzieci = in.nextInt();
        System.out.println("Podaj stan cywilny true/false");
        boolean stanCywilny = in.nextBoolean();
        return new Pracownik(imie, nazwisko, plec, nrDzialu, placa, wiek, dzieci, stanCywilny);
    }

}
