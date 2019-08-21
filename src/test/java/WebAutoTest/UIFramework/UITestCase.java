package WebAutoTest.UIFramework;

import java.util.ArrayList;

public class UITestCase {
	
	private String name;
	private String testmodel;
	private String[] testdata;
	private String exceptedresult;
	private String isnot;

	public UITestCase(String name, String testmodel, String[] testdata, String exceptedresult, String isnot) {
		this.name = name;
		this.testmodel = testmodel;
		this.testdata = testdata;
		this.exceptedresult = exceptedresult;
		this.isnot = isnot;
	}
	
	public String getName() {
		return name;
	}
	public String getTestmodel() {
		return testmodel;
	}
	public String[] getTestdata() {
		return testdata;
	}
	public String getExceptedresult() {
		return exceptedresult;
	}
	public String getIsnot() {
		return isnot;
	}
	
	
	

}
