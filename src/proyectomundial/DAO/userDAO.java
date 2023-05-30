/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectomundial.DAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyectomundial.model.Seleccion;
import proyectomundial.model.user;
import proyectomundial.util.BasedeDatos;
import static proyectomundial.util.BasedeDatos.ejecutarSQL;


public class userDAO {
     public userDAO() {
        BasedeDatos.conectar();
    }
    
    public boolean registrarSeleccion(user  User) {
        
        String sql = "INSERT INTO poo.users (username, password) values("
                 
                
                + "'" + User.getUsername() + "', " 
                + "'" + User.getPassword() + "')";
        
        //BasedeDatos.conectar();
        boolean secion = BasedeDatos.ejecutarActualizacionSQL(sql);
        //BasedeDatos.desconectar();
        return secion;
    }
    
    public List<user> getsecion() {
        
        String sql = "SELECT username,password FROM poo.users";
        List<user> username = new ArrayList<user>();
        
        try {
            ResultSet result = BasedeDatos.ejecutarSQL(sql);
            
            if(result != null) {
            
                while (result.next()) { 
                    user Username = new user(result.getString("username"), result.getString("password"));
                    username.add(Username);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Error consultando selecciones");
        }
        
        return username;
    }
    
    
    public String[][] getSeleccionesMatriz() {
        
        String[][] matrizSelecciones = null;
        List<user> username = getsecion();
        
        
        if(username != null && username.size() > 0) {
            
        
            matrizSelecciones = new String[username.size()][3];

            int x = 0;
            for (user USERNAME : username) {

                matrizSelecciones[x][0] = USERNAME.getUsername();
                matrizSelecciones[x][1] = USERNAME.getPassword();
                
                x++;
            }
        }
        
        return matrizSelecciones;
    }

}
