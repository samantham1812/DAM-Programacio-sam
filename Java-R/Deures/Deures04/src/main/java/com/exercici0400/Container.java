package main.java.com.exercici0400;

import java.util.ArrayList;

public class Container extends Component {
    private ArrayList<Component> components;

    public Container(int x, int y, int width, int height, ArrayList<Component> components) {
        super(x, y, width, height);
        this.components = components;
    }

    @Override
    public ArrayList<String> render() {
        ArrayList<String> buffer = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            String line = " ".repeat(width);
            buffer.add(line);
        }

        return addBorder(buffer);
    }

    public ArrayList<String> addBorder(ArrayList<String> buffCmp) {
        ArrayList<String> resul = new ArrayList<>();

        for (int i = 0; i < buffCmp.size(); i++) {
            String line = buffCmp.get(i);
            if (i == 0 || i == buffCmp.size() - 1) {
                line = "|".repeat(line.length());
            } else {
                char[] array = line.toCharArray();
                array[0] = '|';
                array[array.length - 1] = '|';
                line = new String(array);
            }
            resul.add(line);
        }
        return resul;
    }

    public void draw() {
        /*clearScreen();*/

        ArrayList<String> buffer = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            buffer.add(" ".repeat(width));
        }

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
                        String partC = buffLine.substring(Math.min(posX + partB.length(), buffLine.length()));
                        buffer.set(posY, partA + partB + partC);
                    }
                }
                posY++;
            }
        }

        for (String line : buffer) {
            System.out.println(line);
        }
    }
}