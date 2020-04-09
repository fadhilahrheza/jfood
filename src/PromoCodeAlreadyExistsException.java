public class PromoCodeAlreadyExistsException extends Exception
{
    /**
     * Below are the variable for class PromoCodeAlreadyExistsException
     */
    private Promo promo_error;

    /**
     * Constructor for objects of class PromoCodeAlreadyExistsException
     *
     */
    public PromoCodeAlreadyExistsException(Promo promo_input)
    {
        super("Promo Code : ");
        this.promo_error = promo_input;
    }

    @Override
    public String getMessage()
    {
        return super.getMessage() + promo_error.getCode() + " already exists.";
    }
}
