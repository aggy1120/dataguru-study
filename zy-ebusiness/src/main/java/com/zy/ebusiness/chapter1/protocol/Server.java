package com.zy.ebusiness.chapter1.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.org.apache.bcel.internal.generic.InstructionConstants.Clinit;
import com.zy.ebusiness.chapter1.protocol.service.PersonServiceImp;
import com.zy.ebusiness.chapter1.protocol.utils.Encode;
import com.zy.ebusiness.chapter1.protocol.utils.ProtocolUtil;
import com.zy.ebusiness.chapter1.protocol.utils.Request;
import com.zy.ebusiness.chapter1.protocol.utils.Response;

/**
 * 服务端
 * @author zhangyi
 *
 */
public class Server {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(9901);
		
		while (true) {
			//获取请求链接
			Socket client = server.accept();
			//获取请求数据
			InputStream input = client.getInputStream();
			Request request = ProtocolUtil.readRequest(input);
			
			if(request.getCommand().equals("getPerson")){
				//得到序列化对象的字节流
				PersonServiceImp service = new PersonServiceImp();
				byte[] responseBytes = service.findPerson();
				//封装响应实体
				Response response = new Response();
				response.setEncode(Encode.UTF8.getValue());
				response.setResponseLength(responseBytes.length);
				response.setResponse(responseBytes);
				
				//发送响应
				OutputStream out = client.getOutputStream();
				ProtocolUtil.writeResponse(response, out);
				
				client.shutdownOutput();
			}
		}
	}
}
