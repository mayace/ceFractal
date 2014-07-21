
package com.github.ceFractal.graph;

import com.github.gg.OptGoto;
import com.github.gg.OptIf;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.*;

public class GraphGenerator {
    
    public String relation;
    public String method_relation;
    
    String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
      
    
    public GraphGenerator(){
        this.relation = "";
        this.method_relation = "";
    }
    
    public String getString(final LinkedHashMap app) {
        StringBuilder builder = new StringBuilder();
        int ContadorEstados= 0;
        builder.append("digraph g {"+
                    "graph [fontsize=30 labelloc=\"t\" label=\"\" splines=true overlap=false rankdir = \"LR\"];"+
                    "ratio = auto;");
        final LinkedHashMap<String, LinkedHashMap> methods = (LinkedHashMap) app;
        for (Map.Entry<String, LinkedHashMap> method : methods.entrySet()) {
            final String mname = method.getKey();
            String last_lname = "";
            String first_lname="";
            boolean pendiente = false;
            //builder.append(String.format("void %s(){", mname));
            //builder.append("\n");
            final LinkedHashMap<String, ArrayList> labels = method.getValue();
            for (Map.Entry<String, ArrayList> label : labels.entrySet()) {
                final String lname = label.getKey();
                final ArrayList stmts = label.getValue();
                ContadorEstados++;                
                if(lname.isEmpty()){
                    builder.append("\"state"+ContadorEstados+"\" \n" +
                            "[ style = \"filled, bold\" penwidth = 1 fillcolor = \"white\" fontname = \"Courier New\" shape = \"box\" label =<<table border=\"0\" cellborder=\"0\" cellpadding=\"3\" bgcolor=\"white\">");
                    last_lname = "state"+ContadorEstados;
                    if (ContadorEstados == 1)
                        first_lname =last_lname;
                }else{
                    builder.append("\""+lname.trim()+"\" \n" +
                            "[ style = \"filled, bold\" penwidth = 1 fillcolor = \"white\" fontname = \"Courier New\" shape = \"box\" label =<<table border=\"0\" cellborder=\"0\" cellpadding=\"3\" bgcolor=\"white\">");
                    last_lname = lname.trim();
                    if (ContadorEstados == 1)
                        first_lname =last_lname;
                }
                
                //if (!lname.isEmpty()) {
                    builder.append("<tr>\n" +
                                "<td align=\"left\" colspan=\"2\">"+last_lname.trim()+"</td>\n" +
                                "</tr>");
                //}
                for (int i = 0; i < stmts.size(); i++) {
                    Object stmt = stmts.get(i);
                    builder.append("<tr>\n" +
                                "<td align=\"left\" port=\"r0\">"+ replaceChars(stmt.toString()) +"</td>\n" +
                                "</tr>");
                    //verificar relaciones
                    if (stmt instanceof OptGoto){
                        int indice = 0;
                        indice = stmt.toString().indexOf("goto");
                        String tag = stmt.toString().substring(indice + 4, stmt.toString().length()-1).trim();
                        //if(!lname.isEmpty()){
                            //relation += "state"+ContadorEstados +"->"+tag+" [ penwidth = 1 fontsize = 28 fontcolor = \"black\"];";
                        //}else{
                            relation += last_lname.trim() +"->"+tag+ " [ penwidth = 1 fontsize = 28 fontcolor = \"black\"];";
                        //}
                    }                    
                    if (stmt instanceof OptIf){
                        int indice = 0;
                        indice = stmt.toString().indexOf("goto");
                        String tag = stmt.toString().substring(indice + 4, stmt.toString().length()-1).trim();
                        //if(!lname.isEmpty()){
                            //relation += "state"+ContadorEstados +"->"+tag+" [ penwidth = 1 fontsize = 28 fontcolor = \"black\"];";
                        //}else{
                            relation += last_lname.trim() +"->"+tag+ " [ penwidth = 1 fontsize = 28 fontcolor = \"black\"];";
                        //}
                    }
                    
                    
                }
                builder.append("</table>> ];");
            }
            
            this.method_relation += mname + "->" + last_lname.trim()+ " [ penwidth = 1 fontsize = 28 fontcolor = \"black\"];";
            
            this.method_relation += mname + "->" + first_lname.trim()+ " [ penwidth = 1 fontsize = 28 fontcolor = \"black\"];";
            
            builder.append(method_relation);
            builder.append(relation);
            builder.append("}");
            builder.append("\n");
        }
        
        
        builder.append("}");
        return builder.toString();
    }
    
    private String replaceChars(String input){
        String output = input;
        output.replaceAll("<", "&#60;");
        output.replaceAll(">", "&#62;");
        output.replaceAll("/", "&#47;");        
        return output;
    }
    
    private String gerRelatedNodes(){
        StringBuilder relation = new StringBuilder();
        
        return relation.toString();
    }
    
    public void crearImagen(String graph, String name, String image){
      //Escribir archivo txt con esructura de grafo
      this.escribirArcvhivo(name, graph);        
      String fileInputPath = name;
      String fileOutputPath = image;
      String tParam = "-Tjpg";
      String tOParam = "-o";
      try{      
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;                  
            Runtime rt = Runtime.getRuntime();      
            rt.exec( cmd );      
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {}
      
        
      //  System.out.println(Graphviz.writeGraphToFile(Graphviz.getGraph(graph,"png"),"grafo"));

    //Graphviz.writeGraphToFile(Graphviz.getGraph(graph,"png"), "Graph");
        
    }
    
    public void escribirArcvhivo(String name, String content){
        FileWriter temp_con = null;
        PrintWriter pw = null;
        try
        {
            temp_con = new FileWriter(name);
            pw = new PrintWriter(temp_con);
            pw.println(content);
                
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {           
            if (null != temp_con)
              temp_con.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        } 
    }
}


