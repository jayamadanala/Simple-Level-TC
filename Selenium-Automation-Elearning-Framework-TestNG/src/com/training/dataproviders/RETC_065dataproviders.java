package com.training.dataproviders;

import java.util.List;
import org.testng.annotations.DataProvider;
import com.training.bean.RETC_065Bean;
import com.training.dao.RETC_065DAO;
import com.training.readexcel.ApachePOIExcelRead;


public class RETC_065dataproviders {
	
	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<RETC_065Bean> list = new RETC_065DAO().getposts(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RETC_065Bean temp : list){
			Object[]  obj = new Object[8]; 
			
			obj[0] = temp.getUserName();
			obj[1] = temp.getPassword();
			obj[2] = temp.getName();
			obj[3] = temp.getSlug();
			obj[4] = temp.getDescription();
			obj[5] = temp.getTitle();
			obj[6] = temp.getBody();
			obj[7] = temp.getPhrase();
			
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}

	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\testdata1.xlsx\\"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}}
