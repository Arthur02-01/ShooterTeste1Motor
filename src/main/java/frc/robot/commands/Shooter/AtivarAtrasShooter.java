package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Shooter;

public class AtivarAtrasShooter extends InstantCommand {

    private final Shooter shooter;

    public AtivarAtrasShooter(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        shooter.ligarTras();
    }
}
