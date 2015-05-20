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
}
