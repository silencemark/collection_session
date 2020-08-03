package com.collection.sms;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

import com.collection.util.Constants;
import com.collection.util.Md5Util;

public class sendSms {
	private static final Logger LOGGER = Logger.getLogger(sendSms.class);
	private static String BASE_URI = "http://39.104.28.149:8888/v2sms.aspx";
	private static String username = "1498855646";
	private static String password = "123456";
	private static String ENCODING = "UTF-8";
	/**
	 * 发送验证码
	 * @param phonenum
	 * @param code
	 * @return
	 * @throws IOException
	 */
	public static void sendSms(String phonenum,String content) throws IOException {
		String phone = phonenum;
		HttpClient client = new HttpClient();
		NameValuePair[] param = new NameValuePair[8];
		param[0] = new NameValuePair("userid", "4828");
		param[1] = new NameValuePair("content", content);
		param[2] = new NameValuePair("mobile", phone);
		String timestamp = new Date().getTime()+"";
		param[3] = new NameValuePair("timestamp", timestamp);
		//为空表示立即发送，定时发送格式2010-10-24 09:08:10
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.SECOND, 10);
		param[4] = new NameValuePair("sendTime", "");
		//设置为固定的:send
		param[5] = new NameValuePair("action", "send");
		//设置为固定的:send
		param[6] = new NameValuePair("extno", "");
		//签名加密串
		param[7] = new NameValuePair("sign", Md5Util.getMD5(username.concat(password).concat(timestamp)))	;
		
		PostMethod method = new PostMethod(BASE_URI);
		method.setRequestBody(param);
		HttpMethodParams parameter = method.getParams();
		parameter.setContentCharset(ENCODING);
		client.executeMethod(method);
		LOGGER.info("短信返回值"+ method.getResponseBodyAsString());
	}
	
	public static void main(String[] args) {
		try {
			sendSms("15000042335", Constants.smsTranslate1.replace("typename", "iphone6"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
