package com.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Students {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String names;
	private int marks;
	
	public Students() {
		
	}
	
	public Students(int id, String names, int marks) {
		this.id = id;
		this.names = names;
		this.marks = marks;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String names) {
		this.names= names;
	}
	
	public String getName() {
		return this.names;
	}
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public int getMarks() {
		return this.marks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, marks, names);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Students other = (Students) obj;
		return id == other.id && marks == other.marks && Objects.equals(names, other.names);
	}
	
	
	public String toString() {
		return "id: "+this.id+" name: "+this.names+" marks: "+this.marks;
	}
}
