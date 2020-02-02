package Repository;

import java.util.ArrayList;

public class CategoryRepository {

    private static ArrayList<String> listOfCategories = new ArrayList<String>();
    private static CategoryRepository categoryRepository=new CategoryRepository();

    private CategoryRepository(){

        listOfCategories=DbUtils.DbCategories.loadListOfStrings();
        checkAddNoCategory();
    }

    public static ArrayList<String> getListOfCategories(){
    return listOfCategories;
    }

    public static void addCategories(String newCategory){
        boolean flag=false;
        for(String element:listOfCategories){
            if(element.toUpperCase().equals(newCategory.toUpperCase())){
                flag=true;
                break;
            }
        }
        if(flag==false){
            listOfCategories.add(newCategory);
            DbUtils.DbCategories.saveListOfStrings(listOfCategories);
        }
    }

    public static boolean doesCategoryExists(String newCategory){
        boolean does=false;

        for (String category :listOfCategories){
            if (newCategory.equals(category)){does=true;}
        }
        return does;
    }

    private static void checkAddNoCategory() {
        boolean isNoCategory = false;
        for (String category : listOfCategories) {
            if (category.equals("NOCATEGORY")) {
                isNoCategory = true;
            }
        }
        if (!isNoCategory) {
            listOfCategories.add(0,"NOCATEGORY");
        }
    }


}



