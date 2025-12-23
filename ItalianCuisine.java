//Ciaran Crowley
//C24335666
public class ItalianCuisine
{
    private double price;
    private int stock;
    private int orderNum;
    /**
     * Constructor for objects of class italianCuisine
     */
    public ItalianCuisine()
    {
        this.price = 0.0;
        this.stock = 0;
        this.orderNum = 0;
    }

    public ItalianCuisine(double price, int stock, int orderNum)
    {
      this.price = price;
      this.stock = stock;
      this.orderNum = orderNum;
    }   
    
    public double getPrice()
    {
        return this.price;
    }
    
    public int getStock()
    {
      return this.stock;
    }
    
    public int getOrderNum()
    {
        return this.orderNum;
    }
    
    public void setPrice(double price)
    {
      this.price = price;
    }
    
    public void setStock(int stock)
    {
        this.stock = stock;
    }
    
    public void setOrderNum(int orderNum)
    {
        this.orderNum = orderNum;
    }
}
