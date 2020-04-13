public class FoodNotFoundException extends Exception
{
    /**
     * Below are the variable for class FoodNotFoundException
     */
    private int food_error;

    /**
     * Constructor for objects of class FoodNotFoundException
     *
     */
    public FoodNotFoundException(int food_input)
    {
        super("Food ID : ");
        this.food_error = food_input;
    }

    @Override
    public String getMessage()
    {
        return super.getMessage() + food_error + " not found";
    }
}
