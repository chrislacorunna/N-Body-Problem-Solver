package main.bodyLogic;

import main.FileIO.ICoordinatesWriter;
import main.FileIO.IPlanetsReader;
import main.FileIO.IScript;
import main.logicImplementation.CoordinatesWriter;
import main.logicImplementation.NBody;
import main.logicImplementation.PlanetReader;
import main.logicImplementation.Script;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michal on 09.06.2017.
 */
public final class Singleton {
    private static IScript Script = null;
    private static INBody NBody = null;
    private static IPlanetsReader PlanetsReader = null;
    private static ICoordinatesWriter CoordinatesWriter = null;
    private static List<Body> BodyStorage;
    private static double SimulationTime;
    private static double TimeStep;

    protected Singleton(){}

    public static double getSimulationTime() {
        return SimulationTime;
    }

    public static void setSimulationTime(double simulationTime) {
        SimulationTime = simulationTime;
    }

    public static  double getTimeStep() {
        return TimeStep;
    }

    public static void setTimeStep(double timeStep) {
        TimeStep = timeStep;
    }

    public static INBody getNBody() throws Exception
    {
        if(NBody == null)
        {
            if(SimulationTime ==0)
                throw new Exception("Czas symulacji nie może być równy 0");
            if(TimeStep ==0)
                throw new Exception("Krok czasowy nie może być równy 0");
            NBody = new NBody(TimeStep);
        }

        return NBody;
    }

    public static IScript getScript() {
        if(Script == null)
            Script = new Script();
        return Script;
    }

    public static IPlanetsReader getPlanetsReader() {
        if(PlanetsReader == null)
            PlanetsReader = new PlanetReader();
        return PlanetsReader;
    }

    public static ICoordinatesWriter getCoordinatesWriter() {
        if(CoordinatesWriter == null)
            CoordinatesWriter = new CoordinatesWriter();
        return CoordinatesWriter;
    }

    public static List<Body> getBodyStorage() {
        if(BodyStorage == null)
            BodyStorage = new ArrayList<Body>();
        return BodyStorage;
    }

    public static void setBodyStorage(List<Body> bodyStorage)
    {
        BodyStorage = bodyStorage;
    }
}
