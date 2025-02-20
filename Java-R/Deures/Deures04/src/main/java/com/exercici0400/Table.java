package main.java.com.exercici0400;

import java.util.ArrayList;

public class Table extends Component {

    private ArrayList<String> headers;
    private ArrayList<Integer> widths;
    private ArrayList<String> aligns;
    private ArrayList<ArrayList<String>> rows;
    
    Table(int x, int y, int width, int height,String title, ArrayList<String> headers, ArrayList<Integer> widths, ArrayList<String> aligns, ArrayList<ArrayList<String>> rows) {
        super(x, y, width, height, title);
        this.headers = headers;
        this.widths = widths;
        this.aligns = aligns;
        this.rows = rows;
    }

    public ArrayList<String> render() {
        ArrayList<String> rst = new ArrayList<String>();
        rst.add(0," ".repeat(width));

        for (int i = 0; i < height; i = i +1){
            rst.add(i, "x".repeat(width));
        }
        return rst;
    } 
}