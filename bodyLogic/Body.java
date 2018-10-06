package main.bodyLogic;

import java.util.ArrayList;
import java.util.List;

public class Body {
	
	//Variables
	
	private String name;
	private double mass;
	private List<Vector> coordinates = new ArrayList<Vector>();
	private Vector velocity;
	
	//Getters and Setters
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}

	public Vector getCoordinates(int i) {
		return coordinates.get(i);
	}
	public Vector getLastCoordinates() {
		return coordinates.get(coordinates.size()-1);
	}
	public int getVectorListSize(){
		return coordinates.size();
	}
	public void setCoordinates(double x, double y, double z) {
		this.coordinates.add(new Vector(x, y, z));
	}
	public Vector getVelocity() {
		return velocity;
	}
	public void setVelocity(double vx, double vy, double vz) {
		this.velocity.setX(vx);
		this.velocity.setY(vy);
		this.velocity.setZ(vz);
	}
	
	//Constructors
	
	public Body(String name, double mass, double x, double y,
			double z, double vx, double vy, double vz){
		this.coordinates.add(new Vector(x, y, z));
		this.velocity = new Vector(vx, vy, vz);
		this.mass = mass;
		this.name = name;
	}

}
