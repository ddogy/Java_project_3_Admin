package org.academy.controller;



import org.academy.domain.StudentVO;
import org.academy.domain.Student_detailVO;
import org.academy.domain.AdminVO;
import org.academy.domain.Admin_detailVO;
import org.academy.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@RequestMapping("/Admin/*")
@AllArgsConstructor
public class AdminController {
	
	private AdminService service;
	// 拳搁贸府
	@GetMapping("/list")
	public void list(Model model) {
		
		log.info("list");
		model.addAttribute("list", service.getList());
	
	}
	//包府磊 拳搁贸府
	@GetMapping("/adminlist")
	public void Adminlist(Model model) {
	log.info("list");
	model.addAttribute("alist", service.getadminList());
	}
	 
	
	//切积炼雀 贸府
	@RequestMapping(value = "/Admin/read", method = RequestMethod.GET)
	public String read(@ModelAttribute("searchVO")Student_detailVO searchVO, @RequestParam("STU_ID") String STU_ID, Model model) {
		
		Student_detailVO StudentView = service.getStudentView(STU_ID);
		model.addAttribute("StudentView", StudentView);
		
		return "/Admin/read";
	}
	//包府磊 炼雀
	@RequestMapping(value = "/Admin/adminread", method = RequestMethod.GET)
	public String read(@ModelAttribute("searchVO")Admin_detailVO searchVO, @RequestParam("ADMIN_ID") String ADMIN_ID, Model model) {
		
		Admin_detailVO AdminView = service.getAdminView(ADMIN_ID);
		model.addAttribute("AdminView", AdminView);
		
		return "/Admin/adminread";
	}
	
	  
	
//昏力贸府
@RequestMapping(value = "/Admin/StudentDelete", method = RequestMethod.GET)
public String StudentDelete(@ModelAttribute("searchVO") StudentVO searchVO, @RequestParam("STU_ID") String STU_ID, RedirectAttributes redirect , Model model) {
	
	try {
		
		service.getStudentDelete(STU_ID);
		redirect.addFlashAttribute("msg", "昏力啊 肯丰登菌嚼聪促.");
		
	} catch (Exception e) {
		redirect.addFlashAttribute("msg", "坷幅啊 惯积登菌嚼聪促.");
		
	}
	
	return "redirect:/Admin/list";
}//包府磊 昏力贸府
@RequestMapping(value = "/Admin/Admindelete", method = RequestMethod.GET)
public String delete(@ModelAttribute("searchVO") AdminVO searchVO, @RequestParam("ADMIN_ID") String ADMIN_ID, RedirectAttributes redirect , Model model) {
	
	try {
		
		service.getAdminDelete(ADMIN_ID);
		redirect.addFlashAttribute("msg", "昏力啊 肯丰登菌嚼聪促.");
		
	} catch (Exception e) {
		redirect.addFlashAttribute("msg", "坷幅啊 惯积登菌嚼聪促.");
		
	}
	
	return "redirect:/Admin/adminlist";
}
}


	


