package server;

public class BeanPersona {
    private String name;
    private String apellido1;
    private String apellido2;
    private String anio;
    private String mes;
    private String dia;
    private String curp;
    private String rfc;

    public BeanPersona() {
    }
    public BeanPersona(String name, String apellido1, String apellido2, String anio, String mes, String dia, String curp,String rfc) {
        this.name = name;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.curp = curp;
        this.rfc=rfc;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
}
