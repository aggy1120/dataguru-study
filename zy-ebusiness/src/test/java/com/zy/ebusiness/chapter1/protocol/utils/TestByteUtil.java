package com.zy.ebusiness.chapter1.protocol.utils;

import java.util.Arrays;

import org.junit.Test;

public class TestByteUtil {
	
	@Test
	public void testInt2Byte(){
		System.out.println(Arrays.toString(ByteUtil.int2ByteArray(14)));
	}
	
	@Test
	public void testByte2Int(){
		System.out.println(ByteUtil.bytes2Int(ByteUtil.int2ByteArray(14)));
	}
}
