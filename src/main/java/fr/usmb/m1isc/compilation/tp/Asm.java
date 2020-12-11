package fr.usmb.m1isc.compilation.tp;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Asm {
    public void createAsmfile(Arbre arbre, String filename) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter pw = new PrintWriter(filename, "UTF-8");
        pw.println(arbre.toString());

        pw.println("DATA SEGMENT");
        rightVariables(arbre, pw);
        pw.println("DATA ENDS");
        pw.println("CODE SEGMENT");
        //rightCode(arbre, pw);
        pw.println("CODE ENDS");
        pw.close();

    }

    public void rightVariables(Arbre arbre, PrintWriter pw){
        //pw.println(arbre.getValue());
        if (arbre.getType() == Arbre.NodeType.SEMI){
            if(arbre.getFg() != null){
                rightVariables(arbre.getFg(), pw);
            }
            if (arbre.getFd() != null){
                rightVariables(arbre.getFd(), pw);
            }
        }
        else {
            if (arbre.getType() == Arbre.NodeType.LET){
                pw.println("    "+arbre.getFg()+ " DD");
            }
            if(arbre.getFg() != null){
                rightVariables(arbre.getFg(), pw);
            }
            if (arbre.getFd() != null){
                rightVariables(arbre.getFd(), pw);
            }
        }

    }
    public void rightCodes(Arbre arbre, PrintWriter pw){
        if(arbre.getType())
    }
}
