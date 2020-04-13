public class InvoiceNotFoundException extends Exception
{
    /**
     * Below are the variable for class CustomerNotFoundException
     */
    private int invoice_error;

    /**
     * Constructor for objects of class CustomerNotFoundException
     *
     */
    public InvoiceNotFoundException(int invoice_input)
    {
        super("Invoice ID : ");
        this.invoice_error = invoice_input;
    }

    @Override
    public String getMessage()
    {
        return super.getMessage() + invoice_error + " not found";
    }
}
