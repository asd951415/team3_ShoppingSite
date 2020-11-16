package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.model.dao.DAOSeller;
import kr.or.bit.model.dto.DTOSeller;

public class SellerPageService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		int selNum = (int)request.getSession().getAttribute("sellerNum");
		DTOSeller seller = DAOSeller.ryu_getSellerBySelNum(selNum);
		request.setAttribute("seller", seller);
		
		forward.setRedirect(false);
		forward.setPath("Seller.jsp");
		
		return forward;
	}

}
