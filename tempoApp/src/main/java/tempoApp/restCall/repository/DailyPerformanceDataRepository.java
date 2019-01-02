package tempoApp.restCall.repository;


import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tempoApp.restCall.models.DailyPerformanceData;

@Repository
public interface DailyPerformanceDataRepository extends CrudRepository<DailyPerformanceData, LocalDate> {
	//this class will be a repository that holds all collection of DailyPerformanceData
	//it will be user for storage, encapsulating and search behavior for User instances

	//findAll() is defined in CrudRepository that finds all entities in CrudRepository
	Collection<DailyPerformanceData> findAll();
}
