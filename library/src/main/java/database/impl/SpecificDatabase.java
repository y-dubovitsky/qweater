package database.impl;

import database.Database;

public class SpecificDatabase implements Database {

    public SpecificDatabase() {
        System.out.println("SpecificDatabase created!");
    }

    @Override
    public void executeQuery() {
        System.out.println("Select count(*) from table");
    }
}
