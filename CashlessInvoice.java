
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
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus)
    {
        super(id, food, date, customer, invoiceStatus);
    }
    
    /**
     * Constructor no.2
     */
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus, Promo promo)
    {
        super(id, food, date, customer, invoiceStatus);
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
     * Sets the TotalPrice of the promo
     * 
     * @param TotalPrice
     */
    public void setTotalPrice()
    {
        if (promo != null && getFood().getPrice() >= promo.getMinPrice() && promo.getActive() == true)
        {
            super.totalPrice = getFood().getPrice() - promo.getDiscount();
        }
        else
        {
            super.totalPrice = getFood().getPrice();
        }
    }
    
    public void printData()
    {
        if (promo == null || promo.getActive() == false || getFood().getPrice() < promo.getMinPrice())
        {
            System.out.println("==========INVOICE==========");
            System.out.println("ID:"+super.getId());
            System.out.println("Food:"+super.getFood());
            System.out.println("Date:"+super.getDate());
            System.out.println("Customer:"+super.getCustomer().getName());
            System.out.println("Total Price:"+super.getTotalPrice());
            System.out.println("Status:"+super.getInvoiceStatus());
            System.out.println("Payment Type:"+PAYMENT_TYPE);
        }
        else
        {
            System.out.println("==========INVOICE==========");
            System.out.println("ID:"+super.getId());
            System.out.println("Food:"+super.getFood());
            System.out.println("Date:"+super.getDate());
            System.out.println("Customer:"+super.getCustomer().getName());
            System.out.println("Promo:"+promo);
            System.out.println("Total Price:"+super.getTotalPrice());
            System.out.println("Status:"+super.getInvoiceStatus());
            System.out.println("Payment Type:"+PAYMENT_TYPE);
        }
    }
}
