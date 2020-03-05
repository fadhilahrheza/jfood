    public class JFood
{        
    public static void main(String[] args)
    {
        Location locObj = new Location("Jakarta", "Macet", "Jakarta");
        
        Seller selObj = new Seller(1706042863, "Fadhilah Rheza P", "eja.fadhil@gmail.com", "085817661578", locObj);
        
        Food foodObj = new Food(1, "Hamburger", selObj, 30000, FoodCategory.Western);
        
        Customer cusObj = new Customer(12, "Ika", "ik.kw@gmail.com", "patapon", "12 Juni 2020");
        
        Invoice invObj = new Invoice(17, 13, "18 Maret 2020", 20, cusObj);
      
        foodObj.printData();
    }
}