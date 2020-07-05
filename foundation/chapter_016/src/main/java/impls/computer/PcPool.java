package impls.computer;

import interfaces.Computer;
import interfaces.ComputersPool;

import java.util.Collection;
import java.util.Map;

public class PcPool implements ComputersPool {

    private Collection<Computer> computerCollection; //! Внедрение делается через xml
    private Map<String, Computer> computerMap;

    public PcPool() {
    }

    public PcPool(Collection<Computer> computerCollection, Map<String, Computer> computerMap) {
        this.computerCollection = computerCollection;
        this.computerMap = computerMap;
    }

    @Override
    public Collection<Computer> printComputerCollection() {
        return computerCollection;
    }

    @Override
    public Map<String, Computer> printComputerMap() {
        return computerMap;
    }

    public void outputComputerCollection() {
        for (Computer computer : computerCollection) {
            System.out.println(computer);
            computer.calculate();
        }
    }

    public void outputComputerMap() {
        for (String key : computerMap.keySet()) {
            System.out.println(key + " : " + computerMap.get(key));
        }
    }

    //* Getters and setters

    public Collection<Computer> getComputerCollection() {
        return computerCollection;
    }

    public void setComputerCollection(Collection<Computer> computerCollection) {
        this.computerCollection = computerCollection;
    }

    public Map<String, Computer> getComputerMap() {
        return computerMap;
    }

    public void setComputerMap(Map<String, Computer> computerMap) {
        this.computerMap = computerMap;
    }
}
