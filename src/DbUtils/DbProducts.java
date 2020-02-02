package DbUtils;

import Product.Product;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class DbProducts {

    public static ArrayList<Product> loadProductsData (){

       /*  Mogę to od razu ładować do ProductRepository ale to rozwiązanie jest
          ogólniejsze i mogę ten kod łatwiej podłączać do innych programów.
          Dodatkowo powinienm przepisać nazwy zmiennych na ogólne nic nie
          mówiące i będzie to już prawei ogólna procedura ładowania z pliku,
          prawie bo wczytany rekord muszę zamienić na obiekt klasy Product.*/

       ArrayList<Product> loadedProducts=new ArrayList<Product>();

        String nazwaPliku ="src/Resources/iniProductsData.txt";
        File plik = new File(nazwaPliku);
        FileReader fr;
        BufferedReader br;
        DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String line;

        try {
            br = new BufferedReader(new FileReader(plik));

            while ((line=br.readLine())!=null) {
                String[] value=line.split(",");
                String name=value[0];
                Double price=Double.parseDouble(value[1]);
                String productId=value[2];
                LocalDate date=LocalDate.parse(value[3],dateFormat);
                String category=value[4];
                Product product=new Product(name,price,productId, date, category);
                loadedProducts.add(product);
                }
            br.close();
        } catch (IOException e) {e.printStackTrace(); }
        return loadedProducts;
    }

    public static void saveProducts(ArrayList<Product> productsToSave) {

        String nazwaPliku ="src/Resources/iniProductsData.txt";
        File plik = new File(nazwaPliku);


        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter(plik));
            for (Product product:productsToSave) {
                bw.write(productToLine(product));
            }
            bw.close();
        } catch (IOException e) { e.printStackTrace(); }
    }

    private static String productToLine(Product product){
        String line;
        StringBuilder sb=new StringBuilder();
            sb.append(product.getName()+",");
            sb.append(product.getPrice()+",");
            sb.append(product.getProductId()+",");
            sb.append(product.getDate()+",");
            sb.append(product.getCategory()+"\n");
        line=sb.toString();
        return line;
    }

}
