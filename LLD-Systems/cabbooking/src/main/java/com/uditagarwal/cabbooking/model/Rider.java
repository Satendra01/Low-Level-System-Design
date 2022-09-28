package com.uditagarwal.cabbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Rider {
  String id;
  String name;
public Rider(String id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public String getId() {
	return id;
}
public String getName() {
	return name;
}
@Override
public String toString() {
	return "Rider [id=" + id + ", name=" + name + "]";
}
}
