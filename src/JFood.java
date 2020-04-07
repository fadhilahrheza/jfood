import javax.xml.crypto.Data;
import java.util.*;
import java.util.regex.*;
import java.lang.Object;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

    public class JFood
{        
    public static void main(String[] args)
    {
        //CS
        DatabaseSeller basedataSeller = new DatabaseSeller();
        DatabaseFood basedataFood = new DatabaseFood();
        DatabaseCustomer basedataCustomer = new DatabaseCustomer();

        Location baselocation = new Location("Jakarta Selatan", "Sepi", "DKI Jakarta");

        basedataSeller.addSeller(new Seller(DatabaseSeller.getLastid()+1, "EJA", "eja@gmail.com", "085817661578", baselocation));

        basedataCustomer.addCustomer(new Customer(DatabaseCustomer.getLastid()+1, "EJA", "eja@gmail.com", "Abcd1234", new GregorianCalendar(2020, 3, 1)));
        basedataCustomer.addCustomer(new Customer(DatabaseCustomer.getLastid()+1, "EJA", "eja@gmail.com", "Abcd1234", 2020, 3, 1));
        basedataCustomer.addCustomer(new Customer(DatabaseCustomer.getLastid()+1, "Rama", "mkharisma@gmail.com", "4567"));

        for (Customer customer : DatabaseCustomer.getCustomerDatabase())
        {
            System.out.println(customer);
            System.out.println("");
        }

        basedataFood.addFood(new Food(DatabaseFood.getLastId()+1, "Fries", DatabaseSeller.getSellerById(1), 10000, FoodCategory.Western));
        basedataFood.addFood(new Food(DatabaseFood.getLastId()+1, "Macha Tea", DatabaseSeller.getSellerById(1), 15000, FoodCategory.Japanese));
        basedataFood.addFood(new Food(DatabaseFood.getLastId()+1, "Nasi", DatabaseSeller.getSellerById(1), 5000, FoodCategory.Rice));

        for (Food food : DatabaseFood.getFoodByCategory(FoodCategory.Western))
        {
            System.out.println(food);
            System.out.println("");
        }

        //Post Test
        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastid() + 1, "YEET", 5000, 20000, true));
        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastid() + 1, "YEET", 5000, 20000, false));

        System.out.println("\nDaftar Promo: ");
        for (Promo promo : DatabasePromo.getPromoDatabase())
        {
            System.out.println(promo);
            System.out.println("");
        }

        ArrayList<Food> foods1 = new ArrayList<>();
        foods1.add(DatabaseFood.getFoodById(1));
        ArrayList<Food> foods2 = new ArrayList<>();
        foods2.add(DatabaseFood.getFoodById(2));
        foods2.add(DatabaseFood.getFoodById(3));

        DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1, foods1, DatabaseCustomer.getCustomerById(1), 2000));
        for (Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1))
        {
            invoice.setTotalPrice();
        }
        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, foods2, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(DatabasePromo.getLastid())));
        for (Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1))
        {
            invoice.setTotalPrice();
        }

        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            System.out.println(invoice.toString() + "\n");
        }


        for (Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1))
        {
            invoice.setInvoiceStatus(InvoiceStatus.Finished);
        }

        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, foods1, DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoById(DatabasePromo.getLastid())));
        DatabasePromo.activePromo(DatabasePromo.getLastid());

        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            invoice.setTotalPrice();
        }

        System.out.println("\nDaftar Invoice: ");
        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            System.out.println(invoice.toString() + "\n");
        }
    }
}