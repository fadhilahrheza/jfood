    public class JFood
{        
    public static void main(String[] args)
    {
        Location locObj = new Location("Jakarta", "Macet", "Jakarta");
        
        Seller selObj = new Seller(1706042863, "Fadhilah Rheza P", "eja.fadhil@gmail.com", "085817661578", locObj);
        
        Food foodObj1 = new Food(1, "Martabak", selObj, 20000, FoodCategory.Western);
        
        Food foodObj2 = new Food(2, "Gorengan", selObj, 2000, FoodCategory.Western);
        
        Customer cusObj = new Customer(11, "Timothy", "tim.tim@gmail.com", "patapon", "12 Juni 2020");
        
        ////Invoice invoice1 = new Invoice(0001, 001, "28-02-2020", pelangganPertama, 20000, InvoiceStatus.Finished);
        
        Promo promObj = new Promo(1, "LinkAja101", 5000, 10000, true);
        
        CashlessInvoice cashinObj1 = new CashlessInvoice(1, foodObj1, "3/3/2020", cusObj, InvoiceStatus.Ongoing);
        
        CashlessInvoice cashinObj2 = new CashlessInvoice(2, foodObj2, "3/3/2020", cusObj, InvoiceStatus.Ongoing, promObj);
        
        CashlessInvoice cashinObj3 = new CashlessInvoice(3, foodObj1, "3/3/2020", cusObj, InvoiceStatus.Ongoing, promObj);
        
        cashinObj1.setTotalPrice();
        cashinObj2.setTotalPrice();
        cashinObj3.setTotalPrice();
        
        cashinObj1.printData();
        cashinObj2.printData();
        cashinObj3.printData();
    }
}