package Work;

public class Main {
    public static void main(String[] args) {
        Work AnonymousObject1 = new Work() {
            @Override
            public void doWork1() {
                System.out.println("doWork1byAO1");
            }



            @Override
            public void doWork2() {
                System.out.println("doWork1byAO1");
            }
        };

        AnonymousObject1.doWork1();
        AnonymousObject1.doWork2();


    }
}
