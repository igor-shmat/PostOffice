package postoffice.dao;

public interface DAO<Entity> {
    void create(Entity entity);

    Entity read(Entity entity);

    void update(Entity entity);

    void delete(Entity entity);

}
