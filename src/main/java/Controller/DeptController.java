package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import oracle.jdbc.proxy.annotation.Post;
import service.DeptService;
import vo.DeptVO;

@Controller
public class DeptController {

	public static final String VIEW_PATH="/WEB-INF/views/dept/";
	
	private DeptService deptService;
	
	public DeptController(DeptService deptService) {
		this.deptService = deptService;
	}
	
	@RequestMapping({"/list","/"})
	public String list(Model model) {
		
		List<DeptVO> list = deptService.selectList();
		
		model.addAttribute("list", list);
		
		return VIEW_PATH + "list.jsp";
	}
	
	@RequestMapping(value="/insert" , method = RequestMethod.GET)
	public String insertForm() {
		return VIEW_PATH + "insert.jsp";
	}
	
	@RequestMapping(value="/insert" , method = RequestMethod.POST)
	public String insert(DeptVO vo) {
		boolean res = deptService.insert(vo);
		
		if(res) {
			return "redirect:list";
		}else {
			return "redirect:insert";
		}
	}

	@RequestMapping("/update")
	public String update(Model model,DeptVO vo,HttpServletRequest request) {
	
		//request.getMethod() - Method¹æ½Ä return
		
		String url = "";
		
		if(request.getMethod().equals("GET")) {
			model.addAttribute("vo", deptService.selectOne(vo.getDeptno()));
			url = VIEW_PATH + "update.jsp";
		}else if(request.getMethod().equals("POST")) {
			if(deptService.update(vo) == 1) {
				url = "redirect:list";
			}else {
				url = "redirect:update?deptno=" + vo.getDeptno();
			}
		}
		
		return url;
	}
	
	@RequestMapping("/delete")
	public String delete(int deptno) {
		deptService.delete(deptno);
		
		return "redirect:list";
	}
	
}















