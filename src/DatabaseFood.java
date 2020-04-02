import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Here is the class DatabaseFood.
 * Inside this class, contains the list of food in the database.
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 * @since 2020-02-27
 */
public class DatabaseFood
{
    /**
     * Below are the variable for class Customer
     */
    private static ArrayList<Food> FOOD_DATABASE;
    private static int lastid = 0;

    /**
     * Constructor for objects of class DatabaseFood
     * 
     * @param listFood (the list of food in the database)
     */

    /**
     * Adding Seller
     *
     * @return boolean to true, if food was added
     */
    public static ArrayList<Food> getFoodDatabase()
    {
        return FOOD_DATABASE;
    }

    /**
     * Adding Seller
     *
     * @return boolean to true, if food was added
     */
    public static int getLastId()
    {
        return lastid;
    }

    /**
     * Adding food
     *
     * @return boolean to true, if food was added
     */
    public static Food getFoodById(int id)
    {
        for(int i=0; i < FOOD_DATABASE.size(); i++)
        {
            if(id == FOOD_DATABASE.get(i).getId())
            {
                return FOOD_DATABASE.get(i);
            }
        }
        return null;
    }

    /**
     * Adding food
     *
     * @return boolean to true, if food was added
     */
    public static ArrayList<Food> getFoodBySeller(int sellerId)
    {
        ArrayList<Food> foodlist = new ArrayList<Food>();
        boolean list;

        for(int i=0; i < FOOD_DATABASE.size(); i++)
        {
            if(sellerId == FOOD_DATABASE.get(i).getSeller().getId())
            {
                foodlist.add(FOOD_DATABASE.get(i));
                list = true;
            }
        }
        if(list = true)
        {
            return foodlist;
        }
        return null;
    }
    
    /**
     * Removing food
     *
     * @return boolean to true, if food was removed
     */
    public static ArrayList<Food> getFoodByCategory (FoodCategory foodCategory)
    {
        ArrayList<Food> foodlist = new ArrayList<Food>();
        boolean list;

        for(int i=0; i < FOOD_DATABASE.size(); i++)
        {
            if (foodCategory == FOOD_DATABASE.get(i).getCategory())
            {
            foodlist.add(FOOD_DATABASE.get(i));
            list = true;
            }
        }
        return null;
    }

    /**
     * Adding Seller
     *
     * @return boolean to true, if food was added
     */
    public static boolean addFood(Food food)
    {
        FOOD_DATABASE.add(food);
        lastid = food.getId();

        return true;
    }

    /**
     * Removing Seller
     *
     * @return boolean to true, if food was removed
     */
    public static boolean removeFood(int id)
    {
        boolean foodRemoved = false;
        for(int i = 0; i < FOOD_DATABASE.size(); i++)
        {
            if(id == FOOD_DATABASE.get(i).getId())
            {
                FOOD_DATABASE.remove(i);
                foodRemoved = true;
            }
        }
        return true;
    }
}
