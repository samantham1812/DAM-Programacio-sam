package com.exercici0400;

import java.util.ArrayList;

public class Table extends Component {

    private ArrayList<String> headers;
    private ArrayList<Integer> widths;
    private ArrayList<String> aligns;
    private ArrayList<ArrayList<String>> rows;
    
    public Table(int x, int y, int width, int height, String title, ArrayList<String> headers, ArrayList<Integer> widths, ArrayList<String> aligns, ArrayList<ArrayList<String>> rows) {
        super(x, y, width, height, title);
        this.headers = headers;
        this.widths = widths;
        this.aligns = aligns;
        this.rows = rows;
    }

    public static String alineacio (String txt, int width, String align) {
        
        String truncated = txt;
        if (txt.length() < width) {
            truncated = txt;
        } else {
            truncated = txt.substring(0, width);
        }

        int dist = width - txt.length();
        String spaces = " ".repeat(dist);

        if (align.contentEquals("left")) {
            return truncated + spaces;
        } else if (align.contentEquals("right")) {
            return spaces + truncated;
        } else{
            int left = (dist / 2) + (dist % 2);
            int right = dist - left;
            return " ".repeat(left) + truncated + " ".repeat(right);
        }
    }

    public ArrayList<String> render() {
        ArrayList<String> rst = new ArrayList<String>();

        // Afegir linia buida al principi
        rst.add(0, " ".repeat(width)); 

        String cap = "";
        for (int i = 0; i < headers.size(); i++) {
            String header = headers.get(i);
            int width = widths.get(i);
            String align = aligns.get(i);
            
            header = alineacio(header, width, align);

            cap = cap + header;
            if (i < headers.size() - 1) {
                cap = cap + "|";
            }
        }
        rst.add(1, " " + cap + " ".repeat(width - cap.length() - 1));

        String separador="";
        for (int i = 0; i < widths.size(); i++) {
            int width = widths.get(i);
            
            if (i == widths.size()-1) {
                separador = separador + "┼" + "─".repeat(width + (super.width - cap.length()));
            }
            else{
                separador = separador + "┼" + "─".repeat(width);
            }
        }
        rst.add(2, separador);
        // rst.add(2, "│" + "─".repeat(widths.get(0)) + "┼" + "─".repeat(widths.get(1)) + "┼" + "─".repeat(widths.get(2) + 1) + "│");
        
        //for (int cntcol = 3; cntcol < height; cntcol++){}
        for (ArrayList<String> row : rows) {
            String cap2 = "";
                //Integer num = 3;
            for (int i = 0; i < row.size(); i++){
                String item = row.get(i);
                int width = widths.get(i);
                String align = aligns.get(i);
            
                item = alineacio(item, width, align);    
                cap2 = cap2 + item;
                if (i < headers.size() - 1) {
                    cap2 = cap2 + "|";
                }
            }
            rst.add(rst.size(), " " + cap2 + " ".repeat(width - cap.length() - 1));
        }
           
        // Asignar text segons alineació 
        for (int i = 7; i < height; i++) {
            rst.add(i, "x".repeat(width));
        }
        return rst;
    } 
}
