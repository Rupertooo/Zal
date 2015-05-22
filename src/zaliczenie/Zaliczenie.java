package zaliczenie;

import java.io.IOException;

public class Zaliczenie {

    public static void main(String[] args) throws IOException {
        Lista p = new Lista();
        p.dodajPracownika("Michał", "Cogiel", 'M', 5, 3000, 25, 0, false);
        p.dodajPracownika("Marcin", "Cogiel", 'M', 5, 2000, 26, 0, false);
        p.dodajPracownika("Marcin", "Cogiel", 'K', 5, 2000, 26, 0, false);
        int wybor;
        wybor = Menu.menu();
        while (wybor != 0) {
            switch (wybor) {
                case 1:
                    p.wyswietlPracownikow();
                    break;
                case 2:
                    p.dodajPracownika(Menu.dodawniePrac());
                    break;
                case 3:
                    p.eksport(Menu.jakiPlik());
                    break;
                case 4:
                    p.usunPracownika();
                    break;
                case 5:
                    p.edycjaPracownika();
                    break;
                case 6:
                    int wybor2 = Menu.menuDodatkowe();
                    switch (wybor2) {
                        case 1:
                            System.out.println(p.obliczniePracownikow(Menu.jakiPlik(),Menu.jakaPensja()) + " pracowników ma wyższą pensję");
                            break;
                        case 2:                          
                            System.out.println(p.sredniaDzialu(Menu.jakiPlik(),Menu.jakiDzial()));
                            break;
                        case 3:
                            p.najwiekszePlace(Menu.jakiPlik());
                            break;
                        case 4:
                            p.stosunekPensji(Menu.jakiPlik());
                            break;
                        case 5:
                            p.zwiekszPensje(Menu.jakiPlik());
                            break;
                        default:
                            System.out.println("Wybrano złą opcje");

                    }
                    break;
                default:
                    System.out.println("Wybrano złą opcje");

            }

            System.out.println("\nWciśnij Enter, aby kontynuować...");
            System.in.read();

            wybor = Menu.menu();
        }
    }

}
