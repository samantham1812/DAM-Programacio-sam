package main.java.com.exercici0400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import com.exercici0400.MenuItem;

public class Menu extends Component {

    private HashMap<Integer, MenuItem> items;
    private boolean lastZero;
    
    public Menu(int x, int y, int width, int height,String title, HashMap<Integer, MenuItem> items, boolean lastZero) {
        super(x, y, width, height, title);
        this.items = items;
        this.lastZero = lastZero;
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
        Integer countZero = 0; 

        int begin = 0;
        if (lastZero) {
            begin = 1;
        }


        rst.add(" ".repeat(width));
        for (int i = begin; i < height; i++) {
            if (items.get(i) != null) {
                String linia = " " + items.get(i).getTitle();
                rst.add(fixLine(linia));
            } else {
                if (lastZero && countZero == 0) {
                    String line = " " + items.get(0).getTitle();
                    rst.add(fixLine(line));
                    countZero++;
                }
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