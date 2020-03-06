
/**
 * Enumeration class PaymentType - write a description of the enum class here
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 */
public enum PaymentType
{
    Cashless("Cashless"),
    Cash("Cash");
    
    private String payment;
    
    PaymentType(String payment)
    {
        this.payment = payment;
    }
    
    public String toString()
    {
        return payment;
    }
}
