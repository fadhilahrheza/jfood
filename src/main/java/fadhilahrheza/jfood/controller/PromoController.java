package fadhilahrheza.jfood.controller;

import fadhilahrheza.jfood.*;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;

/**
 * Here is the PromoController class.
 * The class manage promo data
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 */

@RequestMapping("/promo")
@RestController
public class PromoController
{
    /**
     * The method below is used to return all promos in DatabasePromo
     *
     * @return ArrayList<Promo>
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo()
    {
        return DatabasePromo.getPromoDatabase();
    }

    /**
     * The method below is used to return promo using the promo code
     *
     * @param code
     * @return Promo
     * @throws PromoCodeAlreadyExistsException
     */
    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@PathVariable String code) throws PromoCodeAlreadyExistsException {
        Promo promo = null;
        promo = DatabasePromo.getPromoByCode(code);
        return promo;
    }

    /**
     * The method below is used to add promo to DatabasePromo
     *
     * @param code
     * @param discount
     * @param minPrice
     * @param active
     * @return Invoice
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value = "code") String code,
                           @RequestParam(value = "discount") int discount,
                           @RequestParam(value = "minPrice") int minPrice,
                           @RequestParam(value = "active") boolean active)
    {
        try
        {
            Promo newPromo = new Promo(DatabasePromo.getLastid()+1, code, discount, minPrice, active);
            DatabasePromo.addPromo(newPromo);
            return newPromo;
        }
        catch (PromoCodeAlreadyExistsException e)
        {
            e.getMessage();
            return null;
        }
    }

}
