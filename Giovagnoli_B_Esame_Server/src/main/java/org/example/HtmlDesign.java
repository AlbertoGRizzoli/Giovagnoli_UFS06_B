package org.example;

public class HtmlDesign {
    private String upperPart = "<!DOCTYPE html>" +
            "<html>" +
            "<style>" +
            "table, th, td {" +
            "  border:1px solid black;" +
            "}" +
            "</style>" +
            "<body>" + "<h2>HTML Response Table</h2>" +
            "<table style=\"width:100%\">" +
            "<tr>" +
            "<th>ID</th>" +
            "<th>Nome</th>" +
            "<th>Prezzo</th>" +
            "<th>Quantita</th>" +
            "</tr>";
    private String bottomPart = "</table>\n" +
            "\n" +
            "</body>\n" +
            "</html>";

    public String getUpperPart() {
        return upperPart;
    }

    public void setUpperPart(String upperPart) {
        this.upperPart = upperPart;
    }

    public String getBottomPart() {
        return bottomPart;
    }

    public void setBottomPart(String bottomPart) {
        this.bottomPart = bottomPart;
    }
}
