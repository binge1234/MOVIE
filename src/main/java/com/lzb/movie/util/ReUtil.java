package com.lzb.movie.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReUtil {
	public static String get(String regex, String content, int groupIndex) {
		if(null == content || null == regex){
			return null;
		}
		
		Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
		return get(pattern, content, groupIndex);
	}
	
	public static String get(Pattern pattern, String content, int groupIndex) {
		if(null == content || null == pattern){
			return null;
		}
		
		Matcher matcher = pattern.matcher(content);
		if (matcher.find()) {
			return matcher.group(groupIndex);
		}
		return null;
	}
}
