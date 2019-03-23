package com.asiainfo.einvoice.core.def.bo.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOInvoiceBusiFeatureValue extends DataStructInterface{

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


public long getInvoiceDsId();

public String getFeature1();

public String getState();

public String getRemarks();

public String getFeature4();

public String getFeature5();

public String getFeature2();

public String getFeature3();

public String getFeature8();

public String getFeature9();

public String getNotes();

public String getFeature10();

public String getFeature6();

public String getFeature7();

public String getSharding();


public  void setInvoiceDsId(long value);

public  void setFeature1(String value);

public  void setState(String value);

public  void setRemarks(String value);

public  void setFeature4(String value);

public  void setFeature5(String value);

public  void setFeature2(String value);

public  void setFeature3(String value);

public  void setFeature8(String value);

public  void setFeature9(String value);

public  void setNotes(String value);

public  void setFeature10(String value);

public  void setFeature6(String value);

public  void setFeature7(String value);

public  void setSharding(String value);
}
