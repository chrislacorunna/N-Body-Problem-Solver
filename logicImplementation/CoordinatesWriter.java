package main.logicImplementation;

import main.FileIO.ICoordinatesWriter;
import main.bodyLogic.*;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class CoordinatesWriter implements ICoordinatesWriter {
	
	public boolean Write(List<Body> bodyList, String path) throws FileNotFoundException{
		File output = new File(path);
		//if(!output.exists()) throw new FileNotFoundException("Nie można zapisać pliku.");
		PrintWriter out = new PrintWriter(output);
		
		for(int j=0; j<bodyList.get(0).getVectorListSize(); j++){
			for(int i=0; i<bodyList.size(); i++){
				out.println(  bodyList.get(i).getCoordinates(j).getX() + " "
							+ bodyList.get(i).getCoordinates(j).getY() + " "
							+ bodyList.get(i).getCoordinates(j).getZ());
			}
		}
		out.close();
		return true;
	}
}
