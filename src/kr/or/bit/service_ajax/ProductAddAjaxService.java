package kr.or.bit.service_ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.or.bit.action.ActionAjax;
import kr.or.bit.action.ActionAjaxData;

public class ProductAddAjaxService implements ActionAjax {
	
	@Override
	public ActionAjaxData execute(HttpServletRequest request, HttpServletResponse response) {
		ActionAjaxData ajaxData = new ActionAjaxData();
		System.out.println("ProductAddService");
		
		JsonObject body = (JsonObject) request.getAttribute("jsonBody");
        String pName = body.get("pName").getAsString();
        int pPrice = body.get("pPrice").getAsInt();
        String pSize = body.get("pSize").getAsString();
        int pAmount = body.get("pAmount").getAsInt();
        String pDesc = body.get("pDesc").getAsString();
        
        System.out.println(pName);
        System.out.println(pPrice);
        System.out.println(pSize);
        System.out.println(pAmount);
        System.out.println(pDesc);
        
		ajaxData.setContentType("text/plain");
		ajaxData.setData("success");
		
		return ajaxData;
	}
}
