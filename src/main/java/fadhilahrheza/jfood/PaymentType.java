package fadhilahrheza.jfood;
/**
 * Enumeration class PaymentType
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 */
public enum PaymentType
{
    Cashless("Cashless"),
    Cash("Cash");

    /**
     * Below are the variable for class PaymentType
     */
    private String payment;

    /**
     * Constructor for objects of class PaymentType
     *
     * @param payment
     */
    PaymentType(String payment)
    {
        this.payment = payment;
    }

    /**
     * To return payment
     * @return payment
     */
    public String toString()
    {
        return payment;
    }
}
