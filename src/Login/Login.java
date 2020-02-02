package Login;
import User.User;
import org.apache.commons.codec.digest.DigestUtils;

/**
* Klasa zawiera wszystkie metody wykonawcze związane z logowaniem.
* Nie zawiera wyświetlanego menu logowania ani wprowadzania danych
*
* */


public class Login {


    public static void checkLogin (String enteredLogin, String enteredPassword) {

        String codedEnteredPassword= codedPassword(enteredPassword);

        String trueLogin=  User.getOneUser().getLogin();
        String truePassword=User.getOneUser().getPassword();

        if (enteredLogin.equals(trueLogin) && codedEnteredPassword.equals(truePassword)) {
            User.getOneUser().setUserLoginStatus(true);
        } else {
            User.getOneUser().setUserLoginStatus(false);           //zabezpieczenie
        }
        System.out.println("Login status ="+User.getOneUser().isUserLoginStatus()+"\n|");

    }

    public static void changeLogin(String newLogin){
        User.getOneUser().saveUserData();
    };

    public static void changePassword(String newPassword){};

    public static String codedPassword(String password){
        return DigestUtils.md5Hex(password);
    }
}
