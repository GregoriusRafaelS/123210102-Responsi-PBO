/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg123210102_responsipbo;

import controller.HomeController;
import model.MovieModel;
import view.HomeView;

/**
 *
 * @author Lab Informatika
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HomeView homeView = new HomeView();
        homeView.setVisible(true);
        homeView.show();
        
        MovieModel movie = new MovieModel();
        
        HomeController homeController = new HomeController(homeView, movie);
    }
    
}
