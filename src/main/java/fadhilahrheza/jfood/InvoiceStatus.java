package fadhilahrheza.jfood;
/**
 * Enumeration class InvoiceStatus
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 */
public enum InvoiceStatus
{
    Ongoing("Ongoing"), 
    Finished("Finished"), 
    Cancelled("Cancelled");

    /**
     * Below are the variable for class InvoiceStatus
     */
    private String status;

    /**
     * Constructor for objects of class FoodCategory
     *
     * @param status
     */
    InvoiceStatus (String status)
    {
        this.status = status;
    }

    /**
     * To return status
     * @return status
     */
    public String toString()
    {
        return status;
    }
}
