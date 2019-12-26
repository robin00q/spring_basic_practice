package com.javalec.spring_plj_board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring_plj_board.command.BCommand;
import com.javalec.spring_plj_board.command.BContentCommand;
import com.javalec.spring_plj_board.command.BDeleteCommand;
import com.javalec.spring_plj_board.command.BListCommand;
import com.javalec.spring_plj_board.command.BModifyCommand;
import com.javalec.spring_plj_board.command.BReplyCommand;
import com.javalec.spring_plj_board.command.BReplyViewCommand;
import com.javalec.spring_plj_board.command.BWriteCommand;

@Controller
public class BController {

	// BListCommand한테 작업을 시키면 좋음. interface Bcommand객체를 만들어 하나로 통일하자
	BCommand command;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list() start");
		
		command = new BListCommand();
		//받아온 모델 넣어준다.
		command.execute(model);
		
		
		return "/list";
	}
	
	// 작성하는페이지
	@RequestMapping("/write_view")
	public String write_view() {
		System.out.println("write_view() start");
		
		return "/write_view";
	}
	
	// 작성한 글의 폼에있는 데이터를 받아야 하기 때문에 HttpServletRequest객체 받음
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write() start");
		
		model.addAttribute("request", request);
		
		command = new BWriteCommand();
		command.execute(model);
		
		
		// 작성 후 list페이지로 보내줌
		return "redirect:/list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view() start");
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "/content_view";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify() start");
		
		model.addAttribute("request", request);
		 
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view() start");
		
		model.addAttribute("request", request);
		
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply() start");
		
		model.addAttribute("request", request);
		
		command = new BReplyCommand();
		command.execute(model);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete() start");
		
		model.addAttribute("request", request);
		
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:/list";
		
	}
}
