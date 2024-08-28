package org.example.products;

public class Actor {
    private int actorId;
    private String actorFirstName;
    private String actorLastName;

    Actor(){

    }

    public Actor(int actorId, String actorFirstName, String actorLastName) {
        this.actorId = actorId;
        this.actorFirstName = actorFirstName;
        this.actorLastName = actorLastName;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getActorFirstName() {
        return actorFirstName;
    }

    public void setActorFirstName(String actorFirstName) {
        this.actorFirstName = actorFirstName;
    }

    public String getActorLastName() {
        return actorLastName;
    }

    public void setActorLastName(String actorLastName) {
        this.actorLastName = actorLastName;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", actorFirstName='" + actorFirstName + '\'' +
                ", actorLastName='" + actorLastName + '\'' +
                '}';
    }
}
