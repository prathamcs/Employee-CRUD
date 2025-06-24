import java.time.LocalDate;
class JuniorDeveloper extends Developer {
    private String mentor;
    private boolean trainingComplete;
    private int tasksCompleted;

    public JuniorDeveloper(int id, String name, String department, double salary, String email, LocalDate hireDate, String mentor) {
        super(id, name, department, salary, email, hireDate);
        this.mentor = mentor;
    }

    public String getMentor() { return mentor; }
    public void setMentor(String mentor) { this.mentor = mentor; }

    public boolean isTrainingComplete() { return trainingComplete; }
    public void completeTraining() { trainingComplete = true; }

    public int getTasksCompleted() { return tasksCompleted; }
    public void completeTask() { tasksCompleted++; }

    @Override
    public double calculateBonus() {
        // base 5% salary + $20 per completed task
        return salary * 0.05 + tasksCompleted * 20;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is learning under " + mentor + ". Training complete: " + trainingComplete);
    }

    @Override
    public String toString() {
        return "JuniorDeveloper -> " + super.toString() + String.format(
                ", Mentor: %s, Training: %b, Tasks: %d",
                mentor, trainingComplete, tasksCompleted
        );
    }
}