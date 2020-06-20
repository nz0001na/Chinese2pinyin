import java.util.HashMap;
import java.lang.Character;

public class Parser {

	private static int INDEX = 0; //indicate current location
	private static int LEN_INPUT = 0; //input length
	private static String INPUT = new String(); //global input sentence
	private static String TOKEN = new String();  //current token
	
	private static String [] TOKEN_STACK= new String[20]; //define let stack
	private static int top = 0; //stack top+1
	
	@SuppressWarnings("rawtypes")
	private static HashMap LOOKUP_TABLE = new HashMap();
	
	@SuppressWarnings("unused")
	private static String [] QUERY_STACK = new String[20]; //
	@SuppressWarnings("unused")
	private static int q_top = 0;  //query_stack top
	
	//# indicates beganing and end of a sentence
	private static String [] opset = {"(", ")", "~", "&", "|", "->", "<=>", "#"};  
	private static String [][] priority =  
	{  
			{ "<", "=", "<", "<", "<", "<", "<", ">" },
			{ "<", ">", ">", ">", ">", ">", ">", ">" },
			{ "<", ">", ">", ">", ">", ">", ">", ">" },
			{ "<", ">", "<", ">", ">", ">", ">", ">" },
			{ "<", ">", "<", "<", ">", ">", ">", ">" },
			{ "<", ">", "<", "<", "<", "<", ">", ">" },
			{ "<", ">", "<", "<", "<", "<", ">", ">" },
			{ "<", ">", "<", "<", "<", "<", "<", "=" },
	};  
	
	
		
	/**
	 * main
	 * @param input_sentence
	 * @return
	 */
	public static boolean parse(String input_sentence){
		INPUT = input_sentence;
		LEN_INPUT = input_sentence.length();
		boolean result = false;
				
		INDEX = 0; //indicate current location
		top = 0; //stack top+1
		LOOKUP_TABLE = new HashMap();
		q_top = 0;  //query_stack top
				
		// construct lookup table
		construct_table();
		
		// compute query statement
		result = query();
		
		System.out.println("**************RESULT*************");	
		System.out.println("result="+result);
		
		return result;		
	}
	
		
	/***
	 * Execute query statement
	 * @return boolean
	 */
	private static boolean query(){
		System.out.println("**************QUERY*************");	
		String result = new String();
		String [] query = new String[20];
		int i=0;
		
		// put tokens in to an array
		TOKEN=peek();
		while(!TOKEN.trim().equals(".")){
			query[i]=TOKEN.trim();
			i++;
			TOKEN=peek();
		}
		query[i]="#";
		
		String [] P = new String[10]; // operands stack
		int top_p = 0;  // stack top
		String [] Q = new String[10]; // operator stack
		int top_q = 0;  //query_stack top
		Q[top_q] = "#";
		top_q++;
		i=0;
		
		while(!query[i].equals("#") || !Q[top_q-1].trim().equals("#")){	
			// operands are TRUE/FALSE
			if(query[i].toUpperCase().equals("TRUE") || query[i].toUpperCase().equals("FALSE")){
				P[top_p]=query[i];
				top_p++;
				i++;
			}
			//operands are variables
			else if(LOOKUP_TABLE.get(query[i].toLowerCase()) != null){
				String value = (String) LOOKUP_TABLE.get(query[i].toLowerCase());
				P[top_p]=value;
				top_p++;
				i++;	
			}else // expression
            {  
				// get top element of operators
				String op = Q[top_q-1];
				//compare priority of op in Stack and current token
				String r= compare(op, query[i]);
				System.out.println("r:"+r);
				
				if(r.equals("<")){
					 Q[top_q]=query[i];
					 i++;
					 top_q++;							
				}else
				if(r.equals("=")){
					top_q--;
                    Q[top_q]=null;
                    i++;	
				}else
				if(r.equals(">")){
					if(Q[top_q-1].trim().equals("~"))  
                    {   // top_q elemnt is  '~'
                    	String operand_value = new String();
                    	operand_value = P[top_p-1];
                        	                       	                        
                        String value = new String();
                        if(operand_value.trim().toUpperCase().equals("TRUE"))
                        	value = "FALSE";
                        if(operand_value.trim().toUpperCase().equals("FALSE"))
                        	value = "TRUE";	                        	
                        top_p--;
                        P[top_p]=null;
                        P[top_p]=value;
                        top_p++;
                        
                        top_q--;
                        Q[top_q]=null; 
                    }  
                    else  
                    {   // top_q elemnt is not '~', binary operators
                    	String operand_value_2 = P[top_p-1] ;  
                    	top_p--;
                    	P[top_p]=null;
                    	String operand_value_1 = P[top_p-1]; 
                    	top_p--;
                    	P[top_p]=null;
                    	
                    	String operator = Q[top_q-1].trim();
                    	top_q--;
                    	Q[top_q]=null;
                    	// calculate values
                    	String re = calculate(operand_value_1, operand_value_2, operator);
                    	P[top_p]=re;
                    	top_p++;	                    	
                    } 		
				}           
            }//else  		  
		}
	
		result = P[top_p-1].trim();
		if(result.toUpperCase().equals("TRUE")){
			return true;
		}			
		else
			return false;
	}
	
	
	
