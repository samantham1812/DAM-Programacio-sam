package main.java.com.exercici0400;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu extends Component {

    private String title;
    private HashMap<Integer, Object> items;
    private boolean lastZero;
    
    public Menu(int x, int y, int width, int height, String title, HashMap<Integer, String[]> items, boolean lastZero) {
        super(x, y, width, height);
        this.title = title;
        this.items = items;
        this.lastZero = lastZero;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getTitle() {
        return title;
    }

    public void setLastZero(boolean value) {
        this.lastZero = value;
    }

    public boolean getLastZero() {
        return lastZero;
    }

    public int getSelection(String text) {
        return -1;
    }

    private String fixLine(String line) {
        if (line.length() < width) {
            String espais = " ".repeat(width - line.length());
            return line + espais;
        } else {
            String nouString = line.substring(0, width);
            return nouString;
        }
    }

    public ArrayList<String> render() {
        ArrayList<String> rst = new ArrayList<String>();

        Set<Integer> claus = items.keySet();        
        rst.add(" ".repeat(width));
        for (int cnti = 0; cnti < height; cnti++) {
            if (items.get(cnti) != null) {
                String linia = " " + items.get(cnti);
                if (linia.length() < width) {
                    String espais = " ".repeat(width - linia.length());
                    rst.add(linia + espais);
                } else {
                    String nouString = linia.substring(0, width);
                    rst.add(nouString);
                }
            } else {
                String linia = " ".repeat(width);
                rst.add(linia);
            }
            
        }
        
        return rst;
    } 
}
    /*PEQUEÑOS PASOS */
    /*rst = new ArrayList<>();
        for (int cnt = 0; cnt < height; cnt = cnt + 1) {
            String cosa = "x".repeat(width);
            rst.add(cosa);

        }

        /*Set<Integer> claus = items.keySet();
        for (int cntIt = 0; cntIt < claus.size(); cntIt = cntIt + 1){
            String item = items.get(cntIt);
            for (int cntElm = 0; cntElm < claus.size(); cntElm = cntElm + 1){
                String str = items.get(cntElm);
                System.out.println(cntIt + ":" + str + "> ");
                /*System.out.println(cnt + ":" + item[0] + "> ");
            }
        }
        */