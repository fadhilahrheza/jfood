package fadhilahrheza.jfood.controller;

import fadhilahrheza.jfood.*;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;

/**
 * Here is the SellerController class.
 * The class manage seller data
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 */

@RequestMapping("/seller")
@RestController
public class SellerController
{
    /**
     * The method below is used to return all seller in DatabaseSeller
     *
     * @return ArrayList<Seller>
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Seller> getAllSeller()
    {
        return DatabaseSeller.getSellerDatabase();
    }

    /**
     * The method below is used to return food using ID of the seller
     *
     * @param id
     * @return Seller
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Seller getSellerById(@PathVariable int id)
    {
        Seller seller = null;
        try
        {
            seller = DatabaseSeller.getSellerById(id);
        }
        catch (SellerNotFoundException e)
        {
            e.getMessage();
            return null;
        }
        return seller;
    }

    /**
     * The method below is used to add seller to DatabaseSeller
     *
     * @param name
     * @param email
     * @param phoneNumber
     * @param province
     * @param description
     * @param city
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Seller addSeller(@RequestParam(value = "name") String name,
                            @RequestParam(value = "email") String email,
                            @RequestParam(value = "phoneNumber") String phoneNumber,
                            @RequestParam(value = "province") String province,
                            @RequestParam(value = "description") String description,
                            @RequestParam(value = "city") String city)
    {
       Location location = new Location(city, province, description);
       Seller newseller = new Seller(DatabaseSeller.getLastid()+1, name, email, phoneNumber, location);
       DatabaseSeller.addSeller(newseller);
       return newseller;
    }
}
