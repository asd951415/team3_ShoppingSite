package kr.or.bit.service_ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.ActionAjax;
import kr.or.bit.action.ActionAjaxData;
import kr.or.bit.model.dao.DAOSalePost;
import kr.or.bit.model.dao.DAOReview;
import kr.or.bit.model.dto.DTOSalePost;

public class DeleteReivewService implements ActionAjax {

	@Override
	public ActionAjaxData execute(HttpServletRequest request, HttpServletResponse response) {
		ActionAjaxData ajaxData = new ActionAjaxData();
		String saleNum = request.getParameter("saleNum");
		int resultRow =0;
		
		if(resultRow == 1) {
			DAOReview.delete(Integer.parseInt(saleNum));
			ajaxData.setData("success");
		} else {
			ajaxData.setData("fail");
		}
		ajaxData.setContentType("text/plain");
		return ajaxData;
	}

}
