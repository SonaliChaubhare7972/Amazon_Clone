package com.Demo.web.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Demo.web.Model.Student;
import com.Demo.web.Reposity.Student_info;

import jakarta.servlet.http.HttpSession;



@Controller

public class student_handller {

@Autowired
	
	private Student_info repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "Registration";
	}
	
	@RequestMapping("/addstudent")
	public String addstudent(@ModelAttribute Student stude) {
		System.out.println(stude.getId());
		System.out.println(stude.getName());
		System.out.println(stude.getCity());
		
		repo.save(stude);
		
		return "redirect:/get";
	}
	
	@RequestMapping("/get")
	public String getdata(Model m)
	{
		List<Student> al=repo.findAll();
		
		m.addAttribute("e_data",al);
		
		System.out.println(al);
		return "ListUser";
	}
	
	@RequestMapping("/{id}")
	public String deleteuser(@PathVariable int id)
	{
		repo.deleteById(id);
		

		return "redirect:/get";		//it can delete the data in crome and return the remanning data in crome  
		
		
	//	return "ListUser";  it can delete the data in crome but not give the remaning data in crome 
	}
	
	@RequestMapping("/edit/{id}")
	public String editform(@PathVariable int id,Model m)	//model is the spring class it use to set data  it is accessible in front den
	{
		Student ob=repo.findById(id).get();
		
		m.addAttribute("std1",ob);
		return "edit_form";
	}
	
	@RequestMapping("/update/{id}")
	public String updatedata(@PathVariable int id, @ModelAttribute Student us)
	{
		Student user=repo.findById(id).orElse(null);
		
		if(user!=null)
		{
			user.setName(us.getName());
			user.setCity(us.getCity());
			
			repo.save(user);
		}
		return "redirect:/get";
	}
	@RequestMapping("/login")
	public String login(@PathVariable String name, @PathVariable String city ,HttpSession hp)
	{
		Student st=repo.findByname(name);
		
		if(st!=null && st.getName().equals(name) && st.getCity().equals(city))
		{
			hp.setAttribute("login",st);
			return "home";
		}
		else
		{
			return "Registration";
		}
	}
	
}
