package fr.usmb.m1isc.compilation.tp;

public class Arbre {

    public enum NodeType {
        PLUS, MOINS, MOINS_UNAIRE, MUL, DIV, MOD, NOT, OR, AND, PAR_G, PAR_D, SEMI, POINT, LET, INPUT, OUTPUT, IF, THEN, ELSE, WHILE, DO, EGAL, GT, GTE, NIL, ERROR, ENTIER, IDENT
    }

    private NodeType type;
    private Object value;
    private Arbre fg, fd;
    private char format = 0;
    public Arbre(NodeType type, Object value, Arbre fg, Arbre fd) {
        this.type = type;
        this.value = value;
        this.fg = fg;
        this.fd = fd;
    }
    public Arbre(NodeType type, Object value) {
        this(type, value, null, null);
    }
    public Arbre(NodeType type) {
        this(type, null, null, null);
    }
    public NodeType getType() {
        return type;
    }
    public void setType(NodeType type) {
        this.type = type;
    }
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    public Arbre getFg() {
        return fg;
    }
    public void setFg(Arbre fg) {
        this.fg = fg;
    }
    public Arbre getFd() {
        return fd;
    }
    public void setFd(Arbre fd) {
        this.fd = fd;
    }
    public char getFormat() {
        return format;
    }
    public void setFormat(char format) {
        this.format = format;
    }

    public boolean isaleaf(){
        return (this.fg == null && this.fd == null);
    }

    public String toString() {
        StringBuilder res = new StringBuilder("");
        if(this.getFg() != null) {
            if(this.getFd() != null) {
                res.append("(" + this.getValue() + " " + this.getFg().toString() + this.getFd().toString() + ")");
            } else {
                res.append("(" + this.getValue() + " " + this.getFg().toString() + ")");
            }
        }
        else {
            if(this.getFd() != null) {
                res.append("(" + this.getValue() + " . " + this.getFd().toString() + ")");
            }
            else {
                res.append(this.getValue() + " ");
            }
        }
        return res.toString();
    }
}
