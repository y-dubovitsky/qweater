package chapter.collection;

import robot.Robot;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CollectionRobotMapImpl implements CollectionRobot {

    Map<String, Robot> robotMap;

    @Override
    public void allRobotsDoWork() {
        Set<Map.Entry<String, Robot>> entries = robotMap.entrySet();
        Iterator<Map.Entry<String, Robot>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Robot> next = iterator.next();
            System.out.println(next.getKey());
            next.getValue().purpose();
        }
    }

    public Map<String, Robot> getRobotMap() {
        return robotMap;
    }

    public void setRobotMap(Map<String, Robot> robotMap) {
        this.robotMap = robotMap;
    }
}
