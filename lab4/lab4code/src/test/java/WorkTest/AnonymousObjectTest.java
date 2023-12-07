package WorkTest;
import Work.Work;
import org.junit.jupiter.api.Test;

public class AnonymousObjectTest  {
    public void testWork(Work work) {
        work.doWork1();
        work.doWork2();
    }
    @Test
    public void test(){
        Work AnonymousObject2 = new Work() {
            @Override
            public void doWork1() {
                System.out.println("doWork1byAO2");
            }



            @Override
            public void doWork2() {
                System.out.println("doWork1byAO2");
            }
        };
        this.testWork(AnonymousObject2);
    }
}
