
/**
 * Here is the class Promo.
 * Inside this class, contains promo data.
 * 
 * @author Fadhilah Rheza P
 * @version 1.0
 * @since 2020-03-12
 */
public class Promo
{
    /**
     * Below are the variable for class Promo
     */
    private int id;
    private String code;
    private int discount;
    private int minPrice;
    private boolean active;

    /**
     * Constructor for objects of class Promo
     * 
     * @param id (promo's id)
     * @param code (promo's code)
     * @param discount (promo's discount)
     * @param minPrice (promo's minPrice)
     * @param active (promo's active)
     */
    public Promo(int id, String code, int discount, int minPrice, boolean active)
    {
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.minPrice = minPrice;
        this.active = active;
    }

    /**
     * Gets the id of the promo
     *
     * @return id
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Gets the code of the promo
     *
     * @return code
     */
    public String getCode()
    {
        return code;
    }
    
    /**
     * Gets the discount of the promo
     *
     * @return discount
     */
    public int getDiscount()
    {
        return discount;
    }
    
    /**
     * Gets the minPrice of the promo
     *
     * @return minPrice
     */
    public int getMinPrice()
    {
        return minPrice;
    }
    
    /**
     * Gets the Active of the promo
     *
     * @return active
     */
    public boolean getActive()
    {
        return active;
    }
    
    /**
     * Sets the id of the promo
     * 
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Sets the code of the promo
     * 
     * @param code
     */
    public void setCode(String code)
    {
        this.code = code;
    }
    
    /**
     * Sets the discount of the promo
     * 
     * @param discount
     */
    public void setDiscount(int discount)
    {
        this.discount = discount;
    }
    
    /**
     * Sets the minPrice of the promo
     * 
     * @param minPrice
     */
    public void setMinPrice(int minPrice)
    {
        this.minPrice = minPrice;
    }
    
    /**
     * Sets the active of the promo
     * 
     * @param active
     */
    public void setActive(boolean active)
    {
        this.active = active;
    }
    
    /**
     * To print out (printData)
     * 
     * @param
     */
    public void printData()
    {
        System.out.println("==========Promo==========");
        System.out.println("ID:"+id);
        System.out.println("Code:"+code);
        System.out.println("Discount:"+discount);
        System.out.println("MinPrice:"+minPrice);
        System.out.println("Active:"+active);
    }
}
