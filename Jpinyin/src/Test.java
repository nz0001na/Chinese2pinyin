import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Test {
	public static void lastnameprocess(File input,File lastnamedict){
		try{
		BufferedReader br = new BufferedReader(new FileReader(input));
		BufferedWriter bw = new BufferedWriter(new FileWriter(lastnamedict));
		String line=null;
		Set<Character> lastname = new HashSet<Character>();
	    while((line=br.readLine())!=null){
	    	char last = line.split("\\s+")[1].charAt(0);
	    	String[] lastpy = PinyinHelper.convertToPinyinArray(last, PinyinFormat.WITHOUT_TONE);
	    	if(lastpy.length > 1 && (lastname.isEmpty() || !lastname.contains(last))){
	    		StringBuilder sb = new StringBuilder();
	    		Set<String> pytmp = new HashSet<String>();
	    		boolean issame=true;
	    		for(String onepy : lastpy) {
	    			sb.append(onepy+" ");
	    			if(pytmp.isEmpty() || issame && !pytmp.contains(onepy)) 
	    				issame = false;
	    	    }
	    		if(!issame){
	    		bw.write(last+"="+sb+"\n");
	    		lastname.add(last);
	    		}
	    	}
	    }
	    bw.flush();
	    bw.close();
	    br.close();
	    }catch(IOException ioe){
	    	ioe.printStackTrace();
	    }
	}
	
public static void main(String[] args) throws PinyinException{
	String teststr = "阿兰·达瓦卓玛";
	System.out.println(PinyinHelper.convertToPinyinString(teststr, "", PinyinFormat.WITHOUT_TONE));
    long start = System.currentTimeMillis();
    File input = new File("japan_m.txt");
    File lastnamedict = new File("lastname.dict");
    File output = new File("py_japan_m.txt");
    try{
    BufferedReader lbr = new BufferedReader(new FileReader(lastnamedict));
    String lline;
    Map<Character,String> lastname = new HashMap<Character,String>();
    while((lline=lbr.readLine())!=null)
    	lastname.put(lline.charAt(0), lline.substring(2,lline.length()));
    lbr.close();
    BufferedReader br = new BufferedReader(new FileReader(input));
    BufferedWriter bw = new BufferedWriter(new FileWriter(output));
    String line = null;
    while((line=br.readLine())!=null){
    	StringBuilder sb = new StringBuilder();
    	String no = line.split("\\s+")[0];
    	sb.append(no+"\t");
    	String name = line.split("\\s+")[1];
    	
//    	String name = line;
    	
    	if(lastname.containsKey(name.charAt(0))){
    		sb.append(lastname.get(name.charAt(0)));
    		sb.append(PinyinHelper.convertToPinyinString(name.substring(1,name.length()),"", PinyinFormat.WITHOUT_TONE));
    	}else{
    		sb.append(PinyinHelper.convertToPinyinString(name, "",PinyinFormat.WITHOUT_TONE));
    	}	
    	bw.write(sb+"\r\n");
    }
    bw.flush();
    bw.close();
    br.close();
    }catch(FileNotFoundException fe1){
    	fe1.printStackTrace();
    }catch(IOException ioe){
    	ioe.printStackTrace();
    }
    System.out.println("Time:"+(System.currentTimeMillis()-start)/1000.0);
}
}