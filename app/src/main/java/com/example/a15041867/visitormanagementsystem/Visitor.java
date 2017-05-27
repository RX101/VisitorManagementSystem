package com.example.a15041867.visitormanagementsystem;

/**
 * Created by 15017082 on 23/5/2017.
 */

public class Visitor {
    private String visitor_nric;
    private String visitor_name;
    private String visitor_phone_number;
    private String visitor_email;

    public Visitor(String visitor_nric, String visitor_name, String visitor_phone_number, String visitor_email){
        this.visitor_nric = visitor_nric;
        this.visitor_name = visitor_name;
        this.visitor_phone_number = visitor_phone_number;
        this.visitor_email = visitor_email;
    }

    public String getVisitor_nric(){
        return visitor_nric;
    }

    public String getVisitor_name(){
        return visitor_name;
    }

    public String getVisitor_phone_number(){
        return visitor_phone_number;
    }

    public String getVisitor_email(){
        return visitor_email;
    }

    public String toString(){
        return
                visitor_name + '\n' + visitor_nric;

    }
}
