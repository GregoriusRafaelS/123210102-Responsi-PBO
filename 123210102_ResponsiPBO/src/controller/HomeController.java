/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.MovieModel;
import view.HomeView;

/**
 *
 * @author Lab Informatika
 */
public class HomeController {
    HomeView homeView;
    MovieModel movie;

    public HomeController(HomeView homeView, MovieModel movie) {
        this.homeView = homeView;
        this.movie = movie;
        
        homeView.getBtnShow().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
//                clearMovieTabel();
                setMovieToTable();
            }
        });
        
        homeView.getBtnAdd().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                String judul = homeView.getTxtJudul().getText();
                String alur = homeView.getTxtAlur().getText();
                String penokohan = homeView.getTxtPenokohan().getText();
                String akting = homeView.getTxtAkting().getText();
                double nilai = 3;
                
                if(judul.equals("") || alur.equals("") || penokohan.equals("") || akting.equals("")){
                    JOptionPane.showMessageDialog(null, "Isi form Terlebih Dahulu", "Message", JOptionPane.ERROR_MESSAGE);
                }else{
                    movie.addMovie(judul, Double.parseDouble(alur), Double.parseDouble(penokohan), Double.parseDouble(akting), nilai);
                    JOptionPane.showMessageDialog(null, "Berhasil Mengisi Data");
                }

            }
        });
        
        homeView.getTableMovie().addMouseListener(new MouseAdapter(){
            @Override
                public void mouseClicked(MouseEvent e){
                int rowNo = homeView.getTableMovie().getSelectedRow();
                TableModel model = homeView.getTableMovie().getModel();

                homeView.getTxtJudul().setText(model.getValueAt(rowNo, 0).toString());
                homeView.getTxtAlur().setText(model.getValueAt(rowNo, 1).toString());
                homeView.getTxtPenokohan().setText(model.getValueAt(rowNo, 2).toString());
                homeView.getTxtAkting().setText(model.getValueAt(rowNo, 3).toString());
            }
        });

    }
    
    
    public void setMovieToTable(){
        int i=0;
        MovieModel[] movies = movie.putAllData();
        String judul; 
        Double penokohan, akting, alur, nilai;
        
        DefaultTableModel model;
        
        while(i < movies.length){
            judul = movies[i].getJudul();
            penokohan = movies[i].getPenokohan();
            akting = movies[i].getAkting();
            alur = movies[i].getAlur();
            nilai = movies[i].getNilai();
            
            Object[] obj = {judul, alur, penokohan, akting, nilai};
            model = (DefaultTableModel)homeView.getTableMovie().getModel();
            model.addRow(obj);
            i++;
        }
    }
    
    
    
}
