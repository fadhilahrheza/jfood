package fadhilahrheza.jfood;
import java.util.ArrayList;

/**
 * Here is the class DatabaseSeller
 * Contain the database of seller.
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 */
public class DatabaseSeller
{
    /**
     * Below are the variable for class DatabaseSeller
     */
    private static ArrayList<Seller> SELLER_DATABASE = new ArrayList<Seller>();
    private static int lastid = 0;

    /**
     * Get the Array list of SellerDatabase
     *
     * @return SELLER_DATABASE
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
     * Getting Seller by Id
     *
     * @return lastid
     */
    public static Seller getSellerById(int id) throws SellerNotFoundException
    {
        for(Seller seller : SELLER_DATABASE)
        {
            if(id == seller.getId())
            {
                return seller;
            }
        }
        throw new SellerNotFoundException(id);
    }

   /**
     * Adding Seller
     *
     * @return true
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
     * @return true
     */
    public static boolean removeSeller(int id) throws SellerNotFoundException
    {
        for(Seller seller : SELLER_DATABASE)
        {
            if(id == seller.getId())
            {
                SELLER_DATABASE.remove(seller);
                return true;
            }
        }
        throw new SellerNotFoundException(id);
    }
}
