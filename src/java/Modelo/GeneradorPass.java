/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author user
 */
public class GeneradorPass {
    
    private String NUMEROS = "";
    private String MAYUSCULAS = "";
    private String MINUSCULAS = "";
    private String ESPECIALES = "";

    public GeneradorPass() {
        NUMEROS = "0123456789";
        MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
        ESPECIALES = "ñÑ";
    }
    

    //
    public String getPinNumber() {
        return getPassword(NUMEROS, 4);
    }

    public String getPassword() {
        return getPassword(8);
    }

    public String getPassword(int length) {
        return getPassword(NUMEROS + MAYUSCULAS + MINUSCULAS, length);
    }

    public String getPassword(String key, int length) {
        String pswd = "";
        for (int i = 0; i < length; i++) {
            pswd += (key.charAt((int) (Math.random() * key.length())));
        }
        return pswd;
    }
}
