package com.poolik.classfinder;

import com.poolik.classfinder.filter.Annotated;
import com.poolik.classfinder.filter.Subclass;
import com.poolik.classfinder.info.ClassInfo;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        ClassFinder finder = new ClassFinder().addClasspath();
        Collection<ClassInfo> deprecated = finder.findClasses(Subclass.of(java.lang.ClassLoader.class));
        List<ClassInfo> classInfos = deprecated.stream().sorted(Comparator.comparing(ClassInfo::getClassName)).collect(Collectors.toList());
        for (ClassInfo ci: classInfos){
            System.out.println(ci.getClassName());
        }
    }

}
