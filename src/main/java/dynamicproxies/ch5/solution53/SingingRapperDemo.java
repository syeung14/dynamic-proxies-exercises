/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.solution53;

import java.util.*;

// DO NOT CHANGE
public class SingingRapperDemo {
  public static void main(String[] args) {
    var singers = List.of(
        Factory.convert(new BoomBapRapper()),
        Factory.convert(new GangstaRapper()),
        Factory.convert(new EmoRapper())
    );

    System.out.println("Sing:");
    singers.stream()
        .map(Singer::sing)
        .forEach(System.out::println);
    System.out.println();

    System.out.println("Dance:");
    singers.stream()
        .map(Singer::dance)
        .forEach(System.out::println);
    System.out.println();

    System.out.println("toString:");
    singers.forEach(System.out::println);
  }
}