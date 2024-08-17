package DBD.borradorMio.Repositories;
import DBD.borradorMio.Models.Producto_Carro_Compras;
import DBD.borradorMio.Models.Tipo_Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class Producto_Carro_ComprasRepository implements Producto_Carro_ComprasRepositoryInterface {
    @Autowired
    private Sql2o sql2o;

    public Producto_Carro_ComprasRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Producto_Carro_Compras> getAllProducto_Carro_Compras() {
        String sql = "select * from \"Producto_Carro_Compras\"";
        try(var con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Producto_Carro_Compras.class);
        }
    }

    @Override
    public List<Producto_Carro_Compras> getProducto_Carro_ComprasByProducto(int Codigo_Producto) {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("select * from \"Producto_Carro_Compras\" where \"Codigo_Producto\" = :Codigo_Producto")
                    .addParameter("Codigo_Producto", Codigo_Producto)
                    .executeAndFetch(Producto_Carro_Compras.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Producto_Carro_Compras> getProductoCarroComprasByCarro(int ID_Carro_de_Compras) {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("select * from \"Producto_Carro_Compras\" where \"ID_Carro_de_Compras\" = :ID_Carro_de_Compras")
                    .addParameter("ID_Carro_de_Compras", ID_Carro_de_Compras)
                    .executeAndFetch(Producto_Carro_Compras.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean crearProducto_Carro_Compras(Producto_Carro_Compras producto_Carro_Compras) {
        try(Connection con = sql2o.open()) {
            String sql = "INSERT INTO \"Producto_Carro_Compras\"(\n" +
                    "\t\"ID_Carro_de_Compras\", \"Codigo_Producto\", \"Cantidad_producto\")\n" +
                    "\tVALUES (:ID_Carro_de_Compras, :Codigo_Producto, :Cantidad_producto);";
            con.createQuery(sql)
                    .addParameter("ID_Carro_de_Compras", producto_Carro_Compras.getID_Carro_de_Compras())
                    .addParameter("Codigo_Producto", producto_Carro_Compras.getCodigo_Producto())
                    .addParameter("Cantidad_producto",producto_Carro_Compras.getCantidad_Producto())
                    .executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Producto_Carro_Compras producto_carro_compras) {
        String updateSql = "UPDATE \"Producto_Carro_Compras\" SET \"Cantidad_producto\"=:Cantidad_producto " +
                "WHERE \"Codigo_Producto\" = :Codigo_Producto AND \"ID_Carro_de_Compras\" = :ID_Carro_de_Compras";

        try(var con = sql2o.open()) {
            con.createQuery(updateSql)
                    .addParameter("Cantidad_producto", producto_carro_compras.getCantidad_Producto())
                    .addParameter("Codigo_Producto", producto_carro_compras.getCodigo_Producto())
                    .addParameter("ID_Carro_de_Compras", producto_carro_compras.getID_Carro_de_Compras())
                    .executeUpdate();
            return true;
        }

        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteProducto_Carro_Compras(int Codigo_Producto, int ID_Carro_de_Compras) {
        String sql = ("DELETE FROM \"Producto_Carro_Compras\" WHERE \"Codigo_Producto\" = :Codigo_Producto AND \"ID_Carro_de_Compras\" = :ID_Carro_de_Compras");

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("ID_Carro_de_Compras", ID_Carro_de_Compras)
                    .addParameter("Codigo_Producto", Codigo_Producto)
                    .executeUpdate();
            return true;
        }

        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
