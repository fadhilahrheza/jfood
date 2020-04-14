package fadhilahrheza.jfood;
public class EmailAlreadyExistsException extends Exception
{
    /**
     * Below are the variable for class EmailAlreadyExistsException
     */
    private Customer customer_error;

    /**
     * Constructor for objects of class EmailAlreadyExistsException
     *
     */
    public EmailAlreadyExistsException(Customer customer_input)
    {
        super("Customer Email : ");
        this.customer_error = customer_input;
    }

    @Override
    public String getMessage()
    {
        return super.getMessage() + customer_error.getEmail() + " already exists.";
    }
}
