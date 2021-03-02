package learn.bz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;

@XmlRootElement
@AllArgsConstructor
public class Order {
  protected @Getter @Setter int id;
  protected @Getter @Setter String customer;
  protected @Getter @Setter String order;
  protected @Getter @Setter Date date;

  public Order() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return Objects.equals(customer, order.customer) && Objects.equals(this.order, order.order) && Objects.equals(date, order.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customer, order, date);
  }
}
