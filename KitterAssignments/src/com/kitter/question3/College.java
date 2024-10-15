package com.kitter.question3;

public class College {
	String name;
    String location;
    int fees;
    int ranking;
    double score;
    
    
    public College(String name, String location, int fees, int ranking) {
        this.name = name;
        this.location = location;
        this.fees = fees;
        this.ranking = ranking;
    }
    
	public void calculateScore(int rankingWeight, int feesWeight, int maxFees) {
        this.score = (this.ranking * rankingWeight) + ((double) this.fees / maxFees * feesWeight);
    }

	@Override
	public String toString() {
		return "College [name=" + name + ", location=" + location + ", fees=" + fees + ", ranking=" + ranking
				+ ", score=" + score + "]";
	}
    
}
