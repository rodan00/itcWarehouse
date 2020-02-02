package Product;

import java.util.Comparator;

public class CompareByPrice implements Comparator {

    /*
        1) Muszę wczytywać obiekty klasy Object bo tylko wtedy to jest przesłonięcie metody
        z interfejsu Comparator - Bo w interfejsie jest zdefiniowana metoda włąśnie na
         typach object
         2) cena jest w double więc musi zostać zrzutowana na int bo taki typ ta funkcja zwraca
        */
    @Override
    public int compare(Object o1, Object o2) {
        Product p1 = (Product) o1;
        Product p2 = (Product) o2;
        return (int) (p1.getPrice()-p2.getPrice());
    }
}