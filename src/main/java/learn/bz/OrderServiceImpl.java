package learn.bz;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "learn.bz.OrderService")
public class OrderServiceImpl implements OrderService{
  List<Order> orders = new ArrayList<>();
  InsertToDB insert = new InsertToDB();

  @Override
  public String addOrder(Order order) {
    if (order.customer.length() > 10) {
      return "Customer длиннее 10 символов";
    }
    if (order.id > 9999) {
      return "Id больше 9999";
    }
    orders.add(order);
    insert.insertToDB(order);
    return "Заказ добавлен";
  }

  @Override
  public String removeOrder(Order order) {
    if (!orders.contains(order)) {
      return "Такого заказа нет";
    }
    orders.remove(order);
    return "Заказ удалён";
  }

  @Override
  public List<Order> getAllOrders() {
    return orders;
  }
}
