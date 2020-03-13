    public class JFood
{        
    public static void main(String[] args)
    {
        Location locObj = new Location("Jakarta", "Macet", "Jakarta");
        
        Seller selObj = new Seller(1706042863, "Fadhilah Rheza P", "eja.fadhil@gmail.com", "085817661578", locObj);
        
        Food foodObj1 = new Food(1, "Martabak", selObj, 50000, FoodCategory.Western);
        
        Food foodObj2 = new Food(2, "Gorengan", selObj, 5000, FoodCategory.Western);
        
        Food foodObj3 = new Food(3, "Martabak", selObj, 50000, FoodCategory.Western);
        
        Food foodObj4 = new Food(4, "Martabak", selObj, 15000, FoodCategory.Western);
        
        Food foodObj5 = new Food(5, "Martabak", selObj, 15000, FoodCategory.Western);
        
        Customer cusObj = new Customer(11, "Timothy", "tim.tim@gmail.com", "patapon", "12 Juni 2020");
        
        Customer cusObj3 = new Customer(11, "Jony Jony", "tim.tim@gmail.com", "patapon", "12 Juni 2020");
        
        ////Invoice invoiceObj = new Invoice(0001, 001, "28-02-2020", pelangganPertama, 20000, InvoiceStatus.Finished);
        
        Promo promObj = new Promo(1, "LinkAja101", 10000, 20000, true);
        
        CashInvoice cashObj1 = new CashInvoice(4, foodObj4, "3/3/2020", cusObj, InvoiceStatus.Finished);
        
        CashInvoice cashObj2 = new CashInvoice(5, foodObj5, "3/3/2020", cusObj, InvoiceStatus.Finished, 10000);
        
        CashlessInvoice cashinObj1 = new CashlessInvoice(1, foodObj1, "3/3/2020", cusObj, InvoiceStatus.Ongoing);
        
        CashlessInvoice cashinObj2 = new CashlessInvoice(2, foodObj2, "3/3/2020", cusObj, InvoiceStatus.Ongoing, promObj);
        
        CashlessInvoice cashinObj3 = new CashlessInvoice(3, foodObj3, "3/3/2020", cusObj, InvoiceStatus.Ongoing, promObj);
        
        cashinObj1.setTotalPrice();
        cashinObj2.setTotalPrice();
        cashinObj3.setTotalPrice();
        cashObj1.setTotalPrice();
        cashObj2.setTotalPrice();
        
        cashinObj1.printData();
        cashinObj2.printData();
        cashinObj3.printData();
        cashObj1.printData();
        cashObj2.printData();
    }
}