
/**
 * Enumeration class InvoiceStatus - write a description of the enum class here
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 */
public enum InvoiceStatus
{
    Ongoing("Ongoing"), 
    Finished("Finished"), 
    Cancelled("Cancelled");
    
    private String status;
    
    InvoiceStatus (String status)
    {
        this.status = status;
    }
    
    public String toString()
    {
        return status;
    }
}
