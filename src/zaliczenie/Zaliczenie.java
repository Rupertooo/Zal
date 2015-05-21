package zaliczenie;

import java.io.IOException;
import java.util.Scanner;

public class Zaliczenie {

    public static void main(String[] args) throws IOException {
        Lista p = new Lista();
        p.dodajPracownika("Michał", "Cogiel", 'M', 5, 3000, 25, 0, false);
        p.dodajPracownika("Marcin", "Cogiel", 'M', 5, 2000, 26, 0, false);
        int wybor;
        Menu men = new Menu();
        wybor = men.menu();
        while (wybor != 0) {
            switch (wybor) {
                case 1:
                    p.wyswietlPracownikow();
                    break;
                case 2:
                    p.dodajPracownika(men.dodawniePrac());
                    break;
                case 3:

                    break;
                case 4:
                    p.usunPracownika();
                    break;
                case 5:
                    p.edycjaPracownika();
                    break;
                case 6:

                    break;
                default:
                    System.out.println("Wybrano złą opcje");

            }

            System.out.println("\nWciśnij Enter, aby kontynuować...");
            System.in.read();

            wybor = Menu.menu();
        }
        /*        Pracownik p1 = new Pracownik("Michał", "Cogiel", 'M', 5, 3000, 25, 0, false);
         p1.podwyzka(5);
         Lista p = new Lista();
         p.dodajPracownika("Michał", "Cogiel", 'M', 5, 3000, 25, 0, false);
         p.dodajPracownika("Marcin", "Cogiel", 'M', 5, 2000, 26, 0, false);
         p.wyswietlanie();
         p.wyswietlanieOkrojone();
         p.wyswietlanieSpecjalne();*/
    }

}
