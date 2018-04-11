package tp3;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class PartidaMySqlPersistence {
	Connection conexion;
    Properties queries;
    static PartidaMySqlPersistence instance;
    
    
    public static PartidaMySqlPersistence getInstance() {
        if (instance == null) {
            instance = new PartidaMySqlPersistence();
        }
        return instance;
    }

    private PartidaMySqlPersistence() {
        try {
            
            queries = new Properties();            
            queries.load(new FileInputStream("src/tp3/queries.properties"));
            
            
            Class.forName("com.mysql.jdbc.Driver");
            
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp3", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void agregarPartida(Jugador j)  {
        try {
            String sql = queries.getProperty("query.agregarPartida");
            PreparedStatement st = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setString(1,j.getNombre());
            st.setInt(2,j.getPuntaje());
            st.execute();
            
            ResultSet rs = st.getGeneratedKeys();
            int idPartida = 0;            
            if (rs.next()) {
                idPartida = rs.getInt(1);
            }
            
            sql = queries.getProperty("query.agregarCartas");
            st = conexion.prepareStatement(sql);
            
            for (Carta obj : j.getCartas())
    		{
            	String sql2 = queries.getProperty("query.buscarIdCarta");
                PreparedStatement st2 = conexion.prepareStatement(sql2);
                st2.setInt(1,obj.getValor());
                st2.setString(2,obj.getPalo());
                ResultSet rs2 = st2.executeQuery();
                
            	while (rs2.next()) {
                   
            		int idCarta = rs2.getInt("id");
                    String sql3 = queries.getProperty("query.agregarCartas");
                    PreparedStatement st3 = conexion.prepareStatement(sql3);
                   
                    st3.setInt(1,idPartida);
                	st3.setInt(2,idCarta);
                	st3.execute();
                }   
    		}
            
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
