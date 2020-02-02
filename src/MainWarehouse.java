import Gui.GuiMain;

/*
*  Uruchamianie
*
*  Opis:
*  Interfejs - konsola
*  Logowanie - kontrola dostępu do głównego Menu, hasło zakodowane
*  User: jeden użytkownik (singleton), zmiana login, password, kolor menu, metoda sortowania
*  Baza i product - jedna baza danych (singleton) dodawanie i usuwanie produktów z bazy,
*    sortowanie wg metody Usera po cenie, kategorii, nazwie, wyświetlanie, data wpisania
*    do bazy automatyczna
*  Kategorie produktu - Wyświetlanie, dodawanie, pilnowanie występowania NOCATEGORY
*  Warstwa zapisywania i ładowania ustawień Usera, Bazy produktów i listy kategorii do pliku
*
*
* */


public class MainWarehouse {

    public static void main(String[] args) {

        GuiMain.loginGui();

    }
}
