package todo.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.ModelMap;


import todo.dao.TodoDao;
import todo.dto.TodoTask;
import todo.dto.TodoUser;

@ComponentScan
public class TodoService {

	@Autowired
	TodoDao dao;

	public String signup(TodoUser user, ModelMap map)  {
		List<TodoUser> list = dao.findByEmail(user.getEmail());
		if (list.isEmpty()) {
			dao.saveUser(user);
			map.put("pos","Account created");
			return "login";
		} else {
			map.put("neg","email shoud be unique");
			return "signup";
		}
	}

	public String login(String email, String password,ModelMap map,HttpSession session) {
		List<TodoUser> list = dao.findByEmail(email);
		if (list.isEmpty()) {
			map.put("neg","Incorrect eamil");
			return "login";
		} else {
			TodoUser user = list.get(0);
			if (user.getPassword().equals(password)) {
				session.setAttribute("user", user);
				map.put("pos","Login success");
				List<TodoTask> tasks =dao.fetchTaskByUser(user.getId());
				map.put("tasks", tasks);
				return "home";
			} else {
				map.put("neg", "Incorrect password");
				return "login";
			}
		}
	}

	public String addTask(TodoTask task, HttpSession session, ModelMap map)  {
		
		task.setCreatedTime(LocalDateTime.now());

		TodoUser user = (TodoUser) session.getAttribute("user");
		task.setUser(user);
		dao.saveTask(task);
	   map.put("pos","task added success");
		List<TodoTask> tasks = dao.fetchTaskByUser(user.getId());
		map.put("tasks", tasks);
		return "home";

	}
	
	public String logout(HttpSession session, ModelMap map) {
		session.removeAttribute("user");
		map.put("pos","logout success");
		return "login";
	}

	public String completeTask(int id, ModelMap map,HttpSession session) {
		TodoTask task=dao.findTaskById(id);
		task.setStatus(true);
		dao.updateTask(task);
		map.put("pos","Status Changed Success");
		
		TodoUser user = (TodoUser) session.getAttribute("user");
		List<TodoTask> tasks = dao.fetchTaskByUser(user.getId());
		map.put("tasks", tasks);
		return "home";	
	}

	public String deleteTask(ModelMap map,HttpSession session,int id) {
		TodoTask task=dao.findTaskById(id);
		dao.deleteTask(task);
		map.put("pos","Task Deleted Success");
		
		TodoUser user = (TodoUser) session.getAttribute("user");
		List<TodoTask> tasks = dao.fetchTaskByUser(user.getId());
		map.put("tasks", tasks);
		return "home";	
	}

	public String updateTask(ModelMap map,HttpSession session,TodoTask task2, int id) {
		TodoTask task =dao.findTaskById(id);
		task.setName(task2.getName());
		task.setDescription(task2.getDescription());
		task.setStatus(false);
		task.setCreatedTime(LocalDateTime.now());
		TodoUser user = (TodoUser) session.getAttribute("user");
		task.setUser(user);
		dao.updateTask(task);
		map.put("pos","Task Updated Success");
		List<TodoTask> tasks = dao.fetchTaskByUser(user.getId());
		map.put("tasks", tasks);
		return "home";
		
	}

}