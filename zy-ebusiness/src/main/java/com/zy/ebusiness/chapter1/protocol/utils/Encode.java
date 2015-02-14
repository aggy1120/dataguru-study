package com.zy.ebusiness.chapter1.protocol.utils;

public enum Encode {
	
	GBK((byte)0), UTF8((byte)1);
	
	private byte value = 1;
	
	private Encode(byte value){
		this.value = value;
	}

	public byte getValue() {
		return value;
	}

	public void setValue(byte value) {
		this.value = value;
	}
	
}
