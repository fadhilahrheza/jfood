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
    public CashInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus)
    {
        super(id, food, customer, invoiceStatus);
    }
    
    /**
     * Constructor no.2
     */
    public CashInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus, int deliveryFee)
    {
        super(id, food, customer, invoiceStatus);
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
        if (deliveryFee > 0)
        {
            super.totalPrice = (getFood().getPrice()) + getDeliveryFee();
        }
        else
        {
            super.totalPrice = getFood().getPrice();
        }
    }
    
    public String toString()
    {
        String date0 = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        if(super.getDate() != null)
        {
            date0 = dateFormat.format(getDate().getTime());
        }

        if(deliveryFee != 0)
        {
            return "==========INVOICE==========" + 
                   "\nID: " + super.getId() +
                   "\nFood: " + super.getFood().getName() +
                   "\nDate: " + date0 + 
                   "\nCustomer: " + super.getCustomer().getName() +
                   "\nDelivery Fee: " + getDeliveryFee() + 
                   "\nTotal Price: " + super.getTotalPrice() +
                   "\nInvoice Status: " + super.getInvoiceStatus() +
                   "\nPayment Type: " + PAYMENT_TYPE;
        }

        else
        {
             return "==========INVOICE==========" + 
                   "\nID: " + super.getId() +
                   "\nFood: " + super.getFood().getName() +
                   "\nDate: " + date0 + 
                   "\nCustomer: " + super.getCustomer().getName() +
                   "\nDelivery Fee: 0" + 
                   "\nTotal Price: " + super.getTotalPrice() +
                   "\nInvoice Status: " + super.getInvoiceStatus() +
                   "\nPayment Type: " + PAYMENT_TYPE;
        }
    }
}