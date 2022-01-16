/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MONSTER
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


import static java.sql.DriverManager.getConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ogrenciIslemleri {
    private Connection con = null; //bağlantı için
    private Statement statement = null;
    private PreparedStatement preparedStatement=null;
    
    
    
    public void ogrenciSil(int id){
        String sorgu="Delete from students where id=?";
        
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1,id);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ogrenciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void ogrenciGuncelle(int id,String yeni_ad,String yeni_soyad,String yeni_email,String yeni_ogrencino,String yeni_bolum){
    
    String sorgu="Update students set name=? , surname=? , email=? , student_no=? , department=? where id=?"; //parametrede gireceimiz id si olanların name surname vs sini degistirir
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setString(1, yeni_ad);
            preparedStatement.setString(2, yeni_soyad);
            preparedStatement.setString(3, yeni_email);
            preparedStatement.setString(4,yeni_ogrencino);
            preparedStatement.setString(5,yeni_bolum);
            preparedStatement.setInt(6,id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ogrenciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
      public void ogrenciEkle(String ad,String soyad,String email,String ogrencino,String bolum) {
        
        String sorgu = "Insert Into students (name,surname,email,student_no,department) VALUES(?,?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, soyad);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, ogrencino);
            preparedStatement.setString(5, bolum);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ogrenciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }
    
    
    public ArrayList<Ogrenci> ogrencileriGetir(){
        
      
        
        ArrayList<Ogrenci> cikti=new ArrayList<Ogrenci>();
        
        try {
            statement=con.createStatement();
            String sorgu="Select  * from students";
            
            ResultSet rs=statement.executeQuery(sorgu);
            
            while(rs.next())
            {
                 int id=rs.getInt("id");
                 String ad=rs.getString("name");
                 String soyad=rs.getString("surname");
                 String email=rs.getString("email");
                 String student_no=rs.getString("student_no");
                 String department=rs.getString("department");
                 
                 
                 cikti.add(new Ogrenci(id,ad,soyad,email,student_no,department));
                 
                         
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(ogrenciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
    public  boolean girisYap(String kullanici_adi,String parola){
        
        String sorgu="Select * From admins where username=? and password =? ";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1,kullanici_adi);
            preparedStatement.setString(2,parola);
            
            ResultSet rs=preparedStatement.executeQuery();
            
            if(rs.next()==false)
            {
                return false;
                
            }
            else{
                
                return true;
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(ogrenciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        }
        
        
    }

    public ogrenciIslemleri()
    {

        //url: jdbc üzerinden mysql e bağlanıcaz host + port + veri tabanı ismi
        // yani--> jdbc:mysql://localhost:3306/demo
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi + "?useUnicode=true&characterEncoding=utf8";

        // veri tabanına bağlanmak için driverimizi oluşturuyoruz.


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            con = getConnection(url, Database.kullanici_adi, Database.parola);
            System.out.println("Bağlantı başarılı");
        } catch (SQLException throwables) {
            System.out.println("Bağlantı başarısız");
        }

    }

    public static void main(String[] args){
        ogrenciIslemleri islem=new ogrenciIslemleri();

    }


}

