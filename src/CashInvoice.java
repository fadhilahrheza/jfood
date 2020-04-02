import java.util.*;
import java.util.regex.*;
import java.lang.Object;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * Write a description of class CashInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CashInvoice extends Invoice
{
    /**
     * Below are the variable for class CashInvoice
     */
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee ;
    

    /**
     * Constructor no.1
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }
    
    /**
     * Constructor no.2
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer, int deliveryFee)
    {
        super(id, foods, customer);
        this.deliveryFee = deliveryFee;
    }

    /**
     * Gets the paymentType of the CashInvoice
     *
     * @return paymentType
     */
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    /**
     * Gets the DeliveryFee of the CashInvoice
     *
     * @return deliveryFee
     */
    public int getDeliveryFee()
    {
        return deliveryFee;
    }
    
    /**
     * Sets the deliveryFee of the CashInvoice
     * 
     * @param int
     */
    public void setDeliveryFee(int deliveryFee)
    {
        this.deliveryFee = deliveryFee;
    }
    
    /**
     * Sets the TotalPrice of the CashInvoice
     * 
     * @param TotalPrice
     */
    public void setTotalPrice()
    {
        for (int i = 0; 1 < getFoods().size(); i++)
        {
            super.totalPrice = super.totalPrice+getFoods().get(i).getPrice();
        }
        if (deliveryFee > 0)
        {
            totalPrice = totalPrice+getDeliveryFee();
        }
        else
        {
            totalPrice = totalPrice;
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
            return "================Invoice================" + "\n" +
                    "ID: " + getId() + "\n" +
                    "Name: " + foodName + "\n" +
                    "Date: " + date + "\n" +
                    "Customer: " + getCustomer().getName() + "\n" +
                    "Total Price: " + totalPrice + "\n" +
                    "Status: " + getInvoiceStatus() + "\n" +
                    "Payment Type: " + getPaymentType() + "\n" +
                    "Delivery Fee: " + getDeliveryFee() + "\n";
    }
}