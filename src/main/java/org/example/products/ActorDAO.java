package org.example.products;

import java.util.List;

public interface ActorDAO {
    int add(Actor actor);
    List<Actor> view();
    int delete(int actorId);
    int update(Actor actor);

}
