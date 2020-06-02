package fadhilahrheza.jfood;
/**
 * Enumeration class FoodCategory
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 */
public enum FoodCategory
{
    Beverages("Beverages"), 
    Coffee("Coffee"),
    Western("Western"),
    Snacks("Snacks"),
    Rice("Rice"),
    Noodles("Noodles"),
    Bakery("Bakery"),
    Japanese("Japanese");

    /**
     * Below are the variable for class FoodCategory
     */
    private String category;

    /**
     * Constructor for objects of class FoodCategory
     *
     * @param category
     */
    FoodCategory(String category)
    {
        this.category = category;
    }

    /**
     * To return category
     * @return category
     */
    public String toString()
    {
        return category;
    }
}
