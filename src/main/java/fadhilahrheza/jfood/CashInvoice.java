package fadhilahrheza.jfood;
import java.util.*;
import java.util.regex.*;
import java.lang.Object;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static java.lang.System.*;

/**
 * CashInvoice Class.
 * The class manage transaction in JFood
 *
 * @author Fadhilah Rheza P
 * @version 1.0
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
     * @param deliveryFee
     */
    public void setDeliveryFee(int deliveryFee)
    {
        this.deliveryFee = deliveryFee;
    }

    /**
     * Sets the TotalPrice of the CashInvoice
     */
    public void setTotalPrice()
    {
        super.totalPrice = 0;
        for (Food foodList : getFoods())
        {
            super.totalPrice = super.totalPrice + foodList.getPrice();
        }
        super.totalPrice = super.totalPrice + deliveryFee;
    }

    /**
     * The method below to print CashInvoice
     */
    public String toString()
    {
       String foodName = "";
       SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
       for(Food foodList : getFoods())
       {
           foodName = foodName + foodList.getName();
       }
       foodName = foodName.substring(0, foodName.length() - 0);
       return "================Invoice================" + "\n" +
               "ID: " + super.getId() + "\n" +
               "Foods: " + foodName + "\n" +
               "Date: " + sdf.format(super.getDate().getTime()) + "\n" +
               "Customer: " + super.getCustomer().getName() + "\n" +
               "Total Price: " + totalPrice + "\n" +
               "Status: " + super.getInvoiceStatus() + "\n" +
               "Payment Type: " + getPaymentType() + "\n" +
               "Delivery Fee: " + getDeliveryFee() + "\n";
    }
}