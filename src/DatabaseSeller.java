import java.util.ArrayList;

/**
 * Write a description of class DatabaseSeller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseSeller
{
    /**
     * Below are the variable for class Customer
     */
    private static ArrayList<Seller> SELLER_DATABASE = new ArrayList<Seller>();
    private static int lastid = 0;

    /**
     * Constructor for objects of class DatabaseSeller
     */

    /**
     * Adding Seller
     *
     * @return boolean to true, if food was added
     */
    public static ArrayList<Seller> getSellerDatabase()
    {
        return SELLER_DATABASE;
    }

    /**
     * Adding Seller
     *
     * @return boolean to true, if food was added
     */
    public static int getLastid()
    {
        return lastid;
    }

    /**
     * Adding Seller
     *
     * @return boolean to true, if food was added
     */
    public static Seller getSellerById(int id)
    {
        for(int i=0; i < SELLER_DATABASE.size(); i++)
        {
            if(id == SELLER_DATABASE.get(i).getId())
            {
                return SELLER_DATABASE.get(i);
            }
        }
        return null;
    }

   /**
     * Adding Seller
     *
     * @return boolean to true, if food was added
     */ 
    public static boolean addSeller(Seller seller)
    {
        SELLER_DATABASE.add(seller);
        lastid = seller.getId();

        return true;
    }
    
    /**
     * Removing Seller
     *
     * @return boolean to true, if food was removed
     */
    public static boolean removeSeller(int id)
    {
        boolean sellerRemoved = false;
        for(int i = 0; i < SELLER_DATABASE.size(); i++)
        {
            if(id == SELLER_DATABASE.get(i).getId())
            {
                SELLER_DATABASE.remove(i);
                sellerRemoved = true;
            }
        }
        return true;
    }
}
