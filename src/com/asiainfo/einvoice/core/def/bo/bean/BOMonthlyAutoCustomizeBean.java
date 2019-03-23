package com.asiainfo.einvoice.core.def.bo.bean;

import java.sql.Timestamp;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOMonthlyAutoCustomizeValue;

public class BOMonthlyAutoCustomizeBean extends DataContainer implements DataContainerInterface,IBOMonthlyAutoCustomizeValue{

  private static String  m_boName = "com.asiainfo.einvoice.core.def.bo.BOMonthlyAutoCustomize";



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

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOMonthlyAutoCustomizeBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initCreateOpId(long value){
     this.initProperty(S_CreateOpId,new Long(value));
  }
  public  void setCreateOpId(long value){
     this.set(S_CreateOpId,new Long(value));
  }
  public  void setCreateOpIdNull(){
     this.set(S_CreateOpId,null);
  }

  public long getCreateOpId(){
        return DataType.getAsLong(this.get(S_CreateOpId));
  
  }
  public long getCreateOpIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CreateOpId));
      }

  public void initCustId(long value){
     this.initProperty(S_CustId,new Long(value));
  }
  public  void setCustId(long value){
     this.set(S_CustId,new Long(value));
  }
  public  void setCustIdNull(){
     this.set(S_CustId,null);
  }

  public long getCustId(){
        return DataType.getAsLong(this.get(S_CustId));
  
  }
  public long getCustIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CustId));
      }

  public void initGhfDhhm(String value){
     this.initProperty(S_GhfDhhm,value);
  }
  public  void setGhfDhhm(String value){
     this.set(S_GhfDhhm,value);
  }
  public  void setGhfDhhmNull(){
     this.set(S_GhfDhhm,null);
  }

  public String getGhfDhhm(){
       return DataType.getAsString(this.get(S_GhfDhhm));
  
  }
  public String getGhfDhhmInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GhfDhhm));
      }

  public void initOpId(long value){
     this.initProperty(S_OpId,new Long(value));
  }
  public  void setOpId(long value){
     this.set(S_OpId,new Long(value));
  }
  public  void setOpIdNull(){
     this.set(S_OpId,null);
  }

  public long getOpId(){
        return DataType.getAsLong(this.get(S_OpId));
  
  }
  public long getOpIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OpId));
      }

  public void initState(String value){
     this.initProperty(S_State,value);
  }
  public  void setState(String value){
     this.set(S_State,value);
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public String getState(){
       return DataType.getAsString(this.get(S_State));
  
  }
  public String getStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_State));
      }

  public void initUserId(long value){
     this.initProperty(S_UserId,new Long(value));
  }
  public  void setUserId(long value){
     this.set(S_UserId,new Long(value));
  }
  public  void setUserIdNull(){
     this.set(S_UserId,null);
  }

  public long getUserId(){
        return DataType.getAsLong(this.get(S_UserId));
  
  }
  public long getUserIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_UserId));
      }

  public void initIssuingTime(String value){
     this.initProperty(S_IssuingTime,value);
  }
  public  void setIssuingTime(String value){
     this.set(S_IssuingTime,value);
  }
  public  void setIssuingTimeNull(){
     this.set(S_IssuingTime,null);
  }

  public String getIssuingTime(){
       return DataType.getAsString(this.get(S_IssuingTime));
  
  }
  public String getIssuingTimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IssuingTime));
      }

  public void initRemarks(String value){
     this.initProperty(S_Remarks,value);
  }
  public  void setRemarks(String value){
     this.set(S_Remarks,value);
  }
  public  void setRemarksNull(){
     this.set(S_Remarks,null);
  }

  public String getRemarks(){
       return DataType.getAsString(this.get(S_Remarks));
  
  }
  public String getRemarksInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remarks));
      }

  public void initPreIssuingMark(String value){
     this.initProperty(S_PreIssuingMark,value);
  }
  public  void setPreIssuingMark(String value){
     this.set(S_PreIssuingMark,value);
  }
  public  void setPreIssuingMarkNull(){
     this.set(S_PreIssuingMark,null);
  }

  public String getPreIssuingMark(){
       return DataType.getAsString(this.get(S_PreIssuingMark));
  
  }
  public String getPreIssuingMarkInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PreIssuingMark));
      }

  public void initNotes(String value){
     this.initProperty(S_Notes,value);
  }
  public  void setNotes(String value){
     this.set(S_Notes,value);
  }
  public  void setNotesNull(){
     this.set(S_Notes,null);
  }

  public String getNotes(){
       return DataType.getAsString(this.get(S_Notes));
  
  }
  public String getNotesInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Notes));
      }

  public void initBillId(String value){
     this.initProperty(S_BillId,value);
  }
  public  void setBillId(String value){
     this.set(S_BillId,value);
  }
  public  void setBillIdNull(){
     this.set(S_BillId,null);
  }

  public String getBillId(){
       return DataType.getAsString(this.get(S_BillId));
  
  }
  public String getBillIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BillId));
      }

  public void initSharding(String value){
     this.initProperty(S_Sharding,value);
  }
  public  void setSharding(String value){
     this.set(S_Sharding,value);
  }
  public  void setShardingNull(){
     this.set(S_Sharding,null);
  }

  public String getSharding(){
       return DataType.getAsString(this.get(S_Sharding));
  
  }
  public String getShardingInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Sharding));
      }

  public void initPushTime(String value){
     this.initProperty(S_PushTime,value);
  }
  public  void setPushTime(String value){
     this.set(S_PushTime,value);
  }
  public  void setPushTimeNull(){
     this.set(S_PushTime,null);
  }

  public String getPushTime(){
       return DataType.getAsString(this.get(S_PushTime));
  
  }
  public String getPushTimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PushTime));
      }

  public void initOpTime(Timestamp value){
     this.initProperty(S_OpTime,value);
  }
  public  void setOpTime(Timestamp value){
     this.set(S_OpTime,value);
  }
  public  void setOpTimeNull(){
     this.set(S_OpTime,null);
  }

  public Timestamp getOpTime(){
        return DataType.getAsDateTime(this.get(S_OpTime));
  
  }
  public Timestamp getOpTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_OpTime));
      }

  public void initCreateTime(Timestamp value){
     this.initProperty(S_CreateTime,value);
  }
  public  void setCreateTime(Timestamp value){
     this.set(S_CreateTime,value);
  }
  public  void setCreateTimeNull(){
     this.set(S_CreateTime,null);
  }

  public Timestamp getCreateTime(){
        return DataType.getAsDateTime(this.get(S_CreateTime));
  
  }
  public Timestamp getCreateTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateTime));
      }

  public void initGhfNsrmc(String value){
     this.initProperty(S_GhfNsrmc,value);
  }
  public  void setGhfNsrmc(String value){
     this.set(S_GhfNsrmc,value);
  }
  public  void setGhfNsrmcNull(){
     this.set(S_GhfNsrmc,null);
  }

  public String getGhfNsrmc(){
       return DataType.getAsString(this.get(S_GhfNsrmc));
  
  }
  public String getGhfNsrmcInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GhfNsrmc));
      }

  public void initCreateOrgId(long value){
     this.initProperty(S_CreateOrgId,new Long(value));
  }
  public  void setCreateOrgId(long value){
     this.set(S_CreateOrgId,new Long(value));
  }
  public  void setCreateOrgIdNull(){
     this.set(S_CreateOrgId,null);
  }

  public long getCreateOrgId(){
        return DataType.getAsLong(this.get(S_CreateOrgId));
  
  }
  public long getCreateOrgIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CreateOrgId));
      }

  public void initCustomizeId(long value){
     this.initProperty(S_CustomizeId,new Long(value));
  }
  public  void setCustomizeId(long value){
     this.set(S_CustomizeId,new Long(value));
  }
  public  void setCustomizeIdNull(){
     this.set(S_CustomizeId,null);
  }

  public long getCustomizeId(){
        return DataType.getAsLong(this.get(S_CustomizeId));
  
  }
  public long getCustomizeIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CustomizeId));
      }

  public void initAcctId(long value){
     this.initProperty(S_AcctId,new Long(value));
  }
  public  void setAcctId(long value){
     this.set(S_AcctId,new Long(value));
  }
  public  void setAcctIdNull(){
     this.set(S_AcctId,null);
  }

  public long getAcctId(){
        return DataType.getAsLong(this.get(S_AcctId));
  
  }
  public long getAcctIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AcctId));
      }

  public void initGhfQylx(String value){
     this.initProperty(S_GhfQylx,value);
  }
  public  void setGhfQylx(String value){
     this.set(S_GhfQylx,value);
  }
  public  void setGhfQylxNull(){
     this.set(S_GhfQylx,null);
  }

  public String getGhfQylx(){
       return DataType.getAsString(this.get(S_GhfQylx));
  
  }
  public String getGhfQylxInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GhfQylx));
      }

  public void initPushObj(String value){
     this.initProperty(S_PushObj,value);
  }
  public  void setPushObj(String value){
     this.set(S_PushObj,value);
  }
  public  void setPushObjNull(){
     this.set(S_PushObj,null);
  }

  public String getPushObj(){
       return DataType.getAsString(this.get(S_PushObj));
  
  }
  public String getPushObjInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PushObj));
      }

  public void initGhfDz(String value){
     this.initProperty(S_GhfDz,value);
  }
  public  void setGhfDz(String value){
     this.set(S_GhfDz,value);
  }
  public  void setGhfDzNull(){
     this.set(S_GhfDz,null);
  }

  public String getGhfDz(){
       return DataType.getAsString(this.get(S_GhfDz));
  
  }
  public String getGhfDzInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GhfDz));
      }

  public void initOpOrgId(long value){
     this.initProperty(S_OpOrgId,new Long(value));
  }
  public  void setOpOrgId(long value){
     this.set(S_OpOrgId,new Long(value));
  }
  public  void setOpOrgIdNull(){
     this.set(S_OpOrgId,null);
  }

  public long getOpOrgId(){
        return DataType.getAsLong(this.get(S_OpOrgId));
  
  }
  public long getOpOrgIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OpOrgId));
      }

  public void initGhfNsrsbh(String value){
     this.initProperty(S_GhfNsrsbh,value);
  }
  public  void setGhfNsrsbh(String value){
     this.set(S_GhfNsrsbh,value);
  }
  public  void setGhfNsrsbhNull(){
     this.set(S_GhfNsrsbh,null);
  }

  public String getGhfNsrsbh(){
       return DataType.getAsString(this.get(S_GhfNsrsbh));
  
  }
  public String getGhfNsrsbhInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GhfNsrsbh));
      }

  public void initGhfYhzh(String value){
     this.initProperty(S_GhfYhzh,value);
  }
  public  void setGhfYhzh(String value){
     this.set(S_GhfYhzh,value);
  }
  public  void setGhfYhzhNull(){
     this.set(S_GhfYhzh,null);
  }

  public String getGhfYhzh(){
       return DataType.getAsString(this.get(S_GhfYhzh));
  
  }
  public String getGhfYhzhInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GhfYhzh));
      }

  public void initPushWay(String value){
     this.initProperty(S_PushWay,value);
  }
  public  void setPushWay(String value){
     this.set(S_PushWay,value);
  }
  public  void setPushWayNull(){
     this.set(S_PushWay,null);
  }

  public String getPushWay(){
       return DataType.getAsString(this.get(S_PushWay));
  
  }
  public String getPushWayInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PushWay));
      }


 
 }

