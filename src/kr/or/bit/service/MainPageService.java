package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.model.dao.DAOSalePost;
import kr.or.bit.model.dto.DTOSalePost;

public class MainPageService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		List<DTOSalePost> salePostList = DAOSalePost.getSalePostListDesc();
		request.setAttribute("salePostList", salePostList);
		
		forward.setRedirect(false);
		forward.setPath("Main.jsp");
		System.out.println("mainService");
		return forward;
	}

}
