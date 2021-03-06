package fadhilahrheza.jfood;
import java.util.*;
import java.util.regex.*;
import java.lang.Object;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * Here is the class Food.
 * Inside this class, contains information about the food.
 * 
 * @author Fadhilah Rheza P
 * @version 1.0
 * @since 2020-02-27
 */
public class Food
{
    /**
     * Below are the variable for class Food
     */
    private int id;
    private String name;
    private Seller seller;
    private int price;
    private FoodCategory category;

    /**
     * Constructor for objects of class Food
     * 
     * @param id (food's id)
     * @param name (food's name)
     * @param seller (food's seller)
     * @param price (food's price)
     * @param category (food's category)
     */
    public Food(int id, String name, Seller seller, int price, FoodCategory category)
    {
        this.id = id;
        this.name = name;
        this.seller = seller;
        this.price = price;
        this.category = category;
    }

    /**
     * Gets the id of the food
     *
     * @return id
     */
     public int getId()
    {
        return id;
    }
    
    /**
     * Gets the name of the food
     *
     * @return name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets the seller of the food
     *
     * @return seller
     */
    public Seller getSeller()
    {
        return seller;
    }
    
    /**
     * Gets the price of the food
     *
     * @return price
     */
    public int getPrice()
    {
        return price;
    }
    
    /**
     * Gets the category of the food
     *
     * @return category
     */
    public FoodCategory getCategory()
    {
        return category;
    }
    
    /**
     * Sets the id of the food
     * 
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Sets the name of the food
     * 
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Sets the seller of the food
     * 
     * @param seller
     */
    public void setSeller(Seller seller)
    {
        this.seller = seller;
    }
    
    /**
     * Sets the price of the food
     * 
     * @param price
     */
    public void setPrice(int price)
    {
        this.price = price;
    }
    
    /**
     * Sets the category of the food
     * 
     * @param category
     */
    public void setCategory(FoodCategory category)
    {
        this.category = category;
    }
    
    public String toString()
    {
        return "Id = " + getId() + "\nNama = " + getName() + "\nSeller = " + getSeller().getName() + "\nCity = " + getSeller().getLocation().getCity() + "\nPrice = " + getPrice() + "\nCategory = " + getCategory();
    }

    /**
     * The method below to print Food
     */
    public void printData()
    {
        System.out.println("==========FOOD==========");
        System.out.println("ID:"+id);
        System.out.println("Name:"+name);
        System.out.println("Seller:"+seller.getName());
        System.out.println("City:"+seller.getLocation().getCity());
        System.out.println("Price:"+price);
        System.out.println("Category:"+category);
    }
}
