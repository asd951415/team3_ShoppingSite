package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.model.dao.DAOProduct;
import kr.or.bit.model.dto.DTOProduct;

public class WriteSalePageService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		int selNum = (Integer)request.getSession().getAttribute("sellerNum");
		List<DTOProduct> productList = DAOProduct.ryu_getProductListBySelNum(selNum);
		request.setAttribute("productList", productList);
		
		forward.setRedirect(false);
		forward.setPath("WriteSale.jsp");
		
		return forward;
	}

}
