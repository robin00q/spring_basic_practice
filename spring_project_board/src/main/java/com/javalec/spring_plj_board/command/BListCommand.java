package com.javalec.spring_plj_board.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.spring_plj_board.dao.BDao;
import com.javalec.spring_plj_board.dto.BDto;

// DB에 있는 데이터를 모두 가져와서 띄워주는 역할
public class BListCommand implements BCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		
		model.addAttribute("list", dtos);
		
	}
}
