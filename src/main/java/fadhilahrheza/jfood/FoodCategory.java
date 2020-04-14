package fadhilahrheza.jfood;
/**
 * Enumeration class FoodCategory - write a description of the enum class here
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
    
    private String category;
    
    FoodCategory(String category)
    {
        this.category = category;
    }
    
    public String toString()
    {
        return category;
    }
}
