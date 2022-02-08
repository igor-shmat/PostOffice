package postoffice.dao;

public interface DAO<Entity, Key> {
    void save(Entity entity);

    Entity get(Key key);

    void update(Entity entity);

    void delete(Entity entity);

}
