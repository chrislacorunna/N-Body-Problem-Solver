package main.logicImplementation;

import main.FileIO.IScript;
import main.bodyLogic.Controller;
import main.bodyLogic.Singleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Michal on 11.06.2017.
 */
public class Script implements IScript {

    private String script;

    public String getScript() {
        return script;
    }

    @Override
    public String Generate(String dataFileName) {
        int iterations = (int) (Singleton.getSimulationTime()/Singleton.getTimeStep());

        Controller.calculateRange();

        int bodyNumber = Singleton.getBodyStorage().size();

        script="set xrange[" + Controller.getMinx() + ":" + Controller.getMaxx() +
                "]\nset yrange[" + Controller.getMiny() + ":" + Controller.getMaxx() +
                "]\nset zrange[" + Controller.getMinz() + ":" + Controller.getMaxz() +
                "]\ndo for [i=0:" + iterations + "] {\nsplot '" + dataFileName +
                "' every ::i*" + bodyNumber + "::" + bodyNumber + "*i+";
        bodyNumber--;
        script += bodyNumber + " with points pointtype 7\npause 0.1\n}";

        return script;
    }

    @Override
    public boolean Save(String path) throws FileNotFoundException {

        int lastSlash = path.lastIndexOf('\\');

        if (lastSlash != -1)
        {
            path = path.substring(0, lastSlash);
        }


        File output = new File(path+"\\visualise.gnu");
        PrintWriter out = new PrintWriter(output);
        out.println(script);

        out.close();

        return true;
    }
}
