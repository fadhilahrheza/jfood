package fadhilahrheza.jfood;
import java.util.*;
import java.util.regex.*;
import java.lang.Object;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * Here is the class Invoice.
 * Inside this class, contains invoice data.
 * 
 * @author Fadhilah Rheza P
 * @version 1.0
 * @since 2020-02-27
 */
public abstract class Invoice
{
    /**
     * Below are the variable for class Invoice
     */
    private int id;
    private ArrayList<Food> foods;
    private Calendar date;
    protected int totalPrice;
    private Customer customer;
    private InvoiceStatus invoiceStatus;
    
    /**
     * Constructor for objects of class Invoice
     * 
     * @param id (invoice's id)
     * @param food (invoice's food id)
     * @param date (invoice's date)
     * @param totalprice (invoice's total price)
     * @param customer (invoice's customer)
     */
    public Invoice(int id, ArrayList<Food> foods, Customer customer)
    {
        this.id = id;
        this.foods = foods;
        this.date = Calendar.getInstance();
        this.customer = customer;
        this.invoiceStatus = InvoiceStatus.Ongoing;
    }

    /**
     * Gets the id of the invoice
     *
     * @return id
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Gets the food id of the invoice
     *
     * @return idFood
     */
    public ArrayList<Food> getFoods()
    {
        return foods;
    }
    
    /**
     * Gets the date of the invoice
     *
     * @return date
     */
    public Calendar getDate()
    {
        return date;
    }
    
    /**
     * Gets the total price of the invoice
     *
     * @return totalPrice
     */
    public int getTotalPrice()
    {
        return totalPrice;
    }
    
    /**
     * Gets the customer of the invoice
     *
     * @return customer
     */
    public Customer getCustomer()
    {
        return customer;
    }
    
    /**
     * Gets the PaymentType of the invoice
     *
     * @return paymentType
     */
    public abstract PaymentType getPaymentType();
    
    /**
     * Gets the InvoiceStatus of the invoice
     *
     * @return status
     */
    public InvoiceStatus getInvoiceStatus()
    {
        return invoiceStatus;
    }
    
    /**
     * Sets the id of the invoice
     * 
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Sets the food id of the invoice
     * 
     * @param idFood
     */
    public void setFoods(ArrayList<Food> foods)
    {
        this.foods = foods;
    }
    
    /**
     * Sets the date of the invoice
     * 
     * @param date
     */
    public void setDate(Calendar date)
    {
        this.date = date;
    }
    
    /**
     * Sets the date of the invoice
     * 
     * @param date
     */
    public void setDate(int year, int month, int dayOfMonth)
    {
        this.date = new GregorianCalendar(year, month-1,dayOfMonth);
    }
    
    /**
     * Sets the total price of the invoice
     * 
     * @param toalPrice
     */
    public abstract void setTotalPrice();
    
    /**
     * Sets the id of the invoice
     * 
     * @param customer
     */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    /**
     * Sets the InvoiceStatus of the invoice
     * 
     * @param invoiceStatus
     */
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.invoiceStatus=invoiceStatus;
    }
    
    /**
     * To print out
     *
     */
    public abstract String toString();;
}
