package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.State;
import com.example.Repository.StateRepository;

@Service
public  class StateService {
   
	@Autowired
	private StateRepository stateRepository;
	
	public List<State>getState(){
		return (List<State>) stateRepository.findAll();
		
	}
	
	public State getStateById(int Id){
		return stateRepository.findById(Id).orElse(null);
	}
	
	public State saveState(State state) {
		 return stateRepository.save(state);
		
	}
	public List<State> saveStates(List<State> states) {
		 return (List<State>) stateRepository.saveAll(states);
		 
	}
	
	
	public String deleteState(int id) {
		stateRepository.deleteById(id);
		return "state removed !!"+id;
	}
   public State updateState(State state){
	 State existingState= stateRepository.findById(state.getId()).get();
     existingState.setStateName((String)state.getStateName());
     return stateRepository.save(existingState);
   
 }

}
	