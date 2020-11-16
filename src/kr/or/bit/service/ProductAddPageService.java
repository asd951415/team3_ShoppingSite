package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.model.dao.DAOSeller;
import kr.or.bit.model.dto.DTOSeller;

public class ProductAddPageService implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ProductAddPageService");
		ActionForward forward = new ActionForward();
		
//		int selNum = (int)request.getSession().getAttribute("sellerNum");
//		DTOSeller seller = DAOSeller.ryu_getSellerBySelNum(selNum);
	
		DTOSeller seller = new DTOSeller(1, "seller", "aaaa@naver.com", 2, "222-222");
		request.setAttribute("seller", seller);
		
		forward.setRedirect(false);
		forward.setPath("ProductAdd.jsp");
		
		return forward;
	}

}