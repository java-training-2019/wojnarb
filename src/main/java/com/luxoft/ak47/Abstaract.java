package com.luxoft.ak47;

public class Abstaract {

    public static void main(String[] args) {

    }

    abstract static class Account { abstract String type();}

    static class SaveAccoupnt extends Account {
        @Override
        String type(){
            return "type";
        }
    }

    public class RorAccount extends Account {
        @Override
        String type(){
            return "Ror";
        }

    }
}
