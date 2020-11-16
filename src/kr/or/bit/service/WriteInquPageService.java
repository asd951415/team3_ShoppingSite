package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;

public class WriteInquPageService implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		JsonArray products = (JsonArray)request.getAttribute("jsonBody");
		request.setAttribute("products", products);
		
		forward.setRedirect(false);
		forward.setPath("WriteInqPage.jsp");
		
		return forward;
	}

}
