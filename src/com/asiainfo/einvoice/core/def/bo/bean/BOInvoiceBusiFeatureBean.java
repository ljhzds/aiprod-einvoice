package com.asiainfo.einvoice.core.def.bo.bean;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceBusiFeatureValue;

public class BOInvoiceBusiFeatureBean extends DataContainer implements DataContainerInterface,IBOInvoiceBusiFeatureValue{

  private static String  m_boName = "com.asiainfo.einvoice.core.def.bo.BOInvoiceBusiFeature";



  public final static  String S_InvoiceDsId = "INVOICE_DS_ID";
  public final static  String S_Feature1 = "FEATURE1";
  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_Feature4 = "FEATURE4";
  public final static  String S_Feature5 = "FEATURE5";
  public final static  String S_Feature2 = "FEATURE2";
  public final static  String S_Feature3 = "FEATURE3";
  public final static  String S_Feature8 = "FEATURE8";
  public final static  String S_Feature9 = "FEATURE9";
  public final static  String S_Notes = "NOTES";
  public final static  String S_Feature10 = "FEATURE10";
  public final static  String S_Feature6 = "FEATURE6";
  public final static  String S_Feature7 = "FEATURE7";
  public final static  String S_Sharding = "SHARDING";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOInvoiceBusiFeatureBean() throws AIException{
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

  public void initFeature1(String value){
     this.initProperty(S_Feature1,value);
  }
  public  void setFeature1(String value){
     this.set(S_Feature1,value);
  }
  public  void setFeature1Null(){
     this.set(S_Feature1,null);
  }

  public String getFeature1(){
       return DataType.getAsString(this.get(S_Feature1));
  
  }
  public String getFeature1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Feature1));
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

  public void initFeature4(String value){
     this.initProperty(S_Feature4,value);
  }
  public  void setFeature4(String value){
     this.set(S_Feature4,value);
  }
  public  void setFeature4Null(){
     this.set(S_Feature4,null);
  }

  public String getFeature4(){
       return DataType.getAsString(this.get(S_Feature4));
  
  }
  public String getFeature4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Feature4));
      }

  public void initFeature5(String value){
     this.initProperty(S_Feature5,value);
  }
  public  void setFeature5(String value){
     this.set(S_Feature5,value);
  }
  public  void setFeature5Null(){
     this.set(S_Feature5,null);
  }

  public String getFeature5(){
       return DataType.getAsString(this.get(S_Feature5));
  
  }
  public String getFeature5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Feature5));
      }

  public void initFeature2(String value){
     this.initProperty(S_Feature2,value);
  }
  public  void setFeature2(String value){
     this.set(S_Feature2,value);
  }
  public  void setFeature2Null(){
     this.set(S_Feature2,null);
  }

  public String getFeature2(){
       return DataType.getAsString(this.get(S_Feature2));
  
  }
  public String getFeature2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Feature2));
      }

  public void initFeature3(String value){
     this.initProperty(S_Feature3,value);
  }
  public  void setFeature3(String value){
     this.set(S_Feature3,value);
  }
  public  void setFeature3Null(){
     this.set(S_Feature3,null);
  }

  public String getFeature3(){
       return DataType.getAsString(this.get(S_Feature3));
  
  }
  public String getFeature3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Feature3));
      }

  public void initFeature8(String value){
     this.initProperty(S_Feature8,value);
  }
  public  void setFeature8(String value){
     this.set(S_Feature8,value);
  }
  public  void setFeature8Null(){
     this.set(S_Feature8,null);
  }

  public String getFeature8(){
       return DataType.getAsString(this.get(S_Feature8));
  
  }
  public String getFeature8InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Feature8));
      }

  public void initFeature9(String value){
     this.initProperty(S_Feature9,value);
  }
  public  void setFeature9(String value){
     this.set(S_Feature9,value);
  }
  public  void setFeature9Null(){
     this.set(S_Feature9,null);
  }

  public String getFeature9(){
       return DataType.getAsString(this.get(S_Feature9));
  
  }
  public String getFeature9InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Feature9));
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

  public void initFeature10(String value){
     this.initProperty(S_Feature10,value);
  }
  public  void setFeature10(String value){
     this.set(S_Feature10,value);
  }
  public  void setFeature10Null(){
     this.set(S_Feature10,null);
  }

  public String getFeature10(){
       return DataType.getAsString(this.get(S_Feature10));
  
  }
  public String getFeature10InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Feature10));
      }

  public void initFeature6(String value){
     this.initProperty(S_Feature6,value);
  }
  public  void setFeature6(String value){
     this.set(S_Feature6,value);
  }
  public  void setFeature6Null(){
     this.set(S_Feature6,null);
  }

  public String getFeature6(){
       return DataType.getAsString(this.get(S_Feature6));
  
  }
  public String getFeature6InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Feature6));
      }

  public void initFeature7(String value){
     this.initProperty(S_Feature7,value);
  }
  public  void setFeature7(String value){
     this.set(S_Feature7,value);
  }
  public  void setFeature7Null(){
     this.set(S_Feature7,null);
  }

  public String getFeature7(){
       return DataType.getAsString(this.get(S_Feature7));
  
  }
  public String getFeature7InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Feature7));
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


 
 }

