package main.java.com.exercici0400;

import java.util.ArrayList;

public class Container extends Component {
    
    private ArrayList<Component> components;
    
    public Container(int x, int y, int width, int height,ArrayList<Component> components) {
        super(0, 0, width, height);
        
        this.components = components;
    }


    public ArrayList<String> render(){
        ArrayList<String> rst = new ArrayList<String>();
        return rst;
    }

    public void draw(){
        ArrayList<String> buffer;

        buffer = new ArrayList<>();
        for (int cnt = 0; cnt < height; cnt = cnt + 1) {
            String linea = " ".repeat(width);
            buffer.add(linea);
        }

        for (Component cmp : components) {
            ArrayList<String> buffCmp = cmp.render();
            for (int lineCmp = 0; lineCmp < buffCmp.size(); lineCmp = lineCmp + 1);
            // int posY = y + lineCmp;
            // String cmpLineStr = buffCmp.get(lineCmp);
            //if (posY < buffer.size()) {
            //    String oldString = buffer.get(posY)
            }//
        }
}

