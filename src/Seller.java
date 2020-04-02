
/**
 * Here is the class Seller.
 * Inside this class, contains data about the sellers.
 * 
 * @author Fadhilah Rheza P
 * @version 1.0
 * @since 2020-02-27
 */
public class Seller
{
    /**
     * Below are the variable for class Seller
     */
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;

    /**
     * Constructor for objects of class Seller
     * 
     * @param id (seller's id)
     * @param name (seller's name)
     * @param email (seller's email address)
     * @param phoneNumber (seller's phone number)
     * @param location (seller's location)
     */
    public Seller(int id, String name, String email, String phoneNumber, Location location)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    /**
     * Gets the id of the seller
     *
     * @return id
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Gets the name of the seller
     *
     * @return name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets the email of the seller
     *
     * @return email
     */
    public String getEmail()
    {
        return email;
    }
    
    
    /**
     * Gets the phone number of the seller
     *
     * @return phoneNUmber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    /**
     * Gets the location of the seller
     *
     * @return location
     */
    public Location getLocation()
    {
        return location;
    }
    
    /**
     * Sets the id of the seller
     * 
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Sets the name of the seller
     * 
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Sets the email of the seller
     * 
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * Sets the phone number of the seller
     * 
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Sets the location of the seller
     * 
     * @param location
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }
    
    /**
     * To print out (printData)
     * 
     * @param name is used
     */
    public void printData()
    {
        System.out.println(id + name + email + phoneNumber + location);
    }
    
    public String toString()
    {
        return "Id = " + getId() + "\nNama = " + getName() + "\nPhone Number = " + getPhoneNumber() + "\nLocation = " + getLocation();
    }
    
    /**
     * To print out (printName)
     * 
     * @param name is used
     */
    public void printName()
    {
        System.out.println(name);
    }
}
