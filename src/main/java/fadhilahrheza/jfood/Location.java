package fadhilahrheza.jfood;
/**
 * Here is the class Location.
 * Inside this class, 
 * contains the description about cities and province.
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 * @since 2020-02-27
 */
public class Location
{
    /**
     * Below are the variable for class Location
     */
    private String province;
    private String description;
    private String city;

    /**
     * Constructor for objects of class Location
     * 
     * @param province
     * @param description
     * @param city
     */
    public Location(String province, String description, String city)
    {
        this.province = province;
        this.description = description;
        this.city = city;
    }

   /**
     * Gets the province of the location
     *
     * @return province
     */
    public String getProvince()
    {
        return province;
    }
    
    /**
     * Gets the city of the location
     *
     * @return city
     */
    public String getCity()
    {
        return city;
    }
    
    /**
     * Gets the description of the location
     *
     * @return description
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Sets the province of the location
     * 
     * @param province
     */
    public void setProvince(String province)
    {
        this.province = province;
    }
    
    /**
     * Sets the city of the location
     * 
     * @param city
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    
    /**
     * Sets the description of the location
     * 
     * @param description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String toString()
    {
        return "Province = " + getProvince() + "\nCity = " + getCity() + "\nDescription = " + getDescription();
    }
    
    /**
     * To print out (printData)
     * 
     * @param province is used
     */
    public void printData()
    {
        System.out.println(province);
    }
}
