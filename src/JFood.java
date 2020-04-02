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
        //Location locObj = new Location("Jakarta", "Macet", "Jakarta");
        
        //Seller selObj = new Seller(1706042863, "Fadhilah Rheza P", "eja.fadhil@gmail.com", "085817661578", locObj);
        
        //Food foodObj1 = new Food(1, "Martabak", selObj, 50000, FoodCategory.Western);
        //Food foodObj2 = new Food(2, "Gorengan", selObj, 5000, FoodCategory.Western);
        //Food foodObj3 = new Food(3, "Martabak", selObj, 50000, FoodCategory.Western);
        //Food foodObj4 = new Food(4, "Martabak", selObj, 15000, FoodCategory.Western);
        //Food foodObj5 = new Food(5, "Martabak", selObj, 15000, FoodCategory.Western);
        
        //Customer cusObj1 = new Customer(11, "Timothy", "..tim@gmail.com", "12345", new GregorianCalendar(2020, 0, 10));
        //Customer cusObj2 = new Customer(12, "Jony Jony", "John@gmail.com", "Pata12", 2020, 3, 10);
        //Customer cusObj3 = new Customer(11, "Freya", "Freya24@gmail.com", "Jormund1", 2020, 5, 12);
        
        //System.out.println(cusObj1.toString());
        //System.out.println(cusObj2.toString());
        //System.out.println(cusObj3.toString());
        
        ////Invoice invoiceObj = new Invoice(0001, 001, "28-02-2020", pelangganPertama, 20000, InvoiceStatus.Finished);
        
        //Promo promObj = new Promo(1, "LinkAja101", 10000, 20000, true);
        
        //CashInvoice cashObj1 = new CashInvoice(4, foodObj4, cusObj1, InvoiceStatus.Finished);
        
        //CashInvoice cashObj2 = new CashInvoice(5, foodObj5, "3/3/2020", cusObj, InvoiceStatus.Finished, 10000);
        
        //CashlessInvoice cashinObj1 = new CashlessInvoice(1, foodObj1, cusObj2, InvoiceStatus.Ongoing);
        
        //CashlessInvoice cashinObj2 = new CashlessInvoice(2, foodObj2, "3/3/2020", cusObj, InvoiceStatus.Ongoing, promObj);
        
        //CashlessInvoice cashinObj3 = new CashlessInvoice(3, foodObj3, "3/3/2020", cusObj, InvoiceStatus.Ongoing, promObj);
        
        //cashinObj1.setTotalPrice();
        //cashinObj2.setTotalPrice();
        //cashinObj3.setTotalPrice();
        //cashObj1.setTotalPrice();
        //cashObj2.setTotalPrice();
        
        //System.out.println(cashObj1.toString());
        //System.out.println(cashinObj1.toString());
        //cashinObj1.printData();
        //cashinObj2.printData();
        //cashinObj3.printData();
        //cashObj1.printData();
        //cashObj2.printData();

        DatabaseSeller basedatabaseseller = new DatabaseSeller();
        DatabaseFood basedatabasefood = new DatabaseFood();
        DatabaseCustomer basedatabasecustomer = new DatabaseCustomer();

        Location baselocation = new Location("Jakarta Selatan", "Sepi", "DKI Jakarta");

        basedatabaseseller.addSeller(new Seller(1, "EJA", "eja@gmail.com", "085817661578", baselocation));


        basedatabasecustomer.addCustomer(new Customer(1, "EJA", "eja@gmail.com", "1234", new GregorianCalendar(2020, 3, 1)));
        basedatabasecustomer.addCustomer(new Customer(2, "EJA", "eja@gmail.com", "Abcd1234", 2020, 3, 2));
        basedatabasecustomer.addCustomer(new Customer(3, "Rama", "rama@gmail.com", ""));

        System.out.println(basedatabasecustomer.getCustomerDatabase());

        basedatabasefood.addFood(new Food(1, "Paket Sehat Bahari 1", basedatabaseseller.getSellerById(1), 15000, FoodCategory.Beverages));
        basedatabasefood.addFood(new Food(2, "Paket Sehat Bahari 2", basedatabaseseller.getSellerById(1), 3000, FoodCategory.Beverages));
        basedatabasefood.addFood(new Food(3, "Paket Sehat Bahari 3", basedatabaseseller.getSellerById(1), 5000, FoodCategory.Japanese));

        System.out.println(basedatabasefood.getFoodByCategory(FoodCategory.Beverages));
    }
}