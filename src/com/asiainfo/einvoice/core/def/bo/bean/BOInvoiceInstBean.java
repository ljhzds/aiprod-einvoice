package com.asiainfo.einvoice.core.def.bo.bean;

import java.sql.Timestamp;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceInstValue;

public class BOInvoiceInstBean extends DataContainer implements DataContainerInterface,IBOInvoiceInstValue{

  private static String  m_boName = "com.asiainfo.einvoice.core.def.bo.BOInvoiceInst";



  public final static  String S_CreateOpId = "CREATE_OP_ID";
  public final static  String S_InvoiceCzdm = "INVOICE_CZDM";
  public final static  String S_OldInvoiceNumber = "OLD_INVOICE_NUMBER";
  public final static  String S_InvoiceQqddh = "INVOICE_QQDDH";
  public final static  String S_InvoiceContent = "INVOICE_CONTENT";
  public final static  String S_IssuingTime = "ISSUING_TIME";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_Notes = "NOTES";
  public final static  String S_InvoiceInstanceId = "INVOICE_INSTANCE_ID";
  public final static  String S_InvoicePrice = "INVOICE_PRICE";
  public final static  String S_InvoiceType = "INVOICE_TYPE";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_ChReason = "CH_REASON";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_CreateOrgId = "CREATE_ORG_ID";
  public final static  String S_InvoiceTax = "INVOICE_TAX";
  public final static  String S_IssuingType = "ISSUING_TYPE";
  public final static  String S_InvoiceHead = "INVOICE_HEAD";
  public final static  String S_IssuingFlag = "ISSUING_FLAG";
  public final static  String S_InvoiceDsId = "INVOICE_DS_ID";
  public final static  String S_InvoiceVerifyCode = "INVOICE_VERIFY_CODE";
  public final static  String S_InvoiceNumber = "INVOICE_NUMBER";
  public final static  String S_OldInvoiceInstanceId = "OLD_INVOICE_INSTANCE_ID";
  public final static  String S_InvoiceEwm = "INVOICE_EWM";
  public final static  String S_InvoiceCode = "INVOICE_CODE";
  public final static  String S_InvoiceFwm = "INVOICE_FWM";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";
  public final static  String S_IssuingChannel = "ISSUING_CHANNEL";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_OldInvoiceCode = "OLD_INVOICE_CODE";
  public final static  String S_InvoiceAmount = "INVOICE_AMOUNT";
  public final static  String S_InvoiceQqlsh = "INVOICE_QQLSH";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOInvoiceInstBean() throws AIException{
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

  public void initInvoiceCzdm(String value){
     this.initProperty(S_InvoiceCzdm,value);
  }
  public  void setInvoiceCzdm(String value){
     this.set(S_InvoiceCzdm,value);
  }
  public  void setInvoiceCzdmNull(){
     this.set(S_InvoiceCzdm,null);
  }

  public String getInvoiceCzdm(){
       return DataType.getAsString(this.get(S_InvoiceCzdm));
  
  }
  public String getInvoiceCzdmInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InvoiceCzdm));
      }

  public void initOldInvoiceNumber(String value){
     this.initProperty(S_OldInvoiceNumber,value);
  }
  public  void setOldInvoiceNumber(String value){
     this.set(S_OldInvoiceNumber,value);
  }
  public  void setOldInvoiceNumberNull(){
     this.set(S_OldInvoiceNumber,null);
  }

  public String getOldInvoiceNumber(){
       return DataType.getAsString(this.get(S_OldInvoiceNumber));
  
  }
  public String getOldInvoiceNumberInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OldInvoiceNumber));
      }

  public void initInvoiceQqddh(String value){
     this.initProperty(S_InvoiceQqddh,value);
  }
  public  void setInvoiceQqddh(String value){
     this.set(S_InvoiceQqddh,value);
  }
  public  void setInvoiceQqddhNull(){
     this.set(S_InvoiceQqddh,null);
  }

  public String getInvoiceQqddh(){
       return DataType.getAsString(this.get(S_InvoiceQqddh));
  
  }
  public String getInvoiceQqddhInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InvoiceQqddh));
      }

  public void initInvoiceContent(String value){
     this.initProperty(S_InvoiceContent,value);
  }
  public  void setInvoiceContent(String value){
     this.set(S_InvoiceContent,value);
  }
  public  void setInvoiceContentNull(){
     this.set(S_InvoiceContent,null);
  }

  public String getInvoiceContent(){
       return DataType.getAsString(this.get(S_InvoiceContent));
  
  }
  public String getInvoiceContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InvoiceContent));
      }

  public void initIssuingTime(Timestamp value){
     this.initProperty(S_IssuingTime,value);
  }
  public  void setIssuingTime(Timestamp value){
     this.set(S_IssuingTime,value);
  }
  public  void setIssuingTimeNull(){
     this.set(S_IssuingTime,null);
  }

  public Timestamp getIssuingTime(){
        return DataType.getAsDateTime(this.get(S_IssuingTime));
  
  }
  public Timestamp getIssuingTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_IssuingTime));
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

  public void initInvoicePrice(long value){
     this.initProperty(S_InvoicePrice,new Long(value));
  }
  public  void setInvoicePrice(long value){
     this.set(S_InvoicePrice,new Long(value));
  }
  public  void setInvoicePriceNull(){
     this.set(S_InvoicePrice,null);
  }

  public long getInvoicePrice(){
        return DataType.getAsLong(this.get(S_InvoicePrice));
  
  }
  public long getInvoicePriceInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_InvoicePrice));
      }

  public void initInvoiceType(String value){
     this.initProperty(S_InvoiceType,value);
  }
  public  void setInvoiceType(String value){
     this.set(S_InvoiceType,value);
  }
  public  void setInvoiceTypeNull(){
     this.set(S_InvoiceType,null);
  }

  public String getInvoiceType(){
       return DataType.getAsString(this.get(S_InvoiceType));
  
  }
  public String getInvoiceTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InvoiceType));
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

  public void initChReason(String value){
     this.initProperty(S_ChReason,value);
  }
  public  void setChReason(String value){
     this.set(S_ChReason,value);
  }
  public  void setChReasonNull(){
     this.set(S_ChReason,null);
  }

  public String getChReason(){
       return DataType.getAsString(this.get(S_ChReason));
  
  }
  public String getChReasonInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChReason));
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

  public void initInvoiceTax(long value){
     this.initProperty(S_InvoiceTax,new Long(value));
  }
  public  void setInvoiceTax(long value){
     this.set(S_InvoiceTax,new Long(value));
  }
  public  void setInvoiceTaxNull(){
     this.set(S_InvoiceTax,null);
  }

  public long getInvoiceTax(){
        return DataType.getAsLong(this.get(S_InvoiceTax));
  
  }
  public long getInvoiceTaxInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_InvoiceTax));
      }

  public void initIssuingType(String value){
     this.initProperty(S_IssuingType,value);
  }
  public  void setIssuingType(String value){
     this.set(S_IssuingType,value);
  }
  public  void setIssuingTypeNull(){
     this.set(S_IssuingType,null);
  }

  public String getIssuingType(){
       return DataType.getAsString(this.get(S_IssuingType));
  
  }
  public String getIssuingTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IssuingType));
      }

  public void initInvoiceHead(String value){
     this.initProperty(S_InvoiceHead,value);
  }
  public  void setInvoiceHead(String value){
     this.set(S_InvoiceHead,value);
  }
  public  void setInvoiceHeadNull(){
     this.set(S_InvoiceHead,null);
  }

  public String getInvoiceHead(){
       return DataType.getAsString(this.get(S_InvoiceHead));
  
  }
  public String getInvoiceHeadInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InvoiceHead));
      }

  public void initIssuingFlag(String value){
     this.initProperty(S_IssuingFlag,value);
  }
  public  void setIssuingFlag(String value){
     this.set(S_IssuingFlag,value);
  }
  public  void setIssuingFlagNull(){
     this.set(S_IssuingFlag,null);
  }

  public String getIssuingFlag(){
       return DataType.getAsString(this.get(S_IssuingFlag));
  
  }
  public String getIssuingFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IssuingFlag));
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

  public void initInvoiceVerifyCode(String value){
     this.initProperty(S_InvoiceVerifyCode,value);
  }
  public  void setInvoiceVerifyCode(String value){
     this.set(S_InvoiceVerifyCode,value);
  }
  public  void setInvoiceVerifyCodeNull(){
     this.set(S_InvoiceVerifyCode,null);
  }

  public String getInvoiceVerifyCode(){
       return DataType.getAsString(this.get(S_InvoiceVerifyCode));
  
  }
  public String getInvoiceVerifyCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InvoiceVerifyCode));
      }

  public void initInvoiceNumber(String value){
     this.initProperty(S_InvoiceNumber,value);
  }
  public  void setInvoiceNumber(String value){
     this.set(S_InvoiceNumber,value);
  }
  public  void setInvoiceNumberNull(){
     this.set(S_InvoiceNumber,null);
  }

  public String getInvoiceNumber(){
       return DataType.getAsString(this.get(S_InvoiceNumber));
  
  }
  public String getInvoiceNumberInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InvoiceNumber));
      }

  public void initOldInvoiceInstanceId(long value){
     this.initProperty(S_OldInvoiceInstanceId,new Long(value));
  }
  public  void setOldInvoiceInstanceId(long value){
     this.set(S_OldInvoiceInstanceId,new Long(value));
  }
  public  void setOldInvoiceInstanceIdNull(){
     this.set(S_OldInvoiceInstanceId,null);
  }

  public long getOldInvoiceInstanceId(){
        return DataType.getAsLong(this.get(S_OldInvoiceInstanceId));
  
  }
  public long getOldInvoiceInstanceIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OldInvoiceInstanceId));
      }

  public void initInvoiceEwm(String value){
     this.initProperty(S_InvoiceEwm,value);
  }
  public  void setInvoiceEwm(String value){
     this.set(S_InvoiceEwm,value);
  }
  public  void setInvoiceEwmNull(){
     this.set(S_InvoiceEwm,null);
  }

  public String getInvoiceEwm(){
       return DataType.getAsString(this.get(S_InvoiceEwm));
  
  }
  public String getInvoiceEwmInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InvoiceEwm));
      }

  public void initInvoiceCode(String value){
     this.initProperty(S_InvoiceCode,value);
  }
  public  void setInvoiceCode(String value){
     this.set(S_InvoiceCode,value);
  }
  public  void setInvoiceCodeNull(){
     this.set(S_InvoiceCode,null);
  }

  public String getInvoiceCode(){
       return DataType.getAsString(this.get(S_InvoiceCode));
  
  }
  public String getInvoiceCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InvoiceCode));
      }

  public void initInvoiceFwm(String value){
     this.initProperty(S_InvoiceFwm,value);
  }
  public  void setInvoiceFwm(String value){
     this.set(S_InvoiceFwm,value);
  }
  public  void setInvoiceFwmNull(){
     this.set(S_InvoiceFwm,null);
  }

  public String getInvoiceFwm(){
       return DataType.getAsString(this.get(S_InvoiceFwm));
  
  }
  public String getInvoiceFwmInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InvoiceFwm));
      }

  public void initExt1(String value){
     this.initProperty(S_Ext1,value);
  }
  public  void setExt1(String value){
     this.set(S_Ext1,value);
  }
  public  void setExt1Null(){
     this.set(S_Ext1,null);
  }

  public String getExt1(){
       return DataType.getAsString(this.get(S_Ext1));
  
  }
  public String getExt1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext1));
      }

  public void initExt2(String value){
     this.initProperty(S_Ext2,value);
  }
  public  void setExt2(String value){
     this.set(S_Ext2,value);
  }
  public  void setExt2Null(){
     this.set(S_Ext2,null);
  }

  public String getExt2(){
       return DataType.getAsString(this.get(S_Ext2));
  
  }
  public String getExt2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext2));
      }

  public void initExt3(String value){
     this.initProperty(S_Ext3,value);
  }
  public  void setExt3(String value){
     this.set(S_Ext3,value);
  }
  public  void setExt3Null(){
     this.set(S_Ext3,null);
  }

  public String getExt3(){
       return DataType.getAsString(this.get(S_Ext3));
  
  }
  public String getExt3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext3));
      }

  public void initExt4(String value){
     this.initProperty(S_Ext4,value);
  }
  public  void setExt4(String value){
     this.set(S_Ext4,value);
  }
  public  void setExt4Null(){
     this.set(S_Ext4,null);
  }

  public String getExt4(){
       return DataType.getAsString(this.get(S_Ext4));
  
  }
  public String getExt4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext4));
      }

  public void initIssuingChannel(String value){
     this.initProperty(S_IssuingChannel,value);
  }
  public  void setIssuingChannel(String value){
     this.set(S_IssuingChannel,value);
  }
  public  void setIssuingChannelNull(){
     this.set(S_IssuingChannel,null);
  }

  public String getIssuingChannel(){
       return DataType.getAsString(this.get(S_IssuingChannel));
  
  }
  public String getIssuingChannelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IssuingChannel));
      }

  public void initExt5(String value){
     this.initProperty(S_Ext5,value);
  }
  public  void setExt5(String value){
     this.set(S_Ext5,value);
  }
  public  void setExt5Null(){
     this.set(S_Ext5,null);
  }

  public String getExt5(){
       return DataType.getAsString(this.get(S_Ext5));
  
  }
  public String getExt5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext5));
      }

  public void initOldInvoiceCode(String value){
     this.initProperty(S_OldInvoiceCode,value);
  }
  public  void setOldInvoiceCode(String value){
     this.set(S_OldInvoiceCode,value);
  }
  public  void setOldInvoiceCodeNull(){
     this.set(S_OldInvoiceCode,null);
  }

  public String getOldInvoiceCode(){
       return DataType.getAsString(this.get(S_OldInvoiceCode));
  
  }
  public String getOldInvoiceCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OldInvoiceCode));
      }

  public void initInvoiceAmount(long value){
     this.initProperty(S_InvoiceAmount,new Long(value));
  }
  public  void setInvoiceAmount(long value){
     this.set(S_InvoiceAmount,new Long(value));
  }
  public  void setInvoiceAmountNull(){
     this.set(S_InvoiceAmount,null);
  }

  public long getInvoiceAmount(){
        return DataType.getAsLong(this.get(S_InvoiceAmount));
  
  }
  public long getInvoiceAmountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_InvoiceAmount));
      }

  public void initInvoiceQqlsh(String value){
     this.initProperty(S_InvoiceQqlsh,value);
  }
  public  void setInvoiceQqlsh(String value){
     this.set(S_InvoiceQqlsh,value);
  }
  public  void setInvoiceQqlshNull(){
     this.set(S_InvoiceQqlsh,null);
  }

  public String getInvoiceQqlsh(){
       return DataType.getAsString(this.get(S_InvoiceQqlsh));
  
  }
  public String getInvoiceQqlshInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InvoiceQqlsh));
      }


 
 }

