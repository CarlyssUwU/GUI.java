package port;
public class Hub {
    Container[][] containers = new Container[10][12];

    public void stackContainers(Container container) {
        if (container != null) {
            int priority = container.getPriority();
            if (priority == 1 || priority == 2) {
                int column = priority - 1;
                for (int i = containers.length - 1; i >= 0; i--) {
                    if (containers[i][column] == null) {
                        containers[i][column] = container;
                        return;
                    }
                }
            } else {
                for (int j = 2; j < containers[0].length; j++) {
                    for (int i = containers.length - 1; i >= 0; i--) {
                        if (containers[i][j] == null) {
                            containers[i][j] = container;
                            return;
                        }
                    }
                }
            }

        }
    }
    public void unstackContainers(int col) {
        for (int i = 0; i < containers.length; i++) {
            if (containers[i][col] != null) {
                containers[i][col] = null;
            }
        }

    }
    public void clearHub(){
        for (int i =0; i<containers.length;i++){
            for (int j=0;j<containers[i].length;j++){
                containers[i][j]=null;
            }
        }
    }
    public String showHub() {
        String aux = "";
        for (int i = 0; i <10; i++) {
            aux += "\n";
            for (int j = 0; j <12; j++) {
                if (containers[i][j] != null) {
                    aux += containers[i][j].getIdentifier();
                } else {
                    aux += "X";
                }
                aux += " ";
            }
        }
        return aux;
    }

    public boolean isFulled(Container container) {
        switch (container.getPriority()) {
            case 1:
                if (containers[0][0] != null) {
                    return true;
                }
                break;
            case 2:
                if (containers[0][1] != null) {
                    return true;
                }
                break;
            case 3:
                if (containers[0][11] != null) {
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }
}