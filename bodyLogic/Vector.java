package main.bodyLogic;

public class Vector {

	private double x;
	private double y;
	private double z;
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	
	public Vector(){
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	public Vector(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector(Vector a){
		this.x = a.x;
		this.y = a.y;
		this.z = a.z;
	}
}
