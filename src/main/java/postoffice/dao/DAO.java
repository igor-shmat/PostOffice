package postoffice.dao;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface DAO<Entity> {
    void create(Entity entity);

    Entity read(Entity entity);

    void update(Entity entity);

    void delete(Entity entity);

}
