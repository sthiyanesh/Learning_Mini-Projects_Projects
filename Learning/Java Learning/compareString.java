public class compareString{
	public static void main(String[] args){
		String s1 = "SVT";
		String s2 = "SVT";
		String s3 = "King";
		String s4 = "King_SVT";

		System.out.println("Comparing strings with compareTo:");
		System.out.println("Comparing \""+s1+"\" and \""+s2+"\" : "+((s1.compareTo(s2)==0)?"Same":"Different"));
		System.out.println("Comparing \""+s1+"\" and \""+s3+"\" : "+((s1.compareTo(s3)==0)?"Same":"Different"));
		System.out.println("Comparing \""+s1+"\" and \""+s3+"\" : "+((s1.compareTo(s3)==0)?"Same":"Different"));
		
	}
}