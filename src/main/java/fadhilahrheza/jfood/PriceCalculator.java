package fadhilahrheza.jfood;

/**
 * Here is the class PriceCalculator.
 * This class is used to calculated the price of the order
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 * @since 2020-02-27
 */
public class PriceCalculator implements Runnable
{
    Invoice invoice;

    public PriceCalculator(Invoice invoice)
    {
        this.invoice = invoice;
    }

    public void run()
    {
        System.out.println("calculating invoice id : " + invoice.getId());
        invoice.setTotalPrice();
        System.out.println("finish calculating invoice id : " + invoice.getId());
    }
}
