package beans.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beans.data.StudentRequest;
import beans.service.IStudentService;

@Controller

public class StudentController {

	@Autowired
	IStudentService studentService;

/*	@RequestMapping("/Add")
	public ModelAndView add() {
		System.out.println("::::::::ADD method::::::::::::::" );
		return new ModelAndView("Add",null);
	}*/

	 @RequestMapping(value="student/save",method = RequestMethod.POST)  
	public String saveStudent(@ModelAttribute("save") StudentRequest student) {
		System.out.println(":::::::Save method:::::::::::::::" + student);
		studentService.save(student);
		return "redirect:/selectall";
	}

	 @RequestMapping("/edit/{id}")
	    public ModelAndView editPerson(@RequestParam String id, @ModelAttribute("student") StudentRequest student){
		 ModelAndView model = new ModelAndView("studentDetails");
		 System.out.println("::::::::::::::::::::::" + id);
			StudentRequest request=studentService.find(id);
	        model.addObject("detail",id);
	        model.addObject("details",request);
	        return model;
	    }
	
	
	@RequestMapping("/delete/{delete}")
	public String deleteStudent(@PathVariable("delete") String student) {
		System.out.println("::::::::::::::::::::::" + student);
		studentService.delete(student);
		return "redirect:/selectall";
	}
	
	
	
	@RequestMapping(value = "/selectall", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("students", studentService.findAll());
		return "studentDetails";
	}
	
	@RequestMapping("/selectStudent")
	public ModelAndView find(@ModelAttribute("student") String student) {
		System.out.println("::::::::::::::::::::::");
		StudentRequest std =studentService.find(student);
		return new ModelAndView("student", "student",std);
	}

	
	@RequestMapping("/Student")
	public ModelAndView student(@ModelAttribute("student") StudentRequest student) {

		System.out.println("::::::::::::::::::::::" + student);
		return new ModelAndView("student", "student", student);
	}
	
	
	/*@RequestMapping("/edit/{Id}")
	public ModelAndView editStudent(@PathVariable("Id") String student) {
		System.out.println("::::::::::::::::::::::" + student);
		StudentRequest request=studentService.find(student);
		return new ModelAndView("edit", "student", request);
	}*/
	
	
	
	/*@RequestMapping("/selectall")
	public ModelAndView findAll() {
		System.out.println("::::::::::::::::::::::");
		List<StudentRequest> student =studentService.findAll();
		return new ModelAndView("student", "student",student);
	}*/
	
	
	
	/*
	 * @RequestMapping(value = "/addStudent", method = RequestMethod.POST) public
	 * String addStudent(@ModelAttribute("student")StudentRequest student,
	 * 
	 * ModelMap model,BindingResult result) { model.addAttribute("firstName",
	 * student.getFirstName()); model.addAttribute("lastName",
	 * student.getLastName()); model.addAttribute("email", student.getEmail());
	 * 
	 * return "result"; }
	 * 
	 * @RequestMapping(value = "/smit", method = RequestMethod.GET) public String
	 * displayLogin(Model model) { model.addAttribute("login", new
	 * StudentRequest()); return "student"; }
	 * 
	 * @RequestMapping(value = "/save",method = RequestMethod.POST) public
	 * ModelAndView addStudent(@ModelAttribute("model") StudentRequest model){
	 * System.out.println("::::::"+model); Map map= new HashMap(); return new
	 * ModelAndView("Registration", map);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * @RequestMapping(value = "/saveA", method = RequestMethod.POST) public
	 * ModelAndView addStudentD(@ModelAttribute StudentRequest request){
	 * System.out.println("::::::"+request); Map map= new HashMap(); map.put("MSG",
	 * "Data Inserted Successfully"); return new ModelAndView("Registration",map);
	 * 
	 * }
	 */
}
