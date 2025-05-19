package tacos.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.domain.TacoOrder;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

    List<TacoOrder> findByDeliveryZip(String deliveryZip);
    List<TacoOrder> readByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);
}
