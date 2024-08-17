package DBD.borradorMio.Repositories;
import DBD.borradorMio.Models.Tipo_Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class Tipo_UsuarioRepository implements Tipo_UsuarioRepositoryInterface {
    @Autowired
    private Sql2o sql2o;

    public Tipo_UsuarioRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Tipo_Usuario> getAllTipoUsuario() {
        String sql = "select * from \"Tipo_Usuario\" order by \"ID_Tipo_Usuario\" ASC";
        try(var con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Tipo_Usuario.class);
        }
    }

    @Override
    public List<Tipo_Usuario> getTipoUsuarioById(int ID_Tipo_Usuario) {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("select * from \"Tipo_Usuario\" where \"ID_Tipo_Usuario\" = :ID_Tipo_Usuario")
                    .addParameter("ID_Tipo_Usuario", ID_Tipo_Usuario)
                    .executeAndFetch(Tipo_Usuario.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tipo_Usuario> getTipoUsuarioByNombre(String Tipo) {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("select * from \"Tipo_Usuario\" where \"Tipo\" = :Tipo")
                    .addParameter("Tipo", Tipo)
                    .executeAndFetch(Tipo_Usuario.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean crearTipoUsuario(Tipo_Usuario tipo_usuario) {
        try(Connection con = sql2o.open()) {
            String sql = "INSERT INTO \"Tipo_Usuario\"(\n" + "\t\"Tipo\", \"ID_Tipo_Usuario\")\n" + "\tVALUES (:Tipo, :ID_Tipo_Usuario);";
            con.createQuery(sql)
                    .addParameter("Tipo", tipo_usuario.getTipo())
                    .addParameter("ID_Tipo_Usuario",tipo_usuario.getID_Tipo_Usuario())
                    .executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateTipoUsuario(Tipo_Usuario tipo_usuario) {
        String updateSql = "UPDATE \"Tipo_Usuario\" SET \"Tipo\"=:Tipo WHERE \"ID_Tipo_Usuario\" = :ID_Tipo_Usuario";

        try(var con = sql2o.open()) {
            con.createQuery(updateSql)
                    .addParameter("Tipo", tipo_usuario.getTipo())
                    .addParameter("ID_Tipo_Usuario", tipo_usuario.getID_Tipo_Usuario())
                    .executeUpdate();
            return true;
        }

        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteTipoUsuario(int ID_Tipo_Usuario) {
        String sql = ("DELETE FROM \"Tipo_Usuario\" where \"ID_Tipo_Usuario\" = :ID_Tipo_Usuario");

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("ID_Tipo_Usuario", ID_Tipo_Usuario)
                    .executeUpdate();
            return true;
        }

        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
