package tacos.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.domain.TacoOrder;

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, String> {
}
