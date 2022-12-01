package mx.uv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

//Data Access Object

public class DAO {
    //en el dao se establece la conexion al motor de la base de datos

    private static Conexion c= new Conexion();

    public static List<Usuario> dameUsuarios(){

        Statement stm = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Usuario> resultado = new ArrayList<>();

        conn = c.getConnection();

        try {
            String sql = "SELECT * from usuarios80688";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
               Usuario u = new Usuario(rs.getString("id"),rs.getString("nombre"),rs.getString("password"));
               resultado.add(u);
            }
        
        } catch (Exception e) {
            System.out.println("Driver:" + e);
            // TODO: handle exception
        }finally{
            if(rs != null)
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
            rs=null;
            if (stm != null){
                try {
                    stm.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                stm=null;
            }
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return resultado;
    }



    public static String crearUsuario(Usuario u){

        PreparedStatement stm=null;
        Connection conn = null;
        String msj="";

        conn = c.getConnection();
        try {
            String sql = "INSERT INTO usuarios (id,nombre,password) values (?,?,?)";
            stm= conn.prepareStatement(sql);
            stm.setString(1, u.getId());
            stm.setString(2, u.getNombre());
            stm.setString(3, u.getPassword());
            stm.executeUpdate(sql);

            
            if (stm.executeUpdate()>0) {
                msj ="Usuario agregado con exito";
            }else{
                msj ="Usuario no agregado";
            }

            
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            if (stm != null){
                try {
                    stm.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                stm=null;
            }
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        

        
        return null;
    }
}
