package com.mycompany.myapp.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.dto.Comment;
import com.mycompany.myapp.service.CommentService;

@Controller
public class CommentController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private CommentService commentService;

	@RequestMapping("/comment/list")
	public String list() {
		return "comment/list";
	}

	@RequestMapping("/comment/list")
	public String writeForm() {
		logger.info("writeForm()");
		return "redirect:/comment/list";
	}
	

	@RequestMapping("/comment/list")
	public String updateForm(int musicNo, Model model) {
		Comment comment = commentService.getComment(musicNo);
		model.addAttribute("comment", comment);
		return "redirect:/comment/list";
	}

	
	@RequestMapping("/comment/list")
	public String update(Comment comment) {
		commentService.modify(comment);
		return "redirect:/comment/list";
	}

	@RequestMapping("/comment/list")
	public String delete(int commentNo) {
		commentService.remove(commentNo);
		return "redirect:/comment/list";
	}

}
