import java.util.Scanner;
import java.util.ArrayList;
//Ciaran Crowley
//C24335666
public class Driver
{
    ArrayList<ItalianCuisine> productList;
    ArrayList<Customer> customerList;

    public Driver()
    {
        Scanner scan = new Scanner(System.in);
        productList = new ArrayList<ItalianCuisine>(); 
        customerList = new ArrayList<Customer>();
        System.out.println("\f");
        int menuOption = 0;
        String password = "fratellis2024";
        //hard coded pasta dishes so the intial pasta list isnt empty
        productList.add(new Pasta(9.99, 10, 101, "Spaghetti Carbonara"));
        productList.add(new Pasta(11.50, 7, 102, "Penne Arrabiata"));
        productList.add(new Pasta(10.25, 5, 103, "Fettuccine Alfredo"));

        //hard coded pizzas so the intial pizza list isnt empty
        productList.add(new Pizza(12.25, 12, 111, "Margherita "));
        productList.add(new Pizza(12.75, 4, 112, "Pepperoni"));
        productList.add(new Pizza(13.50, 2, 116, "Vegetarian "));
        do {
            menuOption = mainMenu(); 

            if (menuOption == 1) { 
                Customer currentCustomer = handleCustomerLogin();
                int customerOption = 0;
                do {
                    customerOption = customerMenu();
                    if (customerOption == 1)
                    {
                        displayAllPizza();
                    }

                    if(customerOption == 2)
                    {
                        displayAllPasta();  
                    }

                    if(customerOption == 3)
                    {
                        buyPizza(currentCustomer);
                    }

                    if(customerOption == 4)
                    {
                        buyPasta(currentCustomer);
                    }
                } while (customerOption != 5); 

            } else if (menuOption == 2) { 
                int staffOption = 0;

                int attempts = 0;
                boolean access = false;

                do {
                    System.out.println("Enter staff password:");
                    String attempt = scan.nextLine();

                    if (attempt.equals(password)) {
                        access = true;
                        System.out.println("Access granted!");
                    } else {
                        attempts++;
                        if (attempts < 3) {
                            System.out.println("Error - Incorrect password, please try again.");
                        }
                    }
                } while (!access && attempts < 3);

                if (access == true) {

                    do {
                        if (staffOption == 3) {
                            addNewPasta();
                        }
                        if (staffOption == 2) {
                            addNewPizza();
                        }
                        if (staffOption == 4) {
                            updateStockLevel();
                        }
                        if (staffOption == 1)
                        {
                            displayCustomerPurchases();
                        }
                        if (staffOption == 5)
                        {
                            stockAdviser();
                        }

                        staffOption = staffMenu();
                    } while (staffOption != 6); 
                } else {
                    System.out.println("Too many incorrect attempts. Returning to Main Menu.");
                }

            } else if (menuOption == 3) { 
                System.out.println("Exiting program...");
            }

        } while (menuOption != 3); 

    }

    public int mainMenu()
    {
        int option = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Fratelli's - Stock control / ordering system");
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("1. Customer menu ");
        System.out.println("2. Staff menu ");
        System.out.println("3. Exit System");

        do{
            option = scan.nextInt();
            scan.nextLine();
            if (option != 1 && option != 2 && option != 3)
            {
                System.out.println("Error - must be between 1 to and 3");  
            }
        } while(option != 1 && option != 2 && option != 3);
        return option;
    }

    public int staffMenu()
    {
        int option = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");

        System.out.println("Staff menu");
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("1. Display list of customers and products they have bought");  
        System.out.println("2. Add new type of pizza"); 
        System.out.println("3. Add new type of pasta"); 
        System.out.println("4. Update stock levels");
        System.out.println("5. Stock adviser"); //extra action
        System.out.println("6. Exit staff menu");

        do{
            option = scan.nextInt();
            scan.nextLine();
            if (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6)
            {
                System.out.println("Error - must be between 1 to and 5");  
            }
        } while(option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6);
        return option;
    }

    public int customerMenu()
    {
        int option = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");

        System.out.print("     Customer menu"   );
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("1.Display all pizza for sale");
        System.out.println("2.Display all pasta for sale");
        System.out.println("3.Buy one or more pizzas");
        System.out.println("4.Buy one or more pasta dishes");
        System.out.println("5. Exit Customer Menu");

        do{
            option = scan.nextInt();
            scan.nextLine();
            if (option != 1 && option != 2 && option != 3 && option != 4 && option != 5)
            {
                System.out.println("Error - must be between 1 to and 5");  
            }
        } while(option != 1 && option != 2 && option != 3 && option != 4 && option != 5);
        return option;
    }

