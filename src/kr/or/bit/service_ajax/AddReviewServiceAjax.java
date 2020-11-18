package kr.or.bit.service_ajax;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import kr.or.bit.action.ActionAjax;
import kr.or.bit.action.ActionAjaxData;
import kr.or.bit.model.dao.DAOReview;
import kr.or.bit.model.dto.DTOReview;


public class AddReviewServiceAjax implements ActionAjax {

	@Override
	public ActionAjaxData execute(HttpServletRequest request, HttpServletResponse response) {
		ActionAjaxData ajaxData = new ActionAjaxData();
		int resultRow = 0;
//		json
//		{salePostnum:num
//		stars:num,
//		content:string
//		}
		System.out.println("들어옴");
		JsonObject jsonBody = (JsonObject)request.getAttribute("jsonBody");
		System.out.println(jsonBody);
		String salePostnum = jsonBody.get("salePostnum").getAsString();
		String content = jsonBody.get("content").getAsString();
		int stars = jsonBody.get("stars").getAsInt();
//		String id=jsonBody.get("id").getAsString();
		
		System.out.println("중간");
		HttpSession session = request.getSession();
		String id = session.getId();
		DTOReview reivew = new DTOReview(Integer.parseInt(salePostnum), id, content, stars);
		System.out.println(reivew);
		resultRow=DAOReview.insertReview(reivew);
		
		
		if(resultRow == 1) ajaxData.setData("success");
		else ajaxData.setData("fail");
		
		ajaxData.setContentType("text/plain");
		System.out.println("종료");
		return ajaxData;
	}

	
}
