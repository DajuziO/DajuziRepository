package Utils;
/**
 *poi读取用例
 *
 */
public class Usecase {
	private String id;
	private String name;
	private String data;
	private String[] result;
public  Usecase(String id,String name,String data,String[] result){
	 this.id=id;
	 this.name=name;
	 this.data=data;
	 this.result=result;
}
public String getid (){
	return id;
	
}
public String getName(){
	return name;
	
}
public String getdata(){
	return data;
	
}
public String getresult(int i){
	String res=result[i];
	return res;
	
}
}
