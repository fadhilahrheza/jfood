package fadhilahrheza.jfood.controller;

import fadhilahrheza.jfood.*;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;

/**
 * Here is the FoodController class.
 * The class manage food data
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 */

@RequestMapping("/food")
@RestController
public class FoodController
{
    /**
     *  The method is used to return all food in DatabaseFood
     *
     * @return Arraylist<Food>
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood()
    {
        return DatabaseFood.getFoodDatabase();
    }

    /**
     * The method below is used to return food using ID of the food
     *
     * @param id
     * @return Food
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Food getFoodById(@PathVariable int id)
    {
        Food food = null;
        try
        {
            food = DatabaseFood.getFoodById(id);
            return food;
        }
        catch (FoodNotFoundException e)
        {
            e.getMessage();
            return null;
        }
    }

    /**
     * The method below is used to return all food that are sold by seller
     *
     * @param sellerid
     * @return ArrayList<Food>
     */
    @RequestMapping(value = "/seller/{sellerid}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerid)
    {
        {
            ArrayList<Food> foodsBySeller = null;
            foodsBySeller = DatabaseFood.getFoodBySeller(sellerid);
            return foodsBySeller;
        }
    }

    /**
     * The method below is used to return all food to their own category
     *
     * @param category
     * @return ArrayList<Food>
     */
    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category)
    {
        {
            ArrayList<Food> foodByCategory = null;
            foodByCategory = DatabaseFood.getFoodByCategory(category);
            return foodByCategory;
        }
    }

    /**
     * The method below is used to add a food to the DatabaseFood
     *
     * @param name
     * @param price
     * @param category
     * @param sellerId
     * @return Food
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value = "name") String name,
                        @RequestParam(value = "price") int price,
                        @RequestParam(value = "category") FoodCategory category,
                        @RequestParam(value = "sellerid") int sellerId)
    {
        try
        {
            Food newFood = new Food(DatabaseFood.getLastId()+1, name, DatabaseSeller.getSellerById(sellerId), price, category);
            DatabaseFood.addFood(newFood);
            return newFood;
        }
        catch (SellerNotFoundException e)
        {
            e.getMessage();
            return null;
        }
    }
}
