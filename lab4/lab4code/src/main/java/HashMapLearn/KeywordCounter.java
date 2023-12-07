package HashMapLearn;

import java.util.HashMap;

public class KeywordCounter {

    private model keywordModel;

    public KeywordCounter() {
        keywordModel = new model();
        keywordModel.setMap(new HashMap<>());
    }

    public void processInput(String input) {
        // 将输入字符串拆分为关键字数组，假设关键字由空白字符分隔
        String[] keywords = input.split("\\s+");

        // 遍历关键字，统计每个关键字的出现次数
        for (String keyword : keywords) {
            keywordModel.getMap().merge(keyword, 1, Integer::sum);
        }
    }

    public void printKeywordCounts() {
        keywordModel.getMap().forEach((keyword, count) -> System.out.println(keyword + ": " + count));
    }
}
