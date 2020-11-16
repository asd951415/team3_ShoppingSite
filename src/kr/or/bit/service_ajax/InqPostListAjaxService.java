package kr.or.bit.service_ajax;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionAjax;
import kr.or.bit.action.ActionAjaxData;
import kr.or.bit.action.ActionForward;
import kr.or.bit.model.dao.DAOInquiryPost;
import kr.or.bit.model.dao.lee2_DAOReview;
import kr.or.bit.model.dto.DTOInqAnsPost;
import kr.or.bit.model.dto.DTOPdInqPost;
import kr.or.bit.model.dto.DTOReview;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class InqPostListAjaxService implements ActionAjax{

	@Override
	public ActionAjaxData execute(HttpServletRequest request, HttpServletResponse response) {
		ActionAjaxData ajaxData = new ActionAjaxData();
		DAOInquiryPost inqPost = new DAOInquiryPost();
		DTOPdInqPost dtoInqPost = null;
		List<DTOPdInqPost> list = inqPost.inqPostList();
		Iterator<DTOPdInqPost> itr = list.iterator();
		
		
		JSONObject json = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		int resultRow = 0;
		if(!itr.hasNext()) {
			resultRow = 1;
			while(itr.hasNext()){
			    json.put("sale_num",itr.next().getSaleNum());
			    json.put("id",itr.next().getId());
			    json.put("inq_title",itr.next().getInqTitle());
			    json.put("inq_content",itr.next().getInqContent());
			    json.put("inq_private_flag",itr.next().getInqPrivate());
			    json.put("inq_created_at",itr.next().getInqCreatedAt());
			    jsonArray.add(json);
			    json = new JSONObject();
			}
		}
	
		if(resultRow == 1) ajaxData.setData("success");
		else ajaxData.setData("fail");
		
		ajaxData.setContentType("application/json");
		return ajaxData;
	}
	

}