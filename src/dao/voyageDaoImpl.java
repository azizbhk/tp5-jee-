package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.SingletonConnection;
import metier.entities.voyage;

public class voyageDaoImpl implements IvoyageDao {

	@Override
	public voyage save(voyage p) {
		 Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO voyageS(NOM_voyage,PRIX) VALUES(?,?)");
			ps.setString(1, p.getNomvoyage());
			ps.setDouble(2, p.getPrix());
			ps.executeUpdate();
			
			
			PreparedStatement ps2= conn.prepareStatement
					("SELECT MAX(ID_voyage) as MAX_ID FROM voyageS");
			ResultSet rs =ps2.executeQuery();
			if (rs.next()) {
				p.setIdvoyage(rs.getLong("MAX_ID"));
			}
			ps.close();
			ps2.close();
				 
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<voyage> voyagesParMC(String mc) {
	      List<voyage> prods= new ArrayList<voyage>();
	       Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from voyageS where NOM_voyage LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				voyage p = new voyage();
				p.setIdvoyage(rs.getLong("ID_voyage"));
				p.setNomvoyage(rs.getString("NOM_voyage"));
				p.setPrix(rs.getDouble("PRIX"));
				prods.add(p);								
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

			return prods;
	}

	@Override
	public voyage getvoyage(Long id) {
		    
		   Connection conn=SingletonConnection.getConnection();
		    voyage p = new voyage();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from voyageS where ID_voyage = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				
				p.setIdvoyage(rs.getLong("ID_voyage"));
				p.setNomvoyage(rs.getString("NOM_voyage"));
				p.setPrix(rs.getDouble("PRIX"));
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			return p;
	}

	@Override
	public voyage updatevoyage(voyage p) {
		Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("UPDATE voyageS SET NOM_voyage=?,PRIX=? WHERE ID_voyage=?");
			ps.setString(1, p.getNomvoyage());
			ps.setDouble(2, p.getPrix());
			ps.setLong(3, p.getIdvoyage());
			ps.executeUpdate();
			ps.close();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void deletevoyage(Long id) {
		 Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM voyageS WHERE ID_voyage = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