	//calculate  x y with op  
	private static String calculate(String x, String y, String op)  
	{  
		int a=0;
		int b=0;
		int c=1;
//		String result = new String();
		if(x.equals("TRUE")){
			a=1;
		}
		else if(x.equals("FALSE")){
			a=0;
		}
			
		if(y.equals("TRUE")){
			b=1;
		}else if(y.equals("FALSE")){
			b=0;	
		}
			
		
		if(op.equals("&")){
			if(a==0 && b==0)c=0;
			if(a==0 && b==1)c=0;
			if(a==1 && b==0)c=0;
			if(a==1 && b==1)c=1;	
		}
		if(op.equals("|")){
//			c= a | b;
			if(a==0 && b==0)c=0;
			if(a==0 && b==1)c=1;
			if(a==1 && b==0)c=1;
			if(a==1 && b==1)c=1;
		}
		if(op.equals("->")){
			if(a==0 && b==0)c=1;
			if(a==0 && b==1)c=1;
			if(a==1 && b==0)c=0;
			if(a==1 && b==1)c=1;	
		}
		if(op.equals("<=>")){
			if(a==0 && b==0)c=1;
			if(a==0 && b==1)c=0;
			if(a==1 && b==0)c=0;
			if(a==1 && b==1)c=1;
		}
			
		if(c==1)return "TRUE";
		else
			return "FALSE";
	    
	}  
	

	/**
	 * Compare top of Q with current token
	 * @param a
	 * @param b
	 * @return
	 */
	private static String compare(String a, String b)  
	{  
	    int x = findindex(a);  
	    int y = findindex(b);  
	    return priority[x][y];  
	}  
	

