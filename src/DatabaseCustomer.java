import java.util.ArrayList;

/**
 * Class DatabaseCustomer. Contain the database of the customer
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 */
public class DatabaseCustomer
{
    /**
     * Below are the variable for class DatabaseCustomer
     */
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();
    private static int lastid = 0;

    /**
     * Constructor for objects of class DatabaseFood
     * 
     * @param listFood (the list of food in the database)
     */

    /**
     * Get the Array list of CustomerDatabase
     *
     * @return CUSTOMER_DATABASE
     */
    public static ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
    }

    /**
     * Get the last ID of CustomerDatabase
     *
     * @return lastid
     */
    public static int getLastid()
    {
        return lastid;
    }

    /**
     * Getting Customer Id
     *
     * @return true
     */
    public static Customer getCustomerById(int id)
    {
        for(Customer customer : CUSTOMER_DATABASE)
        {
            if(id == customer.getId())
            {
                return customer;
            }
        }
        return null;
    }

    /**
     * Adding customer to database
     *
     * @return true
     */
    public static boolean addCustomer(Customer customer)
    {
        for(Customer customerLagi : CUSTOMER_DATABASE)
        {
            if (customerLagi.getEmail().equals(customerLagi.getEmail()))
            {
                return false;
            }
        }

        CUSTOMER_DATABASE.add(customer);
        lastid = customer.getId();

        return true;
    }

    /**
     * Removing customer to database
     *
     * @return true
     */
    public static boolean removeCustomer(int id)
    {
        for(Customer customer : CUSTOMER_DATABASE)
        {
            if(id == customer.getId())
            {
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        return false;
    }
}