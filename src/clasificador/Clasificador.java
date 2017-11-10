/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificador;

import archivos.LeerArchivo;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author Liquid
 */
public class Clasificador {

    public ClasificadorADN oCla;    
    File DatosTxt;
    public int modelo, sitio;
    public int[] positivos, positivos2;
    public String rutaSecuencia;

    public void setoCla(ClasificadorADN oCla) {
        this.oCla = oCla;
    }

    public void setPositivos(int[] positivos) {
        this.positivos = positivos;
    }

    public ClasificadorADN getoCla() {
        return oCla;
    }

    public int getModelo() {
        return modelo;
    }

    public int getSitio() {
        return sitio;
    }

    public int[] getPositivos() {
        return positivos;
    }

    public String getRutaSecuencia() {
        return rutaSecuencia;
    }
   
    public void setRutaSecuencia(String rutaSecuencia) {
        this.rutaSecuencia = rutaSecuencia;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public void setSitio(int sitio) {
        this.sitio = sitio;
    }

    public Clasificador(int sitio, int modelo, String rutaSecuencia) {
        
        setModelo(modelo);
        setSitio(sitio);
        oCla = new ClasificadorADN();
        setRutaSecuencia(rutaSecuencia);       
        
    }

    public static void main(String[] args) throws Exception {
        String RutaModelo = null, RutaData;
       
        int modelo, sitio;
        
        RutaData = args[2];
        sitio = Integer.parseInt(args[0]);
        modelo = Integer.parseInt(args[1]);
        
        ClasificadorADN oCla = new ClasificadorADN();
        /*
        while (repeat) {
            try {
                System.out.println("Seleccione Gen a identificar:");
                System.out.println("0. Exon-Intron (GT)");
                System.out.println("1. Intron-Exon (AG)");
                sitio = Integer.parseInt(reader.readLine());

                System.out.println("Seleccione modelo a emplear:");
                System.out.println("0. Conjunctive Rule ");
                System.out.println("1. Multilayer Perceptron");
                System.out.println("2. Tree J48");
                modelo = Integer.parseInt(reader.readLine());
                if (sitio > 1 || modelo > 2) {
                    repeat = true;
                } else {
                    repeat = false;
                }
            } catch (Exception e) {
                repeat = true;

            }
        }*/

        if (modelo == 0 && sitio == 0) {
            //home/jose/NetBeansProjects/clasificadorGTAG/EI_GT/4Modelos
            RutaModelo = "EI_GT/4Modelos/ConjunctiveRule.model";
        }
        if (modelo == 1 && sitio == 0) {
            RutaModelo = "EI_GT/4Modelos/MultiLayerPerceptronAS.model";
        }
        if (modelo == 2 && sitio == 0) {
            RutaModelo = "EI_GT/4Modelos/TreeJ48.model";
        }

        if (modelo == 0 && sitio == 1) {
            RutaModelo = "IE_AG/4Modelos/ConjunctiveRule.model";
        }
        if (modelo == 1 && sitio == 1) {
            RutaModelo = "IE_AG/4Modelos/MultiLayerPerceptronAS.model";
        }
        if (modelo == 2 && sitio == 1) {
            RutaModelo = "IE_AG/4Modelos/TreeJ48.model";
        }

        //RutaData = "test/gen_SST.txt";

        int[] positivos;
        File datos = new File(RutaData);
        positivos = oCla.ClasificarTxt(datos, modelo, sitio, RutaModelo, true);

        System.out.println("Vector de positivos: " + Arrays.toString(positivos));

        //positivos2 = new Clasificador().clasificador(modelo, sitio, "test/gen_SST.txt");

        System.out.println("FIN DEL PROCESO");

    } 

    public List<Integer> clasificador() throws Exception {

        String rutaModelo;
        //oCla = new ClasificadorADN();
        /*
         if(modelo == 0 && Clasificador.sitio == 0)rutaModelo="EI_GT/4Modelos/ConjunctiveRule.model";
         if(modelo == 1 && Clasificador.sitio == 0)rutaModelo="EI_GT/4Modelos/MultiLayerPerceptron.model";
         if(modelo == 2 && Clasificador.sitio == 0)rutaModelo="EI_GT/4Modelos/TreeJ48.model";
    
         if(modelo == 0 && Clasificador.sitio == 1)rutaModelo="IE_AG/4Modelos/ConjunctiveRule.model";
         if(modelo == 1 && Clasificador.sitio == 1)rutaModelo="IE_AG/4Modelos/MultiLayerPerceptron.model";
         if(modelo == 2 && Clasificador.sitio == 1)rutaModelo="IE_AG/4Modelos/TreeJ48.model";
         * */
        rutaModelo = "";

        if (modelo == 0 && sitio == 0) {
            rutaModelo = "clasificador/modelosGT/ConjunctiveRule.model";
        }
        if (modelo == 1 && sitio == 0) {
            rutaModelo = "clasificador/modelosGT/MultiLayerPerceptronAS.model";
        }
        if (modelo == 2 && sitio == 0) {
            rutaModelo = "clasificador/modelosGT/TreeJ48.model";
        }

        if (modelo == 0 && sitio == 1) {
            rutaModelo = "clasificador/modelosAG/ConjunctiveRule.model";
        }
        if (modelo == 1 && sitio == 1) {
            rutaModelo = "clasificador/modelosAG/MultiLayerPerceptronAS.model";
        }
        if (modelo == 2 && sitio == 1) {
            rutaModelo = "clasificador/modelosAG/TreeJ48.model";
        }

        File datos = new File(rutaSecuencia);         
        
        positivos = oCla.ClasificarTxt(datos, modelo, sitio, rutaModelo, true);

        System.out.println("Vector de positivos: " + Arrays.toString(positivos));

        System.out.println("FIN DEL PROCESO");
        
        List<Integer> coords = new ArrayList<>();
        
        for(int i = 0; i < positivos.length; i++){
            
            coords.add(i, positivos[i]);
            
        }

        return coords;

    }
}
