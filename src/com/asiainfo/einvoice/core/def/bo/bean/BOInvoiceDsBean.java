package com.asiainfo.einvoice.core.def.bo.bean;

import java.sql.Timestamp;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceDsValue;

public class BOInvoiceDsBean extends DataContainer implements DataContainerInterface,IBOInvoiceDsValue{

  private static String  m_boName = "com.asiainfo.einvoice.core.def.bo.BOInvoiceDs";



  public final static  String S_Sky = "SKY";
  public final static  String S_CreateOpId = "CREATE_OP_ID";
  public final static  String S_CustId = "CUST_ID";
  public final static  String S_GhfDhhm = "GHF_DHHM";
  public final static  String S_XhfNsrmc = "XHF_NSRMC";
  public final static  String S_XhfNsrsbh = "XHF_NSRSBH";
  public final static  String S_InvoiceContent = "INVOICE_CONTENT";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_DsState = "DS_STATE";
  public final static  String S_KpfMc = "KPF_MC";
  public final static  String S_BusiType = "BUSI_TYPE";
  public final static  String S_Notes = "NOTES";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_InvoiceType = "INVOICE_TYPE";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_Kpy = "KPY";
  public final static  String S_Fhy = "FHY";
  public final static  String S_TotalPrice = "TOTAL_PRICE";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_GhfNsrmc = "GHF_NSRMC";
  public final static  String S_CreateOrgId = "CREATE_ORG_ID";
  public final static  String S_XhfDz = "XHF_DZ";
  public final static  String S_IssuingType = "ISSUING_TYPE";
  public final static  String S_InvoiceHead = "INVOICE_HEAD";
  public final static  String S_SoOrderId = "SO_ORDER_ID";
  public final static  String S_InvoiceDsId = "INVOICE_DS_ID";
  public final static  String S_XhfDhhm = "XHF_DHHM";
  public final static  String S_AcctId = "ACCT_ID";
  public final static  String S_GhfQylx = "GHF_QYLX";
  public final static  String S_KpfSbh = "KPF_SBH";
  public final static  String S_SoOrderSeria = "SO_ORDER_SERIA";
  public final static  String S_GhfDz = "GHF_DZ";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";
  public final static  String S_IssuingChannel = "ISSUING_CHANNEL";
  public final static  String S_TotalTax = "TOTAL_TAX";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_KpfDzdah = "KPF_DZDAH";
  public final static  String S_GhfNsrsbh = "GHF_NSRSBH";
  public final static  String S_XhfYhzh = "XHF_YHZH";
  public final static  String S_GhfYhzh = "GHF_YHZH";
  public final static  String S_TotalAmount = "TOTAL_AMOUNT";
  public final static  String S_Dkbz = "DKBZ";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOInvoiceDsBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initSky(String value){
     this.initProperty(S_Sky,value);
  }
  public  void setSky(String value){
     this.set(S_Sky,value);
  }
  public  void setSkyNull(){
     this.set(S_Sky,null);
  }

