package functional_interfaces.background_job_execution;

// Background job execution using Runnable
public class BackgroundJobExecution {
    
    public void executeTask(String taskName, int duration) {
        Runnable task = () -> {
            System.out.println("Starting background task: " + taskName);
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Completed background task: " + taskName);
        };
        
        Thread thread = new Thread(task);
        thread.start();
    }
}
