package com.asiainfo.einvoice.core.def.bo.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOInvoiceMsgLogValue extends DataStructInterface{

  public final static  String S_CreateOpId = "CREATE_OP_ID";
  public final static  String S_ResContent1 = "RES_CONTENT1";
  public final static  String S_ResContent7 = "RES_CONTENT7";
  public final static  String S_ResContent6 = "RES_CONTENT6";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ResContent9 = "RES_CONTENT9";
  public final static  String S_ResContent8 = "RES_CONTENT8";
  public final static  String S_ResContent3 = "RES_CONTENT3";
  public final static  String S_ResContent2 = "RES_CONTENT2";
  public final static  String S_ResContent5 = "RES_CONTENT5";
  public final static  String S_ResContent4 = "RES_CONTENT4";
  public final static  String S_Notes = "NOTES";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_MessageId = "MESSAGE_ID";
  public final static  String S_ReqContent2 = "REQ_CONTENT2";
  public final static  String S_ReqContent3 = "REQ_CONTENT3";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_ReqContent1 = "REQ_CONTENT1";
  public final static  String S_CreateOrgId = "CREATE_ORG_ID";
  public final static  String S_ReqContent6 = "REQ_CONTENT6";
  public final static  String S_ReqContent7 = "REQ_CONTENT7";
  public final static  String S_ReqContent4 = "REQ_CONTENT4";
  public final static  String S_ReqContent5 = "REQ_CONTENT5";
  public final static  String S_ReqContent8 = "REQ_CONTENT8";
  public final static  String S_ReqContent9 = "REQ_CONTENT9";
  public final static  String S_MessageType = "MESSAGE_TYPE";
  public final static  String S_ResContent10 = "RES_CONTENT10";
  public final static  String S_MessageKeyType = "MESSAGE_KEY_TYPE";
  public final static  String S_MessageKey = "MESSAGE_KEY";
  public final static  String S_ReqContent10 = "REQ_CONTENT10";


public long getCreateOpId();

public String getResContent1();

public String getResContent7();

public String getResContent6();

public String getRemarks();

public String getResContent9();

public String getResContent8();

public String getResContent3();

public String getResContent2();

public String getResContent5();

public String getResContent4();

public String getNotes();

public String getSharding();

public long getMessageId();

public String getReqContent2();

public String getReqContent3();

public Timestamp getCreateTime();

public String getReqContent1();

public long getCreateOrgId();

public String getReqContent6();

public String getReqContent7();

public String getReqContent4();

public String getReqContent5();

public String getReqContent8();

public String getReqContent9();

public String getMessageType();

public String getResContent10();

public String getMessageKeyType();

public String getMessageKey();

public String getReqContent10();


public  void setCreateOpId(long value);

public  void setResContent1(String value);

public  void setResContent7(String value);

public  void setResContent6(String value);

public  void setRemarks(String value);

public  void setResContent9(String value);

public  void setResContent8(String value);

public  void setResContent3(String value);

public  void setResContent2(String value);

public  void setResContent5(String value);

public  void setResContent4(String value);

public  void setNotes(String value);

public  void setSharding(String value);

public  void setMessageId(long value);

public  void setReqContent2(String value);

public  void setReqContent3(String value);

public  void setCreateTime(Timestamp value);

public  void setReqContent1(String value);

public  void setCreateOrgId(long value);

public  void setReqContent6(String value);

public  void setReqContent7(String value);

public  void setReqContent4(String value);

public  void setReqContent5(String value);

public  void setReqContent8(String value);

public  void setReqContent9(String value);

public  void setMessageType(String value);

public  void setResContent10(String value);

public  void setMessageKeyType(String value);

public  void setMessageKey(String value);

public  void setReqContent10(String value);
}
