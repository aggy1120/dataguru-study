package com.zy.ebusiness.chapter1.protocol.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ProtocolUtil {
	
	public static Request readRequest(InputStream input) throws IOException{
		
		//读取编码
		byte[] encodeByte = new byte[1];
		input.read(encodeByte);
		byte encode = encodeByte[0];
		
		//读取命令长度
		byte[] commandLengthBytes = new byte[4];
		input.read(commandLengthBytes);
		int commandLength = ByteUtil.bytes2Int(commandLengthBytes);
		
		//读取命令
		byte[] commandBytes = new byte[commandLength];
		input.read(commandBytes);
		String command = null;
		if(Encode.UTF8.getValue()==encode){
			command = new String(commandBytes,"UTF8");
		}else{
			command = new String(commandBytes,"GBK");
		}
		
		//组装请求并返回
		Request request = new Request();
		request.setCommand(command);
		request.setEncode(encode);
		request.setCommandLength(commandLength);
		
		return request;
	}
	
	public static Response readResponse(InputStream input) throws IOException{
		//读取编码
		byte[] encodeByte = new byte[1];
		input.read(encodeByte);
		byte encode = encodeByte[0];
		
		//读取响应长度
		byte[] responseLengthBytes = new byte[4];
		input.read(responseLengthBytes);
		int responseLength = ByteUtil.bytes2Int(responseLengthBytes);
		
		//读取响应
		byte[] responseBytes = new byte[responseLength];
		input.read(responseBytes);
	
		//组装请求并返回
		Response response = new Response();
		response.setEncode(encode);
		response.setResponse(responseBytes);
		response.setResponseLength(responseLength);
				
		return response;
	}
	
	public static void writeRequest(Request request,OutputStream out) throws IOException{
		//写入编码
		out.write(request.getEncode());
		//写入请求长度
		out.write(ByteUtil.int2ByteArray(request.getCommandLength()));
		//写入请求体
		if(Encode.UTF8.getValue()==request.getEncode()){
			out.write(request.getCommand().getBytes("UTF8"));
		}else{
			out.write(request.getCommand().getBytes("GBK"));
		}
	}
	
	public static void writeResponse(Response response,OutputStream out) throws IOException{
		//写入编码
		out.write(response.getEncode());
		//写入请求长度
		out.write(ByteUtil.int2ByteArray(response.getResponseLength()));
		//写入请求体
		out.write(response.getResponse());
	}
	
}
