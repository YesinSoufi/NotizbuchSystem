package com.notizbuchsystem.gwt.shared.bo;

public class Notiz {
	
int notizId;
String titel;
String inhalt;


public int getNotizId() {
	return notizId;
}
public void setNotizId(int notizId) {
	this.notizId = notizId;
}
public String getTitel() {
	return titel;
}
public void setTitel(String titel) {
	this.titel = titel;
}

public String getInhalt() {
	return inhalt;
}
public void setInhalt(String inhalt) {
	this.inhalt = inhalt;
}
public String toString() {
	return "NutzerID #N" + this.getNotizId() + " " + this.titel;
	






}

}
