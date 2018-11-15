package com.arsoft.projects.artutorial.learning.java8.methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings ("unused")
public class ConstructorReference
{
    public static void main(String[] args)
    {
        Supplier<List<String>> st1 = ArrayList::new;
        List<String> l2 = st1.get();
    }
}
