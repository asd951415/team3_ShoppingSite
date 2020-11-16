package kr.or.bit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import kr.or.bit.model.DBManager;
import kr.or.bit.model.dto.DTOInqAnsPost;
import kr.or.bit.model.dto.DTOPdInqPost;
import kr.or.bit.model.dto.DTOProduct;

public class lee2_DAOPdInqPost {
	private static DBManager instance = DBManager.getInstance();
	private static final String SQL_SELECT_PDINQPOST = "SELECT * FROM PD_INQ_POST";
	private static final String SQL_SELECT_PDINQPOST_BY_INQ_NUM = "SELECT * FROM PD_INQ_POST WHERE INQ_NUM = ?";
	private static final String SQL_UPDATE_PDINQPOST = "UPDATE PD_INQ_POST "
															+ "SET INQ_TITLE = ?"
																+ "INQ_CONTENT =?"
																+ "INQ_PRIVATE_FLAG =?"											
																+ "WHERE INQ_NUM = ?";


	

	public DTOPdInqPost selectInqPostByInqNum(DTOPdInqPost inqPost) {
		int resultRow = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = instance.getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_PDINQPOST_BY_INQ_NUM);
			pstmt.setInt(1, inqPost.getInqNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				inqPost = lee2_DAOPdInqPost.setDTOInqAnsPost(rs);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			instance.freeConnection(conn, pstmt);
		}
		
		return inqPost;
	}
	
	
	
	public static int updateInqPost(String title,String content, String private_flag, int inq_num) {
		int resultRow = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = instance.getConnection();
			pstmt = conn.prepareStatement(SQL_UPDATE_PDINQPOST);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, private_flag);
			pstmt.setInt(4, inq_num);
			
			
			resultRow = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			instance.freeConnection(conn, pstmt);
		}
		
		return resultRow;
	}
	
	
	private static DTOPdInqPost setDTOInqAnsPost(ResultSet rs) throws SQLException {
		int inqNum = rs.getInt("inq_num");
		int saleNum = rs.getInt("sale_num");
		String id = rs.getString("id").trim();
		String inqTitle = rs.getString("inq_title");
		String inqContent = rs.getString("inq_content").trim();
		char inqPrivate = (char) rs.getInt("inq_private_flag");
		
		DTOPdInqPost inqPost = new DTOPdInqPost(inqNum, saleNum, id, inqTitle, inqContent, inqPrivate);
		
		return inqPost;
	}
	
	
	
	
}
