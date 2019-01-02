package tempoApp.restCall.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tempoApp.restCall.models.DailyPerformanceData;
import tempoApp.restCall.repository.DailyPerformanceDataRepository;




//define class as RestController and map it under http://localHost:{portNo}/tempoApp/dailyPerformance
@RestController
@RequestMapping("/tempoApp/dailyPerformance")
public class DailyPerformanceDataElementController {
	
	//for more about CRUD (create = POST, read = GET, update = PUT, delete = DELETE
	
	
	@Autowired
	private DailyPerformanceDataRepository dailyRepo;
	
	//methods/////////////
	
	
	//get method for finding all performance data:
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity< Collection<DailyPerformanceData> > getAllDailyPerformanceData(){
		return new ResponseEntity<>(dailyRepo.findAll(), HttpStatus.OK );
	}
	
	
	//get method for finding specific daily performance data
	
	@RequestMapping( value = "/{performanceDate}", method = RequestMethod.GET)
	public ResponseEntity<DailyPerformanceData> 
		getDailyDatawithDate(@PathVariable("performanceDate") String performanceDate){
		
		DailyPerformanceData tmpData = new DailyPerformanceData();
		LocalDate tmpDate = stringToLocalDate(performanceDate);
		
		//we change performanceDate string to LocalDate since dailyRepo's primary key finder works with
		//LocalDate type
		
		tmpData = dailyRepo.findOne(tmpDate);
		
		if(tmpData!= null) {
			return new ResponseEntity<DailyPerformanceData>(tmpData, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	//POST Method
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addDailyPerformanceData(@RequestBody DailyPerformanceData tmpData){
		//@RequestBody handles value= at runtime
		return new ResponseEntity<>(dailyRepo.save(tmpData), HttpStatus.CREATED);
	}
	
	
	
	//PUT Method
	@RequestMapping(value= "/{performanceDate}", method= RequestMethod.PUT)
	public ResponseEntity<?> updateDailyPerformanceData(@PathVariable String nonDateType, 
			@RequestBody DailyPerformanceData tmpData){
		
		LocalDate dateType = stringToLocalDate(nonDateType);
		//we change performanceDate string to LocalDate since dailyRepo's primary key finder works with
		//LocalDate type
		DailyPerformanceData currentData = dailyRepo.findOne(dateType);
		
		currentData.setAveraPace(tmpData.getAveragePace());
		currentData.setCaloriesBurn(tmpData.getCaloriesBurnt());
		currentData.setDistanceRun(tmpData.getDistanceRun());
		//userID wont change 
		
		return new ResponseEntity<>(dailyRepo.save(currentData), HttpStatus.OK);
	}
	
	
	//DELETE Method one specific data
	@RequestMapping(value= "/{performanceDate}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> deleteOneDailyPerformanceData(
			@PathVariable("performanceDate") String nonDateType){
		
		LocalDate dateType= stringToLocalDate(nonDateType); 
		dailyRepo.delete(dateType);
		return new ResponseEntity<Void>(HttpStatus.OK);	
	}
	
	
	//DELETE method for all daily performance data
	@RequestMapping(value= "/deleteAll", method= RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAllPerformanceData(){
		dailyRepo.deleteAll();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////////////
	
	
	//other functions
	public LocalDate stringToLocalDate(String nonDateType) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		return LocalDate.parse(nonDateType, formatter);
	}
	

}





