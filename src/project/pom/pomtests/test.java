package pom.pomtests;

public class test {
	 public static void main(String[] args) {
	      
		 String str = "one two thr'ee fou'r five s'i'x seven";
		 String arr[] = str.split("\\s+");

		 String temp ="" ;
		 for(String a : arr ){
		   if(a.contains("'")) {
		 	temp = temp + a; 
		   }else{
		 	System.out.println(temp);
			System.out.println(a);
		 	temp =""; 
		   }
		   
		 }
		     }
}
