package kr.or.bit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.model.dao.DAOSalePost;
import kr.or.bit.model.dto.DTOSalePost;

public class CategoryPageService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		int categoryNum = Integer.parseInt(request.getParameter("categoryNum"));
		System.out.println("categoryNum :" + categoryNum);
//		int categoryNum = 15;
		//List<DTOSalePost> salePostList = DAOSalePost.getSalePostListByCategory(categoryNum);
		
//		private int saleNum; &
//		private int selNum; 
//		private int categoryNum; &
//		private String saleTitle;
//		private String saleContent;
//		private Date saleCreatedAt;
//		private List<String> imageAddrs;
//		private List<Integer> pNums;
		
		List<String> imageAddrs = new ArrayList<String>();
		imageAddrs.add("Test Addrs1");
		imageAddrs.add("Test Addrs2");
		imageAddrs.add("Test Addrs3");
		
		List<Integer> pNums = new ArrayList<Integer>();
		pNums.add(1);
		pNums.add(2);
		pNums.add(3);
		
		List<DTOSalePost> salePostList = new ArrayList<DTOSalePost>();
		DTOSalePost samplePost1 = new DTOSalePost(91010, 100, categoryNum, "너무 이쁜 셔츠", "너무 이쁜 셔츠 내용", new Date(), imageAddrs,20000);
		samplePost1.setpNums(pNums);
		DTOSalePost samplePost2 = new DTOSalePost(91010, 100, categoryNum, "너무 이쁜 셔츠", "너무 이쁜 셔츠 내용", new Date(), imageAddrs,30000);
		samplePost2.setpNums(pNums);
		DTOSalePost samplePost3 = new DTOSalePost(91010, 100, categoryNum, "너무 이쁜 셔츠", "너무 이쁜 셔츠 내용", new Date(), imageAddrs,40000);
		samplePost3.setpNums(pNums);
		
		salePostList.add(samplePost1);
		salePostList.add(samplePost2);
		salePostList.add(samplePost3);
		salePostList.add(samplePost1);
		salePostList.add(samplePost2);
		salePostList.add(samplePost3);
		salePostList.add(samplePost1);
		salePostList.add(samplePost2);
		salePostList.add(samplePost3);
		
		//product 뒤져서 가격 하나 가져와야함 
		
		
		
		
		
		
		
		
		request.setAttribute("salePostList", salePostList);
		
		forward.setRedirect(false);
		forward.setPath("Category.jsp");
		
		return forward;
	}

}
