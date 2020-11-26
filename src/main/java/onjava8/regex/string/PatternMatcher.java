package onjava8.regex.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author jojo
 * @create 2020/2/29 下午9:57
 */
public class PatternMatcher {

    public static void main(String[] args) {
//        testRegex();
        test();
    }

    /**
     * 测试正则表达式
     */
    public static void testRegex() {
        String target = "Java now has regular expression";
        String[] candidates = new String[] {"^Java","\\Breg.*","n.w\\s+h(a|i)s","s?","z*","s+","s{4}","s{1}.", "s{0,3}"};
        System.out.println("Input: \"" + target + "\"");
        for (String candidate : candidates) {
            System.out.println("Regular expression: \"" + candidate + "\"");
            Pattern pattern = Pattern.compile(candidate);
            Matcher matcher = pattern.matcher(target);
            boolean b = matcher.find();
            System.out.println("result: " + b);

        }
    }

    /**
     * \s 空白符（空格，换行，回车，换页，tab）
     * \w 词字符（a-zA-Z0-9）
     * \b 词的边界
     *
     * 正则表达式的模式修饰符。
     * 　　(?i)即匹配时不区分大小写。表示匹配时不区分大小写。
     * 　　(?s)即Singleline(单行模式)。表示更改.的含义，使它与每一个字符匹配（包括换行 符\n）。
     * 　　(?m)即Multiline(多行模式) 。 表示更改^和$的 含义，使它们分别在任意一行的行首和行尾匹配，而不仅仅在整个字符串的开头和结尾匹配。(在此模式下,$的 精确含意是:匹配\n之前的位置以及字符串结束前的位置.)
     * 　　(?x)：表示如果加上该修饰符，表达式中的空白字符将会被忽略，除非它已经被转义。
     * 　　(?e)：表示本修饰符仅仅对于replacement有用，代表在replacement中作为PHP代码。
     * 　　(?A)：表示如果使用这个修饰符，那么表达式必须是匹配的字符串中的开头部分。比如说"/a/A"匹配"abcd"。
     * 　　(?E)：与"m"相反，表示如果使用这个修饰符，那么"$"将匹配绝对字符串的结尾，而不是换行符前面，默认就打开了这个模式。
     * 　　(?U)：表示和问号的作用差不多，用于设置"贪婪模式"。
     */
    public static void test() {
        String target = "Arline ate eight apples and one orange while Anita hadn't any";
        String regex = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
        System.out.println("target: " + "\"" + target + "\"");
        System.out.println("regex: " + "\"" + regex + "\"");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(target);
        while(matcher.find()) {
            System.out.println("Match \"" + matcher.group() + "\" at positions " + matcher.start() + "-" + (matcher.end() - 1));
        }

    }

}
