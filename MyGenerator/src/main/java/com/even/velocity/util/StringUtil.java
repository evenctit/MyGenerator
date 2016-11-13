package com.even.velocity.util;

public class StringUtil {
	
	public static void main(String[] args) {
		String abc = "my_name_abc";
		String result = transformColumnName(abc);
		System.out.println(result);
		result = transformToCamelName(abc);
		System.out.println(result);
		abc = "my";
		result = transformToCamelName(abc);
		System.out.println(result);
	}
	
	public static String transformColumnName(String originalName){
		String[] arr = originalName.split("_");
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < arr.length; i ++){
			sb.append(arr[i].substring(0, 1).toUpperCase()).append(arr[i].substring(1).toLowerCase());
		}
		return sb.toString();
	}
	
	public static String transformToCamelName(String originalName){
		String[] arr = originalName.split("_");
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < arr.length; i ++){
			sb.append(arr[i].substring(0, 1).toUpperCase()).append(arr[i].substring(1).toLowerCase());
		}
		if(arr.length > 1){
		}else{
			
		}
		return sb.subSequence(0, 1).toString().toLowerCase() + sb.substring(1);
	}

}
