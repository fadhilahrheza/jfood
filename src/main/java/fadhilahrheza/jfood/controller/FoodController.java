package fadhilahrheza.jfood.controller;

import fadhilahrheza.jfood.*;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;

@RequestMapping("/food")
@RestController
public class FoodController
{
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood()
    {
        return DatabaseFood.getFoodDatabase();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Food getFoodById(@PathVariable int id)
    {
        Food food = null;
        try
        {
            food = DatabaseFood.getFoodById(id);
        }
        catch (FoodNotFoundException e)
        {
            e.getMessage();
            return null;
        }
        return food;
    }

    @RequestMapping(value = "/sellerid", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(int sellerid)
    {
        {
            ArrayList<Food> foodsBySeller = null;
            foodsBySeller = DatabaseFood.getFoodBySeller(sellerid);
            return foodsBySeller;
        }
    }

    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category)
    {
        {
            ArrayList<Food> foodlagi = null;
            foodlagi = DatabaseFood.getFoodByCategory(category);
            return foodlagi;
        }
    }

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
