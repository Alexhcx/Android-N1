package com.example.avaliacaon1;

public class SecretCodeData {

    private String n1, n2, n3, n4;
    private int[] nSorteado;
    public SecretCodeData(){}

    public SecretCodeData(String n1, String n2, String n3, String n4){
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
    }
    public SecretCodeData(SecretCodeData other) {
        this.n1 = other.n1;
        this.n2 = other.n2;
        this.n3 = other.n3;
        this.n4 = other.n4;
    }
    public String getN(int num){
        String numero = "";
        if(num == 1) numero = getN1();
        if(num == 2) numero = getN2();
        if(num == 3) numero = getN3();
        if(num == 4) numero = getN4();

        return numero;
    }

    public String getN1() {
        return n1;
    }

    public void setN1(String n1) {
        this.n1 = n1;
    }

    public String getN2() {
        return n2;
    }

    public void setN2(String n2) {
        this.n2 = n2;
    }

    public String getN3() {
        return n3;
    }

    public void setN3(String n3) {
        this.n3 = n3;
    }

    public String getN4() {
        return n4;
    }

    public void setN4(String n4) {
        this.n4 = n4;
    }
}
