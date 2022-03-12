package lazy.lamejam.util;

import com.badlogic.gdx.utils.Timer;

public class TimedManager {

	public Timer.Task[] tasks = new Timer.Task[4];
	public int index;
	public void addTask(Timer.Task task) {
		tasks[index++] = task;
	}

	public void start(int index) {
		if (!tasks[index].isScheduled()) {
			System.out.println("Running");
			tasks[index].run();
		} else {
			System.out.println("Already started");
		}
	}
}
