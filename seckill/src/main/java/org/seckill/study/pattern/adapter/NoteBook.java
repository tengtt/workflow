package org.seckill.study.pattern.adapter;

/**
 * Created by teng on 2016/5/27.
 */
public class NoteBook {

    private ThreePlugIf plug;

    public NoteBook(ThreePlugIf plug) {
        this.plug = plug;
    }

    //使用插座充电
    public void charge(){
        plug.powerWithThree();
    }

    public static void main(String[] args){
        GBTwoPlug two = new GBTwoPlug();
        ThreePlugIf three = new TwoPlugAdapter(two);
        NoteBook noteBook = new NoteBook(three);
        noteBook.charge();
        System.out.println("-----------------------------------------------");
        ThreePlugIf three2 = new TwoPlugAdaper1();
        NoteBook noteBook2 = new NoteBook(three2);
        noteBook2.charge();

    }
}
