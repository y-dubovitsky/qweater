package chapter.initialization_sequence;

import database.Database;
import robot.Robot;

/**
 * Этот класс показывает как можно задавать порядок инициализации Бинов, если один бин зависит от другого
 */
public class DependentRobotImpl implements Robot {

    private Database database;

    public DependentRobotImpl() {
    }

    public DependentRobotImpl(Database database) {
        this.database = database;
    }

    @Override
    public void purpose() {
        System.out.println(this.getClass().getCanonicalName());
    }

    @Override
    public void doAction() {
        database.executeQuery();
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
}
