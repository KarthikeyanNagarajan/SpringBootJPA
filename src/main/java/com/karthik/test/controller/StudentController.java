package com.karthik.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.test.dao.Student;
import com.karthik.test.dao.StudentRepository;

//@Controller --> We need to use @responseBody in each place since restapi uses only data.
@RestController //We need not use @responseBody, it is by default data only.
public class StudentController {
	
	@Autowired
	StudentRepository repo;

	@RequestMapping("/")
	public String showHome()
	{
		return "home";
	}
	
	@PostMapping("/addstudent")
	public Student addStudent(@RequestBody Student std) //@RequestBody is used to get raw data from client, ie json or xml but doesnot accept formdata.
	{
		repo.save(std);
		return std;
	}
	
//	@RequestMapping("/getStudent")
//	public ModelAndView getStudent(@RequestParam int id)
//	{
//		ModelAndView mv = new ModelAndView("showStudent");
//		Student std = repo.findById(id).orElse(new Student());
//		mv.addObject(std);
//		return mv;
//	}
	
	@GetMapping(path="/student")
	public List<Student> getStudent()
	{		
		return (List<Student>) repo.findAll();
	}
	
	@RequestMapping("/student/{id}")
 	public Optional<Student> getStudent(@PathVariable("id") int id)
	{		
		return repo.findById(id);
	}
}
