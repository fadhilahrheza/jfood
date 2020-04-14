package fadhilahrheza.jfood;
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
