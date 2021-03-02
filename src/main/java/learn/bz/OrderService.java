package learn.bz;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface OrderService {
  String addOrder(Order order);
  String removeOrder(Order order);
  List<Order> getAllOrders();
}
