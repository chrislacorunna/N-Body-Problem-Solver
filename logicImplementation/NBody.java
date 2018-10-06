package main.logicImplementation;
import main.bodyLogic.Body;
import main.bodyLogic.INBody;
import main.bodyLogic.Singleton;
import main.bodyLogic.Vector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.List;


public class NBody implements INBody {
	
	private final double G = 6.67408e-11;
	private double timeStep = 86400; //krok czasowy, domyślnie 1 dzień = 86400s

	public void setTimeStep(double timeStep) {
		this.timeStep = timeStep;
	}

	public NBody(double timeStep) {
		this.timeStep = timeStep;
	}

	private double calculateL2(double a, double b, double c){
		double p = Math.sqrt((a*a)+(b*b)+(c*c));
		return p;
	}
	
	private Vector[] calculateAcceleration(List<Body> bodiesS){
		
		Vector[] acceleration = new Vector[bodiesS.size()];
		
		for(int a=0; a < bodiesS.size(); a++){
		    Vector v = new Vector(0,0,0);
			acceleration[a] = v;
		}
		
		for(int i=0; i < bodiesS.size(); i++){
			for(int j=0; j < bodiesS.size(); j++){
				if(i != j){
					double r_ij = 0;

					double mian = Math.pow(calculateL2(bodiesS.get(i).getLastCoordinates().getX() - bodiesS.get(j).getLastCoordinates().getX(),
							bodiesS.get(i).getLastCoordinates().getY() - bodiesS.get(j).getLastCoordinates().getY(),
							bodiesS.get(i).getLastCoordinates().getZ() - bodiesS.get(j).getLastCoordinates().getZ()), 3);

					r_ij = bodiesS.get(i).getLastCoordinates().getX() - bodiesS.get(j).getLastCoordinates().getX();
					double tmpForce = -( (G * r_ij * bodiesS.get(j).getMass()) / mian );
                    tmpForce+=acceleration[i].getX();
					acceleration[i].setX(tmpForce);
			
					
					r_ij = bodiesS.get(i).getLastCoordinates().getY() - bodiesS.get(j).getLastCoordinates().getY();
					tmpForce = -( (G * r_ij * bodiesS.get(j).getMass()) / mian );
					tmpForce+=acceleration[i].getY();
					acceleration[i].setY(tmpForce);
				
					
					r_ij = bodiesS.get(i).getLastCoordinates().getZ() - bodiesS.get(j).getLastCoordinates().getZ();
					tmpForce = -( (G * r_ij * bodiesS.get(j).getMass()) / mian );
					tmpForce+=acceleration[i].getZ();
					acceleration[i].setZ(tmpForce);
				
				}
			}
		}
		return acceleration;
	}
	
	private Vector[] calculateVelocity(List<Body> bodiesS, Vector acceleration[], double timeStep){
		Vector[] velocity = new Vector[bodiesS.size()];
		
		for(int i = 0; i < bodiesS.size(); i++ ){
			Vector v = new Vector(0,0,0);
			
			double  x = bodiesS.get(i).getVelocity().getX() + acceleration[i].getX() * timeStep;
					v.setX(x);
			double	y = bodiesS.get(i).getVelocity().getY() + acceleration[i].getY() * timeStep;
					v.setY(y);
			double	z = bodiesS.get(i).getVelocity().getZ() + acceleration[i].getZ() * timeStep;
					v.setZ(z);
		            velocity[i] = v;
		  
		}
		
		return velocity;
	}

	public void nextCoordinate(List<Body> bodiesS){
		Vector[] acceleration;
		Vector[] velocity;
		
		acceleration = calculateAcceleration(bodiesS);
		velocity = calculateVelocity(bodiesS, acceleration, Singleton.getTimeStep());
		
		int i=0;
		for(Body body : bodiesS){
			

			double x = bodiesS.get(i).getLastCoordinates().getX() + velocity[i].getX() * Singleton.getTimeStep();
			double y = bodiesS.get(i).getLastCoordinates().getY() + velocity[i].getY() * Singleton.getTimeStep();
			double z = bodiesS.get(i).getLastCoordinates().getZ() + velocity[i].getZ() * Singleton.getTimeStep();

			bodiesS.get(i).setCoordinates(x, y, z);
			bodiesS.get(i).setVelocity(velocity[i].getX(), velocity[i].getY(), velocity[i].getZ());
            i++;
            System.out.println(bodiesS.get(3).getLastCoordinates().getX() + " " + bodiesS.get(3).getLastCoordinates().getY() + " " + bodiesS.get(3).getLastCoordinates().getZ() );
            System.out.println(bodiesS.get(3).getVelocity().getX() + " " + bodiesS.get(3).getVelocity().getY() + " " + bodiesS.get(3).getVelocity().getZ() + " ");
            System.out.println(acceleration[3].getX() + " " + acceleration[3].getY() + " " + acceleration[3].getZ());
    		  
		}

		
		
		Singleton.setBodyStorage(bodiesS);
	}
}
