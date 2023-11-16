/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package interfaz;

import Aplication.Gimnasio;
import Negocio.enums.Nivel;

/**
 *
 * @author Santi
 */
public class GimnasioPOOEntregaFinalGrupo4 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
                Gimnasio controller = new Gimnasio();
                controller.crearAdministrativo("juan", 1);
                controller.crearAdministrativo("juan2", 2);
                controller.crearAdministrativo("juan3", 3);
                controller.crearSede("sede1", Nivel.Platinum, "barrio1", (float) 10);
                controller.agregarSedeAdministrativo(controller.listarAdministrativos().get(0), controller.listarSedes().get(0));
                
    }
}
