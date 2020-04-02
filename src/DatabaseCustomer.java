import java.util.ArrayList;

/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseCustomer
{
    // instance variables - replace the example below with your own
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();
    private static int lastid = 0;

    /**
     * Constructor for objects of class DatabaseFood
     * 
     * @param listFood (the list of food in the database)
     */
    

    /**
     /**
     * Adding Seller
     *
     * @return boolean to true, if food was added
     */
    public static ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
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
    public static Customer getCustomerById(int id)
    {
        for(int i=0; i < CUSTOMER_DATABASE.size(); i++)
        {
            if(id == CUSTOMER_DATABASE.get(i).getId())
            {
                return CUSTOMER_DATABASE.get(i);
            }
        }
        return null;
    }

    /**
     * Adding Seller
     *
     * @return boolean to true, if food was added
     */
    public static boolean addCustomer(Customer customer)
    {
        CUSTOMER_DATABASE.add(customer);
        lastid = customer.getId();

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
        for(int i = 0; i < CUSTOMER_DATABASE.size(); i++)
        {
            if(id == CUSTOMER_DATABASE.get(i).getId())
            {
                CUSTOMER_DATABASE.remove(i);
                sellerRemoved = true;
            }
        }
        return true;
    }
}