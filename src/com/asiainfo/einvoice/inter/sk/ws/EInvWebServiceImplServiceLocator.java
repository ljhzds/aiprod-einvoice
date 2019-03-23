/**
 * EInvWebServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asiainfo.einvoice.inter.sk.ws;

public class EInvWebServiceImplServiceLocator extends org.apache.axis.client.Service implements EInvWebServiceImplService {

    public EInvWebServiceImplServiceLocator() {
    }


    public EInvWebServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EInvWebServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EInvWebServiceImplPort
    private java.lang.String EInvWebServiceImplPort_address = "http://124.207.124.82:10081/cmcc_sync/webservice/eInvWS";

    public java.lang.String getEInvWebServiceImplPortAddress() {
        return EInvWebServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EInvWebServiceImplPortWSDDServiceName = "EInvWebServiceImplPort";

    public java.lang.String getEInvWebServiceImplPortWSDDServiceName() {
        return EInvWebServiceImplPortWSDDServiceName;
    }

    public void setEInvWebServiceImplPortWSDDServiceName(java.lang.String name) {
        EInvWebServiceImplPortWSDDServiceName = name;
    }

    public IEInvWebService getEInvWebServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EInvWebServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEInvWebServiceImplPort(endpoint);
    }

    public IEInvWebService getEInvWebServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
        	EInvWebServiceImplServiceSoapBindingStub _stub = new EInvWebServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getEInvWebServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEInvWebServiceImplPortEndpointAddress(java.lang.String address) {
        EInvWebServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (IEInvWebService.class.isAssignableFrom(serviceEndpointInterface)) {
            	EInvWebServiceImplServiceSoapBindingStub _stub = new EInvWebServiceImplServiceSoapBindingStub(new java.net.URL(EInvWebServiceImplPort_address), this);
                _stub.setPortName(getEInvWebServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EInvWebServiceImplPort".equals(inputPortName)) {
            return getEInvWebServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.ws.aisino.com/", "EInvWebServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.ws.aisino.com/", "EInvWebServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {

if ("EInvWebServiceImplPort".equals(portName)) {
            setEInvWebServiceImplPortEndpointAddress(address);
        }
        else
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
