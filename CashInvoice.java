
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
    public CashInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus)
    {
        super(id, food, date, customer, invoiceStatus);
    }
    
    /**
     * Constructor no.2
     */
    public CashInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus, int deliveryFee)
    {
        super(id, food, date, customer, invoiceStatus);
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
    
    public void printData()
    {
        if (deliveryFee > 0)
        {
            System.out.println("==========INVOICE==========");
            System.out.println("ID:"+super.getId());
            System.out.println("Food:"+super.getFood().getName());
            System.out.println("Date:"+super.getDate());
            System.out.println("Customer:"+super.getCustomer().getName());
            System.out.println("Delivery Fee:"+getDeliveryFee());
            System.out.println("Total Price:"+super.getTotalPrice());
            System.out.println("Status:"+super.getInvoiceStatus());
            System.out.println("Payment Type:"+PAYMENT_TYPE);
        }
        else
        {
            System.out.println("==========INVOICE==========");
            System.out.println("ID:"+super.getId());
            System.out.println("Food:"+super.getFood().getName());
            System.out.println("Date:"+super.getDate());
            System.out.println("Customer:"+super.getCustomer().getName());
            System.out.println("Delivery Fee:"+getDeliveryFee());
            System.out.println("Total Price:"+super.getTotalPrice());
            System.out.println("Status:"+super.getInvoiceStatus());
            System.out.println("Payment Type:"+PAYMENT_TYPE);
        } 
    }
}
