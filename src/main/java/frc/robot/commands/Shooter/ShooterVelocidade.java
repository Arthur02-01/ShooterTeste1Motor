package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Shooter.VelocidadeShooter;

public class ShooterVelocidade extends InstantCommand {

    private final Shooter shooter;
    private final VelocidadeShooter velocidade;

    public ShooterVelocidade(
            Shooter shooter,
            VelocidadeShooter velocidade
    ) {
        this.shooter = shooter;
        this.velocidade = velocidade;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        shooter.setVelocidade(velocidade);
    }
}
