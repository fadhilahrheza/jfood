import java.lang.reflect.Array;
import java.util.ArrayList;

public class DatabaseInvoice
{
    /**
     * Below are the variable for class Customer
     */
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastid = 0;

    /**
     * Adding Seller
     *
     * @return boolean to true, if food was added
     */
    public static ArrayList<Invoice> getInvoiceDatabase()
    {
        return INVOICE_DATABASE;
    }

    /**
     * Adding Seller
     *
     * @return boolean to true, if food was added
     */
    public static int getLastId()
    {
        return lastid;
    }

    /**
     * Adding food
     *
     * @return boolean to true, if food was added
     */
    public static Invoice getInvoiceById(int id)
    {
        for(int i=0; i < INVOICE_DATABASE.size(); i++)
        {
            if(id == INVOICE_DATABASE.get(i).getId())
            {
                return INVOICE_DATABASE.get(i);
            }
        }
        return null;
    }

    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId)
    {
        ArrayList<Invoice> invoicelist = new ArrayList<Invoice>();
        boolean list;

        for(int i=0; i < INVOICE_DATABASE.size(); i++)
        {
            if(customerId == INVOICE_DATABASE.get(i).getCustomer().getId())
            {
                invoicelist.add(INVOICE_DATABASE.get(i));
                list = true;
            }
        }
        if(list = true)
        {
            return invoicelist;
        }
        return null;
    }

    public static boolean addInvoice(Invoice invoice)
    {
        for(int i=0; i < INVOICE_DATABASE.size(); i++)
        {
            if (invoice.getCustomer().getId() == INVOICE_DATABASE.get(i).getCustomer().getId() && INVOICE_DATABASE.get(i).getInvoiceStatus().equals(InvoiceStatus.Ongoing))
            {
                return false;
            }
        }

        INVOICE_DATABASE.add(invoice);
        lastid = invoice.getId();

        return true;
    }

    public static boolean changeInvoice(int id, InvoiceStatus invoiceStatus)
    {
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if(invoiceStatus.equals(InvoiceStatus.Ongoing))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean removeInvoice(int id)
    {
        boolean invoiceRemoved = false;
        for(int i = 0; i < INVOICE_DATABASE.size(); i++)
        {
            if(id == INVOICE_DATABASE.get(i).getId())
            {
                INVOICE_DATABASE.remove(i);
                invoiceRemoved = true;
            }
        }
        return true;
    }

}
