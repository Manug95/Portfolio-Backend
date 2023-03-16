

package com.portfolio.PortfolioBackend.utils;

/**
 * @author Manuel Gutiérrez
 */
public class Mensaje {
    
    private static final String GUIONES = "--------------------";

    public static void mensajeCatch(Exception e, String msj) {
        
        System.out.println(GUIONES + msj + GUIONES);
        System.out.println(e.getMessage());
        System.out.println(GUIONES + GUIONES + guionesPorLongitudMensaje(msj));
        
    }
    
    public static void error(String msj) {
        System.out.println(GUIONES + GUIONES + guionesPorLongitudMensaje(msj));
        System.out.println(GUIONES + msj + GUIONES);
        System.out.println(GUIONES + GUIONES + guionesPorLongitudMensaje(msj));
    }
    
    private static String guionesPorLongitudMensaje(String msj) {
        String linea = "";
        for (int i = 0; i < msj.length(); i++) {
            linea.concat("-");
        }
        return linea;
    }
    
}
