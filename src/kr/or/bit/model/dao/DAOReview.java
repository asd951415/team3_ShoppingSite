package kr.or.bit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import kr.or.bit.model.DBManager;
import kr.or.bit.model.dto.DTOReview;
import kr.or.bit.model.dto.DTOSalePost;

public class DAOReview {
	private static DBManager instance = DBManager.getInstance();
	
	private static final String SQL_SELECT_REVIEW_BY_REV_NUM = "SELECT * FROM REVIEW WHERE REV_NUM = ?";
	private static final String SQL_SELECT_REVIEW_BY_SALE_NUM = "SELECT * FROM REVIEW WHERE SALE_NUM = ?";
	private static final String SQL_DELETE_REVIEW_BY_SALE_NUM= "DELETE * FROM REVIEW WHERE SALE_NUM = ?";
	private static final String SQL_INSERT_REVIEW = "INSERT INTO REVIEW (SALE_NUM, ID, REV_CONTENT, REV_STARS) VALUES (?, ?, ?, ?)";
																

	
	public List<Map<String,Object>> getReview(int saleNum) {
		DTOReview reivew = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map;
		
		try {
			conn = instance.getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_REVIEW_BY_SALE_NUM);
			pstmt.setInt(1, saleNum);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				reivew = DAOReview.setDTOReview(rs);
				map = new HashedMap();
				map.put("rev_num",reivew.getRevNum());
				map.put("sale_num",reivew.getSaleNum());
				map.put("rev_content", reivew.getRevContent());
				map.put("rev_stars", reivew.getRevStars());
				map.put("rev_created_at", reivew.getRevCreatedAt());
				list.add(map);
				
				
				
			}
			
			for(int i=0; i<list.size(); i++) {
				System.out.println(i+": "+list.get(i));
			}
			
	
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			instance.freeConnection(conn, pstmt);
			
		}
		
		return list;
	}
	
	
	
	
	
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
				reivew = DAOReview.setDTOReview(rs);
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
		int rev_num = rs.getInt("rev_num");
		int sale_num = rs.getInt("SALE_NUM");
		String id = rs.getString("ID");
		String rev_content = rs.getString("REV_CONTENT").trim();
		int rev_stars = rs.getInt("REV_STARS");
		Date rev_created_at = rs.getDate("rev_created_at");
		DTOReview review = new DTOReview(rev_num,sale_num, id, rev_content, rev_stars,rev_created_at);
		return review;
	}
	
	
}
