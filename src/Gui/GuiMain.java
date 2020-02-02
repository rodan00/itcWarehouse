package Gui;

import Login.Login;
import Product.Product;
import Repository.CategoryRepository;
import Repository.ProductRepository;
import User.User;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.util.Scanner;

public class GuiMain {

    public static void loginGui() {

        System.out.println("L:admin,P:pass");
        System.out.println("1     - Please login");
        System.out.println("other - Exit");

        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "1":
                System.out.println("Enter login: ");
                String enteredLogin = scanner.nextLine();
                System.out.println("Enter password: ");
                String enteredPassword = scanner.nextLine();

                Login.checkLogin(enteredLogin, enteredPassword);
                if(User.getOneUser().isUserLoginStatus()) { mainMenu(); }
                else { loginGui(); }
            default:
                System.exit(0);
        }
    }

    public static void mainMenu(){
        setColor();
        System.out.println("1 - Show Products");
        System.out.println("2 - Add Product");
        System.out.println("3 - Remove Product");
        System.out.println("4 - Show Categories");
        System.out.println("5 - Add Category");
        System.out.println("7 - Options");
        System.out.println("9 - EXIT");

        Scanner Scanner=new Scanner(System.in);

        String choice;
        choice=Scanner.nextLine();
        switch (choice) {
            case "1":
                showProducts();
                mainMenu();
            case "2":
                addProductGui();
                mainMenu();;
            case "3":
                removeProductGui();
                mainMenu();;
            case "4":
                showAllCategories();
                mainMenu();;
            case "5":
                addCategoriesGui();
                mainMenu();
            case "7":
                optionGui();
                mainMenu();
            case "9":
                System.exit(0);
            default:
                mainMenu();
        }
    }

    private static void optionGui() {
        System.out.println("1     - Set new password");
        System.out.println("2     - Set new color");
        System.out.println("3     - Set new product sort method");
        System.out.println("other - Back to previous menu");

        Scanner scanner=new Scanner(System.in);
        String choice=scanner.nextLine();
        switch(choice){
            case "1":
                showNewPasswordGui();
                optionGui();
            case"2":
                showNewColorGui();
                optionGui();
            case "3":
                showNewSortMethodGui();
                optionGui();
            default:
                mainMenu();
        }
    }

    private static void showNewSortMethodGui() {
        System.out.println("1     - Sort products by name");
        System.out.println("2     - Sort products by price");
        System.out.println("3     - Sort products by category");
        System.out.println("other - Back to previous menu");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                User.getOneUser().setSortMetod("NAME");
                break;
            case "2":
                User.getOneUser().setSortMetod("PRICE");
                break;
            case "3":
                User.getOneUser().setSortMetod("CATEGORY");
                break;
            default:
                optionGui();
        }
    }

    private static void showNewColorGui() {
            System.out.println("1     - menu color = BLUE");
            System.out.println("2     - menu color = GREEN");
            System.out.println("3     - menu color = RED");
            System.out.println("5     - menu color = BLACK");
            System.out.println("other - Back to previous menu");

            Scanner scanner=new Scanner(System.in);
            String choice=scanner.nextLine();

            switch(choice){
                case "1":
                    User.getOneUser().setUserColor("BLUE");
                   setColor();
                   break;
                case "2":
                    User.getOneUser().setUserColor("GREEN");
                    setColor();
                    break;
                case "3":
                    User.getOneUser().setUserColor("RED");
                    setColor();
                    break;
                case "4":
                    User.getOneUser().setUserColor("BLACK");
                    setColor();
                    break;
                default:
                   optionGui();
            }
    }

    private static void showNewPasswordGui() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter new password:");
        String password1=scanner.nextLine();
        System.out.println("Confirm new password:");
        String password2=scanner.nextLine();

        if(password1.equals(password2)) {
            User.getOneUser().setPassword(password1);
            System.out.println("Password has been succesfully changed");
        } else {
            System.out.println("Pasword has NOT been Changed - try again");
        }
    }

    private static void addCategoriesGui() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter new category:");
        CategoryRepository.addCategories(scanner.nextLine());
    }

    private static void removeProductGui(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter product indeks:");
        ProductRepository.removeProduct(scanner.nextInt());
    }

    private static void addProductGui() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter product name:");
        String name=scanner.nextLine();
        System.out.println("Enter product price:");
        double price=Double.parseDouble(scanner.nextLine());
        System.out.println("Enter product Id:");
        String productId=scanner.nextLine();
        System.out.println("Enter product category:");
        String category=scanner.nextLine();
        ProductRepository.addProduct(name,price,productId,category);
    }

    public static void setColor() {
        String userColor = User.getOneUser().getUserColor().toUpperCase();

        switch (userColor) {
            case "RED":
                System.out.println(EColors.RED);
                break;
            case "GREEN":
                System.out.println(EColors.GREEN);
                break;
            case "BLUE":
                System.out.println(EColors.BLUE);
                break;
            default:
                System.out.println(EColors.WHITE);
        }
    }

    public static void showAllCategories(){
        System.out.println(" LIST OF CATEGORIES");
        for (String category: CategoryRepository.getListOfCategories()) {
            System.out.println(category);
        }
        System.out.println();
    }

    public static void showProducts(){

        String sortMethod = User.getOneUser().getSortMethod();
        ProductRepository.sortProductListBy(sortMethod);

        System.out.println();
        System.out.println(" LIST OF PRODUCTS "+"- sorted by "+sortMethod);
        for (Product product:ProductRepository.getProductList()) {
            System.out.print(ProductRepository.getProductList().indexOf(product));
            System.out.print(" - ");
            System.out.println(product);
        }
        System.out.println();
    }




}
