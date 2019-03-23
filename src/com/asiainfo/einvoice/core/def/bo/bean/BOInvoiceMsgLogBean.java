package com.asiainfo.einvoice.core.def.bo.bean;

import java.sql.Timestamp;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceMsgLogValue;

public class BOInvoiceMsgLogBean extends DataContainer implements DataContainerInterface,IBOInvoiceMsgLogValue{

  private static String  m_boName = "com.asiainfo.einvoice.core.def.bo.BOInvoiceMsgLog";



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

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOInvoiceMsgLogBean() throws AIException{
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

  public void initResContent1(String value){
     this.initProperty(S_ResContent1,value);
  }
  public  void setResContent1(String value){
     this.set(S_ResContent1,value);
  }
  public  void setResContent1Null(){
     this.set(S_ResContent1,null);
  }

  public String getResContent1(){
       return DataType.getAsString(this.get(S_ResContent1));
  
  }
  public String getResContent1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ResContent1));
      }

  public void initResContent7(String value){
     this.initProperty(S_ResContent7,value);
  }
  public  void setResContent7(String value){
     this.set(S_ResContent7,value);
  }
  public  void setResContent7Null(){
     this.set(S_ResContent7,null);
  }

  public String getResContent7(){
       return DataType.getAsString(this.get(S_ResContent7));
  
  }
  public String getResContent7InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ResContent7));
      }

  public void initResContent6(String value){
     this.initProperty(S_ResContent6,value);
  }
  public  void setResContent6(String value){
     this.set(S_ResContent6,value);
  }
  public  void setResContent6Null(){
     this.set(S_ResContent6,null);
  }

  public String getResContent6(){
       return DataType.getAsString(this.get(S_ResContent6));
  
  }
  public String getResContent6InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ResContent6));
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

  public void initResContent9(String value){
     this.initProperty(S_ResContent9,value);
  }
  public  void setResContent9(String value){
     this.set(S_ResContent9,value);
  }
  public  void setResContent9Null(){
     this.set(S_ResContent9,null);
  }

  public String getResContent9(){
       return DataType.getAsString(this.get(S_ResContent9));
  
  }
  public String getResContent9InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ResContent9));
      }

  public void initResContent8(String value){
     this.initProperty(S_ResContent8,value);
  }
  public  void setResContent8(String value){
     this.set(S_ResContent8,value);
  }
  public  void setResContent8Null(){
     this.set(S_ResContent8,null);
  }

  public String getResContent8(){
       return DataType.getAsString(this.get(S_ResContent8));
  
  }
  public String getResContent8InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ResContent8));
      }

  public void initResContent3(String value){
     this.initProperty(S_ResContent3,value);
  }
  public  void setResContent3(String value){
     this.set(S_ResContent3,value);
  }
  public  void setResContent3Null(){
     this.set(S_ResContent3,null);
  }

  public String getResContent3(){
       return DataType.getAsString(this.get(S_ResContent3));
  
  }
  public String getResContent3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ResContent3));
      }

  public void initResContent2(String value){
     this.initProperty(S_ResContent2,value);
  }
  public  void setResContent2(String value){
     this.set(S_ResContent2,value);
  }
  public  void setResContent2Null(){
     this.set(S_ResContent2,null);
  }

  public String getResContent2(){
       return DataType.getAsString(this.get(S_ResContent2));
  
  }
  public String getResContent2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ResContent2));
      }

  public void initResContent5(String value){
     this.initProperty(S_ResContent5,value);
  }
  public  void setResContent5(String value){
     this.set(S_ResContent5,value);
  }
  public  void setResContent5Null(){
     this.set(S_ResContent5,null);
  }

  public String getResContent5(){
       return DataType.getAsString(this.get(S_ResContent5));
  
  }
  public String getResContent5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ResContent5));
      }

  public void initResContent4(String value){
     this.initProperty(S_ResContent4,value);
  }
  public  void setResContent4(String value){
     this.set(S_ResContent4,value);
  }
  public  void setResContent4Null(){
     this.set(S_ResContent4,null);
  }

  public String getResContent4(){
       return DataType.getAsString(this.get(S_ResContent4));
  
  }
  public String getResContent4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ResContent4));
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

  public void initMessageId(long value){
     this.initProperty(S_MessageId,new Long(value));
  }
  public  void setMessageId(long value){
     this.set(S_MessageId,new Long(value));
  }
  public  void setMessageIdNull(){
     this.set(S_MessageId,null);
  }

  public long getMessageId(){
        return DataType.getAsLong(this.get(S_MessageId));
  
  }
  public long getMessageIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_MessageId));
      }

  public void initReqContent2(String value){
     this.initProperty(S_ReqContent2,value);
  }
  public  void setReqContent2(String value){
     this.set(S_ReqContent2,value);
  }
  public  void setReqContent2Null(){
     this.set(S_ReqContent2,null);
  }

  public String getReqContent2(){
       return DataType.getAsString(this.get(S_ReqContent2));
  
  }
  public String getReqContent2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReqContent2));
      }

  public void initReqContent3(String value){
     this.initProperty(S_ReqContent3,value);
  }
  public  void setReqContent3(String value){
     this.set(S_ReqContent3,value);
  }
  public  void setReqContent3Null(){
     this.set(S_ReqContent3,null);
  }

  public String getReqContent3(){
       return DataType.getAsString(this.get(S_ReqContent3));
  
  }
  public String getReqContent3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReqContent3));
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

  public void initReqContent1(String value){
     this.initProperty(S_ReqContent1,value);
  }
  public  void setReqContent1(String value){
     this.set(S_ReqContent1,value);
  }
  public  void setReqContent1Null(){
     this.set(S_ReqContent1,null);
  }

  public String getReqContent1(){
       return DataType.getAsString(this.get(S_ReqContent1));
  
  }
  public String getReqContent1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReqContent1));
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

  public void initReqContent6(String value){
     this.initProperty(S_ReqContent6,value);
  }
  public  void setReqContent6(String value){
     this.set(S_ReqContent6,value);
  }
  public  void setReqContent6Null(){
     this.set(S_ReqContent6,null);
  }

  public String getReqContent6(){
       return DataType.getAsString(this.get(S_ReqContent6));
  
  }
  public String getReqContent6InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReqContent6));
      }

  public void initReqContent7(String value){
     this.initProperty(S_ReqContent7,value);
  }
  public  void setReqContent7(String value){
     this.set(S_ReqContent7,value);
  }
  public  void setReqContent7Null(){
     this.set(S_ReqContent7,null);
  }

  public String getReqContent7(){
       return DataType.getAsString(this.get(S_ReqContent7));
  
  }
  public String getReqContent7InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReqContent7));
      }

  public void initReqContent4(String value){
     this.initProperty(S_ReqContent4,value);
  }
  public  void setReqContent4(String value){
     this.set(S_ReqContent4,value);
  }
  public  void setReqContent4Null(){
     this.set(S_ReqContent4,null);
  }

  public String getReqContent4(){
       return DataType.getAsString(this.get(S_ReqContent4));
  
  }
  public String getReqContent4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReqContent4));
      }

  public void initReqContent5(String value){
     this.initProperty(S_ReqContent5,value);
  }
  public  void setReqContent5(String value){
     this.set(S_ReqContent5,value);
  }
  public  void setReqContent5Null(){
     this.set(S_ReqContent5,null);
  }

  public String getReqContent5(){
       return DataType.getAsString(this.get(S_ReqContent5));
  
  }
  public String getReqContent5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReqContent5));
      }

  public void initReqContent8(String value){
     this.initProperty(S_ReqContent8,value);
  }
  public  void setReqContent8(String value){
     this.set(S_ReqContent8,value);
  }
  public  void setReqContent8Null(){
     this.set(S_ReqContent8,null);
  }

  public String getReqContent8(){
       return DataType.getAsString(this.get(S_ReqContent8));
  
  }
  public String getReqContent8InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReqContent8));
      }

  public void initReqContent9(String value){
     this.initProperty(S_ReqContent9,value);
  }
  public  void setReqContent9(String value){
     this.set(S_ReqContent9,value);
  }
  public  void setReqContent9Null(){
     this.set(S_ReqContent9,null);
  }

  public String getReqContent9(){
       return DataType.getAsString(this.get(S_ReqContent9));
  
  }
  public String getReqContent9InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReqContent9));
      }

  public void initMessageType(String value){
     this.initProperty(S_MessageType,value);
  }
  public  void setMessageType(String value){
     this.set(S_MessageType,value);
  }
  public  void setMessageTypeNull(){
     this.set(S_MessageType,null);
  }

  public String getMessageType(){
       return DataType.getAsString(this.get(S_MessageType));
  
  }
  public String getMessageTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MessageType));
      }

  public void initResContent10(String value){
     this.initProperty(S_ResContent10,value);
  }
  public  void setResContent10(String value){
     this.set(S_ResContent10,value);
  }
  public  void setResContent10Null(){
     this.set(S_ResContent10,null);
  }

  public String getResContent10(){
       return DataType.getAsString(this.get(S_ResContent10));
  
  }
  public String getResContent10InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ResContent10));
      }

  public void initMessageKeyType(String value){
     this.initProperty(S_MessageKeyType,value);
  }
  public  void setMessageKeyType(String value){
     this.set(S_MessageKeyType,value);
  }
  public  void setMessageKeyTypeNull(){
     this.set(S_MessageKeyType,null);
  }

  public String getMessageKeyType(){
       return DataType.getAsString(this.get(S_MessageKeyType));
  
  }
  public String getMessageKeyTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MessageKeyType));
      }

  public void initMessageKey(String value){
     this.initProperty(S_MessageKey,value);
  }
  public  void setMessageKey(String value){
     this.set(S_MessageKey,value);
  }
  public  void setMessageKeyNull(){
     this.set(S_MessageKey,null);
  }

  public String getMessageKey(){
       return DataType.getAsString(this.get(S_MessageKey));
  
  }
  public String getMessageKeyInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MessageKey));
      }

  public void initReqContent10(String value){
     this.initProperty(S_ReqContent10,value);
  }
  public  void setReqContent10(String value){
     this.set(S_ReqContent10,value);
  }
  public  void setReqContent10Null(){
     this.set(S_ReqContent10,null);
  }

  public String getReqContent10(){
       return DataType.getAsString(this.get(S_ReqContent10));
  
  }
  public String getReqContent10InitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReqContent10));
      }


 
 }

