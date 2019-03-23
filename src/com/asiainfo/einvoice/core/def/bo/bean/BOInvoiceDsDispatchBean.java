package com.asiainfo.einvoice.core.def.bo.bean;

import java.sql.Timestamp;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceDsDispatchValue;

public class BOInvoiceDsDispatchBean extends DataContainer implements DataContainerInterface,IBOInvoiceDsDispatchValue{

  private static String  m_boName = "com.asiainfo.einvoice.core.def.bo.BOInvoiceDsDispatch";



  public final static  String S_InvoiceDsId = "INVOICE_DS_ID";
  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_TargetSharding = "TARGET_SHARDING";
  public final static  String S_Notes = "NOTES";
  public final static  String S_InvoiceInstanceId = "INVOICE_INSTANCE_ID";
  public final static  String S_ExecuteTime = "EXECUTE_TIME";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_DispatchKind = "DISPATCH_KIND";
  public final static  String S_DispatchCount = "DISPATCH_COUNT";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_DispatchResult = "DISPATCH_RESULT";
  public final static  String S_DispatchId = "DISPATCH_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOInvoiceDsDispatchBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initTargetSharding(String value){
     this.initProperty(S_TargetSharding,value);
  }
  public  void setTargetSharding(String value){
     this.set(S_TargetSharding,value);
  }
  public  void setTargetShardingNull(){
     this.set(S_TargetSharding,null);
  }

  public String getTargetSharding(){
       return DataType.getAsString(this.get(S_TargetSharding));
  
  }
  public String getTargetShardingInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TargetSharding));
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

  public void initExecuteTime(Timestamp value){
     this.initProperty(S_ExecuteTime,value);
  }
  public  void setExecuteTime(Timestamp value){
     this.set(S_ExecuteTime,value);
  }
  public  void setExecuteTimeNull(){
     this.set(S_ExecuteTime,null);
  }

  public Timestamp getExecuteTime(){
        return DataType.getAsDateTime(this.get(S_ExecuteTime));
  
  }
  public Timestamp getExecuteTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ExecuteTime));
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

  public void initDispatchKind(String value){
     this.initProperty(S_DispatchKind,value);
  }
  public  void setDispatchKind(String value){
     this.set(S_DispatchKind,value);
  }
  public  void setDispatchKindNull(){
     this.set(S_DispatchKind,null);
  }

  public String getDispatchKind(){
       return DataType.getAsString(this.get(S_DispatchKind));
  
  }
  public String getDispatchKindInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DispatchKind));
      }

  public void initDispatchCount(int value){
     this.initProperty(S_DispatchCount,new Integer(value));
  }
  public  void setDispatchCount(int value){
     this.set(S_DispatchCount,new Integer(value));
  }
  public  void setDispatchCountNull(){
     this.set(S_DispatchCount,null);
  }

  public int getDispatchCount(){
        return DataType.getAsInt(this.get(S_DispatchCount));
  
  }
  public int getDispatchCountInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_DispatchCount));
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

  public void initDispatchResult(String value){
     this.initProperty(S_DispatchResult,value);
  }
  public  void setDispatchResult(String value){
     this.set(S_DispatchResult,value);
  }
  public  void setDispatchResultNull(){
     this.set(S_DispatchResult,null);
  }

  public String getDispatchResult(){
       return DataType.getAsString(this.get(S_DispatchResult));
  
  }
  public String getDispatchResultInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DispatchResult));
      }

  public void initDispatchId(long value){
     this.initProperty(S_DispatchId,new Long(value));
  }
  public  void setDispatchId(long value){
     this.set(S_DispatchId,new Long(value));
  }
  public  void setDispatchIdNull(){
     this.set(S_DispatchId,null);
  }

  public long getDispatchId(){
        return DataType.getAsLong(this.get(S_DispatchId));
  
  }
  public long getDispatchIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_DispatchId));
      }


 
 }

