package zaliczenie;

public class Pracownik {

    private final String imie;
    private String nazwisko;
    private final char plec;
    private int nrDzialu;
    private float placa;
    private int wiek;
    private int dzieci;
    private boolean stanCywilny;

    public Pracownik(String imie, String nazwisko, char plec, int nrDzialu, float placa, int wiek, int dzieci, boolean stanCywilny) {
        this.imie = stringFormat(imie);
        this.nazwisko = stringFormat(nazwisko);
        if (plec == 'K' || plec == 'M') {
            this.plec = plec;
        } else {
            throw new IllegalStateException("Podaj płeć jako K lub M");
        }
        this.nrDzialu = nrDzialu;
        this.placa = placa;
        this.wiek = wiek;
        this.dzieci = dzieci;
        this.stanCywilny = stanCywilny;
    }

    private String stringFormat(String tekst) {
        String[] tabTmp = tekst.split("\\s+");
        tekst = "";
        for (String tabTmp1 : tabTmp) {
            tekst = tekst + tabTmp1;
        }
        String tmp = tekst.substring(0, 1);
        String tmp2 = tekst.substring(1);
        String toRet = tmp.toUpperCase() + tmp2.toLowerCase();
        return toRet;
    }

    public void wyswietlanie() {
        //       System.out.println("Imie\tNazwisko\tPłeć\tNrDziału\tPłaca\tIlość dzieci\tStan Cywilny");
        System.out.print(getImie() + "\t" + getNazwisko() + "\t\t" + getPlec() + "\t" + getNrDzialu() + "\t\t" + getPlaca() + "\t" + getDzieci() + "\t\t");
        //       sprawdzanieStatusu(getPlec(), isStanCywilny());
    }

    public void wyswietlanieOkrojone() {
        //  System.out.println("Imie\tNazwisko\tPłaca");
        //      for (Pracownik a : listaPracownikow) {
        System.out.println(getImie() + "\t" + getNazwisko() + "\t\t" + getPlaca());
        //     
    }

    public void wyswietlanieSpecjalne() {
   //     System.out.println("IMIĘ\tNAZWISKO");
        //       for (Pracownik a : listaPracownikow) {
        System.out.println(getImie().toUpperCase() + "\t" + getNazwisko().toUpperCase());
        //      }
    }
    
    public boolean sprawdzaniePensji(float ile) {
        if (ile > placa) {
            return true;
        } else {
            return false;
        }
    }
    
    public float podwyzka(float oIle) {
        float tmp;
        tmp = oIle + 2 * dzieci;
        if(stanCywilny) tmp = tmp+3;
        tmp = placa*(tmp/100);
        return tmp;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public char getPlec() {
        return plec;
    }

    public int getNrDzialu() {
        return nrDzialu;
    }

    public float getPlaca() {
        return placa;
    }

    public int getWiek() {
        return wiek;
    }

    public int getDzieci() {
        return dzieci;
    }

    public boolean isStanCywilny() {
        return stanCywilny;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setNrDzialu(int nrDzialu) {
        this.nrDzialu = nrDzialu;
    }

    public void setPlaca(float placa) {
        this.placa = placa;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public void setDzieci(int dzieci) {
        this.dzieci = dzieci;
    }

    public void setStanCywilny(boolean stanCywilny) {
        this.stanCywilny = stanCywilny;
    }

}
