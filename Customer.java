import java.util.*;
import java.util.regex.*;
import java.lang.Object;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private Calendar joinDate;

    /**
     * Constructor no.1 for objects of class Customer
     */
    public Customer(int id, String name, String email, String password, Calendar joinDate)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }
    
    /**
     * Constructor no.2 for objects of class Customer
     */
    public Customer(int id, String name, String email, String password, int year, int month, int dayOfMonth)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = new GregorianCalendar(year, month-1, dayOfMonth);
    }
    
    /**
     * Constructor no.3 for objects of class Customer
     */
    public Customer(int id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
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
    public Calendar getJoinDate()
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
        String regexemail = "^[\\w!#$%’+/=?`{|~^-]+(?:\\.[\\w!#$%’+/=?`{|}^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regexemail);
        Matcher match = pattern.matcher(email);
        if(match.find())
        {
            this.email = email;
        }
        else
        {
            this.email = "";
        }
    }
    
    /**
     * Sets the password of the customer
     * 
     * @param password
     */
    public void setPassword(String password)
    {
        String regexpassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[A-Za-z\\d]{6,}$";
        Pattern pattern = Pattern.compile(regexpassword);
        Matcher match = pattern.matcher(password);
        if(match.find())
        {
            this.password = password;
        }
        else
        {
            this.password = "";
        }
    }
    
    /**
     * Sets the join date of the customer
     * 
     * @param joinDate
     */
    public void setJoinDate(Calendar joinDate)
    {
        this.joinDate = joinDate;
    }
    
    /**
     * Sets the join date of the customer
     * 
     * @param joinDate
     */
    public void setJoinDate(int year, int month, int dayOfMonth)
    {
        this.joinDate = new GregorianCalendar(year, month-1, dayOfMonth);
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
    
    public String toString()
    {
        String date = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        if(getJoinDate() != null)
        {
            date = sdf.format(joinDate.getTime());
        }
        return "Id = " + getId() + "\nNama = " + getName() + "\nEmail = " + getEmail() + "\nPassword = " + getPassword() + "\nJoin Date = " + getJoinDate();
    }
}
