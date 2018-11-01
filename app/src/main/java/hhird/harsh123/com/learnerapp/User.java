package hhird.harsh123.com.learnerapp;

public class User {


    String userfname;
    String userlname;
    String mobno;
    String userprofile;
    String mail;

    public User(String userfname, String userlname, String mobno, String userprofile,String mail) {
        this.userfname = userfname;
        this.userlname = userlname;
        this.mobno = mobno;
        this.userprofile = userprofile;
        this.mail=mail;
    }

    public String getUsername() {
        return userfname;
    }

    public String getUserlname() {
        return userlname;
    }

    public String getMobno() {
        return mobno;
    }

    public String getUserprofile() {
        return userprofile;
    }

    public String getMail() {return mail; }
}
