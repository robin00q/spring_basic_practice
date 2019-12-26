package com.javalec.spring_plj_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_plj_board.dao.BDao;
import com.javalec.spring_plj_board.dto.BDto;

// 실제로 데이터에서 리스트 게시판을 보는것 
// 리스트에서 어떤 게시판 글을 클릭하면 내용이 보여야 하는데 클릭한 글의 내용을 bid를 이용해서 뽑아옴.
public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String bid = request.getParameter("bid");
		
		BDao dao = new BDao();
		//BDto dto = dao.contentView();
		
		//model.addAttribute("content_view", dto);
		
		
	}

}
