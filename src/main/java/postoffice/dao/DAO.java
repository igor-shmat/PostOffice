package postoffice.dao;

import java.util.ArrayList;

public interface DAO<Entity> {
    void create(ArrayList<Entity> entity);

    Entity read(Entity entity);

    void update(Entity entity);

    void delete(Entity entity);

}