    public Customer handleCustomerLogin() {

        Scanner scan = new Scanner(System.in);

        String name;
        int phoneNum;
        String emailAddress;
        Customer existingCustomer = null;

        System.out.println("Enter your email address:");
        emailAddress = scan.nextLine();

        for (Customer c : customerList) {
            if (c.getEmailAddress().equalsIgnoreCase(emailAddress)) {
                existingCustomer = c;
            }
        }

        if (existingCustomer != null) {
            System.out.println("Welcome back, " + existingCustomer.getName() + "!");
            return existingCustomer;
        }

        else {

            System.out.println("Customer not found. Creating a new customer...");
            System.out.println("Enter your name:");
            name = scan.nextLine();

            System.out.println("Enter your phone number:");
            phoneNum = scan.nextInt();
            scan.nextLine();

            Customer newCustomer = new Customer(name, phoneNum, emailAddress, null, 0 );
            customerList.add(newCustomer);
            System.out.println("Welcome, " + name);
            return newCustomer;
        }
    }

    public void displayAllPasta() //Create and add the display all products for sale method - task 8
    {
        boolean found = false;

        if (productList.isEmpty()) 
        {
            System.out.println("There are no items in stock.");
            return;
        }

        for (ItalianCuisine item : productList) {
            if (item instanceof Pasta) {
                Pasta pasta = (Pasta) item;
                System.out.println("Type of pasta: " + pasta.getTypeOfPasta());
                System.out.println("Price: €" + pasta.getPrice());
                System.out.println("Stock: " + pasta.getStock());
                System.out.println("Order Number: " + pasta.getOrderNum());

                found = true;
            }
        }

        if (found == false) {
            System.out.println("There are no pasta dishes in stock.");
        }

        System.out.println("Press Enter to return to the menu...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    public void addNewPasta() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter pasta type: ");
        String typeofPasta = scan.nextLine();

        System.out.print("Enter price: ");
        double price = scan.nextDouble();

        System.out.print("Enter stock: ");
        int stock = scan.nextInt();

        System.out.print("Enter unique order number: ");
        int orderNum = scan.nextInt();
        scan.nextLine();

        Pasta pasta = new Pasta(price, stock, orderNum, typeofPasta);
        productList.add(pasta);
        System.out.println("New pasta added to stock.");
    }

    public void displayAllPizza() //Create and add the display all products for sale method - task 8
    {
        boolean found = false;

        if (productList.isEmpty()) 
        {
            System.out.println("There are no items in stock.");
            return;
        }

        for (ItalianCuisine item : productList) {
            if (item instanceof Pizza) {
                Pizza pizza = (Pizza) item;
                System.out.println("Type of pizza: " + pizza.getTypeOfPizza());
                System.out.println("Price: €" + pizza.getPrice());
                System.out.println("Stock: " + pizza.getStock());
                System.out.println("Order Number: " + pizza.getOrderNum());

                found = true;
            }
        }

        if (found == false) {
            System.out.println("There are no pizzas in stock.");
        }

        System.out.println("Press Enter to return to the menu...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    public void addNewPizza() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a new pizza : ");
        String TypeOfPizza = scan.nextLine();

        System.out.print("Enter price: ");
        double price = scan.nextDouble();

        System.out.print("Enter stock: ");
        int stock = scan.nextInt();

        System.out.print("Enter unique order number: ");
        int orderNum = scan.nextInt();
        scan.nextLine();

        Pizza pizza = new Pizza(price, stock, orderNum, TypeOfPizza);
        productList.add(pizza);
        System.out.println("New pizza added to stock.");
    }

    public void updateStockLevel() {
        Scanner scan = new Scanner(System.in);
        int delivered;
        int currentStock;
        System.out.println("Would you like to update the stock of a Pizza or Pasta?");
        String choice = scan.nextLine().toLowerCase();

        System.out.print("Enter the order number of the item: ");
        int orderNum = scan.nextInt();
        scan.nextLine(); 

        boolean itemFound = false;

        for (ItalianCuisine item : productList) {
            if (item.getOrderNum() == orderNum) {
                itemFound = true;

                if ((choice.equals("pizza") && item instanceof Pizza) ||
                (choice.equals("pasta") && item instanceof Pasta)) {

                    System.out.print("Enter number of items delivered: ");
                    delivered = scan.nextInt();
                    scan.nextLine(); 

                    currentStock = item.getStock();
                    item.setStock(currentStock + delivered);

                    if (item instanceof Pizza) 
                    {
                        Pizza pizza = (Pizza) item;
                        System.out.println("The updated stock for Pizza : " + pizza.getTypeOfPizza() + " is now " + pizza.getStock());
                    }

                    else if (item instanceof Pasta)
                    {
                        Pasta pasta = (Pasta) item;
                        System.out.println("The updated stock for Pasta: " + pasta.getTypeOfPasta() + " is now " + pasta.getStock());
                    }

                } else {
                    System.out.println("Order number found, but it does not match the selected item type.");
                }
            }
        }

        if (itemFound == false) {
            System.out.println("Item with order number " + orderNum + " not found.");
        }

        System.out.println("Press Enter to return to the menu...");
        scan.nextLine();
    }

