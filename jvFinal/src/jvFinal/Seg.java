package jvFinal;
import org.fnlp.nlp.cn.CNFactory;
import org.fnlp.nlp.cn.CNFactory.Models;
import taobe.tec.jcc.JChineseConvertor;
public class Seg {
	
	public String posStr (String str)throws Exception{
		JChineseConvertor jChineseConvertor = JChineseConvertor.getInstance();
	 	CNFactory factory = CNFactory.getInstance("models");
	 	String simple =jChineseConvertor.t2s(str);
	 	String[][] result = factory.tag(simple);
	 	String myStr="";
	 	for(int i = 0 ; i < result[0].length; i++){
	 		myStr=myStr+jChineseConvertor.s2t(result[0][i])+"("+jChineseConvertor.s2t(result[1][i])+") ";
	 		
	 	}
	 	return myStr;
	
	}
	
}