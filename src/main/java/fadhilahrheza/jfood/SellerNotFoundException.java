package fadhilahrheza.jfood;
public class SellerNotFoundException extends Exception
{
    /**
     * Below are the variable for class SellerNotFoundException
     */
    private int seller_error;

    /**
     * Constructor for objects of class SellerNotFoundException
     *
     */
    public SellerNotFoundException(int seller_input)
    {
        super("Seller ID : ");
        this.seller_error = seller_input;
    }

    @Override
    public String getMessage()
    {
        return super.getMessage() + seller_error + " not found";
    }
}
