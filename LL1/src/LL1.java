
public class LL1 {

	/**
	 * main function
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input =
//		"QUERY TRUE." ;
//	    "QUERY FALSE.";
//		"QUERY ~TRUE.";
//		"QUERY ~FALSE.";
//		
//		"QUERY TRUE -> TRUE.";
//		"QUERY TRUE -> FALSE.";
//		"QUERY FALSE -> TRUE.";
//		  "QUERY FALSE -> FALSE.";
		
//		  "QUERY TRUE <=> TRUE.";
//		 "QUERY TRUE <=> FALSE." ;
//		 "QUERY FALSE <=> TRUE." ;
//		  "QUERY FALSE <=> FALSE." ;
//		
//		  "LET p = TRUE;  LET q = TRUE;  QUERY p & q." ;
//		 "LET p = TRUE;  LET q = FALSE; QUERY p & q." ;
//		 "LET p = FALSE; LET q = TRUE;  QUERY p & q." ;
//		 "LET p = FALSE; LET q = FALSE; QUERY p & q." ;
//		
//		  "LET p = TRUE;  LET q = TRUE;  LET r = TRUE;   QUERY p & q & r." ;
//		 "LET p = TRUE;  LET q = TRUE;  LET r = FALSE;  QUERY p & q & r." ;
//		 "LET p = TRUE;  LET q = FALSE; LET r = TRUE;   QUERY p & q & r." ;
//		 "LET p = TRUE;  LET q = FALSE; LET r = FALSE;  QUERY p & q & r." ;
//		 "LET p = FALSE; LET q = TRUE;  LET r = TRUE;   QUERY p & q & r." ;
//		 "LET p = FALSE; LET q = TRUE;  LET r = FALSE;  QUERY p & q & r." ;
//		 "LET p = FALSE; LET q = FALSE; LET r = TRUE;   QUERY p & q & r." ;
//		 "LET p = FALSE; LET q = FALSE; LET r = FALSE;  QUERY p & q & r." ;
//		
//		  "LET p = TRUE;  LET q = TRUE;  QUERY p | q." ;
//		  "LET p = TRUE;  LET q = FALSE; QUERY p | q." ;
//		  "LET p = FALSE; LET q = TRUE;  QUERY p | q." ;
//		 "LET p = FALSE; LET q = FALSE; QUERY p | q." ;
//		
//		  "LET p = TRUE;  LET q = TRUE;  LET r = TRUE;   QUERY p | q | r." ;
//		  "LET p = TRUE;  LET q = TRUE;  LET r = FALSE;  QUERY p | q | r." ;
//		  "LET p = TRUE;  LET q = FALSE; LET r = TRUE;   QUERY p | q | r." ;
//		  "LET p = TRUE;  LET q = FALSE; LET r = FALSE;  QUERY p | q | r." ;
//		  "LET p = FALSE; LET q = TRUE;  LET r = TRUE;   QUERY p | q | r." ;
//		  "LET p = FALSE; LET q = TRUE;  LET r = FALSE;  QUERY p | q | r." ;
//		  "LET p = FALSE; LET q = FALSE; LET r = TRUE;   QUERY p | q | r." ;
//		 "LET p = FALSE; LET q = FALSE; LET r = FALSE;  QUERY p | q | r." ;
//
//		  "LET p = TRUE;  LET q = TRUE;  QUERY p -> q." ;
//		 "LET p = TRUE;  LET q = FALSE; QUERY p -> q." ;
//		  "LET p = FALSE; LET q = TRUE;  QUERY p -> q." ;
//		  "LET p = FALSE; LET q = FALSE; QUERY p -> q." ;
//		
//		  "LET p = TRUE;  LET q = TRUE;  LET r = TRUE;   QUERY p -> q -> r." ;
//		 "LET p = TRUE;  LET q = TRUE;  LET r = FALSE;  QUERY p -> q -> r." ;
//		  "LET p = TRUE;  LET q = FALSE; LET r = TRUE;   QUERY p -> q -> r." ;
//		  "LET p = TRUE;  LET q = FALSE; LET r = FALSE;  QUERY p -> q -> r." ;
//		  "LET p = FALSE; LET q = TRUE;  LET r = TRUE;   QUERY p -> q -> r." ;
//		  "LET p = FALSE; LET q = TRUE;  LET r = FALSE;  QUERY p -> q -> r." ;
//		  "LET p = FALSE; LET q = FALSE; LET r = TRUE;   QUERY p -> q -> r." ;
//		  "LET p = FALSE; LET q = FALSE; LET r = FALSE;  QUERY p -> q -> r." ;
//		
//		  "LET p = TRUE;  LET q = TRUE;  QUERY p <=> q." ;
//		 "LET p = TRUE;  LET q = FALSE; QUERY p <=> q." ;
//		 "LET p = FALSE; LET q = TRUE;  QUERY p <=> q." ;
//		  "LET p = FALSE; LET q = FALSE; QUERY p <=> q." ;
//		
//		  "LET p = TRUE;  LET q = TRUE;  LET r = TRUE;   QUERY p <=> q <=> r." ;
//		 "LET p = TRUE;  LET q = TRUE;  LET r = FALSE;  QUERY p <=> q <=> r." ;
//		 "LET p = TRUE;  LET q = FALSE; LET r = TRUE;   QUERY p <=> q <=> r." ;
//		  "LET p = TRUE;  LET q = FALSE; LET r = FALSE;  QUERY p <=> q <=> r." ;
//		 "LET p = FALSE; LET q = TRUE;  LET r = TRUE;   QUERY p <=> q <=> r." ;
//		  "LET p = FALSE; LET q = TRUE;  LET r = FALSE;  QUERY p <=> q <=> r." ;
//		  "LET p = FALSE; LET q = FALSE; LET r = TRUE;   QUERY p <=> q <=> r." ;
//		 "LET p = FALSE; LET q = FALSE; LET r = FALSE;  QUERY p <=> q <=> r." ;
//		
//		  "LET p = TRUE;  QUERY p." ;
//		 "LET p = FALSE; QUERY p." ;
//		 "LET p = TRUE;  QUERY ~p." ;
//		  "LET p = FALSE; QUERY ~p." ;
//		  "LET p = TRUE;  QUERY ~(~p)." ;
//		 "LET p = FALSE; QUERY ~(~p)." ;
//		  "LET p = TRUE;  QUERY (p)." ;
//		 "LET p = FALSE; QUERY (p)." ;
//		  "LET p = TRUE;  QUERY ((p))." ;
//		 "LET p = FALSE; QUERY ((p))." ;
//		
//		  "LET p = TRUE;  LET q = TRUE;  QUERY ~(p & q) <=> (~p | ~q).";
//		  "LET p = TRUE;  LET q = FALSE; QUERY ~(p & q) <=> (~p | ~q).";
//		  "LET p = FALSE; LET q = TRUE;  QUERY ~(p & q) <=> (~p | ~q).";
//		  "LET p = FALSE; LET q = FALSE; QUERY ~(p & q) <=> (~p | ~q).";
//		
//		  "LET p = TRUE;  LET q = TRUE;  QUERY (p -> q) <=> (~p | q).";
//		  "LET p = TRUE;  LET q = FALSE; QUERY (p -> q) <=> (~p | q).";
//		  "LET p = FALSE; LET q = TRUE;  QUERY (p -> q) <=> (~p | q).";
//		  "LET p = FALSE; LET q = FALSE; QUERY (p -> q) <=> (~p | q).";
//		
//		  "LET p = TRUE;  LET q = TRUE;  QUERY p -> q <=> ~p | q.";
//		  "LET p = TRUE;  LET q = FALSE; QUERY p -> q <=> ~p | q.";
//		  "LET p = FALSE; LET q = TRUE;  QUERY p -> q <=> ~p | q.";
//		  "LET p = FALSE; LET q = FALSE; QUERY p -> q <=> ~p | q.";
//	

		
//		  "LET p = TRUE;  LET q = p;  QUERY q." ;
//		 "LET p = FALSE; LET q = p;  QUERY q." ;
//		 "LET p = TRUE;  LET q = ~p; QUERY q." ;
//		  "LET p = FALSE; LET q = ~p; QUERY q." ;
//		
//		 "LET p = TRUE;  LET q = TRUE;  LET r = ~p & ~q; QUERY r." ;
//		 "LET p = TRUE;  LET q = FALSE; LET r = ~p & ~q; QUERY r." ;
//		 "LET p = FALSE; LET q = TRUE;  LET r = ~p & ~q; QUERY r." ;
//		  "LET p = FALSE; LET q = FALSE; LET r = ~p & ~q; QUERY r." ;
//		
//		  "LET red = TRUE;     QUERY red." ;
//		 "LET orange = FALSE; QUERY orange." ;
//		 "LET yellow = TRUE;  QUERY ~yellow." ;
//		  "LET green = FALSE;  QUERY ~green." ;
//		  "LET blue = TRUE;    QUERY ~(~blue)." ;
//		 "LET purple = FALSE; QUERY ~(~purple)." ;
//		
//		  "let p = true;     query p." ;
//		  "let P = true;     query P." ;
		  "let p = true;     query P." ;
//		  "let P = true;     query p." ;
		
		boolean result = Parser.parse(input);
		if (result==true)
			System.out.println("Yes");
		else
			System.out.println("No");
		

	}

}