	/**
	 * Find index in array opset
	 * @param operator
	 * @return index
	 */
	private static int findindex(String op)  
	{  
		int index=0;
	    for(int i = 0; i < opset.length; i++)  
	    {  
	        if(opset[i].equals(op))  
	        	index=i;	             
	    }  
	    return index; 
	} 
	
	
	/***
	 * construct look up table
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	private static void construct_table(){
		String key = new String();
		String value = new String();
		int flag=0; //&
		int tag = 0;//~
		
		TOKEN = peek();
		while(!TOKEN.trim().toUpperCase().equals("QUERY")){
			
			if(TOKEN.trim().toUpperCase().equals("LET")){
				TOKEN_STACK[top]=TOKEN;
				top++;
				TOKEN = peek();
				continue;
			}
			if(TOKEN.trim().equals("=")){
				key=TOKEN_STACK[top-1];
				TOKEN_STACK[top]=TOKEN;
				top++;
				TOKEN = peek();
				continue;
			}
			if(TOKEN.trim().toUpperCase().equals("TRUE") || TOKEN.trim().toUpperCase().equals("FALSE")){
				value=TOKEN;
				top--;
				TOKEN_STACK[top]=null;
				top--;
				TOKEN_STACK[top]=null;
				TOKEN = peek();
				continue;
			}
			
			if(TOKEN.trim().equals("&")){
//				TOKEN_STACK[top]=TOKEN;
//				top++;	
				flag=1;
				TOKEN = peek();	
				continue;
			}
			if(TOKEN.trim().equals("~")){
				tag=1;
				TOKEN_STACK[top]=TOKEN;
				top++;	
				TOKEN = peek();	
				continue;
			}
			
			if(TOKEN.trim().length()==1 && Character.isLetter(TOKEN.trim().charAt(0)) 
					&& TOKEN_STACK[top-1].trim().equals("=")){
				value = (String) LOOKUP_TABLE.get(TOKEN.trim());
				TOKEN = peek();	
				continue;
			}
			
			if(TOKEN_STACK[top-1].trim().equals("~")){
				top--;
				TOKEN_STACK[top]=null;
				String a_value = (String) LOOKUP_TABLE.get(TOKEN.trim());
				
				if(flag==1){
					if(a_value.trim().equals("TRUE"))
						value = "FALSE";	
					if(a_value.trim().equals("FALSE")){
						if(value.equals("TRUE"))
							value="TRUE";
						if(value.equals("FALSE"))
							value="FALSE";	
						if(value.equals(""))
							value = "TRUE";
						}	
					flag=0;
					
				}else{
											
					if(a_value.trim().equals("TRUE"))
						value="FALSE";			
					if(a_value.trim().equals("FALSE"))
						value="TRUE";		
				}
				top--;
				TOKEN_STACK[top]=null;
				top--;
				TOKEN_STACK[top]=null;
				LOOKUP_TABLE.put(key.toLowerCase(), value);
				TOKEN = peek();	
				continue;
			}
								
			if(TOKEN.trim().equals(";")){
				LOOKUP_TABLE.put(key.toLowerCase(), value);
				key=null;
				value=null;
				TOKEN = peek();
				continue;
			}
			
			TOKEN_STACK[top]=TOKEN;
			top++;	
			TOKEN = peek();	
			
		}//while
		
		System.out.println(LOOKUP_TABLE);
//		display_stack();
//		System.out.println("value="+value);
			
	}//fun
		
		
	
	/***
	 * peek one next token
	 * @return token
	 */
	private static String peek(){
		int current_index = INDEX;
		char [] token = new char[20];
		int i = 0;
		String str = new String();
		if (current_index == LEN_INPUT){
			return "end";
		}
		
		char ch = INPUT.charAt(current_index);									
		if (ch==';' || ch=='.'|| ch=='~' || ch=='(' || ch==')'){
			str = String.valueOf(ch);
			current_index ++;
		}else{
			
			while(ch!= '.' && ch !=';'){
				if (ch ==' ' || ch==')'){
					int len = String.valueOf(token).trim().length();
					if(len==0){
						current_index ++;
						token[i] = ch;
						i++;
						
						ch=INPUT.charAt(current_index);	
						continue;
					}else{
						if(ch==' '){
							current_index ++;
							break;
						}
						if(ch==')'){
							break;
						}						
					}
				}else
					if(ch==')'|| ch=='(' || ch=='~'){					
						current_index ++;
						token[i]=ch;
						i++;
						break;
					}else {
						
						token[i] = ch;
						i++;
						current_index ++;
						ch=INPUT.charAt(current_index);						
					}
				
			}//end while
			str = String.valueOf(token);
		}
				
		INDEX = current_index;		
//		System.out.println("Current Index="+INDEX);
		System.out.println("Current Token:" + str);
		return str.trim();
	}
	
	
	/**
	 * Display elements of Stack
	 */
	@SuppressWarnings("unused")
	private static void display_stack(){
		for(int i=0;i<top;i++){
			System.out.println("Stack_"+i+":"+TOKEN_STACK[i]);
		}
	}
	
	
//	/**
//	 * convert string to char array
//	 * @param s
//	 * @return char[]
//	 */
//	private static char [] convert2array(String s){
//		//convert string to array
//		int len_input = s.length();
//		char [] input_array = new char[len_input];
//		for (int i=0; i<len_input; i++){
//			input_array[i]=INPUT.charAt(i);
//		}
//		
//		return input_array;
//	}
	
	
}
