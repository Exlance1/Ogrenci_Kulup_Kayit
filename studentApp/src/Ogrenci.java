/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MONSTER
 */
public class Ogrenci {
    
    private int id;
    private String ad;
    private String soyad;
    private String email;
    private String student_no;
    private String department;
    

    public Ogrenci(int id, String ad, String soyad, String email, String student_no, String department) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.student_no = student_no;
        this.department = department;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }
      public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudent_no() {
        return student_no;
    }

    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

  
    
    
   
    
    
}
