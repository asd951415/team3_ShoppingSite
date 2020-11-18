package kr.or.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.*;
import kr.or.bit.service_ajax.InqPostListAjaxService;

@WebServlet(
		name = "FrontController",
		urlPatterns = "*.do",
		loadOnStartup = 1
		)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Action> actionList = null;
       
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.print("*.do Servlet ->");
		actionList = new HashMap<String, Action>();
		
		actionList.put("/mainPage.do", new MainPageService());
		actionList.put("/mainPage.do", new MainPageService());
		actionList.put("/signUpPage.do", new SignUpPageService());
		actionList.put("/signUp.do", new SignUpService());
		actionList.put("/signInPage.do", new SignInPageService());
		actionList.put("/signOut.do", new SignOutService());
		actionList.put("category.do", new CategoryPageService());
		actionList.put("/salePage.do", new SalePageService());
		
		actionList.put("/member/mainPage.do", new MainPageService());
		actionList.put("/member/mainPage.do", new MainPageService());
		actionList.put("/member/signUpPage.do", new SignUpPageService());
		actionList.put("/member/signUp.do", new SignUpService());
		actionList.put("/member/signInPage.do", new SignInPageService());
		actionList.put("/member/signOut.do", new SignOutService());
		actionList.put("/member/category.do", new CategoryPageService());
		actionList.put("/member/salePage.do", new SalePageService());
		
		actionList.put("/member/cart.do", new CartPageService());
		actionList.put("/member/purchasePage.do", new PurchasePageService());
		actionList.put("/member/purchasedPage.do", new PurchasedPageService());
		actionList.put("/member/myPage.do", new MyPageService());
		actionList.put("/member/writeInquPage.do", new WriteInquPageService());
		actionList.put("/member/registSellerPage.do", new RegistSellerPageService());
		actionList.put("/seller/sellerPage.do", new SellerPageService());
		actionList.put("/seller/saleListPage.do", new SaleListPageService());
		actionList.put("/seller/writeSalePage.do", new WriteSalePageService());
		actionList.put("/seller/productList.do", new ProductListService());
		actionList.put("/seller/productAddPage.do", new ProductAddPageService());
		
		System.out.println(" initialized");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlCommand = (String)request.getAttribute("urlCommand");
		
		Action action = this.actionList.get(urlCommand);
		if(action != null) {
			ActionForward forward = action.execute(request, response);
			
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		} else {
			response.sendError(404);
		}
	}
	
}
