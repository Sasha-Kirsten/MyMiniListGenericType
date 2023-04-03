import java.util.Arrays;
import java.util.Objects;

public class MyMiniList <T> implements MiniList<T> {

    Object[] objectStore = (T[]) new Object[10];

    private int capacity = 0;

    @Override
    public void add(T element) {

        objectStore = Arrays.copyOf(objectStore, capacity+1);
        objectStore[capacity] = element;
        capacity = capacity+1;
    }

    @Override
    public T get(int index) {

        return (T) objectStore[index];
    }

    @Override
    public int getIndex(T element) {

        for(int i=0;i<objectStore.length; i++){
            if(objectStore[i] == element){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void set(int index, T element) {
        if(Objects.checkIndex(index,objectStore.length)==index){
            int oldValue = index;
            objectStore[index] = element;
        }

    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public T remove(int index) {
        //boolean tmpBoolean = false;

        Object[] objectStoretmp = (T[]) new Object[objectStore.length];

        int j=0;

        if(Objects.checkIndex(index,objectStore.length) == index){
            //objectStore[index] = null;
            //System.arraycopy(objectStore, index+1, objectStore, index, capacity-index);
            System.arraycopy(objectStore, index, objectStore, index, capacity-index);
            for(int i=0; i<objectStore.length-1;i++){

                if(i==index){
                    i++;
                }
                if(i != index){
                    objectStoretmp[i] = objectStore[i];
                }
                j++;

            }
            objectStore = (T[]) objectStoretmp.clone();

        }
        //index = index-1;
        //objectStore[index] = null;

        return null;
    }


    @Override
    public boolean remove(T element) {

        int i=0;

        found:{
            if(element ==null){
                for(;i<capacity;i++){
                    if(objectStore[i] == null){
                        break found;
                    }
                }
            }else{
                for(;i<capacity;i++){
                    if(element.equals(objectStore[i])){
                        break found;
                    }
                }
            }
            return false;
        }
        remove(i);

        return true;
    }

    @Override
    public void clear() {
        for(int i=0;i< objectStore.length;i++){
            objectStore[i] = null;
        }
    }

}














// import java.util.Objects;

// public class MyMiniList<T> implements MiniList<T> {
//     private int size;
//     private T[] objectStore;

//     public MyMiniList() {
//         objectStore = (T[]) new Object[10];
//         size = 0;
//     }

//     @Override
//     public void add(T element) {
//         if (size == objectStore.length) {
//             T[] newArray = (T[]) new Object[objectStore.length * 2];
//             System.arraycopy(objectStore, 0, newArray, 0, size);
//             objectStore = newArray;
//         }
//         objectStore[size++] = element;
//     }

//     @Override
//     public T get(int index) {
//         Objects.checkIndex(index, size);
//         return objectStore[index];
//     }

//     @Override
//     public int getIndex(T element) {
//         for (int i = 0; i < size; i++) {
//             if (element.equals(objectStore[i])) {
//                 return i;
//             }
//         }
//         return -1;
//     }

//     @Override
//     public void set(int index, T element) {
//         Objects.checkIndex(index, size);
//         objectStore[index] = element;
//     }

//     @Override
//     public int size() {
//         return size;
//     }

//     @Override
//     public T remove(int index) {
//         Objects.checkIndex(index, size);
//         T removedElement = objectStore[index];
//         System.arraycopy(objectStore, index + 1, objectStore, index, size - index - 1);
//         size--;
//         return removedElement;
//     }

//     @Override
//     public boolean remove(T element) {
//         int index = getIndex(element);
//         if (index != -1) {
//             remove(index);
//             return true;
//         }
//         return false;
//     }

//     @Override
//     public void clear() {
//         size = 0;
//     }
// }












