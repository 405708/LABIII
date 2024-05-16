package ar.edu.utn.frc.tup.lciii;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle extends Figure {
    //atributos
    private BigDecimal radius;

    //constructor
    Circle(BigDecimal r){
        this.radius = r;
    }

    //getters
    public BigDecimal getRadius(){
        return radius;
    }

    //setters
    public void setRadius(BigDecimal r){
        this.radius = r;
    }

    //metodos clase padre Figure
    @Override
    public BigDecimal getPerimeter() {
        BigDecimal x1 = new BigDecimal("2.0").multiply(new BigDecimal("3.1416"));
        BigDecimal perimeter = x1.multiply(this.getRadius());

        return perimeter.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getArea() {
        BigDecimal x1 = this.getRadius().pow(2);
        BigDecimal area = x1.multiply(new BigDecimal("3.1416"));

        return area.setScale(2, RoundingMode.HALF_UP);
    }
}
