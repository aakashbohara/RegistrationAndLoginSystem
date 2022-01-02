package com.spring.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.spring.practice.entity.Worker;
import com.spring.practice.service.WorkerService;

@Controller
public class WorkerController {
	
	@Autowired
	private WorkerService workerService;
	
	@GetMapping("/workerForm")
	public String showWorkerForm(Model model) {
		
		model.addAttribute("workerObject", new Worker());
		return "workerForm";
	}
	
	
	@PostMapping("/workerForm")
	public String saveWorkerInfo(@ModelAttribute Worker worker) {
		
		workerService.saveWorkerInfo(worker);
		return "redirect:/workerForm";
	}
	
	
	@GetMapping("/wlist")
	public String listWorkers(Model model) {
		
		model.addAttribute("wlist", workerService.getAllWorkerInfo());
		
		return "workerList";
	}

	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		workerService.deleteWorker(id);
		return "redirect:/wlist";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("workerObject", workerService.getWorkerById(id));
		return "editForm";
	}
	
	
	@PostMapping("/update")
	public String update(@ModelAttribute Worker worker) {
		
		workerService.saveWorkerInfo(worker);
		return "redirect:/wlist";
	}
	
	

}
