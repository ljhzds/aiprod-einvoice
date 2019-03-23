package com.asiainfo.einvoice.core.def.bo.bean;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceInstItemValue;

public class BOInvoiceInstItemBean extends DataContainer implements DataContainerInterface,IBOInvoiceInstItemValue{

  private static String  m_boName = "com.asiainfo.einvoice.core.def.bo.BOInvoiceInstItem";



  public final static  String S_Notes = "NOTES";
  public final static  String S_InvoiceInstanceId = "INVOICE_INSTANCE_ID";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_InvoiceDsDetailId = "INVOICE_DS_DETAIL_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_InvoiceInstanceItemId = "INVOICE_INSTANCE_ITEM_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOInvoiceInstItemBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initInvoiceDsDetailId(long value){
     this.initProperty(S_InvoiceDsDetailId,new Long(value));
  }
  public  void setInvoiceDsDetailId(long value){
     this.set(S_InvoiceDsDetailId,new Long(value));
  }
  public  void setInvoiceDsDetailIdNull(){
     this.set(S_InvoiceDsDetailId,null);
  }

  public long getInvoiceDsDetailId(){
        return DataType.getAsLong(this.get(S_InvoiceDsDetailId));
  
  }
  public long getInvoiceDsDetailIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_InvoiceDsDetailId));
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

  public void initInvoiceInstanceItemId(long value){
     this.initProperty(S_InvoiceInstanceItemId,new Long(value));
  }
  public  void setInvoiceInstanceItemId(long value){
     this.set(S_InvoiceInstanceItemId,new Long(value));
  }
  public  void setInvoiceInstanceItemIdNull(){
     this.set(S_InvoiceInstanceItemId,null);
  }

  public long getInvoiceInstanceItemId(){
        return DataType.getAsLong(this.get(S_InvoiceInstanceItemId));
  
  }
  public long getInvoiceInstanceItemIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_InvoiceInstanceItemId));
      }


 
 }

