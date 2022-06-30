interface StringFunction {
	
	String run(String str);
	
}
public class Lambda {
	
	public static void main(String[] args) {
	    StringFunction exclaim = (s) -> s + "!";
	    StringFunction ask = (s) -> s + "?";
	    StringFunction speech = (s) -> "'" + s + "'";
	    StringFunction adele = (s) -> s + " from the other side";
	    
	    printFormatted("Hello", exclaim);
	    printFormatted("Hello", ask);
	    printFormatted("Hello", speech);
	    printFormatted("Hello", adele);
	    printFormatted("Shak", speech);
	    printFormattedNew("Shak", exclaim, speech);
	  }
	  public static void printFormatted(String str, StringFunction format) {
	    String result = format.run(str);
	    System.out.println(result);
	  }
	  
	  public static void printFormattedNew(String str, StringFunction format, StringFunction format1) {
		    String result = format.run(str);
		    String resultnew = format1.run(result);
		    System.out.println(resultnew);
		  }

}
