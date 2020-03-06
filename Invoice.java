/**
 * Here is the class Invoice.
 * Inside this class, contains invoice data.
 * 
 * @author Fadhilah Rheza P
 * @version 1.0
 * @since 2020-02-27
 */
public class Invoice
{
    /**
     * Below are the variable for class Invoice
     */
    private int id;
    private int idFood;
    private String date;
    private int totalPrice;
    private Customer customer;
    private PaymentType paymentType;
    private InvoiceStatus status;
    
    /**
     * Constructor for objects of class Invoice
     * 
     * @param id (invoice's id)
     * @param idFood (invoice's food id)
     * @param date (invoice's date)
     * @param totalprice (invoice's total price)
     * @param customer (invoice's customer)
     */
    public Invoice(int id, int idFood, String date, int totalPrice, Customer customer, InvoiceStatus status)
    {
        this.id = id;
        this.idFood = idFood;
        this.date = date;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.status = status;
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
    public int getIdFood()
    {
        return idFood;
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
    public PaymentType getPaymentType()
    {
        return paymentType;
    }
    
    /**
     * Gets the InvoiceStatus of the invoice
     *
     * @return status
     */
    public InvoiceStatus getInvoiceStatus()
    {
        return status;
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
    public void setIdFoods(int Food)
    {
        this.idFood = idFood;
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
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    
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
     * Sets the PaymentType of the invoice
     * 
     * @param paymentType
     */
    public void setCustomer(PaymentType paymentType)
    {
        this.paymentType = paymentType;
    }
    
    /**
     * Sets the InvoiceStatus of the invoice
     * 
     * @param status
     */
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.status = status;
    }
    
    /**
     * To print out (printData)
     * 
     * @param idFood is used
     */
    public void printData()
    {
        System.out.println("==========INVOICE==========");
        System.out.println("ID:"+id);
        System.out.println("Food ID:"+idFood);
        System.out.println("Date:"+date);
        System.out.println("Customer:"+customer.getName());
        System.out.println("Total Price:"+totalPrice);
        System.out.println("Status:"+status);
    }
}
