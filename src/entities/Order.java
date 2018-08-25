
package entities;

import entitiesEnum.OrderStatus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aldo Nunes
 */
public class Order {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    private Date date;
    private OrderStatus status;

    private List<OrderItem> items = new ArrayList<>();
    
    public Order(){
        
    }

    public Order(Date date, OrderStatus status) {
        this.date = date;
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

   public void addItem(OrderItem item){
       items.add(item);
   }
    
   public void removeItem(OrderItem item){
       items.remove(item);
   }
    
   public Double total(){
       double sum = 0;
       for(OrderItem x : items){
           sum += x.subTotal();
       }
       return sum;
   }

    public String orderSumary() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("\nORDER SUMARY:\n");
        sb.append("Order moment: ").append(sdf.format(date));
        sb.append("\nOrder status: ").append(status);
        
        return sb.toString();
    }
    
    
   
}
