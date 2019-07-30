package intro.aop.aspectj;

public class Poem implements Performance {

    @Override
    public void perform() {
        System.out.println("Из книг мелькает лермонтовский парус,\n" +
                "А в голове паршивый сэр Керзон.\n" +
                "«Мне скучно, бес!»\n" +
                "«Что делать, Фауст?»");
    }
}
