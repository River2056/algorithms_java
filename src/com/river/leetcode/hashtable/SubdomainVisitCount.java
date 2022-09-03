package com.river.leetcode.hashtable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SubdomainVisitCount {
  public List<String> subdomainVisits(String[] cpdomains) {
    Map<String, Integer> visited = new HashMap<>();
    for (int i = 0; i < cpdomains.length; i++) {
      String domain = cpdomains[i];
      String[] timesAndDomain = domain.split(" ");
      String sub = timesAndDomain[1];
      Integer times = Integer.parseInt(timesAndDomain[0]);
      while (sub.length() > 0) {
        if (!visited.containsKey(sub)) visited.put(sub, times);
        else visited.put(sub, visited.get(sub) + times);

        if (sub.indexOf(".") > 0) sub = sub.substring(sub.indexOf(".") + 1);
        else sub = "";
      }
    }

    return visited.entrySet().stream()
        .map(entry -> String.format("%s %s", entry.getValue(), entry.getKey()))
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    SubdomainVisitCount svc = new SubdomainVisitCount();

    System.out.printf("res: %s\n", svc.subdomainVisits(new String[] {"9001 discuss.leetcode.com"}));
    System.out.printf(
        "res: %s\n",
        svc.subdomainVisits(
            new String[] {
              "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"
            }));
  }
}
