package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.RETC_065Bean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class RETC_065DAO {
	
Properties properties; 
	
	public RETC_065DAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<RETC_065Bean> getposts(){
		String sql = properties.getProperty("get.posts"); 
		
		GetConnection gc  = new GetConnection(); 
		List<RETC_065Bean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<RETC_065Bean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				RETC_065Bean temp = new RETC_065Bean(); 
				
				temp.setUserName(gc.rs1.getString(1));
				temp.setPassword(gc.rs1.getString(2));
				temp.setName(gc.rs1.getString(3));
				temp.setSlug(gc.rs1.getString(4));
				temp.setDescription(gc.rs1.getString(5));
				temp.setTitle(gc.rs1.getString(6));
				temp.setBody(gc.rs1.getString(7));
				temp.setPhrase(gc.rs1.getString(8));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new RETC_065DAO().getposts().forEach(System.out :: println);
	}
	

}
