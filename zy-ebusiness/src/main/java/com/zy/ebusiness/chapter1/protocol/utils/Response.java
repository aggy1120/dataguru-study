package com.zy.ebusiness.chapter1.protocol.utils;

public class Response {
	
	/**
	 * 编码
	 */
	private byte encode;
	
	/**
	 * 响应长度
	 */
	private int responseLength;
	
	/**
	 * 响应
	 */
	private byte[] response;

	public byte getEncode() {
		return encode;
	}

	public void setEncode(byte encode) {
		this.encode = encode;
	}

	public int getResponseLength() {
		return responseLength;
	}

	public void setResponseLength(int responseLength) {
		this.responseLength = responseLength;
	}

	public byte[] getResponse() {
		return response;
	}

	public void setResponse(byte[] response) {
		this.response = response;
	}

}
