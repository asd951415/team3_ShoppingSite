package kr.or.bit.service_ajax;

import com.google.gson.JsonObject;
import kr.or.bit.action.ActionAjax;
import kr.or.bit.action.ActionAjaxData;
import kr.or.bit.model.dao.DAOMember;
import kr.or.bit.model.dao.DAOSeller;
import kr.or.bit.model.dto.DTOMember;
import kr.or.bit.model.dto.DTOSeller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistSellerAjaxService implements ActionAjax {
    @Override
    public ActionAjaxData execute(HttpServletRequest request, HttpServletResponse response) {
        ActionAjaxData ajaxData = new ActionAjaxData();
        
        JsonObject body = (JsonObject) request.getAttribute("jsonBody");
        String selEmail = body.get("email").getAsString();
        int selRegistNum = body.get("registNum").getAsInt();
        String selAccount = body.get("account").getAsString();
        String id = (String)request.getSession().getAttribute("memberId");
        
        DTOSeller seller = new DTOSeller(id, selEmail, selRegistNum, selAccount);
        int resultRow = DAOSeller.lim_registSeller(seller);
        if(resultRow == 1) {
        	resultRow = DAOMember.lim_RegistSeller(id);
        	if(resultRow == 1) ajaxData.setData("success");
        	else ajaxData.setData("fail");
        } else {
        	ajaxData.setData("fail");
        }
        ajaxData.setContentType("text/plain");

        return ajaxData;
    }
}
