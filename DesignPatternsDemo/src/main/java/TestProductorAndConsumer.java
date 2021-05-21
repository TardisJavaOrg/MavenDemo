public class TestProductorAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new  Clerk();
        Productor pro = new  Productor(clerk);
        Consumer cus = new  Consumer(clerk);

        new Thread(pro, "生产者1").start();
        new Thread(cus, "消费者1").start();
        new Thread(pro, "生产者2").start();
        new Thread(cus, "消费者2").start();
    }
}

//店员
class Clerk{
    private int product = 0;
    //进货
    public synchronized void get(){
        while(product >= 3){
            System.out.println("产品已满");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "：当前产品数量由：" + product + "->" + ++product);
        notifyAll();
    }
    //卖货
    public synchronized void sale(){
        while(product <= 0){
            System.out.println("缺货!");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "：当前产品数量由：" + product + "->" + --product);
        notifyAll();
    }
}

//生产者
class Productor implements Runnable{
    private  Clerk clerk;
    public Productor( Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            clerk.get();
        }
    }
}

//消费者
class Consumer implements Runnable{
    private  Clerk clerk;
    public Consumer( Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            clerk.sale();
        }
    }
}