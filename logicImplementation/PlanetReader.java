package main.logicImplementation;
import main.FileIO.IPlanetsReader;
import main.bodyLogic.Body;
import main.bodyLogic.Singleton;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PlanetReader implements IPlanetsReader{
	String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public boolean readFromFile(String fileName) throws Exception{
		
		File input = new File(fileName);
		if(!input.exists())
		    throw new FileNotFoundException("Nie znaleziono pliku.");
        Scanner in = new Scanner(input);

        List<Body> bodyS = new ArrayList<>();

	      while(in.hasNextLine()){
	    	  String name = in.next();
	    	  if(!name.matches("(.*)[a-z](.*)"))
	    	  	throw new Exception("Nazwa Ciała powinna zawierać przynajmniej jedną literę!");
	    	 
	    	  double x;
	    	  double y;
              double z;
              double vx;
              double vy;
              double vz;
	    	  try {
                  x = in.nextDouble();
                  y = in.nextDouble();
                  z = in.nextDouble();
                  vx = in.nextDouble();
                  vy = in.nextDouble();
                  vz = in.nextDouble();
              } catch (InputMismatchException e) {
                  throw new Exception("Podałeś liczbę w złym formacie");
              }
	    	  double mass = in.nextDouble();
	    	  if(mass<=0)
	    	      throw new Exception("Masa ciała: '" + name + "' musi być większa od 0!");
	    	  
	    	 
	    	  Body body = new Body(name, mass, x, y, z, vx, vy, vz);
	    	  
			  bodyS.add(body);
	      }
	    in.close();
		Singleton.setBodyStorage(bodyS);
		return true;
	}
}
