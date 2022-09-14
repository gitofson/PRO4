package cz.spsmb.ctvrtak.b_anotace;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//Parametrická anotace
@Target({ElementType.METHOD})
public @interface Testovat {
    public String druh() default "";
    public Den[] frekvence() default {Den.PO, Den.ÚT, Den.ST, Den.ČT, Den.PÁ};
}
