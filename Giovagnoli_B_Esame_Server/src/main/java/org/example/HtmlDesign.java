package org.example;

public class HtmlDesign {
    private String UpperPartTable = "<!DOCTYPE html>" +
            "<html>" +
            "<style>" +
            "table, th, td {" +
            "border:1px solid black;" +
            "}" +
            "</style>" +
            "<body>" + "<h2>HTML Response Table</h2>" +
            "<table style=\"width:100%\">" +
            "<tr>" +
            "<th>ID</th>" +
            "<th>Nome Albergo</th>" +
            "<th>Prezzo suite</th>" +
            "<th>Quantità suite</th>" +
            "</tr>";
    private String BottomPartTable= "</table>\n" +
            "\n" +
            "</body>\n" +
            "</html>";
    public String getUpperPartTable() {
        return UpperPartTable;
    }

    public void setUpperPartTable(String upperPartTable) {
        UpperPartTable = upperPartTable;
    }

    public String getBottomPartTable() {
        return BottomPartTable;
    }

    public void setBottomPartTable(String bottomPartTable) {
        BottomPartTable = bottomPartTable;
    }
}
