package main.bodyLogic;

import main.bodyLogic.INBody;
import main.bodyLogic.Singleton;

/**
 * Created by Michal on 10.06.2017.
 */
public class Controller {

    private static double maxx;
    private static double maxy;
    private static double maxz;

    private static double minx;
    private static double miny;
    private static double minz;

    public static double getMaxx() {
        return maxx;
    }

    public static double getMaxy() {
        return maxy;
    }

    public static double getMinx() {
        return minx;
    }

    public static double getMiny() {
        return miny;
    }

    public static double getMaxz() {
        return maxz;
    }

    public static double getMinz() {
        return minz;
    }

    public static void calculateRange()
    {
        int iterations = (int) (Singleton.getSimulationTime()/Singleton.getTimeStep());

        maxx = Singleton.getBodyStorage().get(0).getCoordinates(0).getX();
        maxy = Singleton.getBodyStorage().get(0).getCoordinates(0).getY();

        minx = Singleton.getBodyStorage().get(0).getCoordinates(0).getX();
        miny = Singleton.getBodyStorage().get(0).getCoordinates(0).getY();

        for (Body body : Singleton.getBodyStorage()) {
            for (int k = 0; k < iterations; k++) {
                if (maxx < body.getCoordinates(k).getX())
                    maxx = body.getCoordinates(k).getX();
                if (maxy < body.getCoordinates(k).getY())
                    maxy = body.getCoordinates(k).getY();
                if (maxz < body.getCoordinates(k).getZ())
                    maxz = body.getCoordinates(k).getZ();

                if( minx > body.getCoordinates(k).getX() )
                    minx = body.getCoordinates(k).getX();
                if( miny > body.getCoordinates(k).getY() )
                    miny = body.getCoordinates(k).getY();
                if( minz > body.getCoordinates(k).getY() )
                    minz = body.getCoordinates(k).getY();
            }
        }

        maxx *= 1.2;
        maxy *= 1.2;
        maxz *= 1.2;
        minx *= 1.2;
        miny *= 1.2;
        minz *= 1.2;
    }

    public static void compute(double simulationTime, double timeStep)
    {

        Singleton.setSimulationTime(simulationTime);
        Singleton.setTimeStep(timeStep);

        INBody nBody = null;
        try {
            nBody = Singleton.getNBody();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int iterations = (int) (Singleton.getSimulationTime()/Singleton.getTimeStep());

        for(int i=0; i<iterations; i++)
            nBody.nextCoordinate(Singleton.getBodyStorage());
    }

}
