package com.asiainfo.einvoice.core.def.bo.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.ai.appframe2.bo.DataContainerFactory;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;
import com.asiainfo.einvoice.core.def.bo.ivalues.IBOInvoiceDsDispatchValue;

public class BOInvoiceDsDispatchEngine {

  public static BOInvoiceDsDispatchBean[] getBeans(DataContainerInterface dc) throws
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

    public static BOInvoiceDsDispatchBean getBean(long _DispatchId) throws Exception{
            /**new create*/
    String condition = "DISPATCH_ID = :S_DISPATCH_ID";
      Map map = new HashMap();
      map.put("S_DISPATCH_ID",new Long(_DispatchId));
;
      BOInvoiceDsDispatchBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
	      return beans[0];
      else if(beans!=null && beans.length>1){
	//[错误]根据主键查询出现一条以上记录
	      throw new Exception("[ERROR]More datas than one queryed by PK");
      }else{
	      BOInvoiceDsDispatchBean bean = new BOInvoiceDsDispatchBean();
	      	      bean.setDispatchId(_DispatchId);
	      	      return bean;
      }
 }

  public static  BOInvoiceDsDispatchBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  BOInvoiceDsDispatchBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    Map param = null;
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
      param = sql.getParameters();
    }
    return (BOInvoiceDsDispatchBean[])getBeans(cols,condition,param,startNum,endNum,isShowFK);
  }




  public static  BOInvoiceDsDispatchBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  BOInvoiceDsDispatchBean[] getBeans(String[] cols,String condition,Map parameter,
	   int startNum,int endNum,boolean isShowFK) throws Exception{
	Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		return (BOInvoiceDsDispatchBean[])ServiceManager.getDataStore().retrieve(conn,BOInvoiceDsDispatchBean.class,BOInvoiceDsDispatchBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
	}catch(Exception e){
		throw e;
	}finally{
	   if (conn != null)
	      conn.close();
	}
  }

   public static  BOInvoiceDsDispatchBean[] getBeans(String[] cols,String condition,Map parameter,
	  int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
	  Connection conn = null;
	  try {
		  conn = ServiceManager.getSession().getConnection();
		  return (BOInvoiceDsDispatchBean[])ServiceManager.getDataStore().retrieve(conn,BOInvoiceDsDispatchBean.class,BOInvoiceDsDispatchBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
	      return ServiceManager.getDataStore().retrieveCount(conn,BOInvoiceDsDispatchBean.getObjectTypeStatic(),condition,parameter,null);
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
		return ServiceManager.getDataStore().retrieveCount(conn,BOInvoiceDsDispatchBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
	}catch(Exception e){
		throw e;
	}finally{
	  if (conn != null)
	      conn.close();
	}
   }

  public static void save( BOInvoiceDsDispatchBean aBean) throws Exception
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

   public static  void save( BOInvoiceDsDispatchBean[] aBeans) throws Exception{
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

   public static  void saveBatch( BOInvoiceDsDispatchBean[] aBeans) throws Exception{
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


  public static  BOInvoiceDsDispatchBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
	  conn = ServiceManager.getSession().getConnection();
	  String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
	  resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
	  return (BOInvoiceDsDispatchBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BOInvoiceDsDispatchBean.class,BOInvoiceDsDispatchBean.getObjectTypeStatic(),resultset,null,true);
      }catch(Exception e){
	  throw e;
      }finally{
      if(resultset!=null)resultset.close();
	  if (conn != null)
	      conn.close();
      }
   }

     public static  BOInvoiceDsDispatchBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
	  conn = ServiceManager.getSession().getConnection();
	  resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
	  return (BOInvoiceDsDispatchBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BOInvoiceDsDispatchBean.class,BOInvoiceDsDispatchBean.getObjectTypeStatic(),resultset,null,true);
      }catch(Exception e){
	  throw e;
      }finally{
      if(resultset!=null)resultset.close();
	  if (conn != null)
	      conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(BOInvoiceDsDispatchBean.getObjectTypeStatic());
   }


   public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(BOInvoiceDsDispatchBean.getObjectTypeStatic());
   }


   public static BOInvoiceDsDispatchBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (BOInvoiceDsDispatchBean)DataContainerFactory.wrap(source,BOInvoiceDsDispatchBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
	 throw new RuntimeException(e.getCause());
       else
	 throw new RuntimeException(e);
     }
   }
   public static BOInvoiceDsDispatchBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       BOInvoiceDsDispatchBean result = new BOInvoiceDsDispatchBean();
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

   public static BOInvoiceDsDispatchBean transfer(IBOInvoiceDsDispatchValue value) {
	   if(value==null)
		   return null;
	try {
		if(value instanceof BOInvoiceDsDispatchBean){
			return (BOInvoiceDsDispatchBean)value;
		}
		BOInvoiceDsDispatchBean newBean = new BOInvoiceDsDispatchBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static BOInvoiceDsDispatchBean[] transfer(IBOInvoiceDsDispatchValue[] value) {
	   if(value==null || value.length==0)
		   return null;

	try {
		if(value instanceof BOInvoiceDsDispatchBean[]){
			return (BOInvoiceDsDispatchBean[])value;
		}
		BOInvoiceDsDispatchBean[] newBeans = new BOInvoiceDsDispatchBean[value.length];
		   for(int i=0;i<newBeans.length;i++){
			   newBeans[i] = new BOInvoiceDsDispatchBean();
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
  public static void save(IBOInvoiceDsDispatchValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IBOInvoiceDsDispatchValue[] aValues) throws Exception{
	  save(transfer(aValues));
   }

   public static  void saveBatch( IBOInvoiceDsDispatchValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
