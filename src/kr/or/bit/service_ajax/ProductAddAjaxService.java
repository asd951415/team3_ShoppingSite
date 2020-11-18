package kr.or.bit.service_ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import kr.or.bit.action.ActionAjax;
import kr.or.bit.action.ActionAjaxData;
import kr.or.bit.model.dao.DAOProduct;
import kr.or.bit.model.dto.DTOProduct;

public class ProductAddAjaxService implements ActionAjax {
	
	@Override
	public ActionAjaxData execute(HttpServletRequest request, HttpServletResponse response) {
		ActionAjaxData ajaxData = new ActionAjaxData();
		
		HttpSession session = request.getSession();
		int selNum = (Integer)session.getAttribute("sellerNum");
		
		JsonObject body = (JsonObject) request.getAttribute("jsonBody");
        String pName = body.get("pName").getAsString();
        int pPrice = body.get("pPrice").getAsInt();
        String pSize = body.get("pSize").getAsString();
        int pAmount = body.get("pAmount").getAsInt();
        String pDescription = body.get("pDesc").getAsString();
        
        DTOProduct product = new DTOProduct(selNum, pName, pPrice, pSize, pAmount, pDescription);
        int resultRow = DAOProduct.ryu_insertProduct(product);
        if(resultRow == 1) {
        	ajaxData.setData("success");
        } else {
        	ajaxData.setData("fail");        	
        }
		ajaxData.setContentType("text/plain");
		
		return ajaxData;
	}
}
