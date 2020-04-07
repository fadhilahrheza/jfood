import java.util.*;
import java.util.regex.*;
import java.lang.Object;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Cashliess Invoice Class.
 *
 * @author Fadhilah Rheza P
 * @version 1.0
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
     * Sets the id of the CashlessInvoice
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
        super.totalPrice = 0;
        for (Food foodList : getFoods())
        {
            super.totalPrice = super.totalPrice + foodList.getPrice();
        }
        if (promo != null && promo.getActive() == true && super.totalPrice > promo.getMinPrice());
        {
            totalPrice = totalPrice - promo.getDiscount();
        }
    }
    
    public String toString()
    {
        String foodName = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        for(int i = 0; 1 < getFoods().size(); i++)
        {
            foodName = foodName + getFoods().get(i).getName();
        }
        foodName = foodName.substring(0, foodName.length() - 2);

        if (promo != null && promo.getActive() == true)
        {
            return "\n================Invoice================" + "\n" +
                    "ID: " + getId() + "\n" +
                    "Foods: " + foodName + "\n" +
                    "Date: " + sdf.format(getDate().getTime()) + "\n" +
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
                        "Foods: " + foodName + "\n" +
                        "Date: " + sdf.format(getDate().getTime()) + "\n" +
                        "Customer: " + getCustomer().getName() + "\n" +
                        "Total Price: " + totalPrice + "\n" +
                        "Status: " + getInvoiceStatus() + "\n" +
                        "Payment Type: " + getPaymentType() + "\n";
            }
    }
}
