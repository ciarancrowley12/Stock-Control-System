
/**
//Ciaran Crowley
//C24335666
 */
public class Pizza extends ItalianCuisine
{
    private String TypeOfPizza;
    
    /**
     * Constructor for objects of class Pizza
     */
    public Pizza()
    {
        super();
        this.TypeOfPizza = "";   
    }

    public Pizza(double price, int stock, int orderNum , String TypeOfPizza)
    {
        super(price , stock ,orderNum);
        this.TypeOfPizza = TypeOfPizza;
    }

    public String getTypeOfPizza()
    {
        return this.TypeOfPizza;
    }

    
    public void setTypeOfPizza(String TypeOfPizza)
    {
        this.TypeOfPizza = TypeOfPizza;
    }

   
}
