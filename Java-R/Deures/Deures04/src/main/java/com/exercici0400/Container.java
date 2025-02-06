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

    public ArrayList<String> addBorder(ArrayList<String> buffCmp) {
        ArrayList<String> resul = new ArrayList<>();

        for (int cntLine = 0; cntLine < buffCmp.size(); cntLine = cntLine + 1){
            String line = buffCmp.get(cntLine);
            if (cntLine == 0 || cntLine == (buffCmp.size() - 1)) {
                line = "|".repeat(line.length());
            } else {
                char[] rray = line.toCharArray();
                rray[0] = "|";
                rray[rray.length - 1] = "|";
                line = String.valueOf(rray);
            }
            rray.add(line);
        }
        return resul;
    }

    public void draw() {
        ArrayList<String> buffer;

        clearScreen();

        buffer = new ArrayList<>();
        for (int cnt = 0; cnt < height; cnt = cnt + 1) {
            String linia = " ".repeat(width);
            buffer.add(linia);
        } /*Inicia el buffer con espacios en blanco */

        for (Component cmp : components) {
            ArrayList<String> buffCmp = cmp.render();

            buffCmp = addBorder(buffCmp);

            int posY = cmp.getY();
            for (String lineCmp : buffCmp) {
                if (posY < height) {
                    int posX = cmp.getX();
                    if (posX < width) {
                        String buffLine = buffer.get(posY);
                        String partA = buffLine.substring(0, posX);
                        String partB = lineCmp;
                        if (posX + partB.length() > width) {
                            partB = partB.substring(0, width - posX);
                        }
                        String partC = buffLine.substring(posX + partB.length());
                        buffer.set(posY, partA + partB + partC);
                    } /*Dibuja componentes en el buffer */
                }
                posY++;
            }
        }

        for (String line : buffer) {
            System.out.println(line); 
        } /*Escribe el buffer en el terminal */
    }
}