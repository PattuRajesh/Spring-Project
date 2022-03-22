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
import com.example.Model.State;
import com.example.Response.ResponseHandler;
import com.example.Response.SucessResponse;
import com.example.Service.StateService;
@RestController
public class StateController {
	@Autowired
	 private StateService stateService;
	
	  @GetMapping("/state")
	    public ResponseEntity<Object> Get(){
	        try {
	            List<State> result = (List<State>) stateService.getState();
//	            if(result==null){
//	                throw new RecordNotFoundException("Record_Not_Found");
//	            }
	            return  SucessResponse.generateResponse("Successfully retrieved all Data's!",HttpStatus.OK,result);
	        }catch(Exception e){

	        	return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS);
	        }
} 
	  
	  @PostMapping("/states")
	  public ResponseEntity<Object> Post(@Valid  @RequestBody State state){
	     try{
	   
	       if(stateService.getStateById(state.getId())==null) {
	    	  
	    	  throw new RecordNotFoundException("Record_Not_Found");
	       }    
	       else{
	    	
	    	  stateService.updateState(state);
	    	   return ResponseHandler.generateResponse("updated",HttpStatus.OK);
	      } 
	     }catch(Exception ex) {
	    	 stateService.saveState(state);
		       return ResponseHandler.generateResponse("Successfully added data!",HttpStatus.OK);
	        }
	      
}
	  
	  
	  @DeleteMapping("/state/{Id}")
	    public ResponseEntity<Object> Delete(@PathVariable int Id){
	        try{
	            String result = stateService.deleteState(Id);
	            if(result==null){
	                throw new RecordNotFoundException("Record_Not_Found");
	            }
	            return ResponseHandler.generateResponse("Deleted!", HttpStatus.OK);
	        }catch (Exception e){
	            return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS);
	            
	        }
	    }
	   @GetMapping("/state/{Id}")
		  public ResponseEntity<Object> Get(@PathVariable int Id) {
			  try{
			     State result = stateService.getStateById(Id);
			      if(result==null){
			          throw new RecordNotFoundException("Record_Not_Found");
			      }
			      return  SucessResponse.generateResponse("Successfully retrieved data!",HttpStatus.OK,result);
			  }catch(Exception e){
				  throw new RecordNotFoundException ("Record_Not_Found");
		            
			  }
	}
	  
	 
}
