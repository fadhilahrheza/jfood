package fadhilahrheza.jfood;
import jdk.jfr.Category;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class DatabaseFood.
 * Contain the database of Food
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
    public static Food getFoodById(int id) throws FoodNotFoundException
    {
        for(Food food : FOOD_DATABASE)
        {
            if(id == food.getId())
            {
                return food;
            }
        }
        throw new FoodNotFoundException(id);
    }

    /**
     * Get the Array list of Food by Seller
     *
     * @return foodlist
     */
    public static ArrayList<Food> getFoodBySeller(int sellerId)
    {
        ArrayList<Food> foodlist = new ArrayList<Food>();

        for(Food food : FOOD_DATABASE)
        {
            if(food.getSeller().getId() == sellerId)
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
    public static boolean removeFood(int id) throws FoodNotFoundException
    {
        for(Food food : FOOD_DATABASE)
        {
            if(id == food.getId())
            {
                FOOD_DATABASE.remove(food);
                return true;
            }
        }
        throw new FoodNotFoundException(id);
    }
}
