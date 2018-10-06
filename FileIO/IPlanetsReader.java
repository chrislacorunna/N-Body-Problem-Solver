package main.FileIO;

import java.io.FileNotFoundException;

/**
 * Created by Michal on 10.06.2017.
 */
public interface IPlanetsReader {
    boolean readFromFile(String fileName) throws Exception;
}
