package JavaAssessment;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;


public class DoubleTest {
    public static void main(String args[]) {
        String zabbixMessage = "Alert: Out of Balance, Millennium: $%s, Healthe: $%s, Variance: $%s, Percentage:%s%%";
        BigDecimal harcAmount = BigDecimal.ZERO;
        BigDecimal sourceSystemAmount = BigDecimal.ZERO;

        File files = new File("src/main/resources/BoubleTest");
        if (files.exists()) {
            for (File file : files.listFiles()) {
                System.out.println("---------File Name:"+file.getName());
                try {
                    Scanner sc = new Scanner(file);

                    while(sc.hasNext()){
                        String harcStringAmt = sc.next();
                        String sourceSystemStringAmount = sc.next();
                        if(!harcStringAmt.equals("null")) {
                            harcAmount = harcAmount.add(new BigDecimal(harcStringAmt).setScale(2,
                                    BigDecimal.ROUND_HALF_UP));
                        }
                        if(!sourceSystemStringAmount.equals("null")) {
                            sourceSystemAmount = sourceSystemAmount.add(new BigDecimal(sourceSystemStringAmount).setScale(2,
                                    BigDecimal.ROUND_HALF_UP));
                        }
                    }
                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("harcAmount:"+harcAmount);
        System.out.println("sourceSystemAmount:"+sourceSystemAmount);

        BigDecimal percentage = getPercentage(harcAmount, sourceSystemAmount);
        BigDecimal amountVariance = getAmountVariance(harcAmount, sourceSystemAmount);

        System.out.println("Precentage:"+percentage+" amount Variance:"+amountVariance);
        if(percentage.doubleValue() > 5.0 || amountVariance.doubleValue() > 1000000) {
            System.out.println("PrecentageDouble:"+percentage.doubleValue()+" amount VarianceDouble:"+amountVariance.doubleValue());

        }
        System.out.println(String.format(zabbixMessage, sourceSystemAmount, harcAmount, amountVariance, percentage));
    }

    private static BigDecimal getPercentage(BigDecimal harcAmount, BigDecimal sourceSystemAmount) {
        if (sourceSystemAmount == BigDecimal.ZERO && harcAmount != BigDecimal.ZERO) {
            return BigDecimal.valueOf(100);
        }
        BigDecimal percentage = sourceSystemAmount.subtract(harcAmount).abs().multiply(BigDecimal.valueOf(100)).divide(sourceSystemAmount, 2, BigDecimal.ROUND_HALF_UP).abs();
        return percentage;
    }

    private static BigDecimal getAmountVariance(BigDecimal harcAmount, BigDecimal sourceSystemAmount) {
        BigDecimal variance = sourceSystemAmount.subtract(harcAmount).abs();
        return variance;
    }
}


