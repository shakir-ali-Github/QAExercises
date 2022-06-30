
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExercise {
	
	//Exercise 1
	
	public static void main(String[] args) {
	    List<String> names = Arrays.asList("Michael", "Dean", "James", "Chris");
	    List<String> result = 
	        names.stream()
	            .filter(str -> !str.equals("James"))
	            .collect(Collectors.toList());
	    
	    result.forEach(i -> System.out.println("Hello " + i));
	      
	
	//Exercise 2
	
	    List<Integer> number = Arrays.asList(3,4,7,8,12);
	    int mult = 
	        number.stream()
	            .reduce((a,b) -> a*b)
	            .get();
	    System.out.println(mult);
	    }
	
	//Exercise 3
	
	List<Integer> number = Arrays.asList(3,4,7,8,12, 16, 21, 36,45);
	
	
	

}
