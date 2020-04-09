import java.util.ArrayList;

/**
 * Here is the class DatabasePromo. Contain the database of promo
 * 
 * @author Fadhilah Rheza P
 * @version 1.0
 */
public class DatabasePromo
{
    /**
     * Below are the variable for class DatabasePromo
     */
    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<Promo>();
    private static int lastid = 0;

    /**
     * Constructor for objects of class DatabasePromo
     */

    /**
     * Get the Array list of PromoDatabase
     *
     * @return PROMO_DATABASE
     */
    public static ArrayList<Promo> getPromoDatabase()
    {
        return PROMO_DATABASE;
    }

    /**
     * Get the last ID of PromoDatabase
     *
     * @return lastid
     */
    public static int getLastid()
    {
        return lastid;
    }

    /**
     * Getting Promo by Id
     *
     * @return promo
     */
    public static Promo getPromoById(int id) throws PromoNotFoundException
    {
        for(Promo promo : PROMO_DATABASE)
        {
            if(id == promo.getId())
            {
                return promo;
            }
        }
        throw new PromoNotFoundException(id);
    }

    /**
     * Getting Promo by Code
     *
     * @return promo
     */
    public static Promo getPromoByCode(String code)
    {
        for(Promo promo : PROMO_DATABASE)
        {
            if(code == promo.getCode())
            {
                return promo;
            }
        }
        return null;
    }

    /**
     * Adding Promo
     *
     * @return true
     */
    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistsException
    {
        for(Promo promoLagi : PROMO_DATABASE)
        {
            if (promoLagi.getCode().equals(promo.getCode()))
            {
                return false;
            }
        }
        PROMO_DATABASE.add(promo);
        lastid = promo.getId();

        throw new PromoCodeAlreadyExistsException(promo);
    }

    /**
     * Active Promo
     *
     * @return true
     */
    public static boolean activePromo(int id)
    {
        for(Promo promo : PROMO_DATABASE)
        {
            if(id == promo.getId())
            {
                promo.setActive(true);
                return true;
            }
        }
        return false;
    }

    /**
     * Deactive Promo
     *
     * @return true
     */
    public static boolean deactivePromo(int id)
    {
        for(Promo promo : PROMO_DATABASE)
        {
            if(id == promo.getId())
            {
                promo.setActive(false);
                return true;
            }
        }
        return false;
    }

    /**
     * Removing Promo
     *
     * @return true
     */
    public static boolean removePromo(int id) throws PromoNotFoundException
    {
        for(Promo promo : PROMO_DATABASE)
        {
            if(id == promo.getId())
            {
                PROMO_DATABASE.remove(promo);
                return true;
            }
        }
        throw new PromoNotFoundException(id);
    }
}
