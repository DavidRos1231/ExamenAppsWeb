package server;

public class Methods {
    public Methods() {
    }
    public String rfc(String nombre,String apellido1,String apellid2,String ano,String mes,String dia,String curp){
        System.out.println(nombre+apellido1+apellid2+ano+mes+dia);
        String rfc="";
        rfc=(apellido1.charAt(0))+""+apellido1.charAt(1)+""+apellid2.charAt(0)+""+nombre.charAt(0)+""+(ano+"").charAt(2)+""+(ano+"").charAt(3)+""+(mes+"").charAt(0)+""+(mes+"").charAt(1)+""+(dia+"").charAt(0)+""+(dia+"").charAt(1);
        rfc=rfc+aleatorio()+""+aleatorio()+""+aleatorio()+"";
        BeanPersona persona=new BeanPersona(nombre, apellido1,apellid2, ano,mes,dia,curp,rfc);
        DaoPersona daoPersona=new DaoPersona();
        System.out.println(daoPersona.registro(persona));
        return rfc;
    }
    public String jrfc(String nombre,String apellido1,String apellid2,String ano,String mes,String dia){
        String rfc="";
        rfc=(apellido1.charAt(0))+""+apellido1.charAt(1)+""+apellid2.charAt(0)+""+nombre.charAt(0)+""+(ano).charAt(2)+""+(ano).charAt(3)+""+(mes).charAt(0)+""+(mes).charAt(1)+""+(dia).charAt(0)+""+(dia).charAt(1);
        rfc=rfc+aleatorio()+""+aleatorio()+""+aleatorio()+"";
        System.out.println(rfc);
        return rfc;
    }
    public char aleatorio(){
        char letra='a';
        int letraint;
        int num=(int)(Math.random()*2);
        if(num==1){
            //letra
            letraint=(((int)(Math.random()*25))+65);
            letra= (char) letraint;
        }else{
            //numero
            letraint=(((int)(Math.random()*10))+48);
            letra= (char) letraint;
        }
        return letra;
    }
    public String consulta(String curp){
        DaoPersona daoPersona=new DaoPersona();
        String persona;
        persona =daoPersona.consulta(curp);
        return persona;
    }
    public boolean eliminar(String curp){
        DaoPersona daoPersona=new DaoPersona();
        boolean result=false;
        result =daoPersona.eliminar(curp);
        return result;
    }
    public String lista(int nada){
        DaoPersona daoPersona=new DaoPersona();
        String persona;
        persona =daoPersona.lista(nada);
        return persona;
    }
    public boolean actualizar(String curp,String datoindice,String datonuevo){
        DaoPersona daoPersona=new DaoPersona();
        boolean result=false;
        result =daoPersona.actualizar(curp,datoindice,datonuevo);
        return result;
    }
}
