package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;

public class RegistSellerPageService implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("RegistSellerPageService");
		ActionForward forward = new ActionForward();
		
//		JsonArray PdInqPost = (JsonArray)request.getAttribute("jsonBody");
//		request.setAttribute("DTOPdInqPost", PdInqPost);
		
		forward.setRedirect(false);
		forward.setPath("RegistSellerPage.jsp");
		
		return forward;
	}

}