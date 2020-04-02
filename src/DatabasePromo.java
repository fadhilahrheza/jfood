import java.util.ArrayList;

/**
 * Here is the class DatabasePromo.
 * Inside this class, promo database.
 * 
 * @author Fadhilah Rheza P
 * @version 1.0
 * @since 2020-03-12
 */
public class DatabasePromo
{
    // instance variables - replace the example below with your own
    private static ArrayList<Promo> PROMO_DATABASE;
    private static int lastid = 0;

    /**
     * Constructor for objects of class DatabasePromo
     */


    /**
     /**
     * Adding Seller
     *
     * @return boolean to true, if food was added
     */
    public static ArrayList<Promo> getPromoDatabase()
    {
        return PROMO_DATABASE;
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
    public static Promo getCustomerById(int id)
    {
        for(int i=0; i < PROMO_DATABASE.size(); i++)
        {
            if(id == PROMO_DATABASE.get(i).getId())
            {
                return PROMO_DATABASE.get(i);
            }
        }
        return null;
    }

    /**
     * Adding Seller
     *
     * @return boolean to true, if food was added
     */
    public static Promo getPromoByCode(String code)
    {
        for(int i=0; i < PROMO_DATABASE.size(); i++)
        {
            if(code == PROMO_DATABASE.get(i).getCode())
            {
                return PROMO_DATABASE.get(i);
            }
        }
        return null;
    }

    public static boolean addPromo(Promo promo)
    {
        for(int i=0; i < PROMO_DATABASE.size(); i++)
        {
            if (promo.getCode() ==PROMO_DATABASE.get(i).getCode())
            {
                return false;
            }
        }
        PROMO_DATABASE.add(promo);
        lastid = promo.getId();

        return true;
    }

    public static boolean activePromo(int id)
    {
        boolean status = false;

        for(int i=0; i < PROMO_DATABASE.size(); i++)
        {
            if(id == PROMO_DATABASE.get(i).getId())
            {
                PROMO_DATABASE.get(i).setActive(true);
                status = true;
            }
        }
        return false;
    }

    public static boolean deactivePromo(int id)
    {
        boolean status = false;

        for(int i=0; i < PROMO_DATABASE.size(); i++)
        {
            if(id == PROMO_DATABASE.get(i).getId())
            {
                PROMO_DATABASE.get(i).setActive(false);
                status = true;
            }
        }
        return false;
    }

    public static boolean removePromo(int id)
    {
        boolean promoRemoved = false;

        for(int i=0; i < PROMO_DATABASE.size(); i++)
        {
            if(id == PROMO_DATABASE.get(i).getId())
            {
                PROMO_DATABASE.remove(i);
                promoRemoved = true;
            }
        }
        return promoRemoved;
    }
}
