package Repositories;

import com.proballbly.ProballblyApp.Entities.BPLTeams;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface BPLTeamsRepository extends CrudRepository<BPLTeams, Integer> {
}
