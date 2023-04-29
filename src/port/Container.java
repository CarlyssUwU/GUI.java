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
    public int getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(int id) {
        this.identifier = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCountryOfOrigin() {
        return CountryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        CountryOfOrigin = countryOfOrigin;
    }

    public boolean getInspected() {
        return this.inspected;
    }

    public void setInspected(boolean inspected) {
        this.inspected = inspected;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSendingCompany() {
        return sendingCompany;
    }

    public void setSendingCompany(String sendingCompany) {
        this.sendingCompany = sendingCompany;
    }

    public String getReceiverCompany() {
        return receiverCompany;
    }

    public void setReceiverCompany(String receiverCompany) {
        this.receiverCompany = receiverCompany;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
