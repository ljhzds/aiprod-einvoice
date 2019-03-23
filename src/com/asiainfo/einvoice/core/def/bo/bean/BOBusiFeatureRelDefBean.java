package com.asiainfo.einvoice.core.def.bo.bean;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.einvoice.core.def.bo.ivalues.*;

public class BOBusiFeatureRelDefBean extends DataContainer implements DataContainerInterface,IBOBusiFeatureRelDefValue{

  private static String  m_boName = "com.asiainfo.einvoice.core.def.bo.BOBusiFeatureRelDef";



  public final static  String S_State = "STATE";
  public final static  String S_RelDefId = "REL_DEF_ID";
  public final static  String S_FeatureName = "FEATURE_NAME";
  public final static  String S_FeatureCode = "FEATURE_CODE";
  public final static  String S_BusiType = "BUSI_TYPE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_FeatureField = "FEATURE_FIELD";
  public final static  String S_Notes = "NOTES";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOBusiFeatureRelDefBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initRelDefId(long value){
     this.initProperty(S_RelDefId,new Long(value));
  }
  public  void setRelDefId(long value){
     this.set(S_RelDefId,new Long(value));
  }
  public  void setRelDefIdNull(){
     this.set(S_RelDefId,null);
  }

  public long getRelDefId(){
        return DataType.getAsLong(this.get(S_RelDefId));
  
  }
  public long getRelDefIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RelDefId));
      }

  public void initFeatureName(String value){
     this.initProperty(S_FeatureName,value);
  }
  public  void setFeatureName(String value){
     this.set(S_FeatureName,value);
  }
  public  void setFeatureNameNull(){
     this.set(S_FeatureName,null);
  }

  public String getFeatureName(){
       return DataType.getAsString(this.get(S_FeatureName));
  
  }
  public String getFeatureNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FeatureName));
      }

  public void initFeatureCode(String value){
     this.initProperty(S_FeatureCode,value);
  }
  public  void setFeatureCode(String value){
     this.set(S_FeatureCode,value);
  }
  public  void setFeatureCodeNull(){
     this.set(S_FeatureCode,null);
  }

  public String getFeatureCode(){
       return DataType.getAsString(this.get(S_FeatureCode));
  
  }
  public String getFeatureCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FeatureCode));
      }

  public void initBusiType(String value){
     this.initProperty(S_BusiType,value);
  }
  public  void setBusiType(String value){
     this.set(S_BusiType,value);
  }
  public  void setBusiTypeNull(){
     this.set(S_BusiType,null);
  }

  public String getBusiType(){
       return DataType.getAsString(this.get(S_BusiType));
  
  }
  public String getBusiTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BusiType));
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

  public void initFeatureField(String value){
     this.initProperty(S_FeatureField,value);
  }
  public  void setFeatureField(String value){
     this.set(S_FeatureField,value);
  }
  public  void setFeatureFieldNull(){
     this.set(S_FeatureField,null);
  }

  public String getFeatureField(){
       return DataType.getAsString(this.get(S_FeatureField));
  
  }
  public String getFeatureFieldInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FeatureField));
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


 
 }

