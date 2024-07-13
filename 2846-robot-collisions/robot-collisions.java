class Robot {
    public int index;
    public int position;
    public int health;
    public char direction;

    public Robot(int index, int position, int health, char direction) {
        this.index = index;
        this.position = position;
        this.health = health;
        this.direction = direction;
    }
}

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> ans = new ArrayList<>();
        Robot[] robots = new Robot[positions.length];
        Deque<Robot> deque = new ArrayDeque<>();

        for (int i = 0; i < positions.length; i++)
            robots[i] = new Robot(i, positions[i], healths[i], directions.charAt(i));

        Arrays.sort(robots, (a, b) -> a.position - b.position);

        for (Robot robot : robots) {
            if (robot.direction == 'R')
                deque.offerLast(robot);
            else {
                while (!deque.isEmpty() && deque.peekLast().direction == 'R' && robot.health > 0) {
                    Robot rightRobot = deque.pollLast();
                    if (rightRobot.health == robot.health)
                        robot.health = 0;
                    else if (rightRobot.health < robot.health)
                        robot.health -= 1;
                    else {
                        rightRobot.health -= 1;
                        deque.offerLast(rightRobot);
                        robot.health = 0;
                    }
                }
                if (robot.health > 0)
                    deque.offerLast(robot);
            }
        }
        List<Robot> survivingRobots = new ArrayList<>(deque);
        survivingRobots.sort(Comparator.comparingInt(a -> a.index));

        for (Robot robot : survivingRobots)
            ans.add(robot.health);

        return ans;
    }
}