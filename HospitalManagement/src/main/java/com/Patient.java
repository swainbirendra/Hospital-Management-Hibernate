package com;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Patient {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String disies;
private int age;
@OneToOne

private Preciption preciption;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDisies() {
	return disies;
}
public void setDisies(String disies) {
	this.disies = disies;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Preciption getPreciption() {
	return preciption;
}
public void setPreciption(Preciption preciption) {
	this.preciption = preciption;
}


}
