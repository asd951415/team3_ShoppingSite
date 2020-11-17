package kr.or.bit.service_ajax;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.or.bit.action.ActionAjax;
import kr.or.bit.action.ActionAjaxData;
import kr.or.bit.model.dao.lee2_DAOReview;
import kr.or.bit.model.dto.DTOReview;
import net.sf.json.JSON;

public class ReviewListAjaxService implements ActionAjax{

	@Override
	public ActionAjaxData execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("들어옴");
		List<Map<String, Object>> list =new ArrayList<Map<String,Object>>();
		ActionAjaxData ajaxData = new ActionAjaxData();
		DTOReview dtoReview = new DTOReview();
		lee2_DAOReview daoReview = new lee2_DAOReview();
		JsonArray jsonArray = new JsonArray();
		JsonObject body = (JsonObject) request.getAttribute("jsonBody");
		Gson gson = null;
		String json =null;
		int saleNum = body.get("saleNum").getAsInt();

		 if (saleNum != 0) {		
			 list = daoReview.getReview(saleNum);
			
			 for(int i=0; i<list.size(); i++) {
//				 int sale_Num = (int) list.get(i).get("sale_num");
//				 String rev_content = (String) list.get(i).get("rev_content");
//				 int rev_stars = (int) list.get(i).get("rev_stars");
//				 Date rev_created_at = (Date) list.get(i).get("rev_created_at");
				 
				 gson = new Gson() ;
				 json = gson.toJson(list.get(i));
				 jsonArray.add(json);
				 
			 }	
			   json = gson.toJson(jsonArray);
			   System.out.println(json instanceof String);
			   System.out.println(json instanceof Object);
			   System.out.println(json);
			  
	         ajaxData.setData(json);	
	     }else{
	         ajaxData.setData("fail");

	         
	     }
		
		ajaxData.setContentType("application/json");
		return ajaxData;
	}

}
