package com.merryyou.java8.interfac;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created on 2016/5/28 0028.
 *
 * @author zlf
 * @since 1.0
 */
public class CarTest {
    public static void main(String[] args) {
        Car car = Car.create(Car::new);
       final Car carPlice = Car.create(Car::new);
        List<Car> carList = Arrays.asList(car);

        carList.forEach(Car::collide);
        carList.forEach(carPlice::follow);
        carList.forEach(Car::repair);
    }
    static class Car{
        public static Car create( final Supplier< Car > supplier ) {
            return supplier.get();
        }

        public static void collide( final Car car ) {
            System.out.println( "Collided " + car.toString() );
        }

        public void follow( final Car another ) {
            System.out.println( "Following the " + another.toString() );
        }

        public void repair() {
            System.out.println( "Repaired " + this.toString() );
        }
    }
}


