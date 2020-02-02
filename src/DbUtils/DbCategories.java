package DbUtils;

import java.io.*;
import java.util.ArrayList;

public class DbCategories {

    private static String myFileName="src/Resources/iniCategoriesData.txt";
    private static File myFile=new File(myFileName);

    public static ArrayList<String> loadListOfStrings(){
        ArrayList <String> loadedList=new ArrayList<String>();

        File myFile=new File(myFileName);
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(myFile));
            while((line=br.readLine())!=null) {
                loadedList.add(line);
            }
            br.close();
        } catch (IOException e) {e.printStackTrace();}
        return loadedList;
    }

    public static void saveListOfStrings(ArrayList<String> listToSave){

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(myFile));
            for(String element:listToSave){
                if (element!=null) {
                    bw.write(element + "\n");
                } else {break;}
            }
            bw.close();
        } catch (IOException e) {e.printStackTrace();}
    }



}
