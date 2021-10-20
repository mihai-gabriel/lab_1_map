package model;

public class Complex {
    private double im = 0, re = 0;

    public Complex() {
    }

    public Complex(double re) {
        this.re = re;
        this.im = 0;
    }

    public Complex(double re, double im) {
        this.im = im;
        this.re = re;
    }

    public Complex(Complex number) {
        this.im = number.im;
        this.re = number.re;
    }

    public Complex add(Complex nr) {
        return new Complex(this.getRe() + nr.getRe(), this.getIm() + nr.getIm());
    }

    public Complex subtract(Complex nr) {
        return new Complex(this.getRe() - nr.getRe(), this.getIm() - nr.getIm());
    }

    public Complex multiply(Complex nr) {
        return new Complex(this.getRe() * nr.getRe() - this.getIm() * nr.getIm(),
                this.getRe() * nr.getIm() + this.getIm() * nr.getRe());
    }

    public Complex divide(Complex nr) {
        Complex aux = new Complex(nr.getRe(), (-1) * nr.getIm());
        aux = this.multiply(aux);
        return new Complex(aux.getRe() / (nr.getRe() * nr.getRe() + nr.getIm() * nr.getIm()),
                        aux.getIm() / (nr.getRe() * nr.getRe() + nr.getIm() * nr.getIm()));
    }

    public Complex conjugate(Complex nr) {
        return new Complex(nr.getRe(), (-1) * nr.getIm());
    }

    @Override
    public String toString() {
        return "re = " + re + "; im = " + im + "*i";
    }

    public double getIm() {
        return im;
    }

    public double getRe() {
        return re;
    }
}
