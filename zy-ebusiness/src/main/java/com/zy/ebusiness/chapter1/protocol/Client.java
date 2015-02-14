package com.zy.ebusiness.chapter1.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.zy.ebusiness.chapter1.protocol.utils.Encode;
import com.zy.ebusiness.chapter1.protocol.utils.ProtocolUtil;
import com.zy.ebusiness.chapter1.protocol.utils.Request;
import com.zy.ebusiness.chapter1.protocol.utils.Response;
import com.zy.ebusiness.chapter1.protocolbuffers.beans.PersonProtobuf.Person;

/**
 * 客户端
 * @author zhangyi
 *
 */
public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//构造一个请求
		Request request = new Request();
		request.setEncode(Encode.UTF8.getValue());
		request.setCommand("getPerson");
		request.setCommandLength(request.getCommand().length());
		
		//创建socket连接
		Socket client = new Socket("127.0.0.1",9901);
		OutputStream out = client.getOutputStream();
		
		//通过工具类发送请求
		ProtocolUtil.writeRequest(request, out);
		
		//读取响应
		InputStream input = client.getInputStream();
		Response response = ProtocolUtil.readResponse(input);
		
		//反序列化
		Person person = Person.parseFrom(response.getResponse());
		System.out.println(person);
		
		client.shutdownInput();
		client.shutdownOutput();
	}
}
