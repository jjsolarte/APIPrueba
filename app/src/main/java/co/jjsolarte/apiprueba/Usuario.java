package co.jjsolarte.apiprueba;

public class Usuario {

    private int pkUsuario;
    private String nombreusuario;
    private String contrasena;
    private int tipousuario;
    private Object fkPersona;

    public Usuario(int pkUsuario, String nombreusuario, String contrasena, int tipousuario, Object fkPersona) {
        this.pkUsuario = pkUsuario;
        this.nombreusuario = nombreusuario;
        this.contrasena = contrasena;
        this.tipousuario = tipousuario;
        this.fkPersona = fkPersona;
    }

    public Object getFkPersona() {
        return fkPersona;
    }

    public void setFkPersona(Object fkPersona) {
        this.fkPersona = fkPersona;
    }

    public int getPkUsuario() {
        return pkUsuario;
    }

    public void setPkUsuario(int pkUsuario) {
        this.pkUsuario = pkUsuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(int tipousuario) {
        this.tipousuario = tipousuario;
    }

}
