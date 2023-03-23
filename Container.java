package port;
public class Container {
    int identifier;
    int weight;
    String CountryOfOrigin;
    boolean inspected;
    String description;
    String sendingCompany;
    String receiverCompany;
    int priority;
    public Container(){

    }

    public Container(int priority) {
        this.priority = priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public int getPriority() {
        return priority;
    }
    public void setIdentifier(int identifier){
        this.identifier=identifier;
    }
    public int getIdentifier() {
        return identifier;
    }
}
