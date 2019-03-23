package com.asiainfo.einvoice.core.def.bo.bean;

import java.sql.Timestamp;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePushTaskHisValue;

public class BOInvoicePushTaskHisBean extends DataContainer implements DataContainerInterface,IBOInvoicePushTaskHisValue{

  private static String  m_boName = "com.asiainfo.einvoice.core.def.bo.BOInvoicePushTaskHis";



  public final static  String S_PushContent = "PUSH_CONTENT";
  public final static  String S_Notes = "NOTES";
  public final static  String S_InvoiceInstanceId = "INVOICE_INSTANCE_ID";
  public final static  String S_InvoiceDsId = "INVOICE_DS_ID";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_PushTarget = "PUSH_TARGET";
  public final static  String S_PushTime = "PUSH_TIME";
  public final static  String S_State = "STATE";
  public final static  String S_PushResult = "PUSH_RESULT";
  public final static  String S_PushTaskId = "PUSH_TASK_ID";
  public final static  String S_Reamrks = "REAMRKS";
  public final static  String S_PushWay = "PUSH_WAY";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOInvoicePushTaskHisBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initPushContent(String value){
     this.initProperty(S_PushContent,value);
  }
  public  void setPushContent(String value){
     this.set(S_PushContent,value);
  }
  public  void setPushContentNull(){
     this.set(S_PushContent,null);
  }

  public String getPushContent(){
       return DataType.getAsString(this.get(S_PushContent));
  
  }
  public String getPushContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PushContent));
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

  public void initInvoiceInstanceId(long value){
     this.initProperty(S_InvoiceInstanceId,new Long(value));
  }
  public  void setInvoiceInstanceId(long value){
     this.set(S_InvoiceInstanceId,new Long(value));
  }
  public  void setInvoiceInstanceIdNull(){
     this.set(S_InvoiceInstanceId,null);
  }

  public long getInvoiceInstanceId(){
        return DataType.getAsLong(this.get(S_InvoiceInstanceId));
  
  }
  public long getInvoiceInstanceIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_InvoiceInstanceId));
      }

  public void initInvoiceDsId(long value){
     this.initProperty(S_InvoiceDsId,new Long(value));
  }
  public  void setInvoiceDsId(long value){
     this.set(S_InvoiceDsId,new Long(value));
  }
  public  void setInvoiceDsIdNull(){
     this.set(S_InvoiceDsId,null);
  }

  public long getInvoiceDsId(){
        return DataType.getAsLong(this.get(S_InvoiceDsId));
  
  }
  public long getInvoiceDsIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_InvoiceDsId));
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

  public void initPushTarget(String value){
     this.initProperty(S_PushTarget,value);
  }
  public  void setPushTarget(String value){
     this.set(S_PushTarget,value);
  }
  public  void setPushTargetNull(){
     this.set(S_PushTarget,null);
  }

  public String getPushTarget(){
       return DataType.getAsString(this.get(S_PushTarget));
  
  }
  public String getPushTargetInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PushTarget));
      }

  public void initPushTime(Timestamp value){
     this.initProperty(S_PushTime,value);
  }
  public  void setPushTime(Timestamp value){
     this.set(S_PushTime,value);
  }
  public  void setPushTimeNull(){
     this.set(S_PushTime,null);
  }

  public Timestamp getPushTime(){
        return DataType.getAsDateTime(this.get(S_PushTime));
  
  }
  public Timestamp getPushTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_PushTime));
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

  public void initPushResult(String value){
     this.initProperty(S_PushResult,value);
  }
  public  void setPushResult(String value){
     this.set(S_PushResult,value);
  }
  public  void setPushResultNull(){
     this.set(S_PushResult,null);
  }

  public String getPushResult(){
       return DataType.getAsString(this.get(S_PushResult));
  
  }
  public String getPushResultInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PushResult));
      }

  public void initPushTaskId(long value){
     this.initProperty(S_PushTaskId,new Long(value));
  }
  public  void setPushTaskId(long value){
     this.set(S_PushTaskId,new Long(value));
  }
  public  void setPushTaskIdNull(){
     this.set(S_PushTaskId,null);
  }

  public long getPushTaskId(){
        return DataType.getAsLong(this.get(S_PushTaskId));
  
  }
  public long getPushTaskIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PushTaskId));
      }

  public void initReamrks(String value){
     this.initProperty(S_Reamrks,value);
  }
  public  void setReamrks(String value){
     this.set(S_Reamrks,value);
  }
  public  void setReamrksNull(){
     this.set(S_Reamrks,null);
  }

  public String getReamrks(){
       return DataType.getAsString(this.get(S_Reamrks));
  
  }
  public String getReamrksInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reamrks));
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

