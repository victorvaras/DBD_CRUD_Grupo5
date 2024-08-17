package DBD.borradorMio.Repositories;
import DBD.borradorMio.Models.Lista_deseos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class Lista_DeseosRepository implements Lista_DeseosRepositoryInterface {
    @Autowired
    private Sql2o sql2o;

    public Lista_DeseosRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public List<Lista_deseos> getAllListaDeseos() {
        String sql = "select * from \"Lista_deseos\" order by \"ID_Lista_Deseos\" ASC";
        try (var con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Lista_deseos.class);
        }
    }

    //leer
    @Override
    public List<Lista_deseos> getListaDeseosbyID(int ID_Lista_Deseos) {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("select * from \"Lista_deseos\" where \"ID_Lista_Deseos\" = :ID_Lista_Deseos")
                    .addParameter("ID_Lista_Deseos", ID_Lista_Deseos)
                    .executeAndFetch(Lista_deseos.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean crearListaDeseos(Lista_deseos lista_deseos) {
        try(Connection con = sql2o.open()) {
            String sql = "INSERT INTO \"Lista_deseos\"(\n" +
                    "\t\"ID_Lista_Deseos\", \"Precio_Total_Lista\")\n" +
                    "\tVALUES (:ID_Lista_Deseos, :Precio_Total_Lista);";
            con.createQuery(sql)
                    .addParameter("ID_Lista_Deseos",lista_deseos.getID_Lista_Deseos())
                    .addParameter("Precio_Total_Lista", lista_deseos.getPrecio_Total_Lista())
                    .executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    @Override
    public boolean updateListaDeseos(Lista_deseos lista_deseos) {
        String updateSql = "update \"Lista_deseos\" set \"Precio_Total_Lista\" = :Precio_Total_Lista WHERE \"ID_Lista_Deseos\" = :ID_Lista_Deseos";
        try(var con = sql2o.open()) {
            con.createQuery(updateSql)
                    .addParameter("ID_Lista_Deseos", lista_deseos.getID_Lista_Deseos())
                    .addParameter("Precio_Total_Lista", lista_deseos.getPrecio_Total_Lista())
                    .executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    //eliminar
    @Override
    public boolean deleteListaDeseos(int ID_Lista_Deseos) {
        try(Connection conn = sql2o.open()) {
            conn.createQuery("delete from \"Lista_deseos\" where \"ID_Lista_Deseos\" = :ID_Lista_Deseos")
                    .addParameter("ID_Lista_Deseos", ID_Lista_Deseos)
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
