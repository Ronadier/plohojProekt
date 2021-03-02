import learn.bz.OrderService;
import learn.bz.OrderServiceImpl;

import javax.xml.ws.Endpoint;

public class Main {
  public static void main(String[] args) {
    OrderService service1 = new OrderServiceImpl();
    Endpoint.publish("http://localhost:8080", service1);
  }
}
