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

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomerId(@PathVariable int custumerId)
    {
        {
            ArrayList<Invoice> invoiceByCustomer = new ArrayList<>();
            invoiceByCustomer = DatabaseInvoice.getInvoiceByCustomer(custumerId);
            return invoiceByCustomer;
        }
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "status") InvoiceStatus status) throws InvoiceNotFoundException
    {
        Invoice changedInvoice = DatabaseInvoice.getInvoiceById(id);
        try
        {
            DatabaseInvoice.changeInvoiceStatus(id, status);
        }
        catch (Exception e)
        {
            e.getMessage();
            return null;
        }
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
            return false;
        }
        return true;
    }

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
            invoice = new CashInvoice(DatabaseInvoice.getLastId() + 1, foodlagi, DatabaseCustomer.getCustomerById(customer), deliveryFee);
            DatabaseInvoice.addInvoice(invoice);
        }
        catch (CustomerNotFoundException | OngoingInvoiceAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        invoice.setTotalPrice();
        return invoice;
    }

    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value = "makanan") ArrayList<Integer> makanan,
                                      @RequestParam(value = "customer") int customer,
                                      @RequestParam(value = "promoCode", defaultValue = "") String promoCode)
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
        try
        {
            newCashlessInvoice = new CashlessInvoice(DatabaseInvoice.getLastId() + 1, foodlagi, DatabaseCustomer.getCustomerById(customer), DatabasePromo.getPromoByCode(promoCode));
        }
        catch (CustomerNotFoundException e)
        {
            e.getMessage();
        }

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
