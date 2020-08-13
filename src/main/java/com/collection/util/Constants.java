package com.collection.util;



public class Constants {
	
	//项目路径
	public static String PROJECT_PATH = "http://www.xgomv.com.cn/";
	//public static String PROJECT_PATH = "http://localhost:8080/";
	//public static String PROJECT_PATH = "http://101.132.177.82/";
	
	//服务器app上传文件地址
	public static String APP_FILE_UPLOAD_PATH = "/home/silence/collection_web/upload/images";
	
	//cookeis缓存域名
	//public static String COOK_DOMAIN = null;
	public static String COOK_DOMAIN = "www.xgomv.com";
	//public static String COOK_DOMAIN = "101.132.177.82";
	
	//短信模板
	//public static String smsTranslateCode = "【享GO】您本次验证码是：code。如非本人操作，请忽略本短信 ";
	public static String smsTranslate1 = "【享GO】您有新订单，下单物品：typename，请尽快处理。";
	//public static String smsTranslate2 = "【享GO】恭喜您， 您已升级为member，享受更多特权";
	public static String smsTranslate3 = "【享GO】恭喜您参团成功，获得一个typename，请尽快处理。";
	public static String smsTranslate4 = "【享GO】尊敬的用户，您的订单：typename 状态变化，请注意查看订单。";
	
	public static String sysSmsTranslate1 = "恭喜您出售价值price元的typename成功，请注意订单状态";
	public static String sysSmsTranslate2 = "恭喜您， 您已升级为member，享受更多特权";
	public static String sysSmsTranslate3 = "恭喜您参团成功,抢到了价值price元的typename，请注意订单状态尽快处理"; 
	public static String sysSmsTranslate4 = "恭喜您出售的typename，买家【nickname】已付款成功，请尽快审核订单";
	
	/**
	 * 失败
	 */
	public static int FAILED = 0;
	/**
	 * 成功
	 */
	public static int SUCCESS = 1;
	
	
	public static  String TEST_UNIONID = "o6wzrs-3E-FxOyQlueHaRbeYZsxI"; //测试unionid

	public static  String TEST_OPENID = "oVFYwtwa7FHzS0F-z4QgnwosGep8"; //测试openid
	
	//接口加密参数
	public static String INTERFACE_SECRET="255.xgo";
	
	//(融云)
	public static String cloudappkey = "kj7swf8o77ux2";//替换成您的appkey
	public static String cloudappsecret = "Ye3gd38ghaM";//替换成匹配上面key的secret
	
	// 商户资料
	public static  String APPID="wxbceb4e3f71018245";
	public static  String APPSECRET="036564b6b11f1bd96bf120250aac7bd6";
	public static  String PARTNER="";
	public static  String PARTNERKEY="";
	
		/**
		 * 图片压缩的倍数
		 */
		public static int COMPRESSIONRATIO = 10;
		
		/**
		 * 压缩图片的宽度
		 */
		public static int COMPRESSIONWIDTH = 400;
		/**
		 * 压缩图片的高度
		 */
		public static int COMPRESSIONHEIGHT = 700;
}
