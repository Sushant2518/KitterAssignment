package com.kitter.question3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CollegeRankingSystem {
	public static List<College> rankColleges(List<College> colleges, String preferredLocation, int maxFees, int rankingWeight, int feesWeight) {

        List<College> filteredColleges = new ArrayList<>();
        for (College college : colleges) {
            if (college.location.equalsIgnoreCase(preferredLocation) && college.fees <= maxFees) {
                filteredColleges.add(college);
            }
        }

        for (College college : filteredColleges) {
            college.calculateScore(rankingWeight, feesWeight, maxFees);
        }

        filteredColleges.sort(Comparator.comparingDouble(c -> c.score));

        return filteredColleges;
    }
	public static void main(String[] args) {
		List<College> colleges = Arrays.asList(
                new College("College A", "New York", 20000, 1),
                new College("College B", "California", 15000, 2),
                new College("College C", "New York", 25000, 3),
                new College("College D", "New York", 10000, 4)
        );

        String preferredLocation = "New York";
        int maxFees = 20000;
        int rankingWeight = 2;
        int feesWeight = 1;

        List<College> rankedColleges = rankColleges(colleges, preferredLocation, maxFees, rankingWeight, feesWeight);

        for (College college : rankedColleges) {
            System.out.println(college);
        }

	}

}
