package utilities;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
    static NumberFormat formartandoValores = new DecimalFormat("R$ #,##0.00");

    public static String doubleToString(Double valor){
        return formartandoValores.format(valor);

    }
}
