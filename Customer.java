
/**
 * Here is the class Customer.
 * Inside this class, contains data of the customer.
 * 
 * @author Fadhilah Rheza P
 * @version 1.0
 * @since 2020-02-27
 */
public class Customer
{
    /**
     * Below are the variable for class Customer
     */
    private int id;
    private String name;
    private String email;
    private String password;
    private String joinDate;

    /**
     * Constructor for objects of class Customer
     * 
     * @param id (customer's id)
     * @param name (customer's name)
     * @param email (customer's email)
     * @param password (customer's password)
     * @param joinDate (customer's join date)
     */
    public Customer(int id, String name, String email, String password, String joinDate)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }

    /**
     * Gets the id of the customer
     *
     * @return id
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Gets the name of the customer
     *
     * @return name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets the email of the customer
     *
     * @return email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Gets the password of the customer
     *
     * @return password
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * Gets the join date of the customer
     *
     * @return joinDate
     */
    public String getJoinDate()
    {
        return joinDate;
    }
    
    /**
     * Sets the id of the customer
     * 
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Sets the name of the customer
     * 
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Sets the email of the customer
     * 
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * Sets the password of the customer
     * 
     * @param password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    /**
     * Sets the join date of the customer
     * 
     * @param joinDate
     */
    public void setJoinDate(String joinDate)
    {
        this.joinDate = joinDate;
    }
    
    /**
     * To print out (printData)
     * 
     * @param name is used
     */
    public void printname()
    {
        System.out.println(name);
    }
}
