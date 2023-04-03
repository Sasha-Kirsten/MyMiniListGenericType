public interface MiniList <T> {
    public void add(T element);
    public T get(int index);
    public int getIndex(T element);
    public void set(int index, T element);
    public int size();
    public T remove(int index);
    public boolean remove(T element);
    public void clear();

//    public MyMiniList();objectStore = (T[]) new Object[10];
}







// interface MiniList<T> {
//     void add(T element);
//     T get(int index);
//     int getIndex(T element);
//     void set(int index, T element);
//     int size();
//     T remove(int index);
//     boolean remove(T element);
//     void clear();
// }
