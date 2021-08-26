package Model;

import java.util.List;

public class Word {

    private int id;
    private String word;
    private String translation;
    //private List<PartSpeech> translate;

    public Word(int id, String word, String translation) {
        this.id = id;
        this.word = word;
        this.translation = translation;
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }
/*
    public List<PartSpeech> getTranslate() {
        return translate;
    }
*/
    public void setId(int id) {
        this.id = id;
    }

    public String getTranslation() {
        return translation;
    }

    public void setWord(String word) {
        this.word = word;
    }
/*
    public void setTranslate(List<PartSpeech> translate) {
        this.translate = translate;
    }

 */
}
