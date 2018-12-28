package com.rs.util.bean;

/**requestBean、responseBean
 * 
 * @author wcs
 *
 */
public class ReqBean {
	private int code;
	private InfoBean info;
	private String userid;
	/*消息抄送字段
	 *会话类型消息中，并不是每个字段都会一定抄送，请注意对各字段的判空处理。
	 *以下为一般情况下必有的字段：
	 *eventType、convType、to、fromAccount、msgTimestamp、msgType、msgidClient、msgidServer 
	 */
	private String eventType;//*
	private String convType;//*
	private String to;//*
	private String fromAccount;//*
	private String fromClientType;
	private String fromDeviceId;
	private String fromNick;
	private String msgTimestamp;//*
	private String msgType;//*
	private String body;
	private String attach;
	private String msgidClient;//*
	private String msgidServer;//*
	
	private String customSafeFlag;
	private String customApnsText;
	private String tMember;
	private String ext;
	private String antispam;
	private String yidunRes;
	private String resendFlag;
	public void setCode(int code) {
		this.code = code;
	}
	public int getCode() {
		return this.code;
	}
	
	public void setInfo(InfoBean info) {
		this.info = info;
	}
	public InfoBean getInfo() {
		return this.info;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserid() {
		return this.userid;
	}
	
	public void setAttach(String attach) {
        this.attach = attach;
    }
    public String getAttach() {
        return attach;
    }

   public void setBody(String body) {
        this.body = body;
    }
    public String getBody() {
        return body;
    }

   public void setConvType(String convtype) {
        this.convType = convtype;
    }
    public String getConvType() {
        return convType;
    }

   public void setEventType(String eventtype) {
        this.eventType = eventtype;
    }
    public String getEventType() {
        return eventType;
    }

   public void setFromAccount(String fromaccount) {
        this.fromAccount = fromaccount;
    }
    public String getFromaccount() {
        return fromAccount;
    }

   public void setFromClientType(String fromclienttype) {
        this.fromClientType = fromclienttype;
    }
    public String getFromclienttype() {
        return fromClientType;
    }

   public void setFromDeviceId(String fromdeviceid) {
        this.fromDeviceId = fromdeviceid;
    }
    public String getFromdeviceid() {
        return fromDeviceId;
    }

   public void setFromNick(String fromnick) {
        this.fromNick = fromnick;
    }
    public String getFromNick() {
        return fromNick;
    }

   public void setMsgTimestamp(String msgtimestamp) {
        this.msgTimestamp = msgtimestamp;
    }
    public String getMsgTimestamp() {
        return msgTimestamp;
    }

   public void setMsgType(String msgtype) {
        this.msgType = msgtype;
    }
    public String getMsgtype() {
        return msgType;
    }

   public void setMsgidClient(String msgidclient) {
        this.msgidClient = msgidclient;
    }
    public String getMsgidClient() {
        return msgidClient;
    }

   public void setMsgidServer(String msgidserver) {
        this.msgidServer = msgidserver;
    }
    public String getMsgidServer() {
        return msgidServer;
    }

   public void setResendFlag(String resendflag) {
        this.resendFlag = resendflag;
    }
    public String getResendFlag() {
        return resendFlag;
    }

   public void setTo(String to) {
        this.to = to;
    }
    public String getTo() {
        return to;
    }
	
}
