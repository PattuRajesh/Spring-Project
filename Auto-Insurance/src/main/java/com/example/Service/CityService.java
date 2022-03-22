package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.City;
import com.example.Repository.CityRepository;

@Service
public  class CityService {
   
	@Autowired
	private CityRepository cityRepository;
	
	public List<City>getCity(){
		return (List<City>) cityRepository.findAll();
		
	}
	
	public City getCityById(int stateId){
		return cityRepository.findById(stateId).orElse(null);
	}
	
	public City saveCity(City city) {
		 return cityRepository.save(city);
		
	}
	public List<City> saveCitys(List<City> citys) {
		 return (List<City>) cityRepository.saveAll(citys);
		 
	}
	
	
	public String deleteCity(int id) {
		cityRepository.deleteById(id);
		return "city removed !!"+id;
	}
  public City updateCity(City city){
	  City existingCity= cityRepository.findById(city.getId()).get();
      existingCity.setStateId((int)city.getStateId());
      existingCity.setCityName((String)city.getCityName());
      existingCity.setAddress((String)city.getAddress());
      existingCity.setPinCode((Long)city.getPinCode());
      return cityRepository.save(existingCity);
    
  }


}