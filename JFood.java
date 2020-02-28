    public class JFood
{        
    public static void main(String[] args)
    {
        Location locObj = new Location("Jakarta", "Macet", "Jakarta");
        
        Seller selObj = new Seller(1706042863, "Fadhilah Rheza P", "eja.fadhil@gmail.com", "085817661578", locObj);
        
        Food foodObj = new Food(1, "Pizza", selObj, 9, "suka");
        
        Customer cusObj = new Customer(12, "Ika", "ik.kw@gmail.com", "patapon", "12 Juni 2020");
        
        Invoice invObj = new Invoice(17, 13, "18 Maret 2020", 20, cusObj);
        
        selObj.printName();
        
        selObj.setName("Rama");
        selObj.printName();
        
        foodObj.printData();
    }
}