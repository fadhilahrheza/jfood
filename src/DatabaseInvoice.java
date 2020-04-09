import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class DatabaseInvoice. Contain the database of Invoice
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 */
public class DatabaseInvoice
{
    /**
     * Below are the variable for class DatabaseInvoice
     */
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastid = 0;

    /**
     * Constructor for objects of class DatabaseInvoice
     *
     * @param listInvoice (the list of invoice in the database)
     */

    /**
     * Get the Array list of InvoiceDatabase
     *
     * @return INVOICE_DATABASE
     */
    public static ArrayList<Invoice> getInvoiceDatabase()
    {
        return INVOICE_DATABASE;
    }

    /**
     * Get the last ID of InvoiceDatabase
     *
     * @return lastid
     */
    public static int getLastId()
    {
        return lastid;
    }

    /**
     * Getting Invoice Id
     *
     * @return invoice
     */
    public static Invoice getInvoiceById(int id)
    {
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if(id == invoice.getId())
            {
                return invoice;
            }
        }
        return null;
    }

    /**
     * Get the Array list of Invoice by Customer
     *
     * @return foodlist
     */
    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId)
    {
        ArrayList<Invoice> invoiceList = new ArrayList<>();
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if(invoice.getCustomer().getId() == customerId)
            {
                invoiceList.add(invoice);
            }
        }
        return invoiceList;
    }

    /**
     * Adding Invoice
     *
     * @return true
     */
    public static boolean addInvoice(Invoice invoice)
    {
        int customerId = invoice.getCustomer().getId();
        for (Invoice invoiceLagi : INVOICE_DATABASE)
        {
            if (invoiceLagi.getCustomer().getId() == customerId && invoiceLagi.getInvoiceStatus() == InvoiceStatus.Ongoing)
            {
                return false;
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastid = invoice.getId();

        return true;
    }

    /**
     * Changing Invoice
     *
     * @return true
     */
    public static boolean changeInvoiceStatus(int id, InvoiceStatus status)
    {
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if(status.equals(InvoiceStatus.Ongoing))
            {
                return true;
            }
        }
        return false;
    }
    /**
     * Removing Invoice
     *
     * @return true
     */
    public static boolean removeInvoice(int id)
    {
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if(id == invoice.getId())
            {
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        return false;
    }
}