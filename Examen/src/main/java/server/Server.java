package server;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;
import java.lang.reflect.Method;

public class Server {
    public static void main(String[] args) throws XmlRpcException, IOException {
        System.out.println("Starting server. . .");
        PropertyHandlerMapping mapping=new PropertyHandlerMapping();
        mapping.addHandler("Methods",Methods.class);
        WebServer server= new WebServer(1200);
        server.getXmlRpcServer().setHandlerMapping(mapping);
        server.start();
        System.out.println("Waiting. . .");
    }
}
