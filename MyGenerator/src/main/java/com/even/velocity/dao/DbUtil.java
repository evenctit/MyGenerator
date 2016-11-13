package com.even.velocity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.even.velocity.constants.DbMapping;
import com.even.velocity.model.Column;
import com.even.velocity.model.Table;
import com.even.velocity.util.StringUtil;

public class DbUtil {
	
	public static Connection conn = DbConnection.getInstance().getMysqlConnection();
	
	public static List<Table> getAllTables(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Table> list = new ArrayList<Table>();
		try {
			pstmt = conn.prepareStatement("show tables;");
			rs = pstmt.executeQuery();
			if(rs != null){
				while(rs.next()){
					String a = rs.getString(1);
					list.add(getAllColumns(a));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static Table getAllColumns(String tableName){
		PreparedStatement pstmt = null;
		ResultSetMetaData rsmd = null;
		ResultSet rs = null;
		int columnCount;
		Table table = new Table();
		table.setName(tableName);
		List<Column> list = new ArrayList<Column>();
		try {
			pstmt = conn.prepareStatement("select * from " + tableName + " limit 1");
			rs = pstmt.executeQuery();
			Column col = null;
			if(rs != null){
					rsmd = rs.getMetaData();
					columnCount = rsmd.getColumnCount(); 
					for (int i=1; i<=columnCount; i++){   
						col = new Column();
						col.setTable(tableName);
						col.setOriginalName(rsmd.getColumnName(i));
						col.setColName(StringUtil.transformColumnName(rsmd.getColumnName(i)));
						col.setCamelName(StringUtil.transformToCamelName(rsmd.getColumnName(i)));
						col.setType(DbMapping.dbMapping.get(rsmd.getColumnTypeName(i)));
//						System.out.println(rsmd.getColumnTypeName(i));
						
						list.add(col);
				     }   
			}
			table.setColumnList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return table;
	}

}
