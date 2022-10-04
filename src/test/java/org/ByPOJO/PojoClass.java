package org.ByPOJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PojoClass {
  
	private String FName;
	private String LName;
	private int Age;
//	private String Address;
	
	private String AllOk;
	
	
	public String getAllOk() {
		return AllOk;
	}
	public void setAllOk(String allOk) {
		AllOk = allOk;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	


}
