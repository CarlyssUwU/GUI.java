package port;
public class Hub {
    Container[][] containers = new Container[10][12];

    public void stackContainers(int priority) {
        for (int i = 9; i >=0; i--) {
            Container container = new Container(priority);
            if (priority == 1 && containers[i][0] == null) {
                containers[i][0] = container;
                break;
            } else if (priority == 2 && containers[i][1] == null) {
                containers[i][1] = container;
                break;
            } else if (priority > 2) {
                for(int j=2;j<12;j++){
                    if (containers[i][j] == null) {
                        containers[i][j] = container;
                        break;
                    }
                }
            }
        }
    }
    public String toString() {
        String aux = "";
        for (int i = 0; i < 10; i++) {
            aux += "\n";
            for (int j = 0; j < 12; j++) {
                if (containers[i][j] != null) {
                    aux += "F";
                } else {
                    aux += "0";
                }
                aux += " ";
            }
        }
        return aux;
    }

    public boolean isFulled() {
        for (int i = 10; i >=0; i--) {
            for (int j = 12; j >=0; j--) {
                if (containers[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
