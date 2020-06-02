package fadhilahrheza.jfood.controller;

import fadhilahrheza.jfood.*;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;

/**
 * Here is the InvoiceController class.
 * The class manage invoice data
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 */

@RequestMapping("/invoice")
@RestController
public class InvoiceController
{
    /**
     * The method below is used to return all invoice in DatabaseInvoice
     *
     * @return ArrayList<Invoice>
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice()
    {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    /**
     * The method is used to return invoice using ID of the invoice
     *
     * @param id
     * @return Invoice
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id)
    {
        Invoice invoice = null;
        try
        {
            invoice = DatabaseInvoice.getInvoiceById(id);
        }
        catch (InvoiceNotFoundException e)
        {
            e.getMessage();
            return null;
        }
        return invoice;
    }

    /**
     * The method below is used to return all invoice of customer
     *
     * @param customerId
     * @return ArrayList<Invoice>
     */
    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomerId(@PathVariable int customerId)
    {
        ArrayList<Invoice> invoiceByCustomer = new ArrayList<>();
        invoiceByCustomer = DatabaseInvoice.getInvoiceByCustomer(customerId);
        return invoiceByCustomer;
    }

    /**
     * The method below is used to change the invoice status
     *
     * @param id
     * @param status
     * @return Invoice
     * @throws InvoiceNotFoundException
     */
    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "status") InvoiceStatus status) throws InvoiceNotFoundException
    {
        if(DatabaseInvoice.changeInvoiceStatus(id, status))
        {
            try
            {
                return DatabaseInvoice.getInvoiceById(id);
            }
            catch(InvoiceNotFoundException e)
            {
                System.out.println(e.getMessage());
                return null;
            }
        }
        else
            {
            return null;
            }
    }

    /**
     * To remove invoice from DatabaseInvoice
     *
     * @param id
     * @return boolean
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean removeInvoice(@PathVariable int id)
    {
        try
        {
            DatabaseInvoice.removeInvoice(id);
        }
        catch (InvoiceNotFoundException e)
        {
            e.getMessage();
            return false;
        }
        return true;
    }

    /**
     * The method below is used to add invoice for cash payment
     *
     * @param makanan
     * @param customer
     * @param deliveryFee
     * @return Invoice
     */
    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value = "makanan") ArrayList<Integer> makanan,
                                  @RequestParam(value = "customer")int customer,
                                  @RequestParam(value = "deliveryFee", defaultValue = "0") int deliveryFee)
    {
        ArrayList<Food> foodlagi = new ArrayList<>();

        for (int food : makanan)
        {
            try
            {
                foodlagi.add(DatabaseFood.getFoodById(food));
            }
            catch (FoodNotFoundException e)
            {
                System.out.println(e.getMessage());
            }
        }
        Invoice invoice = null;
        try
        {
            invoice = new CashInvoice(DatabaseInvoice.getLastId() + 1, foodlagi, DatabaseCustomerPostgre.getCustomerById(customer), deliveryFee);
            invoice.setTotalPrice();
            DatabaseInvoice.addInvoice(invoice);
        }

        catch (CustomerNotFoundException | OngoingInvoiceAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        invoice.setTotalPrice(); //just incase gk masuk database
        return invoice;
    }

    /**
     * The method below is used to add invoice for cashless payment
     *
     * @param makanan
     * @param customer
     * @param promoCode
     * @return Invoice
     */
    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value = "makanan") ArrayList<Integer> makanan,
                                      @RequestParam(value = "customer") int customer,
                                      @RequestParam(value = "promoCode", defaultValue = "", required = false) String promoCode)
    {
        ArrayList<Food> foodlagi = new ArrayList<>();

        for (int food : makanan)
        {
            try
            {
                foodlagi.add(DatabaseFood.getFoodById(food));
            }
            catch (FoodNotFoundException e)
            {
                System.out.println(e.getMessage());
            }
        }

        Invoice newCashlessInvoice = null;
        System.out.println(promoCode);
        if (promoCode.equals(""))
        {
            try
            {
                newCashlessInvoice = new CashlessInvoice(DatabaseInvoice.getLastId() + 1, foodlagi, DatabaseCustomerPostgre.getCustomerById(customer));
            }
            catch (CustomerNotFoundException e)
            {
                e.getMessage();
            }
        }
        else
            {
                try
                {
                    newCashlessInvoice = new CashlessInvoice(DatabaseInvoice.getLastId() + 1, foodlagi, DatabaseCustomerPostgre.getCustomerById(customer), DatabasePromo.getPromoByCode(promoCode));
                }
                catch (CustomerNotFoundException e)
                {
                    e.getMessage();
                }
            }
        newCashlessInvoice.setTotalPrice();
        try
        {
            DatabaseInvoice.addInvoice(newCashlessInvoice);
        }
        catch (OngoingInvoiceAlreadyExistsException e)
        {
            e.getMessage();
            return null;
        }
        newCashlessInvoice.setTotalPrice();
        return newCashlessInvoice;
    }
}