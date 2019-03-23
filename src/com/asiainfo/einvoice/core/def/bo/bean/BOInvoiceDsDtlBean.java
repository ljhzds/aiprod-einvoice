package com.asiainfo.einvoice.core.def.bo.bean;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceDsDtlValue;

public class BOInvoiceDsDtlBean extends DataContainer implements DataContainerInterface,IBOInvoiceDsDtlValue{

  private static String  m_boName = "com.asiainfo.einvoice.core.def.bo.BOInvoiceDsDtl";



  public final static  String S_Zxbm = "ZXBM";
  public final static  String S_InvoiceDsId = "INVOICE_DS_ID";
  public final static  String S_Hxbz = "HXBZ";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ItemUnit = "ITEM_UNIT";
  public final static  String S_Fpxz = "FPXZ";
  public final static  String S_Spbm = "SPBM";
  public final static  String S_ItemName = "ITEM_NAME";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_ItemNumb = "ITEM_NUMB";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Notes = "NOTES";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_ItemFaxRate = "ITEM_FAX_RATE";
  public final static  String S_Sharding = "SHARDING";
  public final static  String S_InvoiceDsDetailId = "INVOICE_DS_DETAIL_ID";
  public final static  String S_ItemFax = "ITEM_FAX";
  public final static  String S_ItemSpec = "ITEM_SPEC";
  public final static  String S_ItemAmount = "ITEM_AMOUNT";
  public final static  String S_ItemPrice = "ITEM_PRICE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOInvoiceDsDtlBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initZxbm(String value){
     this.initProperty(S_Zxbm,value);
  }
  public  void setZxbm(String value){
     this.set(S_Zxbm,value);
  }
  public  void setZxbmNull(){
     this.set(S_Zxbm,null);
  }

  public String getZxbm(){
       return DataType.getAsString(this.get(S_Zxbm));
  
  }
  public String getZxbmInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Zxbm));
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

  public void initHxbz(String value){
     this.initProperty(S_Hxbz,value);
  }
  public  void setHxbz(String value){
     this.set(S_Hxbz,value);
  }
  public  void setHxbzNull(){
     this.set(S_Hxbz,null);
  }

  public String getHxbz(){
       return DataType.getAsString(this.get(S_Hxbz));
  
  }
  public String getHxbzInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Hxbz));
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

  public void initItemUnit(String value){
     this.initProperty(S_ItemUnit,value);
  }
  public  void setItemUnit(String value){
     this.set(S_ItemUnit,value);
  }
  public  void setItemUnitNull(){
     this.set(S_ItemUnit,null);
  }

  public String getItemUnit(){
       return DataType.getAsString(this.get(S_ItemUnit));
  
  }
  public String getItemUnitInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ItemUnit));
      }

  public void initFpxz(String value){
     this.initProperty(S_Fpxz,value);
  }
  public  void setFpxz(String value){
     this.set(S_Fpxz,value);
  }
  public  void setFpxzNull(){
     this.set(S_Fpxz,null);
  }

  public String getFpxz(){
       return DataType.getAsString(this.get(S_Fpxz));
  
  }
  public String getFpxzInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Fpxz));
      }

  public void initSpbm(String value){
     this.initProperty(S_Spbm,value);
  }
  public  void setSpbm(String value){
     this.set(S_Spbm,value);
  }
  public  void setSpbmNull(){
     this.set(S_Spbm,null);
  }

  public String getSpbm(){
       return DataType.getAsString(this.get(S_Spbm));
  
  }
  public String getSpbmInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Spbm));
      }

  public void initItemName(String value){
     this.initProperty(S_ItemName,value);
  }
  public  void setItemName(String value){
     this.set(S_ItemName,value);
  }
  public  void setItemNameNull(){
     this.set(S_ItemName,null);
  }

  public String getItemName(){
       return DataType.getAsString(this.get(S_ItemName));
  
  }
  public String getItemNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ItemName));
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

  public void initItemNumb(int value){
     this.initProperty(S_ItemNumb,new Integer(value));
  }
  public  void setItemNumb(int value){
     this.set(S_ItemNumb,new Integer(value));
  }
  public  void setItemNumbNull(){
     this.set(S_ItemNumb,null);
  }

  public int getItemNumb(){
        return DataType.getAsInt(this.get(S_ItemNumb));
  
  }
  public int getItemNumbInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ItemNumb));
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

  public void initItemFaxRate(long value){
     this.initProperty(S_ItemFaxRate,new Long(value));
  }
  public  void setItemFaxRate(long value){
     this.set(S_ItemFaxRate,new Long(value));
  }
  public  void setItemFaxRateNull(){
     this.set(S_ItemFaxRate,null);
  }

  public long getItemFaxRate(){
        return DataType.getAsLong(this.get(S_ItemFaxRate));
  
  }
  public long getItemFaxRateInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ItemFaxRate));
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

  public void initItemFax(long value){
     this.initProperty(S_ItemFax,new Long(value));
  }
  public  void setItemFax(long value){
     this.set(S_ItemFax,new Long(value));
  }
  public  void setItemFaxNull(){
     this.set(S_ItemFax,null);
  }

  public long getItemFax(){
        return DataType.getAsLong(this.get(S_ItemFax));
  
  }
  public long getItemFaxInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ItemFax));
      }

  public void initItemSpec(String value){
     this.initProperty(S_ItemSpec,value);
  }
  public  void setItemSpec(String value){
     this.set(S_ItemSpec,value);
  }
  public  void setItemSpecNull(){
     this.set(S_ItemSpec,null);
  }

  public String getItemSpec(){
       return DataType.getAsString(this.get(S_ItemSpec));
  
  }
  public String getItemSpecInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ItemSpec));
      }

  public void initItemAmount(long value){
     this.initProperty(S_ItemAmount,new Long(value));
  }
  public  void setItemAmount(long value){
     this.set(S_ItemAmount,new Long(value));
  }
  public  void setItemAmountNull(){
     this.set(S_ItemAmount,null);
  }

  public long getItemAmount(){
        return DataType.getAsLong(this.get(S_ItemAmount));
  
  }
  public long getItemAmountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ItemAmount));
      }

  public void initItemPrice(long value){
     this.initProperty(S_ItemPrice,new Long(value));
  }
  public  void setItemPrice(long value){
     this.set(S_ItemPrice,new Long(value));
  }
  public  void setItemPriceNull(){
     this.set(S_ItemPrice,null);
  }

  public long getItemPrice(){
        return DataType.getAsLong(this.get(S_ItemPrice));
  
  }
  public long getItemPriceInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ItemPrice));
      }


 
 }

