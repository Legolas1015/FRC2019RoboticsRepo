
# Notes on SmartDashboard and LiveWindow (from manual)

> Quick Note: I learned that it is definitely worth going through and understanding the whole 48 page SmartDashboard manual attached with this folder (imp. parts highlighted)

## What is the difference between them?
- `LiveWindow` is for when robot is in test mode (as specified by the driverstation (DS))
	- import: `edu.wpi.first.wpilibj.livewindow.LiveWindow`
	- (pg. 35) Enable Test Mode in Driver Station and the SmartDashboard display will switch to LiveWindow.
		- (pg. 35) code syntax (**Explicit**):
			- `LiveWindow.addActuator("Arm", "Wrist", w_motor);`
			- `LiveWindow.addSensor("Arm", "Ultrasonic", ultra.getSensorReading());`
		- **Implicit** way (manual doesn't show this but one of the example projects shows this)
			- Put all motor and sensor values to LiveWindow right from `subsystem` using `addChild`
```Java
m_motor = new Victor(5);
m_pot = new AnalogPotentiometer(2, -2.0 / 5);

// Let's name everything on the LiveWindow
addChild("Motor", m_motor); // it assumes the explicit
addChild("Pot", m_pot);		//	subsystem name from the className
```
		
- `SmartDashboard` is for all other modes (Teleop and Autonomous)
	- import: `edu.wpi.first.wpilibj.smartdashboard.SmartDashboard`
	> Detailed use cases [later](#SmartDashboard-Uses)


## SmartDashboard Uses
### Configuring SmartDashbaord (beginning of manual)
- **Where** is the SmartDashboard file physically located?
	- Run SmartDashbaord from driverstation by selecting `Java` in the DS settings (<mark>pg. 5</mark>)
	- When the new window opens up go to **File > Preferences**
		- The value to `Save File` property show the saved location. (<mark>pg. 7</mark>)
- **How** does the SmartDashboard work?
	- It uses `NetworkTables`
	- *NetworkTable acts as a distributed table of name and value pairs. If a name/value pair is added to either the client (laptop) or server (robot) it is replicated to the other.*

### Writing values to SmartDashboard
- <mark>Page 9</mark>
	- The normal commands
		- `SmartDashboard.putBoolean("LabelName", actual_boolean_val);`
		- `SmartDashboard.putNumber("LabelName", actual_number_val);`
		- `SmartDashboard.putData("");` --> This can be used for more [custom things like testing commands without joysticks](#Testing-Commands-QUICKLY-with-SmartDash)
		- To customize *properties of displays* or *type of displayed widget* --> <mark>pages 10-16</mark>

### Testing Commands QUICKLY with SmartDash
- Use the `SmartDashboard.putData("OpenClaw", new OpenClaw());` to add control buttons to SmartDash
	- the command will run until is finished OR
	- until you press cancle on the same button on SmartDash
- <mark>Pages 17-19</mark>

### Multiple Autonomous Programs
- You can program multiple autonomous programs (for instance one for each initial position on field)
- Then chose using SmartDash which one to run *without having to re-deploy the code!*
- Inside `Robot.java` - demonstrates use of `SendableChooser` (the multiple choice) <mark>pg 21 & 22</mark>
```Java
public class Robot extends IterativeRobot {
	Command autonomousCommand;
	SendableChooser autoChooser;

	public void robotInit() {
		autoChooser = new SendableChooser();
		// first argument the choice label
		// second argument the type of Command, any command!
		autoChooser.addDefault("Default program", new Pickup()); // this is always selected default
		autoChooser.addObject("Experimental auto", new ElevatorPickup());
		SmartDashboard.putData("Autonomous mode chooser", autoChooser); // ANOTHER unique use of putData()
	}

	// RETRIVE the choice for which autonomous program to use
	public void autonomousInit() {
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
	}
}
```

### Displaying what is going on? (right from the Scheduler)
- Loved this part!
- Just need to do `SmartDashboard.putData(Scheduler.getInstance())` -- <mark>page 25</mark>
	- This shows which commands are running and also shows a `cancle` button to interrupt it.

### Which command is running the Claw subsystem? - putData()
- inside the `Command` file (more info <mark>page 26</mark>)
```Java
public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
SmartDashboard.putData(exampleSubsystem);`
```

### Extra check out `Preferences` portion
- *Preferences class is used to store values in flash memory on the roboRIO*
- <mark>page 28...</mark>

### Other Resources
- [PID Tuning using FRCSim Youtube video](https://www.youtube.com/watch?v=yqD9iHiR3j8) - https://www.youtube.com/watch?v=yqD9iHiR3j8
- [PID control screensteps](https://wpilib.screenstepslive.com/s/currentCS/m/java/l/599721-operating-the-robot-with-feedback-from-sensors-pid-control) - https://wpilib.screenstepslive.com/s/currentCS/m/java/l/599721-operating-the-robot-with-feedback-from-sensors-pid-control
	- Also attached as pdf with the folder, title `PID control screensteps.pdf`
- BRIEF PID tuning part in SmartDash manual -- <mark>page 39</mark>














