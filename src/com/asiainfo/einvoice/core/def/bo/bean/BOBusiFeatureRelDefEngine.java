package com.asiainfo.einvoice.core.def.bo.bean;

import java.util.Map;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.ResultSet;

import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;
import com.ai.appframe2.bo.DataContainerFactory;

import com.asiainfo.einvoice.core.def.bo.ivalues.*;

public class BOBusiFeatureRelDefEngine {

  public static BOBusiFeatureRelDefBean[] getBeans(DataContainerInterface dc) throws
      Exception {
    Map ps = dc.getProperties();
    StringBuffer buffer = new StringBuffer();
    Map pList = new HashMap();
    for (java.util.Iterator cc = ps.entrySet().iterator(); cc.hasNext(); ) {
      Map.Entry e = (Map.Entry) cc.next();
      if(buffer.length() >0)
	 buffer.append(" and ");
      buffer.append(e.getKey().toString() + " = :p_" + e.getKey().toString());
      pList.put("p_" + e.getKey().toString(),e.getValue());
    }
    Connection conn = ServiceManager.getSession().getConnection();
    try {
      return getBeans(buffer.toString(), pList);
    }finally{
      if (conn != null)
	conn.close();
    }
  }

    public static BOBusiFeatureRelDefBean getBean(long _RelDefId) throws Exception{
            /**new create*/
    String condition = "REL_DEF_ID = :S_REL_DEF_ID";
      Map map = new HashMap();
      map.put("S_REL_DEF_ID",new Long(_RelDefId));
;
      BOBusiFeatureRelDefBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
	      return beans[0];
      else if(beans!=null && beans.length>1){
	//[错误]根据主键查询出现一条以上记录
	      throw new Exception("[ERROR]More datas than one queryed by PK");
      }else{
	      BOBusiFeatureRelDefBean bean = new BOBusiFeatureRelDefBean();
	      	      bean.setRelDefId(_RelDefId);
	      	      return bean;
      }
 }

  public static  BOBusiFeatureRelDefBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  BOBusiFeatureRelDefBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    Map param = null;
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
      param = sql.getParameters();
    }
    return (BOBusiFeatureRelDefBean[])getBeans(cols,condition,param,startNum,endNum,isShowFK);
  }




  public static  BOBusiFeatureRelDefBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  BOBusiFeatureRelDefBean[] getBeans(String[] cols,String condition,Map parameter,
	   int startNum,int endNum,boolean isShowFK) throws Exception{
	Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		return (BOBusiFeatureRelDefBean[])ServiceManager.getDataStore().retrieve(conn,BOBusiFeatureRelDefBean.class,BOBusiFeatureRelDefBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
	}catch(Exception e){
		throw e;
	}finally{
	   if (conn != null)
	      conn.close();
	}
  }

   public static  BOBusiFeatureRelDefBean[] getBeans(String[] cols,String condition,Map parameter,
	  int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
	  Connection conn = null;
	  try {
		  conn = ServiceManager.getSession().getConnection();
		  return (BOBusiFeatureRelDefBean[])ServiceManager.getDataStore().retrieve(conn,BOBusiFeatureRelDefBean.class,BOBusiFeatureRelDefBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
	  }catch(Exception e){
		  throw e;
	  }finally{
		if (conn != null)
		  conn.close();
	  }
   }


   public static int getBeansCount(String condition,Map parameter) throws Exception{
     Connection conn = null;
      try {
	      conn = ServiceManager.getSession().getConnection();
	      return ServiceManager.getDataStore().retrieveCount(conn,BOBusiFeatureRelDefBean.getObjectTypeStatic(),condition,parameter,null);
      }catch(Exception e){
	      throw e;
      }finally{
	  if (conn != null)
	      conn.close();
      }
   }

   public static int getBeansCount(String condition,Map parameter,String[] extendBOAttrs) throws Exception{
	      Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		return ServiceManager.getDataStore().retrieveCount(conn,BOBusiFeatureRelDefBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
	}catch(Exception e){
		throw e;
	}finally{
	  if (conn != null)
	      conn.close();
	}
   }

  public static void save( BOBusiFeatureRelDefBean aBean) throws Exception
  {
	  Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		   ServiceManager.getDataStore().save(conn,aBean);
	   }catch(Exception e){
		throw e;
	}finally{
	  if (conn != null)
		  conn.close();
	}
  }

   public static  void save( BOBusiFeatureRelDefBean[] aBeans) throws Exception{
	     Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		ServiceManager.getDataStore().save(conn,aBeans);
	}catch(Exception e){
		throw e;
	}finally{
	  if (conn != null)
	      conn.close();
	}
   }

   public static  void saveBatch( BOBusiFeatureRelDefBean[] aBeans) throws Exception{
	     Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		ServiceManager.getDataStore().saveBatch(conn,aBeans);
	}catch(Exception e){
		throw e;
	}finally{
	  if (conn != null)
	      conn.close();
	}
   }


  public static  BOBusiFeatureRelDefBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
	  conn = ServiceManager.getSession().getConnection();
	  String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
	  resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
	  return (BOBusiFeatureRelDefBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BOBusiFeatureRelDefBean.class,BOBusiFeatureRelDefBean.getObjectTypeStatic(),resultset,null,true);
      }catch(Exception e){
	  throw e;
      }finally{
	  if (conn != null)
	      conn.close();
      }
   }

     public static  BOBusiFeatureRelDefBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
	  conn = ServiceManager.getSession().getConnection();
	  resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
	  return (BOBusiFeatureRelDefBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BOBusiFeatureRelDefBean.class,BOBusiFeatureRelDefBean.getObjectTypeStatic(),resultset,null,true);
      }catch(Exception e){
	  throw e;
      }finally{
	  if (conn != null)
	      conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(BOBusiFeatureRelDefBean.getObjectTypeStatic());
   }


   public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(BOBusiFeatureRelDefBean.getObjectTypeStatic());
   }


   public static BOBusiFeatureRelDefBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (BOBusiFeatureRelDefBean)DataContainerFactory.wrap(source,BOBusiFeatureRelDefBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
	 throw new RuntimeException(e.getCause());
       else
	 throw new RuntimeException(e);
     }
   }
   public static BOBusiFeatureRelDefBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       BOBusiFeatureRelDefBean result = new BOBusiFeatureRelDefBean();
       DataContainerFactory.copy(source, result, colMatch);
       return result;
     }
     catch (AIException ex) {
       if(ex.getCause()!=null)
	 throw new RuntimeException(ex.getCause());
       else
	 throw new RuntimeException(ex);
     }
    }

   public static BOBusiFeatureRelDefBean transfer(IBOBusiFeatureRelDefValue value) {
	   if(value==null)
		   return null;
	try {
		if(value instanceof BOBusiFeatureRelDefBean){
			return (BOBusiFeatureRelDefBean)value;
		}
		BOBusiFeatureRelDefBean newBean = new BOBusiFeatureRelDefBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static BOBusiFeatureRelDefBean[] transfer(IBOBusiFeatureRelDefValue[] value) {
	   if(value==null || value.length==0)
		   return null;

	try {
		if(value instanceof BOBusiFeatureRelDefBean[]){
			return (BOBusiFeatureRelDefBean[])value;
		}
		BOBusiFeatureRelDefBean[] newBeans = new BOBusiFeatureRelDefBean[value.length];
		   for(int i=0;i<newBeans.length;i++){
			   newBeans[i] = new BOBusiFeatureRelDefBean();
			DataContainerFactory.transfer(value[i] ,newBeans[i]);
		}
		return newBeans;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }
  public static void save(IBOBusiFeatureRelDefValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IBOBusiFeatureRelDefValue[] aValues) throws Exception{
	  save(transfer(aValues));
   }

   public static  void saveBatch( IBOBusiFeatureRelDefValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
