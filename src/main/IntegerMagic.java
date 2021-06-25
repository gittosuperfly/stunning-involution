package main;

import java.lang.reflect.Field;

public class IntegerMagic {

    private static void castMagic() {
        try {
            Class<?> clazz = Integer.class.getDeclaredClasses()[0];
            Field cache = clazz.getDeclaredField("cache");
            cache.setAccessible(true);
            Integer[] array = (Integer[]) cache.get(clazz);
            array[130] = array[129];
            array[131] = array[129];
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        castMagic();

        Integer a = 1;
        if (a == (Integer) 1 && a == (Integer) 2 && a == (Integer) 3) {
            System.out.println("Success");
        }
    }


}
