package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.DeptService;

@Controller
public class DeptController {

	public static final String VIEW_PATH="/WEB-INF/views/dept/";
	
	private DeptService deptService;
	
	public DeptController(DeptService deptService) {
		this.deptService = deptService;
	}
	
	@RequestMapping({"/list","/"})
	public String list(Model model) {
		return VIEW_PATH + "list.jsp";
	}
	
}
