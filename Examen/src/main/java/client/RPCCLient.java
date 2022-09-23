package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import server.BeanPersona;
import server.Methods;

import java.util.Map;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.net.URL;

public class RPCCLient {
    public static void main(String[] args) throws XmlRpcException, MalformedURLException {
        Scanner entrada=new Scanner(System.in);
        XmlRpcClientConfigImpl config=new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client=new XmlRpcClient();
        client.setConfig(config);
        int option=0;
        do{
            System.out.println("Que desea hacer?");
            System.out.println("0.-nada");
            System.out.println("1.-Registro y generar RFC");
            System.out.println("2.-Consulta por curp");
            System.out.println("3.-Lista de registros");
            System.out.println("4.-Eliminar una persona");
            System.out.println("5.-Modificar datos");
            option= entrada.nextInt();
            entrada.nextLine();
            switch (option){
                case 0:
                    System.out.println("Tenga un buen dia");
                    break;
                case 1:
                    System.out.println("Ingrese sus datos");
                    System.out.println("Nombre");
                    String nombre=entrada.nextLine().toUpperCase();
                    System.out.println("Primer apellido");
                    String apellido1=entrada.nextLine().toUpperCase();
                    System.out.println("Segundo apellido");
                    String apellido2=entrada.nextLine().toUpperCase();
                    System.out.println("Anio de nacimiento en numero");
                    String ano=entrada.nextLine();
                    System.out.println("Mes de nacimiento en numero");
                    String mes= entrada.nextLine();
                    System.out.println("dia de nacimiento en numero");
                    String dia= entrada.nextLine();
                    System.out.println("CURP");
                    String curp= entrada.nextLine().toUpperCase();
                    Object datos[]={nombre,apellido1,apellido2,ano,mes,dia,curp};
                    System.out.println("Su rfc es: "+client.execute("Methods.rfc",datos));
                    break;
                case 2:
                    System.out.println("Ingrese la CURP");
                    String curp1= entrada.nextLine().toUpperCase();
                    Object objcurp[]={curp1};
                    String persona;
                    persona=client.execute("Methods.consulta",objcurp).toString();
                    System.out.println(persona);
                    break;
                case 3:
                    Object lista[]={0};
                    persona=client.execute("Methods.lista",lista).toString();
                    System.out.println(persona);
                    break;
                case 4:
                    System.out.println("Ingrese la CURP para eliminar");
                    String curp2= entrada.nextLine().toUpperCase();
                    Object objcurp2[]={curp2};
                    persona=client.execute("Methods.eliminar",objcurp2).toString();
                    System.out.println(persona.equals("false")?"CURP erronea o inexistente":"Eliminado correctamente");
                    break;
                case 5:
                    String ntabla[]={"nombre","apellido1","apellido2", "anio","mes","dia","CURP"};
                    System.out.println("Ingrese la CURP de la persona a modificar");
                    String curp3= entrada.nextLine().toUpperCase();
                    Object objcurp3[]={curp3};
                    String persona1;
                    persona1=client.execute("Methods.consulta",objcurp3).toString();
                    System.out.println(persona1);
                    System.out.println("Que dato desea modificar");
                    System.out.println("0.-Nombre");
                    System.out.println("1.-Apellido paterno");
                    System.out.println("2.-Apellido materno");
                    System.out.println("3.-Anio");
                    System.out.println("4.-Mes");
                    System.out.println("5.-Dia");
                    System.out.println("6.-CURP");
                    String datoindice=ntabla[entrada.nextInt()];
                    System.out.println("Ingrese el dato corregido");
                    entrada.nextLine();
                    String datonuevo=entrada.nextLine().toUpperCase();
                    Object objact[]={curp3,datoindice,datonuevo};
                    String resultado=client.execute("Methods.actualizar",objact).toString();
                    System.out.println(resultado.equals("false")?"CURP erronea o inexistente":"Corregido correctamente");
                    break;

        }}while (option!=0);
    }
}
