package com.asiainfo.einvoice.inter.sk.ws;

import com.ai.appframe2.complex.cache.CacheFactory;
import com.asiainfo.appframe.ext.exeframe.ws.query.impl.po.CfgWsClient;
import com.asiainfo.einvoice.util.EInvoiceUtil;

import java.io.*;
import java.net.URL;

public class EInvWebServiceClient {
    // cfg_ws_client±‡¬Î≈‰÷√
    private static final String CFG_WS_CLIENT_CODE = "EInvWebService";

    private static EInvWebServiceClient client = null;

    private EInvWebServiceImplServiceLocator service = null;
    
    public static EInvWebServiceClient getInstance() throws Exception {
        if (null == client) {
            synchronized(EInvWebServiceClient.class) {
                client = new EInvWebServiceClient();
            }
        }
        return client;
    }

    /**
     * private constructor for singleton
     */
    private EInvWebServiceClient() {
        super();
        service = new EInvWebServiceImplServiceLocator();
    }

    /**
     * @return the service
     */
    public EInvWebServiceImplServiceLocator getService() {
        return service;
    }

    public IEInvWebService getCallService() throws Exception {
        CfgWsClient objCfgWsClient = null;
        String EInvWebService_address = "";
    	try {
    		objCfgWsClient = (CfgWsClient) CacheFactory.get(com.asiainfo.appframe.ext.exeframe.ws.client.cache.WsClientCacheImpl.class, (new StringBuilder()).append("C^").append(CFG_WS_CLIENT_CODE).toString());
        	if(null!=objCfgWsClient){
        		EInvWebService_address=objCfgWsClient.getUrlAddress();
        	}
            URL portAddress = new URL(EInvWebService_address);
            return this.getService().getEInvWebServiceImplPort(portAddress);
    	} catch (Exception e) {
    		throw new Exception(e);
    	}
    }


    public java.lang.String eInvWS(String postData) throws Exception {
        return this.getCallService().eInvWS(postData);
    }
    
    public static void main(String[] args) {

		try {
	    	System.out.println(EInvoiceUtil.base64Decode("5Lu356iO5YiG56a75byC5bi4", "utf-8"));
			File file = new File("E:/request.txt");
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
			BufferedReader bufferReader = new BufferedReader(new FileReader(file));
			String request = "";
			String line = "";
			while((line = br.readLine())!=null){
				request = request+line;
			}
			String aa = EInvWebServiceClient.getInstance().eInvWS(request);
			System.out.println(aa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
