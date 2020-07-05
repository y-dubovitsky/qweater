package impls.collection;

import interfaces.Computer;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionInjection {

    private List<Computer> list;
    private Set<Computer> set;
    private Map<String, Computer> map;

    public CollectionInjection() {
    }

    public CollectionInjection(List<Computer> list, Set<Computer> set, Map<String, Computer> map) {
        this.list = list;
        this.set = set;
        this.map = map;
    }

    public List<Computer> getList() {
        return list;
    }

    public void setList(List<Computer> list) {
        this.list = list;
    }

    public Set<Computer> getSet() {
        return set;
    }

    public void setSet(Set<Computer> set) {
        this.set = set;
    }

    public Map<String, Computer> getMap() {
        return map;
    }

    public void setMap(Map<String, Computer> map) {
        this.map = map;
    }
}
