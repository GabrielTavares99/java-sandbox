package k_nearest.movie_recomendation;

import lombok.var;

public class MovieAdviser {

    public Long calcDistance(User user1, User user2) {
        var sum = 0d;

        for (var entry : user1.getGrades().entrySet()) {
            double tempValue = entry.getValue() - user2.getGrades().get(entry.getKey());
            tempValue = Math.pow(tempValue, 2);
            sum = tempValue + sum;
        }
        return Math.round(Math.sqrt(sum));
    }

}
