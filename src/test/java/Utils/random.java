package Utils;

public class random {
	public static char getRandomChar() {
        return (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
    }
public static String get(int y){
	String str="";
	for(int i=0;i<y;i++){
	str=str+getRandomChar();
	}
	return str;
	
}
}
