package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.model.dao.DAOProduct;
import kr.or.bit.model.dto.DTOProduct;

public class lee2_ProductListPage implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		DAOProduct productDao = new DAOProduct();
		DTOProduct productDto = new DTOProduct();
		System.out.println("PdLIST");
		productDto = productDao.ryu_getProductListBySelNum();
		request.setAttribute("product", productDto);
//		request.setAttribute("p_num", productDto.getpNum());
//		request.setAttribute("sel_num", productDto.getSelNum());
//		request.setAttribute("p_name", productDto.getpName());
//		request.setAttribute("p_price", productDto.getpPrice());
//		request.setAttribute("p_size", productDto.getpSize());
//		request.setAttribute("p_amount", productDto.getpAmount());
//     	request.setAttribute("p_description", productDto.getpDescription());
		forward.setPath("ProductListPage.jsp");
		System.out.println(forward.getPath());
		
		if(productDto != null) {System.out.println(productDto.getpName());}
		return forward;
	}

}
