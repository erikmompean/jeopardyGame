package DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Categoria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Manel
 */
public class CategoriasDAOImp implements CategoriasDAO {

    @Override
    public ArrayList<Categoria> cargarTodas() {
        Path path = Paths.get("preguntas");
        ArrayList<Path> arrayPaths = new ArrayList();
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(path);
            for (Path file : stream) {
                arrayPaths.add(file);

            }

        } catch (IOException ex) {
            Logger.getLogger(CategoriasDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearCategorias(ArrayList<Path> paths) {
        
        for (Path file : paths) {
            BufferedReader br=null;
            try{
                br=Files.newBufferedReader(file,java.nio.charset.StandardCharsets.UTF_8);
                
            }catch(IOException ex){
                System.out.println("--------");
            }finally{
                if(br!=null) try{
                    br.close();
                }catch(IOException ex){
                    System.out.println("---------");
                }
            }
        }

    }

}
