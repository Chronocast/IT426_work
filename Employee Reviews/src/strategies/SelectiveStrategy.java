package strategies;

import rankings.Review;

import java.util.List;

public class SelectiveStrategy implements IStrategy {
    @Override
    public int getScore(int year, List<Review> reviews) {
        int reviewTotal = 0;

        for (Review review : reviews) {
            if(review.getYear() == year) {
                int[] kpis = review.getKpis();
                for (int i = 0; i < kpis.length; i ++){

                    if(i == 0 || i == 2 || i == 3){
                        reviewTotal += kpis[i];
                    }
                }
            }
        }
        return reviewTotal;
    }
}
