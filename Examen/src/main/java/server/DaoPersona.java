package server;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DaoPersona {
    public boolean registro(BeanPersona persona){
        boolean result=false;
        try{
            MySQLConnection connection=new MySQLConnection();
            connection.getConnection();
            PreparedStatement pstm=connection.getConnection().prepareStatement("INSERT INTO `examen`.`persona` (`CURP`, `nombre`, `apellido1`, `apellido2`, `anio`, `mes`, `dia`,`rfc`) VALUES (?, ?, ?, ?, ?, ?, ?,?);");
            pstm.setString(1,persona.getCurp());
            pstm.setString(2,persona.getName());
            pstm.setString(3,persona.getApellido1());
            pstm.setString(4,persona.getApellido2());
            pstm.setString(5,persona.getAnio());
            pstm.setString(6,persona.getMes());
            pstm.setString(7,persona.getDia());
            pstm.setString(8,persona.getRfc());

            result=  (pstm.executeUpdate()==1);
            }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean eliminar(String curp){
        boolean result=false;
        try{
            MySQLConnection connection=new MySQLConnection();
            connection.getConnection();
            PreparedStatement pstm=connection.getConnection().prepareStatement("DELETE FROM `examen`.`persona` WHERE (`CURP` = ?);");
            pstm.setString(1,curp);
            result= (pstm.executeUpdate()==1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean actualizar(String curp,String datoindice,String datonuevo){
        boolean result=false;
        try{
            MySQLConnection connection=new MySQLConnection();
            connection.getConnection();
            PreparedStatement pstm=connection.getConnection().prepareStatement("UPDATE `examen`.`persona` SET "+datoindice+" = ? WHERE (`CURP` = ?);");
            pstm.setString(1,datonuevo);
            pstm.setString(2,curp);
            result= (pstm.executeUpdate()==1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        String newrfc=acturfc(curp);
        System.out.println(newrfc);
        try{
            MySQLConnection connection=new MySQLConnection();
            connection.getConnection();
            PreparedStatement pstm2=connection.getConnection().prepareStatement("UPDATE `examen`.`persona` SET `rfc` = ? WHERE (`CURP` = ?);");
            pstm2.setString(1,newrfc);
            pstm2.setString(2,curp);
            result= (pstm2.executeUpdate()==1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public String acturfc(String curp){
        String rfc="";
        try{
            MySQLConnection connection=new MySQLConnection();
            connection.getConnection();
            PreparedStatement pstm=connection.getConnection().prepareStatement("SELECT * FROM examen.persona where CURP =?;");
            pstm.setString(1,curp);
            ResultSet rs= pstm.executeQuery();
            if (rs.next()){
                Methods methods=new Methods();
                rfc=methods.jrfc(rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("anio"),rs.getString("mes"),rs.getString("dia"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return rfc;
    }
    public String consulta( String curp){
        boolean result=false;
        String persona="";
        try{
            MySQLConnection connection=new MySQLConnection();
            connection.getConnection();
            PreparedStatement pstm=connection.getConnection().prepareStatement("SELECT * FROM examen.persona where CURP =?;");
            pstm.setString(1,curp);
            ResultSet rs= pstm.executeQuery();
            if (rs.next()){
                persona=rs.getString("CURP")+" "+rs.getString("nombre")+" "+rs.getString("apellido1")+" "+rs.getString("apellido2")+" "+rs.getString("anio")+" "+rs.getString("mes")+" "+rs.getString("dia")+" "+rs.getString("rfc");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return persona;
    }


    public String lista(int nada){
        boolean result=false;
        String persona="";
        try{
            MySQLConnection connection=new MySQLConnection();
            Statement statement=connection.getConnection().createStatement();
            ResultSet rs=statement.executeQuery("SELECT * FROM examen.persona;");
            while (rs.next()){
                persona=persona+ rs.getString("CURP")+" "+rs.getString("nombre")+" "+rs.getString("apellido1")+" "+rs.getString("apellido2")+" "+rs.getString("anio")+" "+rs.getString("mes")+" "+rs.getString("dia")+" "+rs.getString("rfc")+ "\r\n";
            }
            rs.close();
            statement.close();
            connection.getConnection().close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return persona;
    }
}
