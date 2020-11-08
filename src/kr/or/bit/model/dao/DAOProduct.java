package kr.or.bit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import kr.or.bit.model.DBManager;
import kr.or.bit.model.dto.DTOProduct;

public class DAOProduct {
	private static DBManager instance = DBManager.getInstance();
	
//	private static final String SQL_SELECT_PRODUCTS_BY_PNUM = "SELECT * FROM PRODUCT WHERE P_NUM = ?";
	
	public static List<DTOProduct> getProductsById(JsonArray products){
		List<DTOProduct> productList = new ArrayList<DTOProduct>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			int sizeProducts = products.size();
			String sql = getSQL_SELECT_PRODUCTS_BY_PNUM(sizeProducts - 1);
			conn = instance.getConnection();
			pstmt = conn.prepareStatement(sql);
			Iterator<JsonElement> iter = products.iterator();
			int i = 1;
			while(iter.hasNext()) {
				JsonObject json = iter.next().getAsJsonObject();
				int pNum = json.get("productId").getAsInt();
				pstmt.setInt(i++, pNum);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				DTOProduct product = 
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			instance.freeConnection(conn, pstmt, rs);
		}
		
		return productList;
	}
	
	private static DTOProduct setDTOProduct(ResultSet rs) throws SQLException {
		int pNum = rs.getInt("P_NUM");
		int selNum = rs.getInt("SEL_NUM");
		String pName = rs.getString("P_NAME").trim();
		int pPrice = rs.getInt("P_PRICE");
		String pSize = rs.getString("P_SIZE").trim();
		int pAmount = rs.getInt("P_AMOUNT");
		String pDescription = rs.getString("P_DESCRIPTION").trim();
		return null;
	}
	
	private static String getSQL_SELECT_PRODUCTS_BY_PNUM(int num) {
		String sql = "SELECT * FROM PRODUCT WHERE P_NUM = ?";
		for(int i = 0; i < num; i++) {
			sql += " OR P_NUM = ?";
		}
		return sql;
	}
}