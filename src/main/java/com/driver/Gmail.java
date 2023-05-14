package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    ArrayList<Mails> inboxmail = new ArrayList<>();
    ArrayList<Mails> trashbox = new ArrayList<>();

    int inboxCapacity; //maximum number of mails inbox can store
    //StringBuilder Inbox = new StringBuilder();
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //   StringBuilder Trash = new StringBuilder();
    // Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        //super.emailId = emailId;
       this.inboxCapacity = inboxCapacity;
    }

    public Gmail(String emailId) {
        super(emailId);
    }

    public void receiveMail(Date date, String sender, String message){
        int size = inboxmail.size();
           if(size>=inboxCapacity){
               trashbox.add(inboxmail.remove(size-1));
           }
           inboxmail.add(new Mails(date,sender,message));
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message){
        for(int i=0;i<inboxmail.size();i++){
            Mails m = inboxmail.get(i);
            if(m.message.equals(message)){
                trashbox.add(inboxmail.remove(i));
                break;
            }
        }
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

    }

    public String findLatestMessage(){
        if(inboxmail.size()==0) return null;
        Mails m = inboxmail.get(0);
        return m.message;
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox

    }

    public String findOldestMessage(){
        if(inboxmail.size()==0) return null;
        Mails m = inboxmail.get(inboxmail.size()-1);
        return m.message;
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox

    }

    public int findMailsBetweenDates(Date start, Date end){
        int mass = 0;
        for(int i=0;i<inboxmail.size();i++){
            boolean f = false;
            Mails m = inboxmail.get(i);
            if(m.date==start){
                f=true;
            }
            if(f) mass++;
            if(m.date==end){
                return mass;
            }
        }
        return mass;
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date

    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inboxmail.size();

    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trashbox.size();

    }

    public void emptyTrash(){
        trashbox.clear();
        // clear all mails in the trash

    }

    public int getInboxCapacity() {
        return inboxCapacity-inboxmail.size();
        // Return the maximum number of mails that can be stored in the inbox
    }
    public class Mails{
        Date date;
        String sender;
        String message;
        public Mails(Date date,String sender,String message){
            this.date =date;
            this.message = message;
            this.sender = sender;
        }
    }
}
