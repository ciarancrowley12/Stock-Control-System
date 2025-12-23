
/**
//Ciaran Crowley
//C24335666
 */
public class Pasta extends ItalianCuisine
{
    private String typeofPasta;
    /**
     * Constructor for objects of class Pasta
     */
    public Pasta()
    {
     super();
     this.typeofPasta = "";
    }
    
    public Pasta(double price, int stock , int orderNum ,String typeofPasta)
    {
     super(price,stock,orderNum);
     this.typeofPasta = typeofPasta;
    }
    
    public String getTypeOfPasta()
    {
        return this.typeofPasta;
    }
    
    public void setTypeOfPasta()
    {
        this.typeofPasta = typeofPasta;
    }
}
