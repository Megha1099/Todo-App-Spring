package todo.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import todo.dto.TodoTask;
import todo.dto.TodoUser;
import todo.service.TodoService;

@Controller//this will say the dispatcher servlet to send the request to this particular class.
public class MyController {
	
	@Autowired
	TodoService service;
	@Autowired
	TodoTask task;
/*	@RequestMapping("/hello")
//	//spring will say that if you get any request using this url send that to this class.
//	@ResponseBody
//	//this will say spring to display the data in the front end.
//	public String hello() {
//		return "Hello";
//		//here we can also write the html but most of the we wont use it cuz we give file name so it will take us to the particular file ex return "<h1>hi</h1>".
//		
//		
//	}*/
	
	//@RequestMapping({"/","/login"})//we can write the multiple url to the same method, but multiple method can't have the same url.
	//will accept all kind of requests.
	//getmapping will accept only the get method request,
	@GetMapping({"/","/login"})
	public String loadLogin()
	{
		return "login";
	}
	/*or separate the login url
	@RequestMapping("/login")
	public String login()
	{
		return "login.jsp";
	}
	*/
	//@RequestMapping("/signup")//we can directly give signup.jsp in the login file, we are mapping cuz that shoudl'nt show the file name in the url so
	@GetMapping("/signup")
	public String signup()
	{
		return "signup";
	}
	
	/*@PostMapping("/signup")//will accept only th epost method request, used only in the case of forms.
	@ResponseBody
	public String signup( @RequestParam String name)
	//@requsetParam works as the req.getparameter.name is same as in the form.and it will receive the value individually.
	{
		return name;
	}
	*/
	@PostMapping("/signup")
	public String signup(@ModelAttribute TodoUser user, ModelMap map)//@modelattribute will get all the values at time, and it is optional we can also directly give TodoUser user.
	//model map is used to print the content in the front end works as .res.getwriter
	{
		
		return service.signup(user, map);
	}
	@PostMapping("/login")
	public String login(@RequestParam String email,@RequestParam String password, ModelMap map, HttpSession session)
	{
		return service.login(email, password, map, session);
	}

	@PostMapping("/add-task")
	public String addTask(HttpSession session, ModelMap map,TodoTask task)
	{
		return service.addTask(task, session, map);
	}
	@GetMapping("/complete")
	public String completeTask(@RequestParam int id,HttpSession session, ModelMap map)
	{
		return service.completeTask(id, map, session);
	}
	@GetMapping("/delete")
	public String deleteTask(HttpSession session, ModelMap map,@RequestParam int id)
	{
		return service.deleteTask(map, session, id);
	}
	@GetMapping("/update-task")
	public String updateTask(HttpSession session, ModelMap map,TodoTask task, @RequestParam int id)
	{
		return service.updateTask(map, session, task, id);
	}
	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map)
	{
		return service.logout(session, map);
	}
}
