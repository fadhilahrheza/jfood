package fadhilahrheza.jfood.controller;

import fadhilahrheza.jfood.*;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;

@RequestMapping("/promo")
@RestController
public class PromoController
{
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo()
    {
        return DatabasePromo.getPromoDatabase();
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@PathVariable String code) throws PromoCodeAlreadyExistsException {
        Promo promo = null;
        promo = DatabasePromo.getPromoByCode(code);
        return promo;
    }

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
