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
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }
    
    /**
     * Constructor no.2
     */
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer, Promo promo)
    {
        super(id, foods, customer);
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
        for (int i = 0; 1 < getFoods().size(); i++)
        {
            super.totalPrice = super.totalPrice+getFoods().get(i).getPrice();
        }
        if ((promo != null) && (totalPrice > promo.getMinPrice()) && (getPromo().getActive() == true))
        {
            totalPrice = totalPrice - promo.getDiscount();
        }
        else
        {
            super.totalPrice = totalPrice;
        }
    }
    
    public String toString()
    {
        String date = "";
        String foodName = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        for(int i = 0; 1 < getFoods().size(); i++)
        {
            foodName = foodName + getFoods().get(i).getName();
        }
        if (getDate() != null)
        {
            date = sdf.format(getDate().getTime());
        }
            return "\n================Invoice================" + "\n" +
                   "ID: " + getId() + "\n" +
                   "Name: " + foodName + "\n" +
                   "Date: " + date + "\n" +
                   "Customer: " + getCustomer().getName() + "\n" +
                   "Promo: " + getPromo().getCode() + "\n" +
                   "Total Price: " + totalPrice + "\n" +
                   "Status: " + getInvoiceStatus() + "\n" +
                   "Payment Type: " + getPaymentType() + "\n";
        }
}
