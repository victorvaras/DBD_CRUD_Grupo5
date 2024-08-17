package DBD.borradorMio.Models;

public class Tipo_Usuario {
    private String Tipo;
    private int ID_Tipo_Usuario;

    public Tipo_Usuario(String tipo, int ID_Tipo_Usuario) {
        Tipo = tipo;
        this.ID_Tipo_Usuario = ID_Tipo_Usuario;
    }

    //getters y setters
    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public int getID_Tipo_Usuario() {
        return ID_Tipo_Usuario;
    }
    public void setID_Tipo_Usuario(int ID_Tipo_Usuario) {
        this.ID_Tipo_Usuario = ID_Tipo_Usuario;
    }

    @Override
    public String toString() {
        return "Tipo_Usuario{" +
                "Tipo='" + Tipo + '\'' +
                ", ID_Tipo_Usuario=" + ID_Tipo_Usuario +
                '}';
    }
}
