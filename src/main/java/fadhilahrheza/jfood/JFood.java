package fadhilahrheza.jfood;
import javax.xml.crypto.Data;
import java.util.*;
import java.util.regex.*;
import java.lang.Object;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JFood
{        
    public static void main(String[] args)
    {
        /**
         * 3 location object
         */
        Location location1 = new Location("Jakarta", "Lockdown", "Jakarta");
        Location location2 = new Location("Depok", "Lockdown", "Depok");
        Location location3 = new Location("Malang", "Lockdown", "Malang");

        /**
         * 3 Seller object
         */
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastid()+1, "Eja","eja.fadhil@gmail.com", "089817661578", location1));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastid()+1, "Yudhis","yudhis.I@gmail.com", "089817661578", location2));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastid()+1, "Titus","titus.b@gmail.com", "089817661578", location3));

        /**
         * 4 Promo Object
         */
        try
        {
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastid()+1, "aaa", 1000, 10000, true));
        }
        catch (PromoCodeAlreadyExistsException e)
        {
            e.printStackTrace();
        }
        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Kebab", DatabaseSeller.getSellerById(2), 10000, FoodCategory.Western));
        }
        catch (SellerNotFoundException e)
        {
            e.getMessage();
        }

        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Nasi", DatabaseSeller.getSellerById(2), 5000, FoodCategory.Rice));
        }
        catch (SellerNotFoundException e)
        {
            e.getMessage();
        }

        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Kopi", DatabaseSeller.getSellerById(3), 12000, FoodCategory.Coffee));
        }
        catch (SellerNotFoundException e)
        {
            e.getMessage();
        }

        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Sushi", DatabaseSeller.getSellerById(2), 18000, FoodCategory.Japanese));
        }
        catch (SellerNotFoundException e)
        {
            e.getMessage();
        }
        SpringApplication.run(JFood.class, args);
    }
}