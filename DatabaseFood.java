
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
    private String[] listFood;

    /**
     * Constructor for objects of class DatabaseFood
     * 
     * @param listFood (the list of food in the database)
     */
    public DatabaseFood()
    {
        this.listFood = listFood;
    }

    /**
     * Adding food
     *
     * @return boolean to true, if food was added
     */
    public boolean addFood(Food food)
    {
        return true;
    }
    
    /**
     * Removing food
     *
     * @return boolean to true, if food was removed
     */
    public boolean removeFood(Food food)
    {
        return true;
    }
    
    //return food passed to the constructor
    public Food getFood()
    {
        return null;
    }
    
    /**
     * Gets the food list of DatabaseFood
     *
     * @return listFood
     */
    public String[] getListFood()
    {
        return listFood;
    }
}
