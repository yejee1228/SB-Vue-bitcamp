package com.hanrabong.web.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanrabong.web.proxy.Box;
import com.hanrabong.web.util.Printer;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class PersonController {
	@Autowired private PersonRepository personRepository;
	@Autowired private Printer printer;
	@Autowired private Person person;
	@Autowired ModelMapper modelMapper;
	@Bean public ModelMapper modelMapper() { return new ModelMapper(); }
	@Autowired Box<?> box;
	
	@RequestMapping("/")
	public String index() {
		Iterable<Person> all = personRepository.findAll();
		StringBuilder sb = new StringBuilder();
		all.forEach(p->sb.append(p.getName()+""));
		return sb.toString();
	}
	
	@PostMapping("/login")
	public HashMap<String, Object> login(@RequestBody Person param) {		
		HashMap<String, Object> map = new HashMap<>();
		printer.accept("로그인 진입");
		printer.accept(String.format("USERID : %s", param.getUserid()));
		printer.accept(String.format("PASSWD : %s", param.getPasswd()));
		person = personRepository.findByUseridAndPasswd(param.getUserid(), param.getPasswd());
		if(person != null) {
			printer.accept("로그인 성공");
			map.put("result", "SUCCESS");
			map.put("person", person);
		}else {
			printer.accept("로그인 실패");
			map.put("result", "FAIL");
		}
		return map;
	}
	
	@DeleteMapping("/withdrawl/{userid}")
	public void withdrawl(@PathVariable String userid) {
		printer.accept("컨트롤러");
		person = personRepository.findByUserid(userid);
		personRepository.deleteById(person.getPersonid());
	}
	
	@PutMapping("/update")
	public HashMap<String, Object> update(@RequestBody Person param) {
		printer.accept("put컨트롤러"+param.getName());
		person = personRepository.findByUserid(param.getUserid());
		personRepository.save(person);
		HashMap<String, Object> map = new HashMap<>();
		if(person != null) {
			printer.accept("수정 성공");
			map.put("result", "SUCCESS");
			map.put("person", person);
		}else {
			printer.accept("수정 실패");
			map.put("result", "FAIL");
		}
		return map;
	}
	@GetMapping("/students")
	public Stream<Person> list(){
		/* Iterable<Person> entites=personRepository.findByRole("student"); */
		Iterable<Person> entites = personRepository.findAll();	
		List<Person> list = new ArrayList<>();
		for(Person p:entites) {
			Person dto = modelMapper.map(p,Person.class);
			list.add(dto);
		}
		return list.stream().filter(role-> role.getRole().equals("student"));
	}
	
	@GetMapping("/students/{searchWord}")
	public Stream<Person> findSome(@PathVariable String searchWord){
		List<Person> list = new ArrayList<>();
		String searchkey = "";
		printer.accept("controller"+ searchWord);
		
		switch(searchWord) {
		case "namesOfStudents" : 
			Iterable<Person> entites = personRepository.findGroupByHak();
			for(Person p: entites) {
				Person dto = modelMapper.map(p, Person.class);
				list.add(dto);
			}
		break;
		case "streamToMap": break;
		case "streamToArray": break;
		case "theNumberOfStudents": break;
		case "totalScore": break;
		case "topStudent": break;
		case "getStat": break;
		case "nameList": break;
		case "남학생 목록": case "여학생 목록": 
			searchkey = (searchWord == "남")? "partitioningByMale" :"partitioningByFemale";
			break;
		case "partitioningCountPerGender": break;
		case "partitioningTopPerGender": break;
		case "partitioningRejectPerGender": break;
		case "findByHak": 
			/*
			 * Iterable<Person> entites = personRepository.findGroupByHak(); for(Person p:
			 * entites) { PersonDTO dto = modelMapper.map(p, PersonDTO.class);
			 * list.add(dto); }
			 */
			break;
		case "findByBan": break;
		case "groupByGrade": break;
		case "personCountByLevel": break;
		case "multiGrouping": break;
		case "multiGroupingMax": break;
		case "multiGroupingGrade":break;
		}
		switch(searchkey) {
		case "namesOfStudents" : 
			
			break;
		case "streamToMap": break;
		case "streamToArray": break;
		case "theNumberOfStudents": break;
		case "totalScore": break;
		case "topStudent": break;
		case "getStat": break;
		case "nameList": break;
		case "partitioningByMale": 
			;
			break;
		case "partitioningByFemale": break;
		case "partioningCountPerGender": break;
		case "partioningTopPerGender": break;
		case "partioningRejectPerGender": break;
		case "findByHak": break;
		case "findByBan": break;
		case "groupByGrade": break;
		case "personCountByLevel": break;
		case "multiGrouping": break;
		case "multiGroupingMax": break;
		case "multiGroupingGrade":break;
		}
		//Iterable<Person> entites=personRepository.findByRole("student"); 
		
		
		return list.stream()
				.filter(role-> role.getRole().equals("student"));
		
	}
	
	
}
