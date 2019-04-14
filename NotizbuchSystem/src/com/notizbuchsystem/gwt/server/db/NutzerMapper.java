package com.notizbuchsystem.gwt.server.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.notizbuchsystem.gwt.shared.bo.Nutzer;

public class NutzerMapper {
	
	private static NutzerMapper nutzerMapper = null;
	
	protected NutzerMapper(){
		
	}
	
	public static NutzerMapper nutzerMapper() {
		if(nutzerMapper == null) {
			nutzerMapper = nutzerMapper();
		}
		return nutzerMapper;
	}
	
	public Nutzer findyNutzerById(int nutzerId) {
		
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM Nutzer " + "WHERE NutzerID= " + nutzerId);
			
			if(rs.next()) {
				Nutzer n = new Nutzer();
				n.setNutzerId(rs.getInt("idNutzer"));
				n.setVorname(rs.getString("Vorname"));
				n.setNachname(rs.getString("Nachname"));
				return n;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertNutzer (Nutzer n) {
		Connection con = DBConnection.connection();
		
		try {
			PreparedStatement statement = con.prepareStatement("INSERT INTO Nutzer (Vorname, Nachname) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, n.getVorname());
			statement.setString(2, n.getNachname());
		
			
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
		
		
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
		
	public void updateNutzer(Nutzer n) {
		
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("UPDATE Nutzer SET Vorname='" + n.getVorname()+"', Nachname='" + n.getNachname() + "' WHERE idNutzer="+n.getNutzerId());
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	public void deleteUser(Nutzer n) {
		
		Connection con = DBConnection.connection();
		
	try {
		Statement stmt = con.createStatement();
		stmt.executeUpdate("DELETE FROM user " + "WHERE idNutzer=" + n.getNutzerId());
	} catch(SQLException e) {
		e.printStackTrace();
	}
	
	}
	
	public Vector<Nutzer> findNutzerByNachname(String nachname){
		
		Connection con = DBConnection.connection();
		Vector<Nutzer> result = new Vector<Nutzer>();
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Nutzer WHERE Nachname=" + "'" + nachname + "'");
			
			while(rs.next()) {
				Nutzer n = new Nutzer();
				n.setNutzerId(rs.getInt("idNutzer"));
				n.setNachname(rs.getString("Nachname"));
				n.setVorname(rs.getString("Vorname"));
				
				result.add(n);
			}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return result;
	}
	
public Vector<Nutzer> findNutzerByVorname(String vorname){
		
		Connection con = DBConnection.connection();
		Vector<Nutzer> result = new Vector<Nutzer>();
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Nutzer WHERE Vorname=" + "'" + vorname + "'");
			
			while(rs.next()) {
				Nutzer n = new Nutzer();
				n.setNutzerId(rs.getInt("idNutzer"));
				n.setNachname(rs.getString("Nachname"));
				n.setVorname(rs.getString("Vorname"));
				
				result.add(n);
			}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return result;
			
	}
}

