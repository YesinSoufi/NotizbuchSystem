package com.notizbuchsystem.gwt.shared.bo;

public class Eintrag {

	String inhalt;

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}
	
	public String toString() {
		return "NutzerID #N" + this.getInhalt();

	
	}
}
