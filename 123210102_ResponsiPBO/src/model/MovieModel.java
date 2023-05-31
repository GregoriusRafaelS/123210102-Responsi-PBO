/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.ResultSet;
/**
 *
 * @author Lab Informatika
 */
public class MovieModel extends DatabaseConnector {
    private String judul;
    private double alur, penokohan, akting, nilai;
    
    public int amtsMovie(String type, String name){
        int amtData = 0;
        try{
            statement = connection.createStatement();
            
            String query = (type.equals("all")) ? "SELECT COUNT(*) FROM movie" : "SELECT COUNT (*) FROM movie";
            ResultSet rs = statement.executeQuery(query);
            
            if(rs.next()){
                amtData = rs.getInt(1);
            }
            statement.close();
            
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
        return amtData;
    }
    
    public MovieModel[] putAllData(){
        int amtMovie = amtsMovie("all", "");
        MovieModel[] movies = new MovieModel[amtMovie];
        int i= 0;
        
        try{
            statement = connection.createStatement();
            String query = "SELECT * FROM movie";
            
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                movies[i] = new MovieModel();
                movies[i].setJudul(rs.getString("judul"));   
                movies[i].setAlur(rs.getDouble("alur"));                
                movies[i].setPenokohan(rs.getDouble("penokohan"));                
                movies[i].setAkting(rs.getDouble("akting"));                
                movies[i].setNilai(rs.getDouble("nilai"));                
                
                i++;
            }

            statement.close();
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
        return movies;
    }
    
    public void addMovie(String judul, Double alur, Double penokohan, Double akting, Double nilai){
        try{
            String query = "INSERT INTO movie"
                    + "(judul, alur, penokohan, akting, nilai)"
                    + "VALUES"
                    + "('" + judul + "' "
                    + ", '" + alur + "' "
                    + ", '" + penokohan + "' "
                    + ", '" + akting + "' "
                    + ", '" + nilai + "')";
            
            statement=connection.createStatement();
            statement.executeUpdate(query);
            statement.close();

        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    
    public String getJudul() {
        return judul;
    }

    public double getAlur() {
        return alur;
    }

    public double getPenokohan() {
        return penokohan;
    }

    public double getAkting() {
        return akting;
    }

    public double getNilai() {
        return nilai;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setAlur(double alur) {
        this.alur = alur;
    }

    public void setPenokohan(double penokohan) {
        this.penokohan = penokohan;
    }

    public void setAkting(double akting) {
        this.akting = akting;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }

    
}
