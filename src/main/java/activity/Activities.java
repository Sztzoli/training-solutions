package activity;


import java.util.*;


public class Activities {
    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }


    public int numberOfTrackActivities() {
        int count = 0;
        for (Activity activity : activities) {
            if (activity instanceof ActivityWithTrack) {
                count++;
            }
        }
        return count;
    }

    public int numberOfWithoutTrackActivities() {
        long count = activities.stream()
                .filter(activity -> activity instanceof ActivityWithoutTrack)
                .count();
        return (int) count;
    }

    public List<Report> distancesByTypes() {
        Report[] reports = new Report[ActivityType.values().length];
        for (int i = 0; i < reports.length; i++) {
            reports[i] = new Report(ActivityType.values()[i], 0);
        }
        for (Activity activity : activities) {
            int index = activity.getType().ordinal();
            reports[index] = new Report(activity.getType(), reports[index].getDistance() + activity.getDistance());

        }
        return Arrays.asList(reports);
    }
}
