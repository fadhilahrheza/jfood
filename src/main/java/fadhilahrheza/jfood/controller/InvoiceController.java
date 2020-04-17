package fadhilahrheza.jfood.controller;

import fadhilahrheza.jfood.*;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;

@RequestMapping("/invoice")
@RestController
public class InvoiceController
{
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice()
    {
        return DatabaseInvoice.getInvoiceDatabase();
    }

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

    @RequestMapping(value = "/customer/{customerid}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomerId(@PathVariable int custumerid)
    {
        {
            ArrayList<Invoice> invoiceByCustomer = null;
            invoiceByCustomer = DatabaseInvoice.getInvoiceByCustomer(custumerid);
            return invoiceByCustomer;
        }
    }

    @RequestMapping(value = "/customer/{customerid}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "status") InvoiceStatus status)
    {
        Invoice changedInvoice;
        try
        {
            changedInvoice = DatabaseInvoice.getInvoiceById(id);
        }
        catch (InvoiceNotFoundException e)
        {
            e.getMessage();
            return null;
        }
        changeInvoiceStatus(id, status);
        return changedInvoice;
    }

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
        }
        return true;
    }

    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value = "foodlist")int foodlist,
                                  @RequestParam(value = "customerId")int customerId,
                                  @RequestParam(value = "deliveryFee")int deliveryFee)
    {
        ArrayList<Food> foodlagi = new ArrayList<>();

        for (int i = 0; i < foodlagi.size(); i++    )
        {
            try
            {
                foodlagi.add(DatabaseFood.getFoodById(i));
            }
            catch (FoodNotFoundException e)
            {
                e.getMessage();
                return null;
            }
        }

        try
        {
            DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1, foodlagi, DatabaseCustomer.getCustomerById(customerId)));
        }
        catch (CustomerNotFoundException e)
        {
            e.getMessage();
        }
        catch (OngoingInvoiceAlreadyExistsException e)
        {
            e.getMessage();
        }

        try
        {
            DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId()).setTotalPrice();
        }
        catch (InvoiceNotFoundException e)
        {
            e.getMessage();
            return null;
        }

        try
        {
            return DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId());
        }
        catch (InvoiceNotFoundException e)
        {
            e.getMessage();
            return null;
        }
    }


    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value = "foodlist")int foodlist,
                                  @RequestParam(value = "customerId")int customerId,
                                  @RequestParam(value = "deliveryFee")int deliveryFee)
    {
        Invoice cashlessInvoice = null;
        ArrayList<Food> foodlagi = new ArrayList<>();

        for (int i = 0; i < foodlagi.size(); i++    )
        {
            try
            {
                foodlagi.add(DatabaseFood.getFoodById(i));
            }
            catch (FoodNotFoundException e)
            {
                e.getMessage();
                return null;
            }
        }

        try
        {
            DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1, foodlagi, DatabaseCustomer.getCustomerById(customerId)));
        }
        catch (CustomerNotFoundException e)
        {
            e.getMessage();
        }
        catch (OngoingInvoiceAlreadyExistsException e)
        {
            e.getMessage();
        }

        try
        {
            DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId()).setTotalPrice();
        }
        catch (InvoiceNotFoundException e)
        {
            e.getMessage();
            return null;
        }

        try
        {
            return DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId());
        }
        catch (InvoiceNotFoundException e)
        {
            e.getMessage();
            return null;
        }
    }
}
