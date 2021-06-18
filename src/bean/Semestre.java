/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author ATH
 */
public class Semestre {
    private String semestre;
    public Semestre() {
    }

    public Semestre(String semestre) {
        this.semestre = semestre;
    }
    
    public String getSemestre() {
        return semestre;
    }
    
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}