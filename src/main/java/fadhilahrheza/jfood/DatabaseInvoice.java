package fadhilahrheza.jfood;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class DatabaseInvoice.
 * Contain the database of Invoice
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
    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException
    {
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if(id == invoice.getId())
            {
                return invoice;
            }
        }
        throw new InvoiceNotFoundException(id);
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
    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException
    {
        int customerId = invoice.getCustomer().getId();
        for (Invoice invoiceLagi : INVOICE_DATABASE)
        {
            if (invoiceLagi.getCustomer().getId() == customerId && invoiceLagi.getInvoiceStatus().equals(InvoiceStatus.Ongoing))
            {
                throw new OngoingInvoiceAlreadyExistsException(invoice);
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastid = invoice.getId();

        return false;
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
            if(invoice.getId() == id && invoice.getInvoiceStatus().equals(InvoiceStatus.Ongoing))
            {
                invoice.setInvoiceStatus(status);
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
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException
    {
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if(id == invoice.getId())
            {
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }
}