  public String getSky(){
       return DataType.getAsString(this.get(S_Sky));
  
  }
  public String getSkyInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Sky));
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

  public void initXhfNsrmc(String value){
     this.initProperty(S_XhfNsrmc,value);
  }
  public  void setXhfNsrmc(String value){
     this.set(S_XhfNsrmc,value);
  }
  public  void setXhfNsrmcNull(){
     this.set(S_XhfNsrmc,null);
  }

  public String getXhfNsrmc(){
       return DataType.getAsString(this.get(S_XhfNsrmc));
  
  }
  public String getXhfNsrmcInitialValue(){
        return DataType.getAsString(this.getOldObj(S_XhfNsrmc));
      }

  public void initXhfNsrsbh(String value){
     this.initProperty(S_XhfNsrsbh,value);
  }
  public  void setXhfNsrsbh(String value){
     this.set(S_XhfNsrsbh,value);
  }
  public  void setXhfNsrsbhNull(){
     this.set(S_XhfNsrsbh,null);
  }

  public String getXhfNsrsbh(){
       return DataType.getAsString(this.get(S_XhfNsrsbh));
  
  }
  public String getXhfNsrsbhInitialValue(){
        return DataType.getAsString(this.getOldObj(S_XhfNsrsbh));
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

  public void initDsState(String value){
     this.initProperty(S_DsState,value);
  }
  public  void setDsState(String value){
     this.set(S_DsState,value);
  }
  public  void setDsStateNull(){
     this.set(S_DsState,null);
  }

  public String getDsState(){
       return DataType.getAsString(this.get(S_DsState));
  
  }
  public String getDsStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DsState));
      }

  public void initKpfMc(String value){
     this.initProperty(S_KpfMc,value);
  }
  public  void setKpfMc(String value){
     this.set(S_KpfMc,value);
  }
  public  void setKpfMcNull(){
     this.set(S_KpfMc,null);
  }

  public String getKpfMc(){
       return DataType.getAsString(this.get(S_KpfMc));
  
  }
  public String getKpfMcInitialValue(){
        return DataType.getAsString(this.getOldObj(S_KpfMc));
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

  public void initKpy(String value){
     this.initProperty(S_Kpy,value);
  }
  public  void setKpy(String value){
     this.set(S_Kpy,value);
  }
  public  void setKpyNull(){
     this.set(S_Kpy,null);
  }

  public String getKpy(){
       return DataType.getAsString(this.get(S_Kpy));
  
  }
  public String getKpyInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Kpy));
      }

  public void initFhy(String value){
     this.initProperty(S_Fhy,value);
  }
  public  void setFhy(String value){
     this.set(S_Fhy,value);
  }
  public  void setFhyNull(){
     this.set(S_Fhy,null);
  }

  public String getFhy(){
       return DataType.getAsString(this.get(S_Fhy));
  
  }
  public String getFhyInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Fhy));
      }

  public void initTotalPrice(long value){
     this.initProperty(S_TotalPrice,new Long(value));
  }
  public  void setTotalPrice(long value){
     this.set(S_TotalPrice,new Long(value));
  }
  public  void setTotalPriceNull(){
     this.set(S_TotalPrice,null);
  }

  public long getTotalPrice(){
        return DataType.getAsLong(this.get(S_TotalPrice));
  
  }
  public long getTotalPriceInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TotalPrice));
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

  public void initXhfDz(String value){
     this.initProperty(S_XhfDz,value);
  }
  public  void setXhfDz(String value){
     this.set(S_XhfDz,value);
  }
  public  void setXhfDzNull(){
     this.set(S_XhfDz,null);
  }

  public String getXhfDz(){
       return DataType.getAsString(this.get(S_XhfDz));
  
  }
  public String getXhfDzInitialValue(){
        return DataType.getAsString(this.getOldObj(S_XhfDz));
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

  public void initSoOrderId(String value){
     this.initProperty(S_SoOrderId,value);
  }
  public  void setSoOrderId(String value){
     this.set(S_SoOrderId,value);
  }
  public  void setSoOrderIdNull(){
     this.set(S_SoOrderId,null);
  }

  public String getSoOrderId(){
       return DataType.getAsString(this.get(S_SoOrderId));
  
  }
  public String getSoOrderIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SoOrderId));
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

  public void initXhfDhhm(String value){
     this.initProperty(S_XhfDhhm,value);
  }
  public  void setXhfDhhm(String value){
     this.set(S_XhfDhhm,value);
  }
  public  void setXhfDhhmNull(){
     this.set(S_XhfDhhm,null);
  }

  public String getXhfDhhm(){
       return DataType.getAsString(this.get(S_XhfDhhm));
  
  }
  public String getXhfDhhmInitialValue(){
        return DataType.getAsString(this.getOldObj(S_XhfDhhm));
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

  public void initKpfSbh(String value){
     this.initProperty(S_KpfSbh,value);
  }
  public  void setKpfSbh(String value){
     this.set(S_KpfSbh,value);
  }
  public  void setKpfSbhNull(){
     this.set(S_KpfSbh,null);
  }

  public String getKpfSbh(){
       return DataType.getAsString(this.get(S_KpfSbh));
  
  }
  public String getKpfSbhInitialValue(){
        return DataType.getAsString(this.getOldObj(S_KpfSbh));
      }

  public void initSoOrderSeria(String value){
     this.initProperty(S_SoOrderSeria,value);
  }
  public  void setSoOrderSeria(String value){
     this.set(S_SoOrderSeria,value);
  }
  public  void setSoOrderSeriaNull(){
     this.set(S_SoOrderSeria,null);
  }

  public String getSoOrderSeria(){
       return DataType.getAsString(this.get(S_SoOrderSeria));
  
  }
  public String getSoOrderSeriaInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SoOrderSeria));
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

  public void initTotalTax(long value){
     this.initProperty(S_TotalTax,new Long(value));
  }
  public  void setTotalTax(long value){
     this.set(S_TotalTax,new Long(value));
  }
  public  void setTotalTaxNull(){
     this.set(S_TotalTax,null);
  }

  public long getTotalTax(){
        return DataType.getAsLong(this.get(S_TotalTax));
  
  }
  public long getTotalTaxInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TotalTax));
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

  public void initKpfDzdah(String value){
     this.initProperty(S_KpfDzdah,value);
  }
  public  void setKpfDzdah(String value){
     this.set(S_KpfDzdah,value);
  }
  public  void setKpfDzdahNull(){
     this.set(S_KpfDzdah,null);
  }

  public String getKpfDzdah(){
       return DataType.getAsString(this.get(S_KpfDzdah));
  
  }
  public String getKpfDzdahInitialValue(){
        return DataType.getAsString(this.getOldObj(S_KpfDzdah));
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

  public void initXhfYhzh(String value){
     this.initProperty(S_XhfYhzh,value);
  }
  public  void setXhfYhzh(String value){
     this.set(S_XhfYhzh,value);
  }
  public  void setXhfYhzhNull(){
     this.set(S_XhfYhzh,null);
  }

  public String getXhfYhzh(){
       return DataType.getAsString(this.get(S_XhfYhzh));
  
  }
  public String getXhfYhzhInitialValue(){
        return DataType.getAsString(this.getOldObj(S_XhfYhzh));
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

  public void initTotalAmount(long value){
     this.initProperty(S_TotalAmount,new Long(value));
  }
  public  void setTotalAmount(long value){
     this.set(S_TotalAmount,new Long(value));
  }
  public  void setTotalAmountNull(){
     this.set(S_TotalAmount,null);
  }

  public long getTotalAmount(){
        return DataType.getAsLong(this.get(S_TotalAmount));
  
  }
  public long getTotalAmountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TotalAmount));
      }

  public void initDkbz(String value){
     this.initProperty(S_Dkbz,value);
  }
  public  void setDkbz(String value){
     this.set(S_Dkbz,value);
  }
  public  void setDkbzNull(){
     this.set(S_Dkbz,null);
  }

  public String getDkbz(){
       return DataType.getAsString(this.get(S_Dkbz));
  
  }
  public String getDkbzInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Dkbz));
      }


 
 }

