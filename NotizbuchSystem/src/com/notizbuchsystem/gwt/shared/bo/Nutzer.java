package com.notizbuchsystem.gwt.shared.bo;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Nutzer implements IsSerializable {
	
	private static final long serialVersionUID = 1L;
	
	private int nutzerId;
	
	private String vorname;
	
	private String nachname;
	
	private String email;
	
	
	public int getNutzerId() {
		return nutzerId;
	}

	public void setNutzerId(int nutzerId) {
		this.nutzerId = nutzerId;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "NutzerID #N" + this.getNutzerId() + " " + this.vorname + " " + this.nachname;

	
	}

}
