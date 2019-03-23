package com.asiainfo.einvoice.core.def.bo.bean;

import java.sql.Timestamp;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoicePresInstValue;

public class BOInvoicePresInstBean extends DataContainer implements DataContainerInterface,IBOInvoicePresInstValue{

  private static String  m_boName = "com.asiainfo.einvoice.core.def.bo.BOInvoicePresInst";



  public final static  String S_CreateOpId = "CREATE_OP_ID";
  public final static  String S_InvoiceInstanceId = "INVOICE_INSTANCE_ID";
  public final static  String S_PersistentKey = "PERSISTENT_KEY";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_PersistentType = "PERSISTENT_TYPE";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_CreateOrgId = "CREATE_ORG_ID";
  public final static  String S_Url = "URL";
  public final static  String S_PersistentPath = "PERSISTENT_PATH";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOInvoicePresInstBean() throws AIException{
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

  public void initPersistentKey(String value){
     this.initProperty(S_PersistentKey,value);
  }
  public  void setPersistentKey(String value){
     this.set(S_PersistentKey,value);
  }
  public  void setPersistentKeyNull(){
     this.set(S_PersistentKey,null);
  }

  public String getPersistentKey(){
       return DataType.getAsString(this.get(S_PersistentKey));
  
  }
  public String getPersistentKeyInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PersistentKey));
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

  public void initPersistentType(String value){
     this.initProperty(S_PersistentType,value);
  }
  public  void setPersistentType(String value){
     this.set(S_PersistentType,value);
  }
  public  void setPersistentTypeNull(){
     this.set(S_PersistentType,null);
  }

  public String getPersistentType(){
       return DataType.getAsString(this.get(S_PersistentType));
  
  }
  public String getPersistentTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PersistentType));
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

  public void initUrl(String value){
     this.initProperty(S_Url,value);
  }
  public  void setUrl(String value){
     this.set(S_Url,value);
  }
  public  void setUrlNull(){
     this.set(S_Url,null);
  }

  public String getUrl(){
       return DataType.getAsString(this.get(S_Url));
  
  }
  public String getUrlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Url));
      }

  public void initPersistentPath(String value){
     this.initProperty(S_PersistentPath,value);
  }
  public  void setPersistentPath(String value){
     this.set(S_PersistentPath,value);
  }
  public  void setPersistentPathNull(){
     this.set(S_PersistentPath,null);
  }

  public String getPersistentPath(){
       return DataType.getAsString(this.get(S_PersistentPath));
  
  }
  public String getPersistentPathInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PersistentPath));
      }


 
 }

