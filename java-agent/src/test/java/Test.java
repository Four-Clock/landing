import java.math.BigDecimal;

/**
 * 功能描述: Test
 *
 * @author linqin.zxl
 * @date 2021/4/30
 */
public class Test {
    public static void main(String[] args) {
        int i = BigDecimal.ZERO.compareTo(BigDecimal.valueOf(1));
        System.out.println(i);
    }
}
