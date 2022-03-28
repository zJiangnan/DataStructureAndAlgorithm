package cn.echo.dsa.linear;

/**
 * 队列
 * <p>
 *     先进先出
 * </p>
 *
 * @author pluto
 * @version 1.0
 * @createdate 2022/3/28
 * @see Queue
 **/
public class Queue {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        System.out.println("新增数据9");
        arrayQueue.addQueue(9);
        System.out.println("新增数据7");
        arrayQueue.addQueue(7);
        System.out.println("新增数据4");
        arrayQueue.addQueue(4);
        System.out.println("显示队列信息：");
        arrayQueue.showQueue();
        System.out.println("取出一个数据：");
        System.out.println(arrayQueue.getQueue());
    }
}

/**
 * 使用数组模拟队列
 */
class ArrayQueue {
    private int maxSize;    // 最大容量
    private int front;      // 队列头，用于出列
    private int rear;       // 队列尾，用于入列
    private int[] arr;      // 数组模拟队列

    // 创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;     // 指向队列头部，它是指向队列头的前一个位置
        rear = -1;      // 指向队列尾部，它是指向队列尾部最后一个元素
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    // 添加数据到队列
    public void addQueue(int data) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++;     // 添加数据，rear 后移
        arr[rear] = data;   // rear 表示数据的最后一个，所以rear++之后就是新数据存放的位置
    }

    // 获取队列数据，出列
    public int getQueue() {
        // 判断是否空队列
        if (isEmpty()) {
            throw new RuntimeException("空队列");
        }
        front++;    // 出队列，头部后移
        return arr[front];  // front 后移表示出一个数据
    }

    // 显示队列数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("空队列");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }
}
