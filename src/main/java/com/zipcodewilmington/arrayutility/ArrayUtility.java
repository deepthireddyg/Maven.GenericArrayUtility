package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private T[] inputArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge,T valueToEvaluate){

        Integer j=0;
        for(int i = 0;i<inputArray.length;i++){
            if(valueToEvaluate == inputArray[i]){
                j++;
            }
        }
        for(int k = 0;k< arrayToMerge.length;k++){
            if(valueToEvaluate == arrayToMerge[k]){
                j++;
            }
        }

//        int array1 = inputArray.length;
////        int array2 = arrayToMerge.length;
////
////        int arraySize = array1+array2;

////        List<T> array3= new ArrayList<T>();
////

////
////        Collections.addAll(array3, inputArray);
////        Collections.addAll(array3,arrayToMerge);
////
////        System.out.println(array3.toString());
//
//        Integer j = 0;
//        for(int i = 0;i<array3.size();i++){
//            if(valueToEvaluate == array3.get(i)){
//                j++;
//            }
//        }

        return j;
    }
    public T getMostCommonFromMerge(T[] arrayToMerge) {
        int array1 = inputArray.length;
        int array2 = arrayToMerge.length;

        int arraySize = array1+array2;

        List<T> array3= new ArrayList<T>();


        Collections.addAll(array3, inputArray);
        Collections.addAll(array3,arrayToMerge);

        System.out.println(array3.toString());

        System.out.println(mostCommon(array3));


        return mostCommon(array3);
    }
    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer j = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (valueToEvaluate == inputArray[i]) {
                j++;
            }


        }
        return j;
    }
    public T[] removeValue(T valueToRemove){
        ArrayList<T> myarrlist1 = new ArrayList<T>();

        for(int i = 0;i<inputArray.length;i++){
            T temp = inputArray[i];
            if(!temp.equals(valueToRemove)){
                myarrlist1.add(temp);
            }
        }


        return toArray(myarrlist1);
    }
    public static <T> T[] toArray(Collection<T> c, T[] a) {
        return c.size()>a.length ?
                c.toArray((T[]) Array.newInstance(a.getClass().getComponentType(), c.size())) :
                c.toArray(a);
    }

    /** The collection CAN be empty */
    public static <T> T[] toArray(Collection<T> c, Class klass) {
        return toArray(c, (T[])Array.newInstance(klass, c.size()));
    }

    /** The collection CANNOT be empty! */
    public static <T> T[] toArray(Collection<T> c) {
        return toArray(c, c.iterator().next().getClass());
    }

    public static <T> T mostCommon(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Map.Entry<T, Integer> max = null;

        for (Map.Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        return max.getKey();
    }
}

