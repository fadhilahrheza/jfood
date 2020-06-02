package fadhilahrheza.jfood.controller;

import fadhilahrheza.jfood.*;
import org.springframework.web.bind.annotation.*;

/**
 * Here is the CustomerController class.
 * The class manage customer data
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping({"/customer"})
@RestController
public class CustomerController
{
    @RequestMapping({""})
    public String indexPage(@RequestParam(value="name", defaultValue="world") String name)
    {
        return "Hello " + name;
    }

    /**
     * The GET method to return customer using customer id
     *
     * @param id
     * @return customer
     */
    @RequestMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id)
    {
        Customer customer = null;
        try
        {
            customer = DatabaseCustomerPostgre.getCustomerById(id);
        }
        catch (CustomerNotFoundException e)
        {
            e.getMessage();
            return null;
        }
        return customer;
    }

    /**
     * The method below is used to register new customer
     *
     * @param name
     * @param email
     * @param password
     * @return customer
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Customer registerCustomer(@RequestParam(value="name") String name,
                                    @RequestParam(value="email") String email,
                                    @RequestParam(value="password") String password)
    {
        Customer customer = new Customer(DatabaseCustomerPostgre.getLastId()+1, name, email, password);
        try
        {
            DatabaseCustomerPostgre.addCustomer(customer);
        }
        catch (EmailAlreadyExistsException e)
        {
            e.getMessage();
            return null;
        }
        return customer;
    }

    /**
     * The method below is used for login by checking their email and password
     *
     * @param email
     * @param password
     * @return customer
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Customer loginCustomer(@RequestParam(value="email") String email,
                                  @RequestParam(value="password") String password)
    {
        Customer customerlogin = null;
        customerlogin = DatabaseCustomerPostgre.getCustomerLogin(email, password);
        return customerlogin;
    }
}
