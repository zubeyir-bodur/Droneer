import java.util.EventListener;

public interface DroneScanner extends EventListener
{
   public void onScannedDrone( ScannedDroneEvent e);
}
   