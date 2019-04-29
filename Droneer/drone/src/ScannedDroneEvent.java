import java.util.EventObject;

public class ScannedDroneEvent extends EventObject
{
   private boolean isScannedDrone;
   
   public ScannedDroneEvent( Object source)
   {
      super( source);
      isScannedDrone = false;
   }
   
   public boolean getScanned()
   {
      return isScannedDrone;
   }
   
   public void droneScanned()
   {
      isScannedDrone = true;
   }
   
}