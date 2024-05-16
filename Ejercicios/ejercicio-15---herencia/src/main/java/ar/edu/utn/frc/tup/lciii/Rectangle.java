package ar.edu.utn.frc.tup.lciii;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rectangle extends Figure {

    //atributos
    private BigDecimal base;
    private BigDecimal height;

    //constructor
    Rectangle(BigDecimal b, BigDecimal a){
        this.base = b;
        this.height = a;
    }

    //getters
    public BigDecimal getBase(){
        return base;
    }

    public BigDecimal getHeight(){
        return height;
    }

    //setters
    public void setBase(BigDecimal b){
        this.base = b;
    }

    public void setHeight(BigDecimal h){
        this.height = h;
    }

    //metodos clase padre Figure
    @Override
    public BigDecimal getPerimeter() {
        BigDecimal x1 = this.getBase().multiply(new BigDecimal("2.0"));
        BigDecimal x2 = this.getHeight().multiply(new BigDecimal("2.0"));
        BigDecimal perimeter = x1.add(x2);

        return perimeter.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getArea() {
        BigDecimal area = this.getBase().multiply(this.getHeight());

        return area.setScale(2, RoundingMode.HALF_UP);
    }
}
