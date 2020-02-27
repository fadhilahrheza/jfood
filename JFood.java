public class JFood
{
    public static void main(String[] args)
    {
        Location locObj = new Location("Jakarta", "Macet", "Jakarta");
        locObj.printData();
        
        Seller selObj = new Seller(1, "Fred", "09-01-1990", "911", locObj);
        selObj.printData();
    }
}
