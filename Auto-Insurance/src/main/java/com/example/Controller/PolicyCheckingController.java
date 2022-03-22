package com.example.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.PolicyChecking;
import com.example.Service.PolicyCheckingService;
import com.example.mapper.PolicyCheckingMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@RestController
public class PolicyCheckingController {
	
	@Autowired
	private final PolicyCheckingService policyService;
	
	
	
	private PolicyCheckingMapper policyMapper;

	

	public PolicyCheckingController(PolicyCheckingService policyService) {
		super();
		this.policyService = policyService;
	}

    @GetMapping
    public ResponseEntity<List<PolicyChecking>> findAll() {
        return ResponseEntity.ok(policyMapper.toPolicyCheckingDTOs(policyService.findAll()));
    }
}

//    @PostMapping
//    public ResponseEntity<PolicyCheckingDTO> create(@RequestBody PolicyCheckingDTO policyDTO) {
//        policyService.save(policyMapper.toPolicyChecking(policyDTO));
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(policyDTO);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<PolicyCheckingDTO> findByBikeId(@PathVariable Long bikeId) {
//        Optional<PolicyChecking> policy= policyService.findByBikeId(bikeId);
//
//        return ResponseEntity.ok(policyMapper.toPolicyCheckingDTO(policy.get()));
//    }
//

    
   
   


//	@Autowired
//	private PolicyCheckingService PolicyService;
//	 
//	 @GetMapping("/check")
//	    public ResponseEntity<Object> Get(){
//	        try {
//	            List<PolicyChecking> result = (List<PolicyChecking>) PolicyService.getPolicyChecking();
//	            if(result==null){
//	                throw new RecordNotFoundException("Record_Not_Found");
//	            }
//	            return  SucessResponse.generateResponse("Successfully retrieved all Data's!",HttpStatus.OK,result);
//	        }catch(Exception e){
//
//	        	return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS);
//	        }
//} 
//	 
//	 
//	 
//	  @GetMapping("/check/{bikeId}")
//	    public ResponseEntity<Object> Get(@PathVariable Long bikeId) {
//		 try{
//	    		PolicyChecking result =  this.PolicyService.getPolicyCheckingByBikeId(bikeId);
//	    		
//	    		if(result==null){
//	    			throw new RecordNotFoundException("Record_Not_Found");
//	    		}
//	    		return SucessResponse.generateResponse("Successfully retrieved data!",HttpStatus.OK,result);
//	    	
//	    	}catch(Exception e){
//	    		
//	    	 return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS);	
//	    	}
//	 }
//
//		
    

