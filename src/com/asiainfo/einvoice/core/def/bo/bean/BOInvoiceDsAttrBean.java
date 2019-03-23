package com.asiainfo.einvoice.core.def.bo.bean;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceDsAttrValue;

public class BOInvoiceDsAttrBean extends DataContainer implements DataContainerInterface,IBOInvoiceDsAttrValue{

  private static String  m_boName = "com.asiainfo.einvoice.core.def.bo.BOInvoiceDsAttr";



  public final static  String S_Notes = "NOTES";
  public final static  String S_AttrName = "ATTR_NAME";
  public final static  String S_InvoiceDsId = "INVOICE_DS_ID";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_AttrValDesc = "ATTR_VAL_DESC";
  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_AttrId = "ATTR_ID";
  public final static  String S_AttrCode = "ATTR_CODE";
  public final static  String S_AttrVal = "ATTR_VAL";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOInvoiceDsAttrBean() throws AIException{
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

  public void initAttrName(String value){
     this.initProperty(S_AttrName,value);
  }
  public  void setAttrName(String value){
     this.set(S_AttrName,value);
  }
  public  void setAttrNameNull(){
     this.set(S_AttrName,null);
  }

  public String getAttrName(){
       return DataType.getAsString(this.get(S_AttrName));
  
  }
  public String getAttrNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AttrName));
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

  public void initAttrValDesc(String value){
     this.initProperty(S_AttrValDesc,value);
  }
  public  void setAttrValDesc(String value){
     this.set(S_AttrValDesc,value);
  }
  public  void setAttrValDescNull(){
     this.set(S_AttrValDesc,null);
  }

  public String getAttrValDesc(){
       return DataType.getAsString(this.get(S_AttrValDesc));
  
  }
  public String getAttrValDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AttrValDesc));
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

  public void initAttrId(long value){
     this.initProperty(S_AttrId,new Long(value));
  }
  public  void setAttrId(long value){
     this.set(S_AttrId,new Long(value));
  }
  public  void setAttrIdNull(){
     this.set(S_AttrId,null);
  }

  public long getAttrId(){
        return DataType.getAsLong(this.get(S_AttrId));
  
  }
  public long getAttrIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AttrId));
      }

  public void initAttrCode(String value){
     this.initProperty(S_AttrCode,value);
  }
  public  void setAttrCode(String value){
     this.set(S_AttrCode,value);
  }
  public  void setAttrCodeNull(){
     this.set(S_AttrCode,null);
  }

  public String getAttrCode(){
       return DataType.getAsString(this.get(S_AttrCode));
  
  }
  public String getAttrCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AttrCode));
      }

  public void initAttrVal(String value){
     this.initProperty(S_AttrVal,value);
  }
  public  void setAttrVal(String value){
     this.set(S_AttrVal,value);
  }
  public  void setAttrValNull(){
     this.set(S_AttrVal,null);
  }

  public String getAttrVal(){
       return DataType.getAsString(this.get(S_AttrVal));
  
  }
  public String getAttrValInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AttrVal));
      }


 
 }

