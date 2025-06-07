package tacos.data;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import tacos.domain.Ingredient;

@Repository
public interface IngredientRepository extends CassandraRepository<Ingredient, String> {
}
