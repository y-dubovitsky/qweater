package impls.computer;

import interfaces.Computer;
import interfaces.ComputersPool;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PcPool implements ComputersPool {

    private List<Computer> list; //! Связывание делается через xml
    private Map<String, Computer> map;
    private Set<Computer> set;

    public PcPool() {
    }

    public PcPool(List<Computer> list, Map<String, Computer> map, Set<Computer> set) {
        this.list = list;
        this.map = map;
        this.set = set;
    }


    @Override
    public void showComputerList() {
        for (Computer computer : list) {
            System.out.println(computer + " list");
            computer.calculate();
        }
    }

    @Override
    public void showComputerMap() {
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }

    @Override
    public void showComputerSet() {
        for (Computer computer : set) {
            System.out.println(computer + " set");
            computer.calculate();
        }
    }

    //* Getters and setters

    public Collection<Computer> getList() {
        return list;
    }

    public void setList(List<Computer> list) {
        this.list = list;
    }

    public Map<String, Computer> getMap() {
        return map;
    }

    public void setMap(Map<String, Computer> map) {
        this.map = map;
    }

    public Set<Computer> getSet() {
        return set;
    }

    public void setSet(Set<Computer> set) {
        this.set = set;
    }
}
