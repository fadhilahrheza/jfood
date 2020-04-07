import jdk.jfr.Category;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class DatabaseFood. Contain the database of Food
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 */
public class DatabaseFood
{
    /**
     * Below are the variable for class DatabaseFood
     */
    private static ArrayList<Food> FOOD_DATABASE = new ArrayList<Food>();
    private static int lastid = 0;

    /**
     * Constructor for objects of class DatabaseFood
     * 
     * @param listFood (the list of food in the database)
     */

    /**
     * Get the Array list of FoodDatabase
     *
     * @return FOOD_DATABASE
     */
    public static ArrayList<Food> getFoodDatabase()
    {
        return FOOD_DATABASE;
    }

    /**
     * Get the last ID of FoodDatabase
     *
     * @return lastid
     */
    public static int getLastId()
    {
        return lastid;
    }

    /**
     * Getting Food Id
     *
     * @return food
     */
    public static Food getFoodById(int id)
    {
        for(Food food : FOOD_DATABASE)
        {
            if(id == food.getId())
            {
                return food;
            }
        }
        return null;
    }

    /**
     * Get the Array list of Food by Seller
     *
     * @return foodlist
     */
    public static ArrayList<Food> getFoodBySeller(int sellerId)
    {
        ArrayList<Food> foodlist = new ArrayList<Food>();
        Seller seller = DatabaseSeller.getSellerById(sellerId);

        for(Food food : FOOD_DATABASE)
        {
            if(seller.equals(food.getSeller()))
            {
                foodlist.add(food);
            }
        }
        return foodlist;
    }
    
    /**
     * Get the Array list of Food by Category
     *
     * @return boolean to true, if food was removed
     */
    public static ArrayList<Food> getFoodByCategory (FoodCategory foodCategory)
    {
        ArrayList<Food> foodlist = new ArrayList<Food>();

        for(Food food : FOOD_DATABASE)
        {
            if (foodCategory.equals(food.getCategory()))
            {
            foodlist.add(food);
            }
        }
        return foodlist;
    }

    /**
     * Adding Food
     *
     * @return true
     */
    public static boolean addFood(Food food)
    {
        FOOD_DATABASE.add(food);
        lastid = food.getId();

        return true;
    }

    /**
     * Removing Food
     *
     * @return true
     */
    public static boolean removeFood(int id)
    {
        for(Food food : FOOD_DATABASE)
        {
            if(id == food.getId())
            {
                FOOD_DATABASE.remove(food);
                return true;
            }
        }
        return false;
    }
}
