    public class JFood
{        
    public static void main(String[] args)
    {
        Location locObj = new Location("Jakarta", "Macet", "Jakarta");
        
        Seller selObj = new Seller(1706042863, "Fadhilah Rheza P", "eja.fadhil@gmail.com", "085817661578", locObj);
        
        Food foodObj = new Food(1, "Hamburger", selObj, 45000, FoodCategory.Western);
        
        Customer cusObj = new Customer(11, "Timothy", "tim.tim@gmail.com", "patapon", "12 Juni 2020");
        
        Invoice invObj = new Invoice(1, foodObj.getId(), "2020-01-01", foodObj.getPrice(), cusObj, InvoiceStatus.Finished);
      
        
        invObj.printData();
    }
}