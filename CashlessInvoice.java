import java.util.*;
import java.util.regex.*;
import java.lang.Object;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * Write a description of class CashlessInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CashlessInvoice extends Invoice
{
    /**
     * Below are the variable for class CashlessInvoice
     */
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo ;

    /**
     * Constructor no.1
     */
    public CashlessInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus)
    {
        super(id, food, customer, invoiceStatus);
    }
    
    /**
     * Constructor no.2
     */
    public CashlessInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus, Promo promo)
    {
        super(id, food, customer, invoiceStatus);
        this.promo = promo;
    }

    /**
     * Gets the paymentType of the CashlessInvoice
     *
     * @return paymentType
     */
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    /**
     * Gets the Promo of the CashlessInvoice
     *
     * @return promo
     */
    public Promo getPromo()
    {
        return promo;
    }
    
    /**
     * Sets the id of the promo
     * 
     * @param promo
     */
    public void setPromo(Promo promo)
    {
        this.promo = promo;
    }
    
    /**
     * Sets the TotalPrice of the CashlessInvoice
     * 
     * @param TotalPrice
     */
    public void setTotalPrice()
    {
        if ((promo != null) && (getFood().getPrice() > getPromo().getMinPrice()) && (getPromo().getActive() == true))
        {
            super.totalPrice = (getFood().getPrice()) - (getPromo().getDiscount());
        }
        else
        {
            super.totalPrice = getFood().getPrice();
        }
    }
    
    public String toString()
    {

        SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
        String date = format1.format(getDate().getTime());
        if (getPromo() != null && getPromo().getActive() == true && getFood().getPrice() > getPromo().getMinPrice())
        {
            return "\n================Invoice================" + "\n" +
                   "ID: " + getId() + "\n" +
                   "Name: " + getFood().getName() + "\n" +
                   "Date: " + date + "\n" +
                   "Customer: " + getCustomer().getName() + "\n" +
                   "Promo: " + getPromo().getCode() + "\n" +
                   "Total Price: " + totalPrice + "\n" +
                   "Status: " + getInvoiceStatus() + "\n" +
                   "Payment Type: " + getPaymentType() + "\n";
        }
        else
        {
            return "\n================Invoice================" + "\n" +
                   "ID: " + getId() + "\n" +
                   "Name: " + getFood().getName() + "\n" +
                   "Date: " + date + "\n" +
                   "Customer: " + getCustomer().getName() + "\n" +
                   "Total Price: " + totalPrice + "\n" +
                   "Status: " + getInvoiceStatus() + "\n" +
                   "Payment Type: " + getPaymentType() + "\n";
        }

    }
}
