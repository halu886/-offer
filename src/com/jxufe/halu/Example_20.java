package com.jxufe.halu;

public class Example_20 {
	
	public static void main(String[] args) {
		System.out.println(match("aaa", "ab*ac*a"));
	}
	
	public static boolean match(String str,String pattern) {
		if(str.isEmpty()||pattern.isEmpty()){
			return false;
		}
		int strIndex = 0;
		int patternIndex = 0;
		for (;strIndex<str.length()&&patternIndex<pattern.length(); strIndex++,patternIndex++) {
			if(str.indexOf(strIndex)==pattern.indexOf(patternIndex)&&pattern.indexOf(patternIndex)!='.'&&
					pattern.indexOf(patternIndex)!='*'){
				continue;
			}else if (pattern.indexOf(patternIndex)=='.') {
				continue;
			}else if(str.indexOf(strIndex)!=pattern.indexOf(patternIndex)){
				if(pattern.indexOf(patternIndex++)=='*'){
					strIndex--;
					patternIndex++;
					continue;
				}else{
					return false;
				}
			}
		}
		if(strIndex!=str.length()||patternIndex!=pattern.length())
			return false;
		else {
			return true;
		}
	}

}
