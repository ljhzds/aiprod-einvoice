package com.asiainfo.einvoice.inter.email139.ws;

import com.ai.appframe2.complex.cache.CacheFactory;
import com.asiainfo.appframe.ext.exeframe.ws.query.impl.po.CfgWsClient;
import com.asiainfo.einvoice.inter.sk.ws.EInvWebServiceImplServiceLocator;
import com.asiainfo.einvoice.inter.sk.ws.IEInvWebService;

import java.net.URL;

public class EInv139WebServiceClient {
    // cfg_ws_client±‡¬Î≈‰÷√
    private static final String CFG_WS_CLIENT_CODE = "EInvWebService";

    private static EInv139WebServiceClient client = null;

    private EInvWebServiceImplServiceLocator service = null;
    
    public static EInv139WebServiceClient getInstance() throws Exception {
        if (null == client) {
            synchronized(EInv139WebServiceClient.class) {
                client = new EInv139WebServiceClient();
            }
        }
        return client;
    }

    /**
     * private constructor for singleton
     */
    private EInv139WebServiceClient() {
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
    
}
