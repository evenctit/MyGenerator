package com.even.test.velocity.util;

import org.junit.Test;

import com.even.velocity.util.StringUtil;

import junit.framework.Assert;

public class StringUtilTest {
	
	@Test
	public void testTransformer(){
		String abc = "my_name_abc";
		String result = StringUtil.transformColumnName(abc);
		System.out.println(result);
		Assert.assertEquals("MyNameAbc",result);
	}

}
