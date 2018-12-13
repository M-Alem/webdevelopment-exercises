package edu.ap.ws;

public class WSJDBCProxy implements edu.ap.ws.WSJDBC {
  private String _endpoint = null;
  private edu.ap.ws.WSJDBC wSJDBC = null;
  
  public WSJDBCProxy() {
    _initWSJDBCProxy();
  }
  
  public WSJDBCProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSJDBCProxy();
  }
  
  private void _initWSJDBCProxy() {
    try {
      wSJDBC = (new edu.ap.ws.WSJDBCServiceLocator()).getWSJDBC();
      if (wSJDBC != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSJDBC)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSJDBC)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSJDBC != null)
      ((javax.xml.rpc.Stub)wSJDBC)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public edu.ap.ws.WSJDBC getWSJDBC() {
    if (wSJDBC == null)
      _initWSJDBCProxy();
    return wSJDBC;
  }
  
  public java.lang.String[] selectAll() throws java.rmi.RemoteException{
    if (wSJDBC == null)
      _initWSJDBCProxy();
    return wSJDBC.selectAll();
  }
  
  
}