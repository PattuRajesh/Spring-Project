package com.example.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.RecordNotFoundException;
import com.example.Model.City;
import com.example.Response.ResponseHandler;
import com.example.Response.SucessResponse;
import com.example.Service.CityService;

@RestController
public class CityController {
	@Autowired
	 private CityService cityService;
	
	  @GetMapping("/city")
	    public ResponseEntity<Object> Get(){
	        try {
	            List<City> result = (List<City>) cityService.getCity();
//	            if(result==null){
//	                throw new RecordNotFoundException("Record_Not_Found");
//	            }
	            return  SucessResponse.generateResponse("Successfully retrieved all Data's!",HttpStatus.OK,result);
	        }catch(Exception e){

	        	return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS);
	        }
} 
	  
	  @PostMapping("/citys")
	  public ResponseEntity<Object> Post(@Valid  @RequestBody City city){
	     try{
	   
	       if(cityService.getCityById(city.getId())==null) {
	    	  
	    	  throw new RecordNotFoundException("Record_Not_Found");
	       }    
	       else{
	    	
	    	  cityService.updateCity(city);
	    	   return ResponseHandler.generateResponse("updated",HttpStatus.OK);
	      } 
	     }catch(Exception ex) {
	    	 cityService.saveCity(city);
		       return ResponseHandler.generateResponse("Successfully added data!",HttpStatus.OK);
	        }
	      
}
	  
	  
	  @DeleteMapping("/city/{Id}")
	    public ResponseEntity<Object> Delete(@PathVariable int Id){
	        try{
	            String result = cityService.deleteCity(Id);
	            if(result==null){
	                throw new RecordNotFoundException("Record_Not_Found");
	            }
	            return ResponseHandler.generateResponse("Deleted!", HttpStatus.OK);
	        }catch (Exception e){
	            return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS);
	            
	        }
	    }
	   @GetMapping("/city/{Id}")
		  public ResponseEntity<Object> Get(@PathVariable int Id) {
			  try{
			     City result = cityService.getCityById(Id);
			      if(result==null){
			          throw new RecordNotFoundException("Record_Not_Found");
			      }
			      return  SucessResponse.generateResponse("Successfully retrieved data!",HttpStatus.OK,result);
			  }catch(Exception e){
				  throw new RecordNotFoundException ("Record_Not_Found");
		            
			  }
	}
}
	  