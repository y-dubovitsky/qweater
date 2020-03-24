package basis.chapter.collection;

import basis.robot.Robot;

import java.util.Collection;

public class CollectionListRobotImpl implements CollectionRobot {

    private Collection<Robot> robotCollection;

    public Collection<Robot> getRobotCollection() {
        return robotCollection;
    }

    public void setRobotCollection(Collection<Robot> robotCollection) {
        this.robotCollection = robotCollection;
    }

    public void allRobotsDoWork() {
        System.out.println("_________Collection____________Robots count: " + robotCollection.size());
        for (Robot robot : robotCollection) {
            robot.doAction();
            robot.purpose();
        }
        System.out.println("_________Collection_____________");
    }
}
