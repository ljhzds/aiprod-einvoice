package com.asiainfo.einvoice.core.def.bo.ivalues;
import com.ai.appframe2.common.DataStructInterface;

public interface IBOBusiFeatureRelDefValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_RelDefId = "REL_DEF_ID";
  public final static  String S_FeatureName = "FEATURE_NAME";
  public final static  String S_FeatureCode = "FEATURE_CODE";
  public final static  String S_BusiType = "BUSI_TYPE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_FeatureField = "FEATURE_FIELD";
  public final static  String S_Notes = "NOTES";


public String getState();

public long getRelDefId();

public String getFeatureName();

public String getFeatureCode();

public String getBusiType();

public String getRemarks();

public String getFeatureField();

public String getNotes();


public  void setState(String value);

public  void setRelDefId(long value);

public  void setFeatureName(String value);

public  void setFeatureCode(String value);

public  void setBusiType(String value);

public  void setRemarks(String value);

public  void setFeatureField(String value);

public  void setNotes(String value);
}
