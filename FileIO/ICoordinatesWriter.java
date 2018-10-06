package main.FileIO;

import main.bodyLogic.Body;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Michal on 10.06.2017.
 */
public interface ICoordinatesWriter {
    boolean Write(List<Body> bodyList, String path) throws FileNotFoundException;
}
