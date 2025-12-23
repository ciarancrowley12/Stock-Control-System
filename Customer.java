//Ciaran Crowley
//C24335666
public class Customer {
    private int amountBought;
    private int phoneNum;
    private String name;
    private String emailAddress;
    private ItalianCuisine product; 

    public Customer() {
        this.amountBought = 0;
        this.phoneNum = 0;
        this.name = "";
        this.emailAddress = "";
        this.product = null;
    }

    public Customer(String name, int phoneNum, String emailAddress, ItalianCuisine product, int amountBought) 
    {
        this.name = name;
        this.phoneNum = phoneNum;
        this.emailAddress = emailAddress;
        this.product = product;
        this.amountBought = amountBought;
    }

    public int getAmountBought() {
        return this.amountBought;
    }

    public int getPhoneNum() {
        return this.phoneNum;
    }

    public String getName() {
        return this.name;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public ItalianCuisine getProduct() {
        return this.product;
    }

    public void setAmountBought(int amountBought) {
        this.amountBought = amountBought;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setProduct(ItalianCuisine product) {
        this.product = product;
    }

}