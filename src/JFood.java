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
        Location baselocation = new Location("Jakarta", "Sepi", "Jakarta");
        try
        {
            DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastid()+1, "Eja", "Eja@gmail.com", "081413565xxx", baselocation));
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Thai Tea", DatabaseSeller.getSellerById(1), 5000, FoodCategory.Beverages));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Latte", DatabaseSeller.getSellerById(1), 12000, FoodCategory.Beverages));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Nasi", DatabaseSeller.getSellerById(1), 20000, FoodCategory.Japanese));
        }
        catch (FoodNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        ArrayList<Food> list1 = new ArrayList<Food>();
        try
        {
            list1.add(DatabaseFood.getFoodById(1));
        }
        catch (FoodNotFoundException e)
        {
            System.out.println(e.getMessage());
        }


        ArrayList<Food> list2 = new ArrayList<Food>();
        try
        {
            list2.add(DatabaseFood.getFoodById(2));
            list2.add(DatabaseFood.getFoodById(3));
        }
        catch (FoodNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastid()+1, "Eja", "eja.fadhil@gmail.com", "Qwerty!123"));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastid() +1, "Eja", "eja.fadhila@gmail.com", "qWerty!123"));
            DatabaseCustomer.addCustomer(new Customer (DatabaseCustomer.getLastid() + 1, "Rama", "rama@gmail.com", "123WQERTY!"));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastid()+1, "Kharisma", "mkharisma@gmail.com", "321WQERTY@"));

        }
        catch (EmailAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }


        try
        {
            DatabaseFood.removeFood(30);
        }
        catch (FoodNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseFood.getFoodById(30);
        }
        catch (FoodNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseCustomer.getCustomerById(30);
        }
        catch (CustomerNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseCustomer.removeCustomer(30);
        }
        catch (CustomerNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseSeller.removeSeller(30);
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseSeller.getSellerById(30);
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabasePromo.removePromo(30);
        }
        catch (PromoNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabasePromo.getPromoById(30);
        }
        catch (PromoNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabasePromo.addPromo(new Promo (DatabasePromo.getLastid() + 1, "MODUL7", 1000, 10000, true));
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastid()+1, "MODUL7", 1200, 30000, true));
        }
        catch (PromoCodeAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("==========YANG MASUK DATABASE CUSTOMER============");
        for(Customer customers : DatabaseCustomer.getCustomerDatabase())
        {
            System.out.println(customers);
            System.out.println();
        }

        System.out.println("==========YANG MASUK DATABASE PROMO============");
        for(Promo promos : DatabasePromo.getPromoDatabase())
        {
            System.out.println(promos);
            System.out.println();
        }

        System.out.println("==========YANG MASUK DATABASE FOOD============");
        for(Food foods : DatabaseFood.getFoodDatabase())
        {
            System.out.println(foods);
            System.out.println();
        }

        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1,
                list1, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(1)));
        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1,
                list2, DatabaseCustomer.getCustomerById(2)));

        //Post Test
        //DatabasePromo.addPromo(new Promo(DatabasePromo.getLastid() + 1, "YEET", 5000, 20000, true));
        //DatabasePromo.addPromo(new Promo(DatabasePromo.getLastid() + 1, "YEET", 5000, 20000, false));

        //System.out.println("\nDaftar Promo: ");
        //for (Promo promo : DatabasePromo.getPromoDatabase())
        //{
        //    System.out.println(promo);
        //    System.out.println("");
        //}

        //ArrayList<Food> foods1 = new ArrayList<>();
        //foods1.add(DatabaseFood.getFoodById(1));
        //ArrayList<Food> foods2 = new ArrayList<>();
        //foods2.add(DatabaseFood.getFoodById(2));
        //foods2.add(DatabaseFood.getFoodById(3));

        //DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1, foods1, DatabaseCustomer.getCustomerById(1), 2000));
        //for (Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1))
        //{
        //   invoice.setTotalPrice();
        //}
        //DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, foods2, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(DatabasePromo.getLastid())));
        //for (Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1))
        //{
        //    invoice.setTotalPrice();
        //}

        //for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        //{
        //   System.out.println(invoice.toString() + "\n");
        //}


        //for (Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1))
        //{
        //    invoice.setInvoiceStatus(InvoiceStatus.Finished);
        //}

        //DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, foods1, DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoById(DatabasePromo.getLastid())));
        //DatabasePromo.activePromo(DatabasePromo.getLastid());

        //for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        //{
        //    invoice.setTotalPrice();
        //}

        //System.out.println("\nDaftar Invoice: ");
        //for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        //{
        //    System.out.println(invoice.toString() + "\n");
        //}
    }
}