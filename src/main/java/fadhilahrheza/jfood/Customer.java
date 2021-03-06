package fadhilahrheza.jfood;
import java.util.*;
import java.util.regex.*;
import java.lang.Object;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Here is the class Customer.
 * Inside this class, contains data of the customer.
 * 
 * @author Fadhilah Rheza P
 * @version 1.0
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
        setEmail(email);
        setPassword(password);
        this.joinDate = joinDate;
        this.joinDate.add(Calendar.MONTH,-1);
    }
    
    /**
     * Constructor no.2 for objects of class Customer
     */
    public Customer(int id, String name, String email, String password, int year, int month, int dayOfMonth)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = new GregorianCalendar(year, month-1, dayOfMonth);

    }
    
    /**
     * Constructor no.3 for objects of class Customer
     */
    public Customer(int id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = Calendar.getInstance();
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
        String regexemail = "^(?!\\.)(?!.*\\.$)(?!.*\\.\\.$)[\\w\\.&*_~]+@(.+)+$";
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
        String regexpassword = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z\\d]{6,}$";
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
     * Sets the join date of the customer in gregorian calendar
     */
    public void setJoinDate(int year, int month, int dayOfMonth)
    {
        this.joinDate = new GregorianCalendar(year, month, dayOfMonth);
    }
    
    /**
     * To print out Customer names(printName)
     */
    public void printname()
    {
        System.out.println(name);
    }

    /**
     * The method below to print Customer
     */
    public String toString()
    {
        String date = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return
        "\nID:" + getId()+
        "\nName:" + getName()+
        "\nEmail:" + getEmail()+
        "\nPassword:" + getPassword()+
        "\nJoin Date:" + sdf.format(joinDate.getTime());
    }
}