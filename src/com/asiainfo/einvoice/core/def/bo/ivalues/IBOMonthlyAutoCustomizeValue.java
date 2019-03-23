package com.asiainfo.einvoice.core.def.bo.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOMonthlyAutoCustomizeValue extends DataStructInterface{

  public final static  String S_CreateOpId = "CREATE_OP_ID";
  public final static  String S_CustId = "CUST_ID";
  public final static  String S_GhfDhhm = "GHF_DHHM";
  public final static  String S_OpId = "OP_ID";
  public final static  String S_State = "STATE";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_IssuingTime = "ISSUING_TIME";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_PreIssuingMark = "PRE_ISSUING_MARK";
  public final static  String S_Notes = "NOTES";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_PushTime = "PUSH_TIME";
  public final static  String S_OpTime = "OP_TIME";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_GhfNsrmc = "GHF_NSRMC";
  public final static  String S_CreateOrgId = "CREATE_ORG_ID";
  public final static  String S_CustomizeId = "CUSTOMIZE_ID";
  public final static  String S_AcctId = "ACCT_ID";
  public final static  String S_GhfQylx = "GHF_QYLX";
  public final static  String S_PushObj = "PUSH_OBJ";
  public final static  String S_GhfDz = "GHF_DZ";
  public final static  String S_OpOrgId = "OP_ORG_ID";
  public final static  String S_GhfNsrsbh = "GHF_NSRSBH";
  public final static  String S_GhfYhzh = "GHF_YHZH";
  public final static  String S_PushWay = "PUSH_WAY";


public long getCreateOpId();

public long getCustId();

public String getGhfDhhm();

public long getOpId();

public String getState();

public long getUserId();

public String getIssuingTime();

public String getRemarks();

public String getPreIssuingMark();

public String getNotes();

public String getBillId();

public String getSharding();

public String getPushTime();

public Timestamp getOpTime();

public Timestamp getCreateTime();

public String getGhfNsrmc();

public long getCreateOrgId();

public long getCustomizeId();

public long getAcctId();

public String getGhfQylx();

public String getPushObj();

public String getGhfDz();

public long getOpOrgId();

public String getGhfNsrsbh();

public String getGhfYhzh();

public String getPushWay();


public  void setCreateOpId(long value);

public  void setCustId(long value);

public  void setGhfDhhm(String value);

public  void setOpId(long value);

public  void setState(String value);

public  void setUserId(long value);

public  void setIssuingTime(String value);

public  void setRemarks(String value);

public  void setPreIssuingMark(String value);

public  void setNotes(String value);

public  void setBillId(String value);

public  void setSharding(String value);

public  void setPushTime(String value);

public  void setOpTime(Timestamp value);

public  void setCreateTime(Timestamp value);

public  void setGhfNsrmc(String value);

public  void setCreateOrgId(long value);

public  void setCustomizeId(long value);

public  void setAcctId(long value);

public  void setGhfQylx(String value);

public  void setPushObj(String value);

public  void setGhfDz(String value);

public  void setOpOrgId(long value);

public  void setGhfNsrsbh(String value);

public  void setGhfYhzh(String value);

public  void setPushWay(String value);
}
