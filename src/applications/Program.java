package applications;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entitiesEnum.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Aldo Nunes
 */
public class Program {

    public static void main(String[] args) throws ParseException {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        Date date = new Date();
        
        System.out.println("Enter client data:"); //cliente
        
        System.out.print("Name: ");
        String name = sc.nextLine();
        
        System.out.print("Email: ");
        String email = sc.nextLine();
        
        System.out.print("Birth date (DD/MM/YYY): ");
        Date birthDate = sdf.parse(sc.nextLine());
        
        Client client = new Client(name, email, birthDate);
        
        System.out.println(); //pedido
        System.out.println("Enter order data:");
        
        System.out.print("Status: ");
        String orderStatus = sc.nextLine();
        
        System.out.print("How many items to this order? ");
        int numberOfItems = sc.nextInt();
        
        Order order = new Order(date, OrderStatus.valueOf(orderStatus));
        List<OrderItem> items = new ArrayList<>();
        
        for(int x=1; x <= numberOfItems; x++){
            sc.nextLine();
            System.out.println("Enter #" + x + " item data: ");
            
            System.out.print("Product name: ");
            String nameProduct = sc.nextLine();
            
            System.out.print("Product price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            
            OrderItem orderItem = new OrderItem(quantity, price, new Product(nameProduct, price));
            order.addItem(orderItem);
            items.add(orderItem);
        }
        
        System.out.println(order.orderSumary());
        
        System.out.println(client);
        
        System.out.println("Order items:");
        
        for(OrderItem x : items){
            System.out.print(x.getProduct().getName() + ", ");
            System.out.print("$" + x.getPrice() + ", ");
            System.out.print("Quantity: " + x.getQuantity() + ", ");
            System.out.println("Subtotal: $" + String.format("%.2f", x.subTotal()));
            
            
        }
        
        System.out.println("Total price: " + String.format("%.2f", order.total()));

    }

}
