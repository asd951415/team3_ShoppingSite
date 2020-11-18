package kr.or.bit.service_ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.or.bit.action.ActionAjax;
import kr.or.bit.action.ActionAjaxData;
import kr.or.bit.model.dao.DAOPdInqPost;
import kr.or.bit.model.dto.DTOPdInqPost;


public class EditInquirySerivce implements ActionAjax{

	@Override
	public ActionAjaxData execute(HttpServletRequest request, HttpServletResponse response) {
		ActionAjaxData ajaxData = new ActionAjaxData();
//		"json
//		{inqNum:num
//		title:string,
//		content:string,
//		private:string
//		}"
		JsonObject jsonBody = (JsonObject)request.getAttribute("jsonBody");
		int inqNum = jsonBody.get("inqNum").getAsInt();
		String title = jsonBody.get("title").getAsString();
		String content = jsonBody.get("content").getAsString();
		String private_flag = jsonBody.get("private").getAsString();
		
		DTOPdInqPost post = new DTOPdInqPost();
		DAOPdInqPost.updateInqPost(title, content, private_flag, inqNum);
		
		if(title != null && content != null) ajaxData.setData("success");
		else ajaxData.setData("fail");
		
		ajaxData.setContentType("text/plain");
		
		return ajaxData;
	}

}
