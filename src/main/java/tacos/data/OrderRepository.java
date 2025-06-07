package tacos.data;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import tacos.domain.TacoOrder;

@Repository
public interface OrderRepository extends CassandraRepository<TacoOrder, Long> {
}
