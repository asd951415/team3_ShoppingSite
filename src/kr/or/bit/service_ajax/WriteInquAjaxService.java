package kr.or.bit.service_ajax;

import kr.or.bit.action.ActionAjax;
import kr.or.bit.action.ActionAjaxData;
import kr.or.bit.model.dao.DAOInquiryPost;
import kr.or.bit.model.dao.DAOMember;
import kr.or.bit.model.dto.DTOMember;
import kr.or.bit.model.dto.DTOPdInqPost;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

public class WriteInquAjaxService implements ActionAjax {
    @Override
    public ActionAjaxData execute(HttpServletRequest request, HttpServletResponse response) {
       ActionAjaxData ajaxData = new ActionAjaxData();
       DTOPdInqPost dtoPdInqPost = new DTOPdInqPost();
       DAOInquiryPost daoInquiryPost = new DAOInquiryPost();
//			json
//        {salePostnum:num
//        	title:string,
//        	content:string,
//        	private:string
//        	}
        HttpSession session = request.getSession();
		JsonObject jsonBody = (JsonObject)request.getAttribute("jsonBody");
		String id = session.getId();
		String saleNum = jsonBody.get("saleNum").getAsString();
		String inqTitle = jsonBody.get("inqTitle").getAsString();
		String InqContent = jsonBody.get("InqContent").getAsString();
		char inqPrivate = jsonBody.get("InqPrivate").getAsCharacter();
		DTOPdInqPost inqPost = new DTOPdInqPost(Integer.parseInt(saleNum), id, inqTitle, InqContent, inqPrivate);
		int resultRow = DAOInquiryPost.lim_inquiryPost(inqPost);
		
		if(resultRow == 1) ajaxData.setData("success");
		else ajaxData.setData("fail");
		
		ajaxData.setContentType("text/plain");

        return ajaxData;
        
        
    }
}
