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
    private Food food;
    private String date;
    protected int totalPrice;
    private Customer customer;
    private InvoiceStatus invoiceStatus;
    
    /**
     * Constructor for objects of class Invoice
     * 
     * @param id (invoice's id)
     * @param idFood (invoice's food id)
     * @param date (invoice's date)
     * @param totalprice (invoice's total price)
     * @param customer (invoice's customer)
     */
    public Invoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus)
    {
        this.id = id;
        this.food = food;
        this.date = date;
        this.customer = customer;
        this.invoiceStatus = invoiceStatus;
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
    public Food getFood()
    {
        return food;
    }
    
    /**
     * Gets the date of the invoice
     *
     * @return date
     */
    public String getDate()
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
    public void setFood(Food food)
    {
        this.food = food;
    }
    
    /**
     * Sets the date of the invoice
     * 
     * @param date
     */
    public void setDate(String date)
    {
        this.date = date;
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
     * @param id
     */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    /**
     * Sets the InvoiceStatus of the invoice
     * 
     * @param status
     */
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.invoiceStatus = invoiceStatus;
    }
    
    /**
     * To print out (printData)
     * 
     * @param idFood is used
     */
    public abstract void printData();
}
