package com.training.dataproviders;

import java.util.List;
import org.testng.annotations.DataProvider;
import com.training.bean.RealEstateBean;
import com.training.dao.RealEstateDAO;
import com.training.readexcel.ApachePOIExcelRead;


public class RealEstatedataproviders {
	
	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<RealEstateBean> list = new RealEstateDAO().getapartments(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RealEstateBean temp : list){
			Object[]  obj = new Object[4]; 
			
			obj[0] = temp.getName();
			obj[1] = temp.getEmail();
			obj[2] = temp.getSubject();
			obj[3] = temp.getMessage();
			
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}

	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\testdata.xlsx\\"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
}
