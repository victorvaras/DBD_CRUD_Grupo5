package DBD.borradorMio.Repositories;
import DBD.borradorMio.Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class UsuarioRepository implements UsuarioRepositoryInterface {
    @Autowired
   private Sql2o sql2o;

    public UsuarioRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Usuario> getAllUsuario() {
        String sql = "select * from \"Usuario\" order by \"ID_Tipo_Usuario\" ASC";
        try(var con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Usuario.class);
        }
    }

    //get by rut, nombre y id tipo usuario
    @Override
    public List<Usuario> getUsuarioByRut(String Rut) {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("select * from \"Usuario\" where \"Rut\" = :Rut")
                    .addParameter("Rut", Rut)
                    .executeAndFetch(Usuario.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Usuario> getUsuarioByNombre(String Nombre) {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("select * from \"Usuario\" where \"Nombre\" = :Nombre")
                    .addParameter("Nombre", Nombre)
                    .executeAndFetch(Usuario.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Usuario> getUsuarioByTipo(int ID_Tipo_Usuario) {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("select * from \"Usuario\" where \"ID_Tipo_Usuario\" = :ID_Tipo_Usuario")
                    .addParameter("ID_Tipo_Usuario", ID_Tipo_Usuario)
                    .executeAndFetch(Usuario.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean crearUsuario(Usuario usuario) {
        try(Connection con = sql2o.open()) {
            String sql = "INSERT INTO \"Usuario\"(\n" +
                    "\t\"Rut\", \"Nombre\", \"Correo\", \"Contrasena\", \"Region\", \"Comuna\", \"Direccion\", \"ID_Tipo_Usuario\", \"ID_Carro_de_Compras\", \"ID_Lista_Deseos\")\n" +
                    "\tVALUES (:Rut, :Nombre, :Correo, :Contrasena, :Region, :Comuna, :Direccion, :ID_Tipo_Usuario, :ID_Carro_de_Compras, :ID_Lista_Deseos);";
            con.createQuery(sql)
                    .addParameter("Rut",usuario.getRut())
                    .addParameter("Nombre",usuario.getNombre())
                    .addParameter("Correo",usuario.getCorreo())
                    .addParameter("Contrasena",usuario.getContrasena())
                    .addParameter("Region",usuario.getRegion())
                    .addParameter("Comuna",usuario.getComuna())
                    .addParameter("Direccion",usuario.getDireccion())
                    .addParameter("ID_Tipo_Usuario",usuario.getID_Tipo_Usuario())
                    .addParameter("ID_Carro_de_Compras",usuario.getID_Carro_de_Compras())
                    .addParameter("ID_Lista_Deseos",usuario.getID_Lista_Deseos())
                    .executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean updateUsuario(Usuario usuario) {
        String updateSql = "UPDATE \"Usuario\"\n" +
                "\tSET \"Rut\"=:Rut, \"Nombre\"=:Nombre, \"Correo\"=:Correo, \"Contrasena\"=:Contrasena, " +
                "\"Region\"=:Region, \"Comuna\"=:Comuna, \"Direccion\"=:Direccion, \"ID_Tipo_Usuario\"=:ID_Tipo_Usuario, \"ID_Carro_de_Compras\"=:ID_Carro_de_Compras, " +
                "\"ID_Lista_Deseos\"=:ID_Lista_Deseos WHERE \"Rut\" = :Rut";

        try (var con = sql2o.open()) {
            con.createQuery(updateSql)
                    .addParameter("Rut", usuario.getRut())
                    .addParameter("Nombre",usuario.getNombre())
                    .addParameter("Correo",usuario.getCorreo())
                    .addParameter("Contrasena",usuario.getContrasena())
                    .addParameter("Region",usuario.getRegion())
                    .addParameter("Comuna",usuario.getComuna())
                    .addParameter("Direccion",usuario.getDireccion())
                    .addParameter("ID_Tipo_Usuario",usuario.getID_Tipo_Usuario())
                    .addParameter("ID_Carro_de_Compras",usuario.getID_Carro_de_Compras())
                    .addParameter("ID_Lista_Deseos",usuario.getID_Lista_Deseos())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteUsuario(String Rut) {
        String sql = "DELETE FROM \"Usuario\" WHERE \"Rut\" = :Rut";
        try(var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("Rut", Rut)
                    .executeUpdate();
        return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
