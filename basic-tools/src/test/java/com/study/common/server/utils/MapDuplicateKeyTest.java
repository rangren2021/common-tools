package com.study.common.server.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapDuplicateKeyTest {

    public static void mapkey() {
        List<Entity> list = new ArrayList<>();
        list.add(new Entity("20170728120", 1));
        list.add(new Entity("20170728119", 0));
        list.add(new Entity("20170728119", 2));

        Map<String, Boolean> map = list.stream().collect(
//                Collectors.toMap(po->po., StringUtils.isNotEmpty(Entity::getKey), (s, a) -> s || a));
                Collectors.toMap(po -> po.getKey(), po -> po.getValue() == 0, (s, a) -> s && a));


        map.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));

    }

    public static void main(String[] args) {
        mapkey();
    }

}