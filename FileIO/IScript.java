package main.FileIO;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import main.bodyLogic.*;

/**
 * Created by Michal on 10.06.2017.
 */
public interface IScript {
    String Generate(String dataFileName);

    boolean Save(String path) throws FileNotFoundException;
}
