package com.github.ceFractal.gui;

import java.util.HashSet;

public class Pj {

    private String nombre;
    private String ruta;
    private String source;

    private HashSet<String> archivos;
    private String principal;

    public Pj(String nombre, String ruta, HashSet<String> archivos, String principal) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.archivos = archivos;
        this.principal = principal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public HashSet<String> getArchivos() {
        if (archivos == null) {
            archivos = new HashSet<>();
        }
        return archivos;
    }

    public String getPrincipal() {
        return principal;
    }

    public boolean isOk() {
        return (nombre != null && !nombre.trim().isEmpty()) && (ruta != null && !ruta.trim().isEmpty());
    }

    @Override
    public String toString() {
        return getNombre();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void setArchivos(HashSet<String> archivos) {
        this.archivos = archivos;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getXml() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("<Proyecto nombre=\"%s\" ruta=\"%s\">", getNombre(), getRuta()));
        builder.append('\n');

        builder.append("<Archivos>");
        builder.append('\n');
        for (String f : getArchivos()) {
            builder.append(String.format("<Archivo nombre=\"%s\" />", f));
            builder.append('\n');
        }
        builder.append("</Archivos>");
        builder.append('\n');

        if (hasPrincipal()) {
            builder.append("<Principal>");
            builder.append('\n');
            builder.append(String.format("<Archivo nombre=\"%s\" />", getPrincipal()));
            builder.append('\n');
            builder.append("</Principal>");
            builder.append('\n');
        }

        builder.append("</Proyecto>");
        builder.append('\n');

        return builder.toString();
    }

    public boolean hasPrincipal() {
        return principal != null && !principal.isEmpty();
    }
}
