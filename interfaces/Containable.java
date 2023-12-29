package interfaces;

import environment.ContainerPutInContainerException;
import environment.Thing;

public interface Containable {
    void add(Thing thing) throws ContainerPutInContainerException;
    void remove();
}