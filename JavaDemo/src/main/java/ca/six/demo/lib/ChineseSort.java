package ca.six.demo.lib;

import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class ChineseSort {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("第一", "无双", "苹果");
        Collections.sort(names, (n1, n2) -> n1.compareTo(n2));
        names.forEach(System.out::println); // 无双, 第一, 苹果

        List<String> names2 = Arrays.asList("第一", "无双", "苹果", "啊", "不");
        Collections.sort(names2, new CN());
        names2.forEach(System.out::println); // 啊, 不, 第一, 苹果, 无双,

        List<String> frNames = Arrays.asList("Mise à jour", "Négociation", "Installer","Activité");
        Collections.sort(frNames, (n1, n2) -> n1.compareTo(n2));
        frNames.forEach(System.out::println); // Activité, Installer, Mise à jour, Négociation

    }
}

class CN implements Comparator<String>{
    RuleBasedCollator collator = (RuleBasedCollator)Collator.getInstance(Locale.CHINA);

    @Override
    public int compare(String o1, String o2) {
        return collator.compare(o1, o2);
    }
}
