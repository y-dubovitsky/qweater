package interfaces;

import java.util.Collection;
import java.util.Map;

public interface ComputersPool {

    Collection<Computer> printComputerCollection();

    Map<String, Computer> printComputerMap();

}
