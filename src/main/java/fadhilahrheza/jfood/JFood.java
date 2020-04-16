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
        SpringApplication.run(JFood.class, args);
        Location location1 = new Location("Jakarta", "Lockdown", "Jakarta");
        Location location2 = new Location("Depok", "Lockdown", "Depok");
        Location location3 = new Location("Malang", "Lockdown", "Malang");

        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastid()+1, "Eja","eja.fadhil@gmail.com", "089817661578", location1));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastid()+1, "Yudhis","yudhis.I@gmail.com", "089817661578", location2));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastid()+1, "Titus","titus.b@gmail.com", "089817661578", location3));

        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Kebab", DatabaseSeller.getSellerById(2), 10000, FoodCategory.Western));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Nasi", DatabaseSeller.getSellerById(2), 5000, FoodCategory.Rice));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Kopi", DatabaseSeller.getSellerById(3), 12000, FoodCategory.Coffee));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Sushi", DatabaseSeller.getSellerById(2), 18000, FoodCategory.Japanese));
        }
        catch (SellerNotFoundException e)
        {
            e.getMessage();
        }

    }
}