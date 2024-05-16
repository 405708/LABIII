package ar.edu.utn.frc.tup.lciii;

import java.math.BigDecimal;

public abstract class Figure {

    public abstract BigDecimal getPerimeter();

    public abstract BigDecimal getArea();

    public boolean isGreater(Figure f){
        int result = this.getArea().compareTo(f.getArea());

        if (result >= 0){
            return true;
        } else {
            return false;
        }
    }
}
