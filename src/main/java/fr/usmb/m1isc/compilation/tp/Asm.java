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
        rightCode(arbre, pw);
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
        /*if(arbre.getType() == Arbre.NodeType.SEMI){
            rightCodes(arbre.getFg(), pw);
            if(!arbre.getFd().isaleaf()){
                rightCodes(arbre.getFd(), pw);
            }

        }else{
            if(arbre.getFg().isaleaf() && arbre.getFd().isaleaf()){
                rightLine(arbre.getFg(), arbre.getType(), arbre.getFd(), pw);
            }

            else if (arbre.getFg().isaleaf() && !arbre.getFd().isaleaf()) {
                rightCodes(arbre.getFd(), pw);
            }
            else if(!arbre.getFg().isaleaf() && arbre.getFd().isaleaf()) {
                rightCodes(arbre.getFg(), pw);
            }
                else {
                    rightCodes(arbre.getFg(), pw);
                    rightCodes(arbre.getFd(), pw);
                }
            }*/

    }

    public static void rightCode(Arbre arbre, PrintWriter pw){
        if((arbre != null)){
            switch(arbre.getType()) {
                case ENTIER:
                case IDENT:
                    pw.println("\tmov eax, " + arbre.toString() + "\n");
                    break;
                case SEMI:
                    rightCode(arbre.getFg(), pw);
                    rightCode(arbre.getFd(), pw);
                    break;
                case LET :
                    rightCode(arbre.getFd(), pw);
                    pw.println("\tmov " + arbre.getFg() + ", eax\n");
                    break;
                case PLUS:
                    rightCode(arbre.getFg(), pw);
                    pw.println("\tpush eax\n");
                    rightCode(arbre.getFd(), pw);
                    pw.println("\tpop ebx\n");
                    pw.println("\tadd eax, ebx\n");
                    break;
                case MOINS:
                    rightCode(arbre.getFg(), pw);
                    pw.println("\tpush eax\n");
                    rightCode(arbre.getFd(), pw);
                    pw.println("\tpop ebx\n");
                    pw.println("\tsub ebx, eax\n");
                    pw.println("\tmov eax, ebx\n");
                    break;
                case MUL:
                    rightCode(arbre.getFg(), pw);
                    pw.println("\tpush eax\n");
                    rightCode(arbre.getFd(), pw);
                    pw.println("\tpop ebx\n");
                    pw.println("\tmul eax, ebx\n");
                    break;
                case DIV:
                    rightCode(arbre.getFg(), pw);
                    pw.println("\tpush eax\n");
                    rightCode(arbre.getFd(), pw);
                    pw.println("\tpop ebx\n");
                    pw.println("\tdiv ebx, eax\n");
                    pw.println("\tmov eax, ebx\n");
                    break;

            }
        }

    }

}
