public class OngoingInvoiceAlreadyExistsException extends Exception
{
    /**
     * Below are the variable for class CustomerNotFoundException
     */
    private Invoice invoice_error;

    /**
     * Constructor for objects of class CustomerNotFoundException
     *
     */
    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input)
    {
        super("Ongoing Invoice : ");
        this.invoice_error = invoice_input;
    }

    @Override
    public String getMessage()
    {
        return super.getMessage() + invoice_error + " not found";
    }
}
