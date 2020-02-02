package User;
import Login.Login;
import java.io.*;

public class User {

    private String login;
    private String password;
    private String color;
    private String sortMethod;
    private boolean userLoginStatus=false;
    private static User oneUser=new User();

    private User(){
        loadUserData();
    }

    public User(String login, String password, String color, String sortMethod) {
        this.login = login;
        this.password = password;
        this.color = color;
        this.sortMethod = sortMethod;
    }

    public static User getOneUser(){ return oneUser; }

    private void loadUserData(){
        String nazwaPliku ="src/Resources/iniUserData.txt";
        //String nazwaPliku="D:\\PROGRAMMING\\JAVA\\Warehouse1\\src\\Resources\\iniUserData.txt"
        File plik = new File(nazwaPliku);
        FileReader fr;
        BufferedReader br;
        try {
            fr=new FileReader(plik);
            br = new BufferedReader(fr);
                login=br.readLine();
                password= br.readLine();
                color=br.readLine();
                sortMethod=br.readLine();
                br.close();
        }
        catch (IOException e) {e.printStackTrace(); }
    }

    public void saveUserData(){
        String nazwaPliku ="src/Resources/iniUserData.txt";
        File plik = new File(nazwaPliku);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(plik));
            bw.write(login+"\n");
            bw.write(password+"\n");
            bw.write(color+"\n");
            bw.write(sortMethod);
            bw.close();
        }
        //catch (FileNotFoundException e) {e.printStackTrace(); }
        catch (IOException e) {e.printStackTrace(); }
    }

    public String getLogin() {return login; }

    public String getPassword() { return password;}

    public String getUserColor() {return color; }

    public String getSortMethod() {
        return sortMethod;
    }

    public boolean isUserLoginStatus() { return userLoginStatus; }

    public void setLogin(String login) {
        this.login = login;
        saveUserData();
    }

    public void setPassword(String password) {
        this.password = Login.codedPassword(password);
        saveUserData();
    }

    public void setUserColor(String color) {
        this.color = color;
        saveUserData(); }

    public void setUserLoginStatus(boolean userLoginStatus) {
        this.userLoginStatus = userLoginStatus;
        saveUserData();
    }

    public void setSortMetod(String sortMethod){
        this.sortMethod=sortMethod;
        System.out.println(this.sortMethod);
        saveUserData();
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", color='" + color + '\'' +
                ", userLoginStatus=" + userLoginStatus +
                '}';
    }
}
