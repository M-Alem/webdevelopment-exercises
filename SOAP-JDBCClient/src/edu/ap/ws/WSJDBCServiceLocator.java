/**
 * WSJDBCServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.ap.ws;

public class WSJDBCServiceLocator extends org.apache.axis.client.Service implements edu.ap.ws.WSJDBCService {

    public WSJDBCServiceLocator() {
    }


    public WSJDBCServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSJDBCServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSJDBC
    private java.lang.String WSJDBC_address = "http://localhost:8080/SOAP-JDBC/services/WSJDBC";

    public java.lang.String getWSJDBCAddress() {
        return WSJDBC_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSJDBCWSDDServiceName = "WSJDBC";

    public java.lang.String getWSJDBCWSDDServiceName() {
        return WSJDBCWSDDServiceName;
    }

    public void setWSJDBCWSDDServiceName(java.lang.String name) {
        WSJDBCWSDDServiceName = name;
    }

    public edu.ap.ws.WSJDBC getWSJDBC() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSJDBC_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSJDBC(endpoint);
    }

    public edu.ap.ws.WSJDBC getWSJDBC(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            edu.ap.ws.WSJDBCSoapBindingStub _stub = new edu.ap.ws.WSJDBCSoapBindingStub(portAddress, this);
            _stub.setPortName(getWSJDBCWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSJDBCEndpointAddress(java.lang.String address) {
        WSJDBC_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (edu.ap.ws.WSJDBC.class.isAssignableFrom(serviceEndpointInterface)) {
                edu.ap.ws.WSJDBCSoapBindingStub _stub = new edu.ap.ws.WSJDBCSoapBindingStub(new java.net.URL(WSJDBC_address), this);
                _stub.setPortName(getWSJDBCWSDDServiceName());
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
        if ("WSJDBC".equals(inputPortName)) {
            return getWSJDBC();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.ap.edu", "WSJDBCService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.ap.edu", "WSJDBC"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSJDBC".equals(portName)) {
            setWSJDBCEndpointAddress(address);
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
