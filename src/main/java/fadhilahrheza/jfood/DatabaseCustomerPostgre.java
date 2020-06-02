package fadhilahrheza.jfood;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Class DatabaseCustomerPostgre.
 * Contain the database of the customer in PostgreSQL
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 */
public class DatabaseCustomerPostgre
{
    private static Connection c;
    private static Statement statement;

    /**
     * Get the Array list of CustomerDatabasePostgre
     *
     * @return temp
     */
    public static ArrayList<Customer> getCustomerDatasbase()
    {
        ArrayList<Customer> temp = new ArrayList<>();
        try
        {
            c = DatabaseConnectionPostgre.connection();
            statement = c.createStatement();
            c.setAutoCommit(false);

            String sqlQuery = "SELECT * FROM customer;";
            ResultSet dbCustomer = statement.executeQuery(sqlQuery);
            while (dbCustomer.next())
            {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dbCustomer.getDate("joindate"));
                temp.add(new Customer(dbCustomer.getInt("id"),
                                      dbCustomer.getString("name"),
                                      dbCustomer.getString("email"),
                                      dbCustomer.getString("password"),
                                      calendar));
            }
            dbCustomer.close();
            statement.close();
            c.commit();
            c.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * Get the last ID of CustomerDatabasePostgre
     *
     * @return id
     */
    public static int getLastId()
    {
        int id = 0;
        try
        {
            c = DatabaseConnectionPostgre.connection();
            statement = c.createStatement();
            c.setAutoCommit(false);

            String sqlQuery = "SELECT MAX(id) as lastid FROM customer;";
            ResultSet lastId = statement.executeQuery(sqlQuery);
            if (lastId.next())
            {
                id = lastId.getInt("lastid");
                System.out.println(id);
            }
            lastId.close();
            statement.close();
            c.commit();
            c.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * Method to get customer id
     *
     * @param id
     * @return temp
     * @throws CustomerNotFoundException
     */
    public static Customer getCustomerById(int id) throws CustomerNotFoundException
    {
        Customer temp = null;
        try
        {
            c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            statement = c.createStatement();

            String sqlQuery = "SELECT * FROM customer " + "WHERE id =" + id + ";";
            ResultSet customer = statement.executeQuery(sqlQuery);
            if (!customer.next())
            {
                throw new CustomerNotFoundException(id);
            }
            else
            {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(customer.getDate("joindate"));
                temp = new Customer(customer.getInt("id"),
                                    customer.getString("name"),
                                    customer.getString("email"),
                                    customer.getString("password"),
                                    calendar);
            }
            customer.close();
            statement.close();
            c.commit();
            c.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * Method to add customer to the database
     *
     * @param customer
     * @throws EmailAlreadyExistsException
     */
    public static void addCustomer(Customer customer) throws EmailAlreadyExistsException
    {
        try
        {
            c = DatabaseConnectionPostgre.connection();
            c.setAutoCommit(false);
            statement = c.createStatement();

            Date date = customer.getJoinDate().getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String sqlQuery = "INSERT INTO customer " + "VALUES (" + customer.getId() + ", " +
                                                               "'" + customer.getName() + "', " +
                                                               "'" + customer.getEmail() + "', " +
                                                               "'" + customer.getPassword() + "', " +
                                                               "'" + format.format(date) + "');";
            statement.executeUpdate(sqlQuery);
            statement.close();
            c.commit();
            c.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw new EmailAlreadyExistsException(customer);
        }
    }

    /**
     * Method to remove customer from the database
     *
     * @param id
     * @throws CustomerNotFoundException
     */
    public static void removeCustomer(int id) throws CustomerNotFoundException
    {
        try
        {
            c = DatabaseConnectionPostgre.connection();
            statement = c.createStatement();
            c.setAutoCommit(false);

            String sqlQuery = "SELECT * FROM customer " + "WHERE id =" + id + ";";
            ResultSet customer = statement.executeQuery(sqlQuery);
            if (!customer.next())
            {
                throw new CustomerNotFoundException(id);
            }

            sqlQuery = "DELETE FROM customer " + "WHERE id = " + id + ";";
            statement.executeUpdate(sqlQuery);

            statement.close();
            c.commit();
            c.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Method to get the information of login cusomer
     *
     * @param email
     * @param password
     * @return
     */
    public static Customer getCustomerLogin(String email, String password)
    {
        Customer temp = null;
        try {
            c = DatabaseConnectionPostgre.connection();
            statement = c.createStatement();
            c.setAutoCommit(false);

            String sqlQuery = "SELECT * FROM customer " +
                              "WHERE email = '" + email + "' " +
                              "AND password = '" + password + "';";
            ResultSet customer = statement.executeQuery(sqlQuery);
            if (customer.next())
            {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(customer.getDate("joindate"));
                temp = new Customer(customer.getInt("id"),
                                    customer.getString("name"),
                                    customer.getString("email"),
                                    customer.getString("password"),
                                    calendar);
            }
            statement.close();
            c.commit();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
