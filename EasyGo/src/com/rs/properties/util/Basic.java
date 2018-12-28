package com.rs.properties.util;

/**配置信息
 * 
 * @author wcs
 *
 */
public class Basic {
	public static volatile String appKey = "439f4cb53f344c444a8aa7a821bb5443";
	public static volatile String appSecret = "dd10f72af53f";
	public static volatile String nonce =  "12345";
	public static volatile String refreshURL = "https://api.netease.im/nimserver/user/refreshToken.action";
	public static volatile String createURL = "https://api.netease.im/nimserver/user/create.action";
	public static volatile int cancallback =0;//回调默认值：1为拒绝，0为通过，2为判断
}