    public void buyPizza(Customer customer) 
    { //Create and add the buy product option - task 9
        int quantity;
        Scanner scan = new Scanner(System.in);

        if (productList.isEmpty()) 
        {
            System.out.println("There are no items in stock.");
            return;
        }

        System.out.println("Enter the order number of the pizza you wish to buy:");
        int orderNum = scan.nextInt();
        scan.nextLine();

        boolean itemFound = false;

        for (ItalianCuisine item : productList)
        {
            if (item instanceof Pizza && item.getOrderNum() == orderNum) {
                itemFound = true;

                System.out.println("Enter quantity to buy:");
                quantity = scan.nextInt();
                scan.nextLine();

                if (item.getStock() >= quantity) {
                    item.setStock(item.getStock() - quantity);
                    customer.setProduct(item);
                    customer.setAmountBought(quantity);

                    Pizza pizza = (Pizza) item;
                    System.out.println("Purchase successful!");
                    System.out.println("Customer: " + customer.getName());
                    System.out.println("Item bought: " + pizza.getTypeOfPizza());
                    System.out.println("Quantity: " + quantity);
                    System.out.println("Remaining stock: " + pizza.getStock());
                } 

                else 
                {
                    System.out.println("Not enough stock available.");
                }

            }
        }

        if (itemFound == false) {
            System.out.println("Pizza with order number: " + orderNum + "has not found.");

        }
        System.out.println("Press Enter to return to the menu...");
        scan.nextLine();
    }

    public void buyPasta(Customer customer) 
    { //Create and add the buy product option - task 9
        int quantity;
        Scanner scan = new Scanner(System.in);

        if (productList.isEmpty()) 
        {
            System.out.println("There are no items in stock.");
            return;
        }

        System.out.println("Enter the order number of the pasta dishes you wish to buy:");
        int orderNum = scan.nextInt();
        scan.nextLine();

        boolean itemFound = false;

        for (ItalianCuisine item : productList)
        {
            if (item instanceof Pasta && item.getOrderNum() == orderNum) {
                itemFound = true;

                System.out.println("Enter quantity to buy:");
                quantity = scan.nextInt();
                scan.nextLine();

                if (item.getStock() >= quantity) {
                    item.setStock(item.getStock() - quantity);
                    customer.setProduct(item);
                    customer.setAmountBought(quantity);

                    Pasta pasta = (Pasta) item;
                    System.out.println("Purchase successful!");
                    System.out.println("Customer: " + customer.getName());
                    System.out.println("Item bought: " + pasta.getTypeOfPasta());
                    System.out.println("Quantity: " + quantity);
                    System.out.println("Remaining stock: " + pasta.getStock());
                } 

                else 
                {
                    System.out.println("Not enough stock available.");
                }

            }
        }

        if (itemFound  == false) {
            System.out.println("Pasta dishes with order number :" + orderNum + "have not found.");

        }
        System.out.println("Press Enter to return to the menu...");
        scan.nextLine();
    }

    public void displayCustomerPurchases() 
    { //Create and add the display list of customers and products they have bought method - task 12
        System.out.println("List of customers and their purchases:");
        // Lists their most recent purchase as explained by the customer instructions on the assignment brief
        System.out.println("--------------------------------------------------");

        int quantity;
        ItalianCuisine product;

        if (customerList.isEmpty()) 
        {
            System.out.println("No customers have made purchases yet.");
        } 
        else
        {
            for (Customer customer : customerList)

            {
                product = customer.getProduct();
                quantity = customer.getAmountBought();

                System.out.println("Customer: " + customer.getName());
                System.out.println("Email: " + customer.getEmailAddress());
                System.out.println("Phone number: " + customer.getPhoneNum());

                if (product != null && quantity > 0) {
                    if (product instanceof Pizza) {
                        System.out.println("Product bought: " + ((Pizza) product).getTypeOfPizza());
                    } else if (product instanceof Pasta) {
                        System.out.println("Product bought: " + ((Pasta) product).getTypeOfPasta());
                    } else {
                        System.out.println("Product bought: Unknown");
                    }

                    System.out.println("Quantity: " + quantity);
                    System.out.println("Price per item: €" + product.getPrice());
                } else {
                    System.out.println("No purchases made.");
                }

                System.out.println("--------------------------------------------------");
            }

            System.out.println("Press Enter to return to the menu...");
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
        }
    }

    public void stockAdviser() {
        // extra action
        boolean found = false;
        System.out.println("Stock Adviser");
        System.out.println("Our system advises you to update the following using the update stock levels function: \n");

        for (ItalianCuisine item : productList) {
            if (item.getStock() < 5) {
                found = true;
                System.out.println("Order Number: " + item.getOrderNum());

                if (item instanceof Pizza) {
                    Pizza pizza = (Pizza) item;
                    System.out.println("Type: Pizza - " + pizza.getTypeOfPizza());
                } else if (item instanceof Pasta) {
                    Pasta pasta = (Pasta) item;
                    System.out.println("Type: Pasta - " + pasta.getTypeOfPasta());
                } else {
                    System.out.println("Type: Unknown");
                }

                System.out.println("Stock: " + item.getStock());
                System.out.println("---------------------------");
            }
        }

        if (found == false) {
            System.out.println("All items have sufficient stock.");
        }

        System.out.println("\nPress Enter to return to the menu...");
        new Scanner(System.in).nextLine();
    }

    public static void main(String[] args)
    {
        new Driver();

    }
}
