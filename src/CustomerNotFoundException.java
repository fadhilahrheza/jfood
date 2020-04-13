public class CustomerNotFoundException extends Exception
{
    /**
     * Below are the variable for class CustomerNotFoundException
     */
    private int customer_error;

    /**
     * Constructor for objects of class CustomerNotFoundException
     *
     */
    public CustomerNotFoundException(int customer_input)
    {
        super("Customer ID : ");
        this.customer_error = customer_input;
    }

    @Override
    public String getMessage()
    {
        return super.getMessage() + customer_error + " not found";
    }
}
