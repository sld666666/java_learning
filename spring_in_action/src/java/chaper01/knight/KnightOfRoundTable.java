package chaper01.knight;

/**
 * Created by diwu.sld on 2016/3/16.
 */
public class KnightOfRoundTable implements IKnight {

    private String name;
    private IQuest quest;
    private Minstrel mistrel;

    public  String getName(){
        return  this.name;
    }

    public void setMistrel(Minstrel mistrel) {
        this.mistrel = mistrel;
    }

    public void setQuest(IQuest quest) {
        this.quest = quest;
    }

    public KnightOfRoundTable(String name) {
        this.name = name;
    }

    public  HolyGrail embarkOnQuest(){
        return quest.embark();
    }
}
