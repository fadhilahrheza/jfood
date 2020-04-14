package fadhilahrheza.jfood;
public class PromoNotFoundException extends Exception
{
    /**
     * Below are the variable for class PromoNotFoundException
     */
    private int promo_error;

    /**
     * Constructor for objects of class PromoNotFoundException
     *
     */
    public PromoNotFoundException(int promo_input)
    {
        super("Promo ID : ");
        this.promo_error = promo_input;
    }

    @Override
    public String getMessage()
    {
        return super.getMessage() + promo_error + " not found";
    }
}
