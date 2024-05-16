package ar.edu.utn.frc.tup.lciii;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Square extends Figure {

    //atributos
    private BigDecimal side;

    //constructor
    Square(BigDecimal l){
        this.side = l;
    }

    //getters
    public BigDecimal getSide(){
        return side;
    }

    //setters
    private void setSide(BigDecimal s){
        this.side = s;
    }

    //metodos clase padre Figure
    @Override
    public BigDecimal getPerimeter() {
        BigDecimal perimeter = this.getSide().add(this.getSide()).add(this.getSide()).add(this.getSide());
        return perimeter.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getArea() {
        BigDecimal area = this.getSide().multiply(this.getSide());
        return area.setScale(2, RoundingMode.HALF_UP);
    }
}
