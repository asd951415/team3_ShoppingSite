package kr.or.bit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.or.bit.model.DBManager;
import kr.or.bit.model.dto.DTOReview;
import kr.or.bit.model.dto.DTOSalePost;

public class lee2_DAOReview {
	private static DBManager instance = DBManager.getInstance();
	
	private static final String SQL_SELECT_REVIEW_BY_REV_NUM = "SELECT * FROM REVIEW WHERE REV_NUM = ?";
	private static final String SQL_DELETE_REVIEW_BY_SALE_NUM= "DELETE * FROM REVIEW WHERE SALE_NUM = ?";
	private static final String SQL_INSERT_REVIEW = "INSERT INTO REVIEW (SALE_NUM, ID, REV_CONTENT, REV_STARS) VALUES (?, ?, ?, ?)";
																

	
	public static int insertReview(DTOReview rev) {
		DTOReview reivew = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultRow=0;
		try {
			conn = instance.getConnection();
			pstmt = conn.prepareStatement(SQL_INSERT_REVIEW);			
			pstmt.setInt(1, rev.getSaleNum());
			pstmt.setString(2, rev.getId());
			pstmt.setString(3, rev.getRevContent());
			pstmt.setInt(4, rev.getRevStars());		
			rs = pstmt.executeQuery();
			resultRow = pstmt.executeUpdate();
			while(rs.next()) {
				reivew = lee2_DAOReview.setDTOReview(rs);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			instance.freeConnection(conn, pstmt);
		}
		
		return resultRow;
	}
	
	public static int delete(int saleNum) {
		DTOReview salePost = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultRow=0;
		try {
			conn = instance.getConnection();
			pstmt = conn.prepareStatement(SQL_DELETE_REVIEW_BY_SALE_NUM);
			pstmt.setInt(1, saleNum);
			rs = pstmt.executeQuery();	
			resultRow = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			instance.freeConnection(conn, pstmt);
		}
		
		return resultRow;
	}
	
	
	private static DTOReview setDTOReview(ResultSet rs) throws SQLException {
		int sale_num = rs.getInt("SALE_NUM");
		String id = rs.getString("ID");
		String rev_content = rs.getString("REV_CONTENT").trim();
		int rev_stars = rs.getInt("REV_STARS");
		
		DTOReview review = new DTOReview(sale_num, id, rev_content, rev_stars);
		return review;
	}
	
	
}
