package kr.or.bit.model.dao;

import kr.or.bit.model.DBManager;
import kr.or.bit.model.dto.DTOPdInqPost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class DAOInquiryPost {
    private static DBManager instance = DBManager.getInstance();
    private static final String SQL_SELECT_PDINQPOST = "SELECT * FROM PD_INQ_POST";
    private static final String SQL_SELECT_PDINQPOST_BY_SALE_NUM_AND_ID = "SELECT * FROM PD_INQ_POST WHERE SALE_NUM = ? AND ID = ?";
    private static final String lim_SQL_UPDATE_INQUIRY_POST_PRIVATE = "UPDATE PD_INQ_POST SET INQ_PRIVATE_FLAG = 'Y' INQ_NUM=?";
    private static final String lim_SQL_INSERT_INQUIRY_POST = "INSERT INTO PD_INQ_POST(SALE_NUM, ID, INQ_TITLE, INQ_CONTENT, INQ_PRIVATE_FLAG) VALUES (?,?,?,?,?)";


    public static int lim_inquiryPost_pri(int inqNum ) {
        int resultRow = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = instance.getConnection();
            pstmt = conn.prepareStatement(lim_SQL_UPDATE_INQUIRY_POST_PRIVATE);
            pstmt.setInt(1,inqNum);
            resultRow = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }finally {
            instance.freeConnection(conn,pstmt);
        }
        return resultRow;
    }

    public static int lim_inquiryPost(DTOPdInqPost pdInqPost) {
        int resultRow = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = instance.getConnection();
            pstmt = conn.prepareStatement(lim_SQL_INSERT_INQUIRY_POST);
            pstmt.setInt(1,pdInqPost.getSaleNum());
            pstmt.setString(2,pdInqPost.getId());
            pstmt.setString(3,pdInqPost.getInqTitle());
            pstmt.setString(4,pdInqPost.getInqContent());
            pstmt.setInt(5, pdInqPost.getInqPrivate());;
            resultRow = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            instance.freeConnection(conn,pstmt);
        }
        return resultRow;
    }
    
    public List<DTOPdInqPost> inqPostList() {
		int resultRow = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<DTOPdInqPost> list = null;
		try {
			DTOPdInqPost inqPost = new DTOPdInqPost();
			conn = instance.getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_PDINQPOST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				inqPost = DAOInquiryPost.setDTOInqAnsPost(rs);
				list.add(inqPost);
			}
		} catch(SQLException e) { 
			e.printStackTrace();
		} finally {
			instance.freeConnection(conn, pstmt);
		}
		
		return list;
	}
    
    public DTOPdInqPost selectInqPostByInqNum(DTOPdInqPost inqPost) {
		int resultRow = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = instance.getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_PDINQPOST_BY_SALE_NUM_AND_ID);
			pstmt.setInt(1, inqPost.getSaleNum());
			pstmt.setString(2, inqPost.getId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				inqPost = DAOInquiryPost.setDTOInqAnsPost(rs);
				
			}
		} catch(SQLException e) { 
			e.printStackTrace();
		} finally {
			instance.freeConnection(conn, pstmt);
		}
		
		return inqPost;
	}
    
  
    
    private static DTOPdInqPost setDTOInqAnsPost(ResultSet rs) throws SQLException {
		int inqNum = rs.getInt("inq_num");
		int saleNum = rs.getInt("sale_num");
		String id = rs.getString("id").trim();
		String inqTitle = rs.getString("inq_title");
		String inqContent = rs.getString("inq_content").trim();
		char inqPrivate = (char) rs.getInt("inq_private_flag");
		Date inqCreated = rs.getDate("inq_created_at");
		
		DTOPdInqPost inqPost = new DTOPdInqPost(inqNum, saleNum, id, inqTitle, inqContent, inqPrivate, inqCreated);
		
		return inqPost;
	}
}