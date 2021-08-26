package Model;

import java.util.List;

public class PartSpeech {

    private String word;
    private List<String> translate;
    private String partSp;

    public PartSpeech(String word, List<String> translate, String partSp) {
        this.word = word;
        this.translate = translate;
        this.partSp = partSp;
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslate() {
        return translate;
    }

    public String getPartSp() {
        return partSp;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setTranslate(List<String> translate) {
        this.translate = translate;
    }

    public void setPartSp(String partSp) {
        this.partSp = partSp;
    }
}
